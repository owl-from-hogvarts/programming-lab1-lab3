package Pokemons;

import Attacks.Blizzard;
import Attacks.Confide;
import Attacks.RockSlide;
import Attacks.ThunderWave;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Dialga extends Pokemon {
  public Dialga(final String name, final int level) {
    super(name, level);
    setStats(100, 120, 120, 150, 100, 90);
    addType(Type.STEEL);
    addType(Type.DRAGON);

    addMove(new RockSlide());
    addMove(new Confide());
    addMove(new Blizzard());
    addMove(new ThunderWave());
  }

}
