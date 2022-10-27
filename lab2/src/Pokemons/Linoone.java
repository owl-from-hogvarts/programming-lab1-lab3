package Pokemons;

import Attacks.Confide;
import Attacks.DoubleEdge;
import Attacks.Headbutt;
import Attacks.Thunder;
import ru.ifmo.se.pokemon.Type;

public class Linoone extends Dialga {
  public Linoone(final String name, final int level) {
    super(name, level);
    setStats(78, 70, 61, 50, 61, 100);
    addType(Type.NORMAL);

    addMove(new Confide());
    addMove(new Headbutt());
    addMove(new Thunder());
    addMove(new DoubleEdge());

  }

}
