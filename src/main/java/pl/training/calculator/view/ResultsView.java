package pl.training.calculator.view;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.commons.View;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ResultsView implements View {

    private final CalculatorController calculatorController;

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Result: %s".formatted(data.get("result")));
        calculatorController.showMenu();
    }

}
