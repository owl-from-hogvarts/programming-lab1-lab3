package myUtils;

import java.util.List;

public class Util {
  public static int randomNumber(int min, int max) {
    assert min > 0 && max > 0;
    assert max > min;
    return (int) ((Math.random() * (max - min)) + min);
  }

  public static <T> T getRandomElementOfList(List<T> list) {
    return list.get(getRandomIndex(list));
  }

  private static int getRandomIndex(List<?> list) {
    return Util.randomNumber(0, list.size());
  }
}
