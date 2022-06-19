package pl.training.calculator.view;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.commons.View;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;
import java.util.Scanner;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class AddValuesView implements View {

    private final CalculatorController calculatorController;
    private final Scanner scanner;

    @Override
    public void render(Map<String, String> data) {
        System.out.println("Dodawanie liczb");
        System.out.println("Podaj pierwszą liczbę: ");
        var firstNumber = scanner.nextBigDecimal();
        System.out.println("Podaj drugą liczbę: ");
        var secondNumber = scanner.nextBigDecimal();
        calculatorController.addValues(firstNumber, secondNumber);
    }

}
