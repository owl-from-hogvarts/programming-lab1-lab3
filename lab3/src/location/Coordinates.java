package location;
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

    this.x = randomNumber(min, max);
    this.y = randomNumber(min, max);
  }

  private int randomNumber(int min, int max) {
    assert min > 0 && max > 0;
    assert max > min;
    return (int) ((Math.random() * (max - min)) + min);
  }
}
