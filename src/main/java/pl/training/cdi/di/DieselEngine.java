package pl.training.cdi.di;

import lombok.extern.java.Log;

@Diesel
@Log
public class DieselEngine implements Engine {

    @Override
    public void start() {
        log.info("Klklekelkelk Diesel engine started...");
    }

}
