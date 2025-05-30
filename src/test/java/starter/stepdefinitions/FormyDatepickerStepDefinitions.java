package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Value;
import starter.tasks.SelectDate;
import starter.ui.DatepickerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

public class FormyDatepickerStepDefinitions {

    @Given("Abrir la página del datepicker")
    public void open_datepicker_page() {
        OnStage.setTheStage(new OnlineCast());
        givenThat(OnStage.theActorCalled("Usuario"))
                .wasAbleTo(
                        net.serenitybdd.screenplay.actions.Open.url(
                                "https://formy-project.herokuapp.com/datepicker"
                        )
                );
    }

    @When("Elegir la fecha {string}")
    public void select_date(String date) {
        when(OnStage.theActorInTheSpotlight())
                .attemptsTo(
                        SelectDate.on(date)
                );
    }

    @Then("Se debería ver la fecha {string} en el campo")
    public void should_see_date(String date) {
        then(OnStage.theActorInTheSpotlight())
                .should(
                        seeThat(
                                Value.of(DatepickerPage.DATE_FIELD),
                                equalTo(date)
                        )
                );
    }
}