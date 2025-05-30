package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import starter.ui.DatepickerPage;

public class SelectDate implements Task {

    private final String date;

    public SelectDate(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(date).into(DatepickerPage.DATE_FIELD)
        );
    }

    public static SelectDate on(String date) {
        return instrumented(SelectDate.class, date);
    }
}
