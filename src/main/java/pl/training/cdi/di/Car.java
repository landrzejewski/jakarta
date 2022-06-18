package pl.training.cdi.di;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import lombok.Setter;
import lombok.extern.java.Log;
import pl.training.cdi.interceptors.LogExecutionTime;

@Log
public class Car implements Vehicle {

    /*@Setter(onMethod = @__({@Inject}))*/
    private Engine engine;

    @Inject
    public Car(@Petrol Engine engine) {
        this.engine = engine;
    }

    @LogExecutionTime
    @Override
    public void go() {
        engine.start();
        log.info("Driving...");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Car postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Car preDestroy");
    }

}
