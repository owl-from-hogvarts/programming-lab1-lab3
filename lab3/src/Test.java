@FunctionalInterface
public interface Test {
  String BIFunc(Object a, Object b);
}

class A {
  private static final Integer x = 0;
  private static final Integer y = 1;

  public static String foo(Test f) {
    return f.BIFunc(A.x, A.y);
  }
}


class B {
  {
    A.foo((Object a, Object b) -> a.getClass().getName() + " " + b.getClass().getName());
  }
}