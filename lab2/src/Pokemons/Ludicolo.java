package Pokemons;

import Attacks.EnergyBall;
import Attacks.FocusBlast;
import Attacks.Swagger;
import Attacks.ZenHeadbutt;
import ru.ifmo.se.pokemon.Type;

public class Ludicolo extends Lombre {
  public Ludicolo(final String name, final int level) {
    super(name, level);
    setStats(80, 70, 70, 90, 100, 70);
    addType(Type.WATER);
    addType(Type.GRASS);

    addMove(new Swagger());
    addMove(new EnergyBall());
    addMove(new ZenHeadbutt());
    addMove(new FocusBlast());
  }
}
