package logger;

import java.util.List;

import messages.Message;

public interface ILogger {
  void add(Message message);
  void add(Object associatedObject, Message message);
  List<Message> getAllMessages();
  List<Message> getMessages(Object associatedObject);
  String getContentPrepared();
}
