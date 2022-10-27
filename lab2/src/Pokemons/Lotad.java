package Pokemons;

import Attacks.EnergyBall;
import Attacks.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Lotad extends Pokemon{
  public Lotad(final String name, final int level) {
    super(name, level);
    setStats(40, 30, 30, 40, 50, 30);
    addType(Type.WATER);
    addType(Type.GRASS);

    addMove(new Swagger());
    addMove(new EnergyBall());
  }
}
