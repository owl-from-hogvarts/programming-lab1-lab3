package inventory;
public class PileAlreadyEmpty extends Error {

  @Override
  public String getMessage() {
    return "Pile already empty";
  }
  
}
