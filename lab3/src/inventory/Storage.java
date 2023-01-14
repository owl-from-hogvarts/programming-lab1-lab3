package inventory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Storage {
  private static final int MAX_CAPACITY = 30;

  private List<Pile> content = new ArrayList<>();

  public boolean isFull() {
    return content.size() == MAX_CAPACITY;
  }

  public int getAmountOfEmptySlots() {
    return this.getTotalCapacity() - this.getAmountOfOccupiedSlots();
  }

  private int getAmountOfOccupiedSlots() {
    return this.content.size();
  }

  public Pile[] getContent() {
    // this.content = filterEmptyPiles(this.content);
    return content.toArray(new Pile[0]);
  }

  public int getTotalCapacity() {
    return Storage.MAX_CAPACITY;
  }

  public Storage addStorables(Pile... storables) {
    checkCapacity(storables);
    content.addAll(Arrays.asList(storables));
    
    return this;
  };

  public Optional<Pile> takeStorable(Predicate<Pile> selector) {
    for (Pile item : content) {
      if (selector.test(item)) {
        content.remove(item);
        return Optional.of(item);
      }
    }

    return Optional.empty();
  }

  // private List<Pile> filterEmptyPiles(List<Pile> piles) {
  //   ArrayList<Pile> clonedPiles = new ArrayList<>(piles);
  //   clonedPiles.removeIf(pile -> pile.getAmount() == 0);
  //   return clonedPiles;
  // }

  private void checkCapacity(Pile ... toAdd) {
    assert this.getAmountOfEmptySlots() > toAdd.length;
  }
}
