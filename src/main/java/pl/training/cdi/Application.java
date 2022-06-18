package pl.training.cdi;

import org.jboss.weld.environment.se.Weld;
import pl.training.cdi.di.Car;
import pl.training.cdi.di.TestBean;

public class Application {

    public static void main(String[] args) {
        var weld = new Weld();
        try (var container = weld.initialize()) {
            var car = container.select(Car.class).get();
            car.go();
            container.select(TestBean.class).get().test();
        }
    }

}
