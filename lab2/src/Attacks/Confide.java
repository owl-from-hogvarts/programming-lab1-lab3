package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;

public class Confide extends StatusMove {
  Effect confideEffect = new Effect().stat(Stat.SPECIAL_ATTACK, -1);

  public Confide() {
    super();
  }

  @Override
  protected String describe() {
    return "раскрывает страшную тайну";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    defendingPokemon.addEffect(confideEffect);
  }
}
