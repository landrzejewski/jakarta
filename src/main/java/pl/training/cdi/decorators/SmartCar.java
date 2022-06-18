package pl.training.cdi.decorators;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import pl.training.cdi.di.Car;
import pl.training.cdi.di.Vehicle;

import java.util.logging.Logger;

@Decorator
public abstract class SmartCar implements Vehicle {

    @Delegate
    @Inject
    private Car car;
    @Inject
    private Logger logger;

    @Override
    public void go() {
        logger.info("Turn on lights");
        car.go();
    }

    public void stop() {
        logger.info("Stopping...");
    }
}
