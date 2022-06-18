package pl.training.jakarta;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Stopper {

    @AroundInvoke
    public Object measure(InvocationContext invocationContext) throws Exception {
        var startTime = System.nanoTime();
        var result = invocationContext.proceed();
        var totalTime = System.nanoTime() - startTime;
        System.out.println("%s execution time %s ns".formatted(invocationContext.getMethod(), totalTime));
        return result;
    }

}
