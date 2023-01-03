
package items.base;
public abstract class Equipment extends Item {

  protected Equipment(String displayName) {
    super(displayName);
  }

  protected Equipment(String displayName, Settings settings) {
    super(displayName, settings);
  }

}
