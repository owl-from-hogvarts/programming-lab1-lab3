package location;

import javax.annotation.CheckForNull;

import inventory.Pile;
import inventory.SplitPileError;
import items.base.Item;
import items.base.RawResource;

public class RawResourceNode implements Mineable {
  private final int totalCapacity;
  @CheckForNull
  private Pile resourcePile;
  private final RawResource resource;

  public RawResourceNode(RawResource resource) {
    this.resource = resource;
    this.totalCapacity = computeTotalCapacity(40, Item.defaultMaxStackSize);
    this.resourcePile = new Pile(this.resource, this.totalCapacity);
  }

  @Override
  public int getNodeTotalCapacity() {
    return totalCapacity;
  }

  @Override
  public int getAmountOfResourcesLeft() {
    if (resourcePile == null) {
      return 0;
    }
    return resourcePile.getAmount();
  }

  @Override
  public Pile mine() throws OutOfResourcesError {
    if (resourcePile == null) {
      throw new OutOfResourcesError();
    }

    try {
      return resourcePile.split(1);
    } catch (SplitPileError e) {
      final Pile last = this.resourcePile;
      this.resourcePile = null;
      
      return last;
    }
  }

  private int computeTotalCapacity(int min, int max) {
    assert min > 0 && max > 0;
    assert max > min;
    return (int) ((Math.random() * (max - min)) + min);
  }

  @Override
  public RawResource getResourceType() {

    return this.resource;
  }

  @Override
  public boolean isNotEmpty() {
    return this.resourcePile != null;
  }

  

}
