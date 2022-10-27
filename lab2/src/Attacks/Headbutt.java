package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Headbutt extends PhysicalMove {
  public Headbutt() {
    super(Type.NORMAL, 70, 100);
  }

  @Override
  protected String describe() {
    return "бьет головой";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    if (this.shouldApplyEffect(0.3)) {
      Effect.flinch(defendingPokemon);
    }
  }

  private boolean shouldApplyEffect(double chance) {
    return Math.random() <= chance;
  }
}
