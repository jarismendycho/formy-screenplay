package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;

public class SoapCalculatorSteps {

    private static final String BASE_URL = "http://www.dneonline.com";
    private String lastOperation;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario")
                .can(CallAnApi.at(BASE_URL));
    }

    @When("llamo a la operación {string} con operandos {int} y {int}")
    public void callSoapOperation(String operation, int op1, int op2) {
        lastOperation = operation;
        String soapAction = "http://tempuri.org/" + operation;
        String envelope =
                "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                        "<soap:Body>" +
                        "<" + operation + " xmlns=\"http://tempuri.org/\">" +
                        "<intA>" + op1 + "</intA>" +
                        "<intB>" + op2 + "</intB>" +
                        "</" + operation + ">" +
                        "</soap:Body>" +
                        "</soap:Envelope>";

        OnStage.theActorInTheSpotlight().attemptsTo(
                Post.to("/calculator.asmx")
                        .with(request -> request
                                .header("Content-Type", "text/xml; charset=utf-8")
                                .header("SOAPAction", soapAction)
                                .body(envelope)
                        )
        );
    }

    @Then("el código de estado debe ser {int}")
    public void verifyStatusCode(int status) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                response -> {
                                    // Fuerza el log de request+response en consola
                                    response.log().all();
                                    response.statusCode(status);
                                }
                        )
                );
    }

    @Then("el resultado de la {word} debe ser {int}")
    public void verifyResult(String operation, int expectedResult) {
        String soapOp;
        switch (operation.toLowerCase()) {
            case "suma":    soapOp = "Add";      break;
            case "resta":   soapOp = "Subtract"; break;
            default:        soapOp = lastOperation; break;
        }
        String expectedTag = "<" + soapOp + "Result>" + expectedResult + "</" + soapOp + "Result>";

        OnStage.theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                response -> {
                                    // Imprime todo el request+response SOAP
                                    response.log().all();
                                    // Verifica que el cuerpo contenga <AddResult>8</AddResult>, etc.
                                    response.body(containsString(expectedTag));
                                }
                        )
                );
    }
}