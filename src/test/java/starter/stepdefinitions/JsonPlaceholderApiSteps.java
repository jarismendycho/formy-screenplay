package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class JsonPlaceholderApiSteps {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("la API está disponible con la URL base {string}")
    public void i_set_jsonplaceholder_api_base_to(String url) {
        OnStage.theActorCalled("Usuario").can(CallAnApi.at(url));
    }

    @When("obtengo el post con ID {int}")
    public void i_get_post_with_id(int id) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Get.resource("/posts/" + id)
                );
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void the_response_status_code_should_be(int expectedStatus) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("Status code is correct",
                                response -> response.statusCode(expectedStatus))
                );
    }

    @Then("el campo title debe ser {string}")
    public void the_title_field_should_be(String expectedTitle) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse("Title field is correct",
                                response -> response.body("title", equalTo(expectedTitle)))
                );
    }
}