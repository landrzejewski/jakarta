package pl.training.cdi.events;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.Setter;

import java.util.logging.Logger;

public class MessageConsumer {

    @Inject
    @Setter
    private Logger logger;

    public void onMessage(@Observes String message) {
        logger.info("New message: %s".formatted(message));
    }

}
