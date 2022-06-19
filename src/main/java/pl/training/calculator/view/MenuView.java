package pl.training.calculator.view;

import pl.training.calculator.commons.View;

import java.util.Map;

public class MenuView implements View {

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Menu");
        System.out.println("1 - Dodaj");
        System.out.println("2 - Odejmij");
        System.out.println("3 - Wyjdź");
    }

}
