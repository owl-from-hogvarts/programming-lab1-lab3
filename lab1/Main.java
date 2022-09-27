import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    final short[] aArr = new short[11];

    for (short i = 0; i < 11; i++) {
      aArr[i] = (short) (i + 6);
    }

    // System.out.println(Arrays.toString(aArr));

    final double[] xArr = new double[20];

    for (int i = 0; i < xArr.length; i++) {
      xArr[i] = ThreadLocalRandom.current().nextDouble(-13, Math.nextUp(8.0));
    }

    final int[] dictionaryLiteral = { 10, 12, 14 };
    final List<Integer> dictionary = Arrays.stream(dictionaryLiteral).boxed().collect(Collectors.toList());

    final double[][] arr2D = new double[6][20];

    for (int i = 0; i < arr2D.length; i++) {
      for (int j = 0; j < arr2D[i].length; j++) {
        double x = xArr[j];
        double c = aArr[i];

        if (aArr[i] == 6) {
          arr2D[i][j] = Math.pow((2.0 / 3.0) + Math.pow(0.25 * (Math.cos(x) - 1.0 / 2.0), 3), 3);
        } else if (dictionary.contains((int) c)) {
          arr2D[i][j] = Math.sin(Math.log(Math.acos((x - 2.5) / 21)));
        } else {
          arr2D[i][j] = Math
              .asin(Math.pow(1 / Math.pow(Math.E, (2 + Math.pow(Math.abs(x) / (3 + Math.abs(x)), x)) / Math.PI), 2));
        }
      }
    }

    for (double[] a : arr2D) {
      for (double b : a) {
        System.out.printf("%.5f ", b);
      }

      System.out.print("\n");
    }

  }

}