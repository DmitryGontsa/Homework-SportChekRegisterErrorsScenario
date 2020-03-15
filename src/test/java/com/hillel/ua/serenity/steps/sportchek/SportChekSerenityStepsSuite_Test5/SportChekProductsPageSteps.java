package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test5;

import com.hillel.ua.common.UrlBuilder;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test5.SportChekProductsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static com.hillel.ua.common.EnvironmentProperties.SPORTCHEK_BASE_URL;

public class SportChekProductsPageSteps extends ScenarioSteps {

    private SportChekProductsPage sportChekProductsPage;

    public SportChekProductsPageSteps(final Pages pages) {
        this.sportChekProductsPage = pages.getPage(SportChekProductsPage.class);
    }

    @Step
    public void openProductsPageByPartialUrl() {
        final String fullNavUrl = UrlBuilder.buildFullUrl(SPORTCHEK_BASE_URL, SportChekProductsPage.class);
        sportChekProductsPage.openUrl(fullNavUrl);
        sportChekProductsPage.scrollToTop();
    }

    @Step
    public void selectSortByButton() {
        sportChekProductsPage.clickSortByButton();
    }

    @Step
    public void selectRatingItem() {
        sportChekProductsPage.clickRatingItem();
    }

    @Step
    public List<String> getProductsItemsSortedByRatingValue() {
        return sportChekProductsPage.getProductItemText();
    }
}
