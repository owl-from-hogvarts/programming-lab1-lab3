import ru.ifmo.se.pokemon.*;
import Pokemons.*;

public class Main {
  public static void main(String[] args) {
    Pokemon p1 = new Dialga("Хищник", 1);
    Pokemon p2 = new Linoone("Дождь", 1);
    Pokemon p3 = new Lombre("Кувшинка", 1);
    Pokemon p4 = new Lotad("Лук", 1);
    Pokemon p5 = new Ludicolo("Арбуз", 1);
    Pokemon p6 = new Zigzagoon("Винни The Пух", 1);

    Pokemon[] teamA = {p1, p2, p3};

    Pokemon[] teamB = {p4, p5, p6};

    new BattleInitializer(teamA, teamB);
  }
}
