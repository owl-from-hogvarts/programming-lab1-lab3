public class Parent {
  public static void staticMethod() {}

  public void instanceMethod() {}
}

class Child extends Parent {
  public static void staicMethod() {}

  public void instanceMethod() {}
}

class A {
  {
    Parent container = new Child();

    container.staticMethod();
    container.instanceMethod();
  }
}
