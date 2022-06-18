package pl.training.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;

@ApplicationScoped
@Log
public class TestBean {

    @RandomValue
    @Inject
    private int randomInt;
    @RandomValue
    @Inject
    private int otherRandomInt;

    public void test() {
        log.info("Random value: %d".formatted(randomInt));
        log.info("Random value: %d".formatted(otherRandomInt));
    }

}
