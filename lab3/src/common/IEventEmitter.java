package common;

import java.util.function.Consumer;


public interface IEventEmitter<Event> {
  void on(Class<Event> event, Consumer<Event> listener);
  void emit(Event event);
  void once(Class<Event> event, Consumer<Event> listener);

}
