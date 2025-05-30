package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import starter.ui.FormPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillForm implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue("Jorge").into(FormPage.FIRST_NAME),
            Enter.theValue("Arismendy").into(FormPage.LAST_NAME),
            Enter.theValue("Tester").into(FormPage.JOB_TITLE),
            Click.on(FormPage.EDUCATION),
            Click.on(FormPage.GENDER),
            SelectFromOptions.byVisibleText("2-4").from(FormPage.EXPERIENCE),
            Enter.theValue("05/28/2025").into(FormPage.DATE),
            Click.on(FormPage.SUBMIT_BUTTON)
        );
    }

    public static FillForm completely() {
        return instrumented(FillForm.class);
    }
}
