package pl.training.cdi.di;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Singleton;

import java.util.Random;
import java.util.logging.Logger;

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

    @RandomValue
    @Produces
    public String randomString(@RandomValue int randomInt) {
        return "Text" + randomInt;
    }

    @Produces
    public Logger logger(InjectionPoint injectionPoint) {
       var className = injectionPoint.getMember().getDeclaringClass().getName();
       return Logger.getLogger(className);
    }

    public void destroyRadomInt(@Disposes @RandomValue int randomInt, Logger logger) {
        logger.info("Destroying random int " + randomInt);
    }

}
