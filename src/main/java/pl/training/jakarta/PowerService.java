package pl.training.jakarta;

import javax.ejb.Remote;
import java.util.concurrent.Future;

@Remote
public interface PowerService {

    Future<Long> calculate(Long number);

}
