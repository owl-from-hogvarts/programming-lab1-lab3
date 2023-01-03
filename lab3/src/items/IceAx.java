package items;

import items.base.Equipment;
import items.base.IMovementAssistant;
import items.base.ItemAttributes;
import location.Location;
import location.LocationAttribute;
import messages.MessageWithPayload;

public final class IceAx extends Equipment implements IMovementAssistant{
  public IceAx() {
    super("IceAx", new Settings().itemAttributes(ItemAttributes.MovementAssistant));
  }

  @Override
  public MessageWithPayload<Boolean> isAbleToWork(Location location) {
    if (location.hasAttribute(LocationAttribute.Difficult) && location.hasAttribute(LocationAttribute.Ice)) {
      return new MessageWithPayload<Boolean>(true, "IceAxes are used");
    }

    return new MessageWithPayload<Boolean>(false, "Locations is not suitable to use IceAxes");
  }

  @Override
  public int movementScore() {
    return 10;
  }
}
