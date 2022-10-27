package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Swagger extends StatusMove {
  public Swagger() {
    // no power was specified in database specified
    super(Type.NORMAL, 0, 90);
  }

  @Override
  protected String describe() {

    return "сбивает с толку";
  }

  @Override
  protected void applyOppEffects(Pokemon defencdingPokemon) {
    Effect.confuse(defencdingPokemon);
    defencdingPokemon.addEffect(new Effect().stat(Stat.ATTACK, 2));
  }
}
