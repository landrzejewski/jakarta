package pl.training.jakarta;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

@Stateful
public class MapPropertiesStore implements PropertiesStore {

    private final Map<String, String> properties = new HashMap<>();

    @Override
    public void put(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String get(String key) {
        return properties.get(key);
    }

    @Remove
    @Override
    public void close() {
        System.out.println("Closing session");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("%s: postConstruct".formatted(getClass().getSimpleName()));
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("%s: preDestroy".formatted(getClass().getSimpleName()));
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("%s: prePassivate".formatted(getClass().getSimpleName()));
    }

    @PostActivate
    public void postActivate() {
        System.out.println("%s: postActivate".formatted(getClass().getSimpleName()));
    }

}
