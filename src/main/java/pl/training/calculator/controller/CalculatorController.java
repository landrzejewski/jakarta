package pl.training.calculator.controller;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import pl.training.calculator.commons.ModelAndView;
import pl.training.calculator.model.Calculator;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CalculatorController {

    private final Calculator calculator;

    public ModelAndView showMenu() {
        return new ModelAndView("Menu");
    }

}
