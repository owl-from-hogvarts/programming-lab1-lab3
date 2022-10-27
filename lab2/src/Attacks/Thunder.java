package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Thunder extends SpecialMove {
  public Thunder() {
    super(Type.ELECTRIC, 110, 70);
  }

  @Override
  protected String describe() {
    return "вызывает гром";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    if (shouldApplyEffect(0.3)) {
      Effect.paralyze(defendingPokemon);
    }
  }

  private boolean shouldApplyEffect(double chance) {
    return Math.random() <= chance;
  }
}
