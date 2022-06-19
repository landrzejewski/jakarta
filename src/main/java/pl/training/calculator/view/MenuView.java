package pl.training.calculator.view;

import pl.training.calculator.commons.View;

import java.util.Map;

public class MenuView implements View {

    @Override
    public void render(Map<String, String> data) {
        System.out.printf("Menu");
        System.out.printf("1 - Dodaj");
        System.out.printf("2 - Odejmij");
        System.out.printf("3 - Wyjdź");
    }

}
