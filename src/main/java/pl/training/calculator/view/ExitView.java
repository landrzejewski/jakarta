package pl.training.calculator.view;

import pl.training.calculator.commons.View;

import java.util.Map;

public class ExitView implements View {

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Calculator finished working");
    }

}
