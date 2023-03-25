import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import logger.ILogger;
import messages.Message;
import person.Person;
import person.emotions.EEmotionalAction;
import person.emotions.EmotionEvent;

public class Crowd {
  private List<Person> participants;
  private final ILogger logger;

  Crowd(ILogger logger, List<Person> participants) {
    this.logger = logger;
    this.participants = participants;

  }

  public void handleEmotionEvent(EmotionEvent event) {
    Map<EEmotionalAction, List<Person>> actions = new HashMap<>();

    // iterate over participants
    for (Person person : participants) {
      // get participant reaction
      EEmotionalAction action = person.react(event);
      // collect reaction
      actions.computeIfAbsent(action, (_unused) -> new ArrayList<Person>());
      actions.get(action).add(person);
    }

    // supply collected reactions to logger
    for (var key : actions.keySet()) {
      int amount = actions.get(key).size();

      final var message = new Message(key.name() + " action was performed " + amount
      + " of times in response to event " + event.getDescription());
      message.setPrefix("Crowd");

      this.logger.add(this, message);
    }

  }
}
