package logger;

import java.util.ArrayList;
import java.util.List;
import messages.Message;

public class Logger implements ILogger {
  private static final Object DEFAULT_ASSOCIATED_OBJECT = new Object();
  private final List<LoggerEntry> storage = new ArrayList<>();

  @Override
  public void add(Message message) {
    this.add(DEFAULT_ASSOCIATED_OBJECT, message);
  }

  @Override
  public void add(Object associatedObject, Message message) {
    this.storage.add(new LoggerEntry(associatedObject, message));
    
  }

  @Override
  public List<Message> getAllMessages() {
    return new ArrayList<Message>(this.storage.stream().map(LoggerEntry::getMessage).toList());
  }

  @Override
  public List<Message> getMessages(Object associatedObject) {
    return this.storage.stream().filter((entry) -> associatedObject == entry.getAssociatedObject())
        .map(LoggerEntry::getMessage).toList();
  }

  @Override
  public String getContentPrepared() {
    return getAllMessages()
        .stream()
        .map((message) -> message.getContentPrepared())
        .reduce("", (acc, content) -> acc + content + "\n");
  }
}

class LoggerEntry {
  private final Object associatedObject;
  private final Message message;

  public LoggerEntry(Object associatedObject, Message message) {
    this.associatedObject = associatedObject;
    this.message = message;
  }

  public Object getAssociatedObject() {
    return associatedObject;
  }

  public Message getMessage() {
    return message;
  }
}