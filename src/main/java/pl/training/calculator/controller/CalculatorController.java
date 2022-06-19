package pl.training.calculator.controller;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.commons.Controller;
import pl.training.calculator.commons.ModelAndView;
import pl.training.calculator.model.Calculator;

import java.math.BigDecimal;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculatorController {

    private final Calculator calculator;

    public ModelAndView showMenu() {
        return new ModelAndView("Menu");
    }

    public ModelAndView select(String option) {
        return switch (option) {
            case "1" -> new ModelAndView("AddValues");
            case "2" -> new ModelAndView("SubstractValues");
            case "3" -> new ModelAndView("Exit");
            default -> throw new IllegalArgumentException();
        };
    }

    public ModelAndView addValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.add(firstNumber, secondNumber).toString();
        return new ModelAndView("Results", Map.of("result", result));
    }

    public ModelAndView substractValues(BigDecimal firstNumber, BigDecimal secondNumber) {
        var result = calculator.substract(firstNumber, secondNumber).toString();
        return new ModelAndView("Results", Map.of("result", result));
    }

}
