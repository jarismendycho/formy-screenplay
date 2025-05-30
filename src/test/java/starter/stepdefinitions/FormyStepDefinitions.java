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

    @Given("Jorge opens the form page")
    public void openForm() {
        OnStage.theActorCalled("Jorge").wasAbleTo(
                Open.url("https://formy-project.herokuapp.com/form")
        );
    }

    @When("he fills in the form with valid data")
    public void fillForm() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                FillForm.completely()
        );
    }

    @Then("he should see a successful submission")
    public void verifySubmission() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(FormPage.ALERT_SUCCESS, isVisible())
                        .forNoMoreThan(10).seconds()
        );
    }
}