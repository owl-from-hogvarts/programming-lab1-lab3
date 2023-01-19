package person;

import java.util.Arrays;
import java.util.List;

import items.IDisplayable;
import location.Location;
import logger.ILogger;
import messages.Message;
import person.emotions.EEmotionalAction;
import person.emotions.Emotion;
import person.emotions.EmotionEvent;
import myUtils.Util;

public class Person implements IDisplayable {
  private final ILogger logger;
  private String name;
  private Location location;
  private ERace race;

  public ERace getRace() {
    return race;
  }

  public Person(ILogger logger, String name, ERace race) {
    this.logger = logger;
    this.race = race;
    this.setName(name);
  }

  protected void setName(String name) {
    this.name = name;
  }

  protected ILogger getLogger() {
    return this.logger;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String getDisplayedName() {
    return this.getName();
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  protected void addMessage(Message message) {
    this.getLogger().add(this, message.setPrefix(this.getName()));
  }

  public EEmotionalAction react(EmotionEvent event) {
    return takeAction(event);
  }

  protected EEmotionalAction takeAction(EmotionEvent event) {
    return Util.getRandomElementOfList(getAvailableReactions(event.getEmotion()));
  };

  protected List<EEmotionalAction> getAvailableReactions(Emotion emotion) {
    return switch (emotion) {
      case Joy -> Arrays.asList(EEmotionalAction.Scream,
          EEmotionalAction.WaveHands,
          EEmotionalAction.Clap,
          EEmotionalAction.ThrowUpHats);

      case Amazement -> Arrays.asList(EEmotionalAction.Clap);

      case Excitement -> Arrays.asList(EEmotionalAction.Jump,
          EEmotionalAction.Cry);

      default -> {
        assert false : "unknown emotion";
        yield Arrays.asList(EEmotionalAction.WTF);
      }
    };
  }

}
