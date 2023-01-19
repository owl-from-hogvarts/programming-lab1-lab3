package location;

import common.Util;
public class Coordinates {
  private int x;
  private int y;

  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }


  public Coordinates() {
    final int min = 10;
    final int max = 100;

    this.x = Util.randomNumber(min, max);
    this.y = Util.randomNumber(min, max);
  }


}
