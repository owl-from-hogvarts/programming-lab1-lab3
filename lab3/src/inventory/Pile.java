package inventory;

import items.base.IStorableItem;;

public class Pile {
  public Pile split(int amountInSecondPile) throws SplitPileError {
    if (amountInSecondPile > this.getAmount()) {
      throw new SplitPileError();
    }

    this.setAmount(this.getAmount() - amountInSecondPile);

    return new Pile(this.getItem(), amountInSecondPile);
  }

  /** Does not mutate data */
  public Pile join(Pile... piles) {
    int totalAmount = this.getAmount();
    for (Pile pile : piles) {
      assert pile.item.is(this.item);
      totalAmount += pile.getAmount();
    }
    return new Pile(this.item, totalAmount);

  }

  private int amount;

  private IStorableItem item;

  public Pile(IStorableItem item, int amount) {
    this.setAmount(amount);
    this.item = item;
  }

  public int getAmount() {
    return amount;
  }

  private void setAmount(int amount) {
    checkAmount(amount, item);
    this.amount = amount;
  }

  public IStorableItem getItem() {
    return item;
  }

  private void checkAmount(int amount, IStorableItem item) {
    assert amount > 0;
    assert amount <= item.getMaxStackSize();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + amount;
    result = prime * result + ((item == null) ? 0 : item.hashCode());
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

    Pile other = (Pile) obj;

    if (amount != other.amount)
      return false;

    if (item == null) {
      if (other.item != null)
        return false;

    } else if (!item.equals(other.item))
      return false;

    return true;
  }
}
