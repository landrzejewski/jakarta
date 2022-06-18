package pl.training.cdi.events;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lombok.Setter;

public class MessageProducer {

    @Inject
    @Setter
    private Event<String> eventEmitter;

    public void send(String message) {
        eventEmitter.fire(message);
    }

}
