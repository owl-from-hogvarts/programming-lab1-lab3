package Pokemons;

import Attacks.EnergyBall;
import Attacks.Swagger;
import Attacks.ZenHeadbutt;
import ru.ifmo.se.pokemon.Type;

public class Lombre extends Lotad {
  public Lombre(final String name, final int level) {
    super(name, level);
    setStats(60, 50, 50, 60, 70, 50);
    addType(Type.WATER);
    addType(Type.GRASS);

    addMove(new Swagger());
    addMove(new EnergyBall());
    addMove(new ZenHeadbutt());

  }
}
