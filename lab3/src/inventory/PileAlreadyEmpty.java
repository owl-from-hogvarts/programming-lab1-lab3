package inventory;
public class PileAlreadyEmpty extends Exception {

  @Override
  public String getMessage() {
    return "Pile already empty";
  }
  
}
