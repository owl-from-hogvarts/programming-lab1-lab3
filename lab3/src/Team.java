import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import common.IEventEmitter;
import common.EventEmitter;
import common.IDisplayable;
import inventory.Pile;
import location.Location;
import location.Terrain;
import logger.ILogger;
import messages.Message;
import person.Astronaut;
import person.actions.ICheckAction;
import person.emotions.Emotion;
import person.emotions.EmotionEvent;

public class Team implements ICheckAction, IDisplayable {
  private Astronaut[] members;
  private Location location;
  private final ILogger logger;
  private String name;
  private final EventEmitter<EmotionEvent> events = new EventEmitter<>();


  public EventEmitter<EmotionEvent> getEvents() {
    return events;
  }

  public Team(ILogger logger, String name, Astronaut[] members, Location location) {
    this.logger = logger;
    this.members = members;
    this.name = name;

    List<String> memberNames = Arrays.asList(this.members).stream().map(Astronaut::getName).toList();

    this.addTeamMessage(new Message("New team with name \"" + name + "\" was formed"));
    this.addTeamMessage(new Message("Members are: " + String.join(", ", memberNames)));
    this.setLocation(location);
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
    this.goTo(location);
  }

  public Astronaut[] getMembers() {
    return members;
  }

  public void setMembers(Astronaut[] members) {
    this.members = members;
  }

  public void goTo(Location location) {
    this.addTeamMessage(new Message("received order to go to " + location.getDisplayedName()));
    for (var astro : this.members) {
      astro.move(location, false);
    }
    this.getEvents().emit(new EmotionEvent("Astronaut flies", Emotion.Amazement, Emotion.Excitement, Emotion.Joy));
  }

  @Override
  public void check() {
    for (var member : this.getMembers()) {
      member.check();
    }

  }

  public void mine() {
    if (this.location instanceof Terrain) {
      Terrain terrain = (Terrain) this.location;
      this.addTeamMessage(new Message("starting mining process"));

      for (var node : terrain.getRawResourceNodes()) {
        this.addTeamMessage(new Message("Mining raw resource node " + node.getResourceType().getDisplayedName()));

        while (node.isNotEmpty()) {
          for (var member : this.getMembers()) {
            Optional<Pile> mined = member.mineLazy(node);

            if (mined.isPresent()) {
              member.getInventory().addStorables(mined.get());
            }
          }
        }
      }

    }
    // TODO: add exception: not able to mine in this location

  }

  @Override
  public String getDisplayedName() {
    return this.name;
  }

  private Team addTeamMessage(Message message) {
    this.logger.add(this, message.setPrefix(name));

    return this;
  }
}
