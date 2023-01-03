package inventory;
import items.base.IStorableItem;;

public class Pile {
  public Pile split(int amountInSecondPile) {
    this.setAmount(this.getAmount() - amountInSecondPile);

    return new Pile(this.getItem(), amountInSecondPile);
  }

  /** Does not mutate data */
  public Pile join(Pile ... piles) {
    int totalAmount = this.getAmount();
    for (Pile pile : piles) {
      totalAmount += pile.getAmount();
    }
    return new Pile(this.item, totalAmount);
    
  }
  private int amount;

  private IStorableItem item;

  public Pile(IStorableItem item, int amount) {
    checkAmount(amount, item);
    this.amount = amount;
    this.item = item;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
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
}
