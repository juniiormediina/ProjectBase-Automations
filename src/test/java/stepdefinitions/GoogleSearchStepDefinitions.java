package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.SearchError;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.CheckWork;
import tasks.InputGoogle;
import tasks.OpenGoogle;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.ErrorConstants.SEARCH_FAILED;

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
        theActorInTheSpotlight().wasAbleTo(OpenGoogle.thePageGoogle());
    }

    @When("^be search the word angeles$")
    public void beSearchTheWordAngeles(String word) {
        theActorInTheSpotlight().attemptsTo(InputGoogle.aWord(word));
    }

    @Then("^be verifies the title in the first publication$")
    public void beVerifiesTheTitleInTheFirstPublication() {
        theActorInTheSpotlight().should(seeThat(CheckWork.inTheScreen())
                .orComplainWith(SearchError.class, SEARCH_FAILED));
    }

}
