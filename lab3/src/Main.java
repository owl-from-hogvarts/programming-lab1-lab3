import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import inventory.Pile;
import items.AntiLunit;
import items.IceAx;
import items.Lunit;
import items.PickAx;
import items.Propeller;
import items.base.Equipment;
import location.AirDensity;
import location.Location;
import location.LocationAttribute;
import location.RawResourceNode;
import location.Terrain;
import location.Location.Settings;
import logger.ILogger;
import logger.Logger;

public class Main {
  private static final List<Pile> defaultEquipment = Main.getDefaultEquipment();
  private static final Location[] LOCATIONS = Main.initLocations();
  private static final ILogger logger = Main.initLogger();
  private static final Astronaut[] ASTRONAUTS = Main.iniAstronauts(Main.logger);
  // private static int currentLocation = 0;

  public static void main(String[] args) {
    for (int i = 0; i < LOCATIONS.length; i++) {
      for (var astro : ASTRONAUTS) {
        astro.move(LOCATIONS[i], false);
      }
    }

    List<Astronaut> astronauts = Arrays.asList(ASTRONAUTS);
    int middle = (int) astronauts.size() / 2;
    Astronaut[] firstHalf = astronauts.subList(0, middle).toArray(new Astronaut[0]);
    Astronaut[] secondHalf = astronauts.subList(middle, astronauts.size()).toArray(new Astronaut[0]);

    Team firsTeam = new Team(Main.logger, "Engineers team", firstHalf, LOCATIONS[LOCATIONS.length - 1]);
    Team secondTeam = new Team(Main.logger, "Miners team", secondHalf, LOCATIONS[LOCATIONS.length - 2]);
    firsTeam.check();
    secondTeam.mine();
  
    System.out.println(Main.logger.getContentPrepared());
  }

  private static List<Pile> getDefaultEquipment() {
    final Equipment[] defaultEquipments = { new PickAx(), new IceAx(), new Propeller() };

    List<Pile> defaultEquipmentPiles = new ArrayList<>();
    for (var equipment : defaultEquipments) {
      defaultEquipmentPiles.add(new Pile(equipment, 1));
    }

    return defaultEquipmentPiles;
  }

  private static Location[] initLocations() {
    List<Location> locations = new ArrayList<>();

    locations.add(new Location("Inclined Ice Tunnel", new Settings()
        .attributes(LocationAttribute.Difficult, LocationAttribute.Ice)
        .airDensity(AirDensity.Sparse)));
    locations.add(new Location("Icicle Grotto", new Settings().attributes(LocationAttribute.Ice)));

    final RawResourceNode[] rawResourceNodes = { new RawResourceNode(new Lunit()),
        new RawResourceNode(new AntiLunit()) };

    locations.add(new Terrain("Cave", rawResourceNodes));
    locations.add(new Location("Surface"));

    return locations.toArray(new Location[0]);
  }

  private static Astronaut[] iniAstronauts(ILogger logger) {
    final String[] names = { "Neznaika", "Ponchik", "Znaika", "Steklyashkin", "Mushka" };

    List<Astronaut> astronauts = new ArrayList<>();

    for (String name : names) {
      var astronaut = new Astronaut(logger, name, defaultEquipment.toArray(new Pile[0]));
      astronauts.add(astronaut);
    }

    return astronauts.toArray(new Astronaut[0]);
  }

  private static ILogger initLogger() {
    return new Logger();
  }
}