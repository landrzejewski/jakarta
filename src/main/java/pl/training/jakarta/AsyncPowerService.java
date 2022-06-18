package pl.training.jakarta;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

@Stateless
public class AsyncPowerService implements PowerService {

    @Asynchronous
    @Override
    public Future<Long> calculate(Long number) {
        try {
            Thread.sleep(5_000); // for training only
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AsyncResult<>(number * number);
    }

}
