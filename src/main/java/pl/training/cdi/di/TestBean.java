package pl.training.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;
import pl.training.cdi.events.MessageProducer;

import java.util.logging.Logger;

@ApplicationScoped
@Log
public class TestBean {

    @RandomValue
    @Inject
    private int randomInt;
    @RandomValue
    @Inject
    private int otherRandomInt;
    @RandomValue
    @Inject
    private String randomString;
    @Inject
    private Logger logger;
    @Inject
    private MessageProducer messageProducer;

    public void test() {
        log.info("Random value: %d".formatted(randomInt));
        log.info("Random value: %d".formatted(otherRandomInt));
        log.info("Random value: %s".formatted(randomString));
        logger.info("Test log entry (%s)".formatted(logger.getName()));
        messageProducer.send("Test message");
    }

}
