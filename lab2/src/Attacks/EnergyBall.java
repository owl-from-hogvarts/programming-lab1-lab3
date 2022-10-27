package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class EnergyBall extends SpecialMove {
  Effect EnergyBallEffect = new Effect().stat(Stat.DEFENSE, -1).chance(0.1);

  public EnergyBall() {
    super(Type.NORMAL, 90, 100);
  }

  @Override
  protected String describe() {
    return "выпускает огненный шар";
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    defendingPokemon.addEffect(this.EnergyBallEffect);
  }

}
