package person.actions;
import java.util.Optional;

import inventory.Pile;
import location.Mineable;

public interface IMineAction {
  Optional<Pile> mine(Mineable mineable);
}
