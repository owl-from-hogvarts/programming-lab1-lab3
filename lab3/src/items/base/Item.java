package items.base;

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

}
