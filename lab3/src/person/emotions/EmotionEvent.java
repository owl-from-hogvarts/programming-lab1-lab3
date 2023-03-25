package person.emotions;

import java.util.Arrays;
import java.util.List;

import common.IDisplayable;

public class EmotionEvent implements IDisplayable {

  private final List<Emotion> emotions;
  private final String description;

  public List<Emotion> getEmotions() {
    return emotions;
  }

  public EmotionEvent(String description, Emotion... emotions) {
    this.description = description;
    assert emotions.length > 0;
    this.emotions = Arrays.asList(emotions);
  }

  @Override
  public String getDisplayedName() {
    return this.emotions.get(0).name();
  }

  public String getDescription() {
    return this.description;
  }

}
