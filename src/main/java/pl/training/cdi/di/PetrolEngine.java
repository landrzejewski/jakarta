package pl.training.cdi.di;

import lombok.extern.java.Log;

@Petrol
@Log
public class PetrolEngine implements Engine {

    @Override
    public void start() {
        log.info("Petrol engine started...");
    }

}
