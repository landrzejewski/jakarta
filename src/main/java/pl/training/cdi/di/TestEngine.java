package pl.training.cdi.di;

import jakarta.enterprise.inject.Alternative;
import lombok.extern.java.Log;

@Alternative
@Petrol
@Log
public class TestEngine implements Engine {

    @Override
    public void start() {
        log.info("Test engine started...");
    }

}
