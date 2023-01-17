package items.base;

import java.util.Arrays;

import javax.annotation.Nullable;

public abstract class Item implements IStorableItem {
  static final public int defaultMaxStackSize = 60;

  private final String displayName;
  private final int maxStackSize;
  private final ItemAttributes[] itemAttributes;

  protected Item(String displayName) {
    this.displayName = displayName;
    this.maxStackSize = defaultMaxStackSize;
    this.itemAttributes = new ItemAttributes[0];
  }

  protected Item(String displayName, Settings settings) {
    this.displayName = displayName;
    this.maxStackSize = settings.maxStackSize;
    this.itemAttributes = settings.itemAttributes;
  }

  @Override
  public ItemAttributes[] getItemAttributes() {
    return itemAttributes;
  }

  @Override
  public String getDisplayedName() {
    return this.displayName;
  }

  @Override
  public int getMaxStackSize() {
    return this.maxStackSize;
  }

  public static class Settings {
    @Nullable
    private int maxStackSize;
    @Nullable
    private ItemAttributes[] itemAttributes;

    public Settings maxStackSize(int maxStackSize) {
      this.maxStackSize = maxStackSize;
      return this;
    }

    public Settings itemAttributes(ItemAttributes ... itemAttributes) {
      this.itemAttributes = itemAttributes;
      return this;
    }
  }

  @Override
  public boolean is(Class<? extends IStorableItem> item) {
    return item.isInstance(this);
  }

  @Override
  public boolean is(IStorableItem item) {
    return item.getClass().isInstance(this);
  }

  @Override
  public String toString() {
    return "Item [displayName=" + displayName + ", maxStackSize=" + maxStackSize + ", itemAttributes="
        + Arrays.toString(itemAttributes) + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
    result = prime * result + maxStackSize;
    result = prime * result + Arrays.hashCode(itemAttributes);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    if (displayName == null) {
      if (other.displayName != null)
        return false;
    } else if (!displayName.equals(other.displayName))
      return false;
    if (maxStackSize != other.maxStackSize)
      return false;
    if (!Arrays.equals(itemAttributes, other.itemAttributes))
      return false;
    return true;
  }

}
