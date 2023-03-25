package inventory;

public class SplitPileError extends Exception {
  @Override
  public String getMessage() {
    return "Can't split pile";
  }
}
