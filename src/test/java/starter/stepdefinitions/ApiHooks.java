package starter.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ApiHooks {

    @Before("@api")
    public void configureActor() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("API User")
                .whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com"));
    }
}