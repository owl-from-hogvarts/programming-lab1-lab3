package location;


import inventory.Pile;
import items.base.RawResource;

public interface Mineable {
  Pile mine() throws OutOfResourcesError;
  int getNodeTotalCapacity();
  int getAmountOfResourcesLeft();
  RawResource getResourceType();
  boolean isNotEmpty();
}
