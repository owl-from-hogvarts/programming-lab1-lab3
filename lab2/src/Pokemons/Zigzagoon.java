package Pokemons;

import Attacks.Confide;
import Attacks.Headbutt;
import Attacks.Thunder;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Zigzagoon extends Pokemon {

  public Zigzagoon(final String name, final int level) {
    super(name, level);
    setStats(38, 30, 41, 30, 41, 60);
    addType(Type.NORMAL);

    addMove(new Confide());
    addMove(new Headbutt());
    addMove(new Thunder());
  }
}
