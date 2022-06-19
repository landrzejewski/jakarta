package pl.training.calculator.commons;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ViewRenderer {

    private final ViewMapper viewMapper;
    private final Instance<View> views;
    private Map<String, View> mappings;

    @PostConstruct
    public void createMappings() {
        mappings = views.stream()
                .collect(toMap(viewMapper::toViewName, view -> view));
    }

    public void render(ModelAndView modelAndView) {
        var viewName = modelAndView.getViewName();
        var data = modelAndView.getData();
        mappings.get(viewName).render(data);
    }

}
