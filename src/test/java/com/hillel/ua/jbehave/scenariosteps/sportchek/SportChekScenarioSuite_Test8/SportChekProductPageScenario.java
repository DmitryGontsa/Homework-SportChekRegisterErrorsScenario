package com.hillel.ua.jbehave.scenariosteps.sportchek.SportChekScenarioSuite_Test8;

import com.hillel.ua.page_object.model.ProductModel;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test8.SportChekProductPageSteps;
import com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test8.SportChekShoppingCartPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportChekProductPageScenario {

    @Steps
    private SportChekProductPageSteps sportChekProductPageSteps;

    @Steps
    private SportChekShoppingCartPageSteps sportChekShoppingCartPageSteps;

    @Given("user opened 'Product Page' on Sportchek website")
    public void openProductPage() {
        sportChekProductPageSteps.openProductPageByPartialUrl();
    }

    @When("user selected product size")
    public void selectRandomlyProductSize() {
        sportChekProductPageSteps.selectItemBySizeWithRandomlySelection();
    }

    @When("user clicked on 'ADD TO CART' button")
    public void clickOnAddToCartButton() {
        sportChekProductPageSteps.clickOnAddToCartButton();
    }

    @When("user clicked on 'SHOPPING CART' icon")
    public void clickOnShoppingCartIcon() {
        sportChekProductPageSteps.clickOnShoppingCartIcon();
    }

    @Then("user verify product items on Shopping Cart page, with following data displayed: $table")
    public void verifyProductItemsData(final ExamplesTable table) {
        final ProductModel actualProductItemsData = sportChekShoppingCartPageSteps.getProductSpecifications();
        final ProductModel expectedProductItemsData = table.getRowsAs(ProductModel.class).get(0);

        // Мы достаём productSize и сетим его в наш expectedProductItemsData, поскольку productSize был выбран рандомно.
        final String productSize = actualProductItemsData.getProductSize();
        expectedProductItemsData.setProductSize(productSize);

        ReflectionAssert.assertReflectionEquals("Actual product parameters don't match expected product parameters!",
                expectedProductItemsData, actualProductItemsData);
    }
}
