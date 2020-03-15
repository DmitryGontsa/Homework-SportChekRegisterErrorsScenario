package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test5;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test5.SportChekProductsPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class SportChekSortedByRatingScenario {

    @Steps
    private SportChekProductsPageSteps sportChekProductsPageSteps;

    @Given("user opened 'Sportchek Products Page'")
    public void openMainPage() {
        sportChekProductsPageSteps.openProductsPageByPartialUrl();
    }

    @When("user selected 'Sort By' button")
    public void selectSortByButton() {
        sportChekProductsPageSteps.selectSortByButton();
    }

    @When("user selected 'Rating From High to Low' item")
    public void selectRatingItem() {
        sportChekProductsPageSteps.selectRatingItem();
    }

    @Then("user checks Products Items sorted by 'Rating From High to Low' displayed: '$sortingByRating'")
    public void verifyProductsItemsSortedByRating(final List<String> expectedSortingByRating) {
        final List<String> actualSortingByRating = sportChekProductsPageSteps.getProductsItemsSortedByRatingValue();

        ReflectionAssert.assertReflectionEquals("This is incorrect sorting by rating displayed!",
                expectedSortingByRating, actualSortingByRating);
    }
}
