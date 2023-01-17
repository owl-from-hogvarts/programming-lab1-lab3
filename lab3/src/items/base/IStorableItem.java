package items.base;

import items.IDisplayable;

public interface IStorableItem extends IDisplayable {
  // String getDisplayedName();
  int getMaxStackSize();
  ItemAttributes[] getItemAttributes();
  boolean is(Class<? extends IStorableItem> item);
  boolean is(IStorableItem item);
}
