package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test3;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test3.SportChekHeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test3.SportChekMainPageSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test3.SportChekShoppingCartPanelSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportChekShoppingCartScenario {

    @Steps
    private SportChekMainPageSteps sportChekMainPageSteps;

    @Steps
    private SportChekHeaderPanelSteps sportChekHeaderPanelSteps;

    @Steps
    private SportChekShoppingCartPanelSteps sportChekShoppingCartPanelSteps;

    @Given("user opened web site, using next url: '$url'")
    public void openSite(final String url) {
        sportChekMainPageSteps.openMainPage(url);
    }

    @When("user hovering mouse on shopping cart icon")
    public void moveToShoppingCartIcon() {
        sportChekHeaderPanelSteps.moveToShoppingCartIcon();
    }

    @Then("user checks following message displayed: '$text'")
    public void verifyShoppingCartMessage(final String text) {
        final String expectedShoppingCartText = text;
        final String actualShoppingCartText = sportChekShoppingCartPanelSteps.getShoppingCartText();
        ReflectionAssert.assertReflectionEquals("This is incorrect shopping cart text displayed!",
                expectedShoppingCartText, actualShoppingCartText);
    }
}
