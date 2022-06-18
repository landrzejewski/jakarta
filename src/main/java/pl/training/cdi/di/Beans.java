package pl.training.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import java.util.Random;

@ApplicationScoped
// @Singleton
public class Beans {

    private final Random random = new Random();

    //@Singleton
    @RandomValue
    @Produces
    public int randomInt() {
        return random.nextInt();
    }

}
