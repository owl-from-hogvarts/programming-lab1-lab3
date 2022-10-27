import java.io.*;

public class Builder {
  public static void main(String[] argv) {

  }

  static void buildTreeHierarchy(String projectRootPath) {
    File projectRoot = new File(projectRootPath);
    
  }

  static private void buildTreeHierarchyFromRoot(File projectRoot) {
    if (projectRoot.isDirectory()) {
      for (final File entry : projectRoot.listFiles()) {
        if (entry.isDirectory()) {
          buildTreeHierarchyFromRoot(entry);
        }
      }
    }
  }
}