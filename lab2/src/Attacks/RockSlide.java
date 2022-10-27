package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class RockSlide extends PhysicalMove {
  public RockSlide() {
    super(Type.ROCK, 75, 90);
  }

  @Override
  protected String describe() {
    return "направляет оползень на соперника";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    if (this.shouldApplyEffect(0.3)) {
      Effect.flinch(defendingPokemon);
    }
  }

  private boolean shouldApplyEffect(double chance) {
    return Math.random() <= chance;
  };


}
