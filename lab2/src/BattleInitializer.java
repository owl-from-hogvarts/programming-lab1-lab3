import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class BattleInitializer {
  BattleInitializer(Pokemon[] teamA, Pokemon[] teamB) {
    Battle battle = new Battle();
    if (teamA.length == 0) {
      System.out.println("Никто не пришел на мега схватку из команды Ally");
    }

    if (teamB.length == 0) {
      System.out.println("Никто не пришел на мега схватку из команды Foe");
    }


    for (Pokemon pokemon : teamA) {
      battle.addAlly(pokemon);
    }
    
    for (Pokemon pokemon : teamB) {
      battle.addFoe(pokemon);
    }

    battle.go();
  }
}
