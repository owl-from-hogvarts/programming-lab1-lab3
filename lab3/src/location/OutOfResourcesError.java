package location;
public class OutOfResourcesError extends Error {

  @Override
  public String getMessage() {
    return "Resource node is ran out of resources";
  }
  
}
