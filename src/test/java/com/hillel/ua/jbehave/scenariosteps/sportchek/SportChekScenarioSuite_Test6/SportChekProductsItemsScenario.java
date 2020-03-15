package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test6;

import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test6.ProductsItemsMainPageSteps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportChekProductsItemsScenario {

    @Steps
    private ProductsItemsMainPageSteps productsItemsMainPageSteps;

    @Given("user opened 'SportChek' website")
    public void openSite() {
        productsItemsMainPageSteps.openProductsMainPageByPartialUrl();
    }

    @When("user selected product item by BRANDS 'ATOMIC'")
    public void selectProductItemByBrand() {
        productsItemsMainPageSteps.selectItemByBrand();
    }

    @Then("user checks products titles by chosen brand displayed: '$productTitle'")
    public void verifyProductTitleAccordingToTheChosenBrand(final String expectedProductTitle) {
        final List<String> actualProductTitle = productsItemsMainPageSteps.getProductsTitles();
        for (String productTitle : actualProductTitle) {
            Assert.assertTrue(productTitle.contains(expectedProductTitle));
        }
    }
}