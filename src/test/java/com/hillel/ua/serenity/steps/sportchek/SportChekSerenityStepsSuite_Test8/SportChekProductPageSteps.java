package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test8;

import com.hillel.ua.common.UrlBuilder;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test8.SportChekProductPage;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test8.SportChekShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static com.hillel.ua.common.EnvironmentProperties.SPORTCHEK_BASE_URL;

public class SportChekProductPageSteps extends ScenarioSteps {

    private SportChekProductPage sportChekProductPage;

    public SportChekProductPageSteps(final Pages pages) {
        this.sportChekProductPage = pages.getPage(SportChekProductPage.class);
    }

    @Step
    public void openProductPageByPartialUrl() {
        final String fullNavigateUrl = UrlBuilder.buildFullUrl(SPORTCHEK_BASE_URL, SportChekProductPage.class);
        sportChekProductPage.openUrl(fullNavigateUrl);
        sportChekProductPage.scrollToTop();
    }

    @Step
    public void selectItemBySizeWithRandomlySelection() {
        sportChekProductPage.selectRandomlyItemBySize();
    }

    @Step
    public void clickOnAddToCartButton() {
        sportChekProductPage.clickOnAddToCartButton();
    }

    @Step
    public SportChekShoppingCartPage clickOnShoppingCartIcon() {
        return sportChekProductPage.clickOnShoppingCartIcon();
    }
}
