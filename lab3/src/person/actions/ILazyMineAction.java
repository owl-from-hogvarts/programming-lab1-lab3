package person.actions;
import java.util.Optional;

import inventory.Pile;
import location.Mineable;

public interface ILazyMineAction {
  Optional<Pile> mineLazy(Mineable mineable);
}
