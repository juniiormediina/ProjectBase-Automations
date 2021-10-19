package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.OpenGoogle;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GoogleSearchStepDefinitions {

    @Managed(driver = "chrome")
    protected WebDriver hisBrowser;

    @Before
    public void initialSetup(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("user").can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^the user wants open browser an go to google$")
    public void theUserWantsOpenBrowserAnGoToGoogle() {
        OnStage.theActorInTheSpotlight().wasAbleTo(OpenGoogle.thePageGoogle());
    }

    @When("^be search the word angeles$")
    public void beSearchTheWordAngeles() {

    }

    @Then("^be verifies the title in the first publication$")
    public void beVerifiesTheTitleInTheFirstPublication() {

    }

}
