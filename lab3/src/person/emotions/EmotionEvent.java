package person.emotions;

import common.IDisplayable;

public class EmotionEvent implements IDisplayable {

  private final Emotion emotion;

  public Emotion getEmotion() {
    return emotion;
  }

  EmotionEvent(Emotion emotion) {
    this.emotion = emotion;
  }

  @Override
  public String getDisplayedName() {
    return this.emotion.name();
  }

}
