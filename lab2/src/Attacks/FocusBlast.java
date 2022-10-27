package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class FocusBlast extends SpecialMove {
  Effect focusBlastEffect = new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1);

  public FocusBlast() {
    super(Type.FIGHTING, 120, 70);
  }

  @Override
  protected String describe() {
    return "выпускает лучь сфокусированной энергии";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    defendingPokemon.addEffect(focusBlastEffect);
  }

}
