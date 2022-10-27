package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class ZenHeadbutt extends PhysicalMove {

  public ZenHeadbutt() {
    super(Type.PSYCHIC, 80, 90);
  }

  @Override
  protected String describe() {
    return "делает дзен удар головой";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {

    if (shouldApplyEffect(0.2)) {
      Effect.flinch(defendingPokemon);
    }
  }

  private boolean shouldApplyEffect(double chance) {
    return Math.random() <= chance;
  };


}

