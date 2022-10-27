package Attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class DoubleEdge extends PhysicalMove {
  private final static int DAMAGE = 120;

  public DoubleEdge() {
    super(Type.NORMAL, DAMAGE, 100);
  }

  @Override
  protected String describe() {
    return "делаелт хтыщь чем то очень острым";
  }

  @Override
  protected void applySelfDamage(Pokemon attackingPokemon, double damageToDefendingPokemon) {
    final int calculatedSelfDamage = (int)(this.calcSelfDamage(damageToDefendingPokemon));

    attackingPokemon.setMod(Stat.HP, calculatedSelfDamage);
  }

  private double calcSelfDamage(double damageToDefendingPokemon) {
    return damageToDefendingPokemon / 3;
  }
}
