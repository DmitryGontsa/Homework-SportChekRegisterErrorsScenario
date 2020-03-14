package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test8;

import com.hillel.ua.page_object.model.ProductModel;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test8.SportChekShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportChekShoppingCartPageSteps extends ScenarioSteps {

    private SportChekShoppingCartPage sportChekShoppingCartPage;

    public SportChekShoppingCartPageSteps(final Pages pages) {
        this.sportChekShoppingCartPage = pages.getPage(SportChekShoppingCartPage.class);
    }

    @Step
    public ProductModel getProductSpecifications() {
        return sportChekShoppingCartPage.getProductSpecifications();
    }
}
