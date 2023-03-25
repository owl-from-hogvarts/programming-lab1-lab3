package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventEmitter<Event> implements IEventEmitter<Event> {
  
  private final Map<Class<Event>, List<Slot<Event>>> listenerStorage = new HashMap<>();


  @Override
  public void emit(Event event) {
    if (listenerStorage.containsKey(event.getClass())) {

      for (var slot : listenerStorage.get(event.getClass())) {
        slot.listener.accept(event);
        
        if (slot.once) {
          listenerStorage.remove(event.getClass(), slot);
        }
      }
      
    }
  }

  @Override
  public void on(Class<Event> event, Consumer<Event> listener) {
    final var listeners = this.listenerStorage.putIfAbsent(event, new ArrayList<Slot<Event>>());
    listeners.add(new Slot<>(listener));
  }

  @Override
  public void once(Class<Event> event, Consumer<Event> listener) {
    this.listenerStorage.putIfAbsent(event, new ArrayList<Slot<Event>>());
    final var listeners = this.listenerStorage.get(event);
    listeners.add(new Slot<>(true, listener));
  }


  
}

class Slot<Event> {
  boolean once;
  Consumer<Event> listener;

  public Slot(Consumer<Event> listeners) {
    this(false, listeners);
  }

  public Slot(boolean once, Consumer<Event> listeners) {
    this.once = once;
    this.listener = listeners;
  }
}
