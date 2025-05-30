package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.tasks.FillForm;
import starter.ui.FormPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FormyStepDefinitions {

    @Before
    public void setupActors() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Abrir la pagina del formulario")
    public void openForm() {
        OnStage.theActorCalled("Usuario").wasAbleTo(
                Open.url("https://formy-project.herokuapp.com/form")
        );
    }

    @When("Llenar el formulario con data valida")
    public void fillForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillForm.completely()
        );
    }

    @Then("Ver que se completa exitosamente")
    public void verifySubmission() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(FormPage.ALERT_SUCCESS, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}