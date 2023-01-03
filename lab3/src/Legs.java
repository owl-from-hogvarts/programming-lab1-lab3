import items.IDisplayable;
import items.base.IMovementAssistant;
import location.Location;
import location.LocationAttribute;
import messages.MessageWithPayload;

public class Legs implements IMovementAssistant, IDisplayable{

  private static final String legsDisplayName = "Legs";

  @Override
  public MessageWithPayload<Boolean> isAbleToWork(Location location) {
    boolean isNotDifficult = !location.hasAttribute(LocationAttribute.Difficult);
    String message = isNotDifficult ? "Using legs" : "Difficult terrain, impossible to walk";

    return new MessageWithPayload<Boolean>(isNotDifficult, message);
  }

  @Override
  public int movementScore() {
    return 50;
  }

  @Override
  public String getDisplayedName() {
    return Legs.legsDisplayName;
  }
}
