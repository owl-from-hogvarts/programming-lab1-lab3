package items;


import items.base.Equipment;
import items.base.IMovementAssistant;
import location.AirDensity;
import location.Location;
import messages.MessageWithPayload;

public final class Propeller extends Equipment implements IMovementAssistant {
  
  public Propeller() {
    super("Propeller", new Settings().maxStackSize(1));
  }

  @Override
  public MessageWithPayload<Boolean> isAbleToWork(Location location) {
    if (location.getAirDensity() != AirDensity.Dense) {
      return new MessageWithPayload<Boolean>(false, "air is too sparse");
    }

    return new MessageWithPayload<Boolean>(true, "airworthy air; using propellers to fly");
  }

  @Override
  public int movementScore() {
    return 100;
  }

}
