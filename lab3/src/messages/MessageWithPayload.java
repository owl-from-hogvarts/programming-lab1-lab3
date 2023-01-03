package messages;

public class MessageWithPayload<T> extends Message {
  private T payload; 

  public MessageWithPayload(T payload, String content) {
    super(content);

    this.payload = payload;
  }

  public T getPayload() {
    return this.payload;
  }


}
