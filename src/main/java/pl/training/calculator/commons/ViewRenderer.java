package pl.training.calculator.commons;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ViewRenderer {

    private final ViewResolver viewResolver;

    public void render(@Observes ModelAndView modelAndView) {
        var viewName = modelAndView.getViewName();
        var data = modelAndView.getData();
        viewResolver.getView(viewName).render(data);
    }

}
