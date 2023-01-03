package items.base;

import location.Location;
import messages.MessageWithPayload;

public interface IMovementAssistant {
  MessageWithPayload<Boolean> isAbleToWork(Location location);
  int movementScore();
}
