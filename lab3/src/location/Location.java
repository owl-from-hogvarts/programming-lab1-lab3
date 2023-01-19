package location;

import java.util.Arrays;
import java.util.List;

import common.IDisplayable;

public class Location implements IDisplayable{
  public static class Settings {
    private AirDensity airDensity = AirDensity.Sparse;
    private LocationAttribute[] locationAttributes = new LocationAttribute[0];

    public Settings attributes(LocationAttribute ... locationAttributes) {
      this.locationAttributes = locationAttributes;
      return this;
    }

    public Settings airDensity(AirDensity airDensity) {
      this.airDensity = airDensity;
      return this;
    }
  }

  private final Coordinates coordinates;
  private final String name;
  private final List<LocationAttribute> locationAttributes;

  private final AirDensity airDensity;

  public Location(String name, Settings settings, Coordinates coordinates) {
    this.coordinates = coordinates;
    this.name = name;
    this.airDensity = settings.airDensity;
    this.locationAttributes = Arrays.asList(settings.locationAttributes);
  }

  public Location(String name, Settings settings) {
    this(name, settings, new Coordinates());
  }

  public Location(String name) {
    this(name, new Settings());
  }

  public LocationAttribute[] getLocationAttributes() {
    return locationAttributes.toArray(new LocationAttribute[0]);
  }

  public boolean hasAttribute(LocationAttribute locationAttribute) {
    return this.locationAttributes.contains(locationAttribute);
  }

  public AirDensity getAirDensity() {
    return airDensity;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  @Override
  public String getDisplayedName() {
    return name;
  }
}
