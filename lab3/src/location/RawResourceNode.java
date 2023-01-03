package location;
import inventory.Pile;
import items.base.IStorableItem;
import items.base.Item;
import items.base.RawResource;

public class RawResourceNode implements Mineable {
  private final int totalCapacity;
  private Pile resourcePile;

  public RawResourceNode(RawResource resource) {

    this.totalCapacity = computeTotalCapacity(40, Item.defaultMaxStackSize);
    this.resourcePile = new Pile(resource, this.totalCapacity);
  }

  @Override
  public int getNodeTotalCapacity() {
    return totalCapacity;
  }

  @Override
  public int getAmountOfResourcesLeft() {
    return resourcePile.getAmount();
  }

  @Override
  public Pile mine() throws OutOfResourcesError {
    if (resourcePile.getAmount() == 0) {
      throw new OutOfResourcesError();
    }

    return resourcePile.split(1);
  }

  private int computeTotalCapacity(int min, int max) {
    assert min > 0 && max > 0;
    assert max > min;
    return (int) ((Math.random() * (max - min)) + min);
  }

  @Override
  public RawResource getResourceType() {
    IStorableItem item = this.resourcePile.getItem();
    assert item instanceof RawResource;
    RawResource rawResource = (RawResource) item;
    return rawResource;
  }

  @Override
  public boolean isNotEmpty() {
    return this.getAmountOfResourcesLeft() > 0;
  }

  

}
