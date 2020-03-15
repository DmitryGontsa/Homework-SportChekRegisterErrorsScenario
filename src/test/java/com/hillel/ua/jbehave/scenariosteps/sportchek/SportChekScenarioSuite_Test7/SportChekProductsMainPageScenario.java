package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test7;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test7.ProductsMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.List;

public class SportChekProductsMainPageScenario {

    @Steps
    private ProductsMainPageSteps productsMainPageSteps;

    @Given("user opened 'Sportchek products main page'")
    public void openProductsMainPage() {
        productsMainPageSteps.openProductsMainPageByPartialUrl();
    }

    @When("user clicks to item by brand 'ROSSIGNOL'")
    public void selectItemByBrand() {
        productsMainPageSteps.clickToItemByBrand();
    }

    @Then("user verify products titles according chosen brand displayed: '$productTitle'")
    public void verifyProductsTitlesAccordingByChosenFilter(final String expectedProductTitle) {
        final List<String> actualProductTitle = productsMainPageSteps.getProductsTitles();
        for (String productTitle : actualProductTitle) {
            Assert.assertTrue(productTitle.contains(expectedProductTitle));
        }
    }

    @Then("user clicks to 'CLEAR ALL' button")
    public void selectClearAllButton() {
        productsMainPageSteps.clickToClearAllButton();
    }

    @Then("user verify that all filters dropped and certain quantity items present displayed: '$quantityItems'")
    public void verificationByDroppingAllFilters(final String expectedQuantityItems) {
        final String actualQuantityItems = productsMainPageSteps.getResultsQuantityValue();
        Assert.assertEquals("This is incorrect Quantity Items, all filters are not dropped !!!",
                expectedQuantityItems, actualQuantityItems);
    }
}
