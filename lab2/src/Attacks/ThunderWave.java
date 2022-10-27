package Attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class ThunderWave extends StatusMove {
  Effect thunderWaveAttackEffect = new Effect().attack(1 - 0.25);
  Effect thunderWaveSpeedEffect = new Effect().chance(0.5).stat(Stat.SPEED, 1);
  
  public ThunderWave() {
    super(Type.ELECTRIC, 90, 20);
  }

  @Override
  protected void applyOppEffects(Pokemon defendingPokemon) {
    Effect.paralyze(defendingPokemon);
    defendingPokemon.addEffect(thunderWaveAttackEffect);
  }
}
