package messages;

public class Message {
  private final String content;
  private final String separator;
  private String prefix;

  public Message(String content) {
    this(new Settings("\n"), content);
  }

  public Message(Settings settings, String content) {
    this.content = content;
    this.separator = settings.separator;
  }

  public String getPrefix() {
    return prefix;
  }

  public Message setPrefix(String prefix) {
    this.prefix = prefix;

    return this;
  }

  public String getContentRaw() {
    return this.content;
  }

  public String getContentPrepared() {
    return getContentPrepared(this.separator);
  }

  public String getContentPrepared(String separator) {
    return getPrefix() + ": " + String.join(separator, content);
  }

  public static class Settings {
    private final String separator;
    public Settings(String separator) {
      this.separator = separator;
    }
  }

}
