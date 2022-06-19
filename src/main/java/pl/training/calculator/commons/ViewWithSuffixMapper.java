package pl.training.calculator.commons;

public class ViewWithSuffixMapper implements ViewMapper {

    private static final String VIEW_SUFFIX = "View";

    public String toViewName(View view) {
        var className = view.getClass().getSimpleName();
        return className.substring(0, className.lastIndexOf(VIEW_SUFFIX));
    }

}
