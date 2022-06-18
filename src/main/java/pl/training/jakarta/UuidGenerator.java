package pl.training.jakarta;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.UUID;

@Stateless
public class UuidGenerator implements IdGenerator {

    @Interceptors(Stopper.class)
    @Override
    public String getNext() {
        return UUID.randomUUID().toString();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("%s: postConstruct".formatted(getClass().getSimpleName()));
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("%s: preDestroy".formatted(getClass().getSimpleName()));
    }

}
