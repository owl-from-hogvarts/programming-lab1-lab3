import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import inventory.Pile;
import inventory.Storage;
import items.IDisplayable;
import items.base.IMovementAssistant;
import location.Location;
import location.Mineable;
import logger.ILogger;
import messages.Message;
import messages.MessageWithPayload;

public class Astronaut implements ICheckAction, IMineAction, ILazyMineAction {
  private String name;
  private Storage inventory = new Storage();
  private Legs legs = new Legs();

  private final ILogger logger;

  private Location location;

  public Astronaut(ILogger logger, String name, Pile[] initialInventoryContent) {
    this.logger = logger;
    setName(name);
    inventory.addStorables(initialInventoryContent);
  }

  public Storage getInventory() {
    return inventory;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void move(Location location, boolean silent) {
    if (!silent) {
      if (location == this.getLocation()) {
        this.addAstronautMessage(new Message("already in place"));
      } else {
        this.addAstronautMessage(new Message("performing movement to location " + location.getDisplayedName()));
        computeMovementReport(location).forEach(this::addAstronautMessage);
        this.addAstronautMessage(new Message("came to " + location.getDisplayedName()));
      }

    }

    move(location);
  }

  @Override
  public Optional<Pile> mine(Mineable mineable) {
    this.addAstronautMessage(new Message("starts mining process"));
    this.addAstronautMessage(new Message("Mining raw resource node " + mineable.getResourceType().getDisplayedName()));

    Pile mined = new Pile(mineable.getResourceType(), 0);

    while (mineable.isNotEmpty()) {
      Pile yieldedPile = mineable.mine();
      mined = mined.join(yieldedPile);

      Message message = new Message(this.buildMinedString(yieldedPile));
      this.addAstronautMessage(message);
    }

    if (mined.getAmount() > 0) {
      return Optional.of(mined);
    }

    this.addAstronautMessage(new Message("nothing mined :("));
    return Optional.empty();
  }

  private String buildMinedString(Pile yieldedPile) {
    return "mined " + yieldedPile.getItem().getDisplayedName()
        + " by amount of " + yieldedPile.getAmount();
  }

  @Override
  public void check() {
    this.addAstronautMessage(new Message("Checking rocket systems"));
  }

  private void setName(String name) {
    this.name = name;
  }

  private void move(Location location) {
    this.setLocation(location);
  }

  private List<Message> computeMovementReport(Location location) {
    List<IMovementAssistant> sortedMovementAssistant = Stream.concat(Arrays.stream(inventory.getContent())
        .map(Pile::getItem)
        .filter(IMovementAssistant.class::isInstance)
        // .filter((a) -> IMovementAssistant.class.isInstance(a))
        .map(IMovementAssistant.class::cast), Stream.of(legs))
        // .filter((item) -> item.isAbleToWork(location).getPayload())
        .sorted(Comparator.comparing(IMovementAssistant::movementScore))
        .collect(Collectors.toList());

    Collections.reverse(sortedMovementAssistant);

    List<Message> report = new ArrayList<>();

    for (var movementAssistant : sortedMovementAssistant) {
      final MessageWithPayload<Boolean> result = movementAssistant.isAbleToWork(location);
      if (result.getPayload()) {
        report.add(result);
        break;
      }

      report.add(new Message("Can't use " + ((IDisplayable) movementAssistant).getDisplayedName() + ". Reason:"));
      report.add(result);
    }

    return report;
  }

  private void addAstronautMessage(Message message) {
    this.logger.add(this, message.setPrefix(name));
  }

  @Override
  public Optional<Pile> mineLazy(Mineable mineable) {
    if (mineable.isNotEmpty()) {
      final Pile yieldedPile = mineable.mine();
      assert yieldedPile.getAmount() > 0;

      this.addAstronautMessage(new Message(this.buildMinedString(yieldedPile)));

      return Optional.of(yieldedPile);
    }
    this.addAstronautMessage(new Message("nothing mined :("));
    return Optional.empty();
  }
}
