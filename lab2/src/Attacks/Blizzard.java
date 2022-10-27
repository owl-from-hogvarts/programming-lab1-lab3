package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Blizzard extends SpecialMove {
  public Blizzard() {
    super(Type.ICE, 110, 70);
  }

  @Override
  protected String describe() {
    return "призывает снежную бурю";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    if (this.shouldApplyEffect(0.1)) {
      Effect.freeze(defendingPokemon);
    }
  }

  private boolean shouldApplyEffect(double chance) {
    return Math.random() <= chance;
  };

}
