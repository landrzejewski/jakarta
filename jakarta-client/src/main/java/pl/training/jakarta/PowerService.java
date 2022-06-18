package pl.training.jakarta;

import java.util.concurrent.Future;

public interface PowerService {

    Future<Long> calculate(Long number);

}
