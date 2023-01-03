package location;

public class Terrain extends Location {
  private RawResourceNode[] resources;
  
  public Terrain(String name, RawResourceNode[] resources, Settings settings, Coordinates coordinates) {
    super(name, settings, coordinates);
    this.resources = resources;
  }

  public Terrain(String name, RawResourceNode[] resources, Location.Settings settings) {
    super(name, settings);
    this.resources = resources;
  }

  public Terrain(String name, RawResourceNode[] resources) {
    super(name);
    this.resources = resources;
  }

  public boolean hasRawResourceNodes() {
    return resources.length > 0;
  }

  public RawResourceNode[] getRawResourceNodes() {
    return resources;
  }
}
