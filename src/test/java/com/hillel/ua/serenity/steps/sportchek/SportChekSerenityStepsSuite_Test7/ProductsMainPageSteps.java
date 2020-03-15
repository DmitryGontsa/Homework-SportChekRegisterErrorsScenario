package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test7;

import com.hillel.ua.common.UrlBuilder;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test7.ProductsMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static com.hillel.ua.common.EnvironmentProperties.SPORTCHEK_BASE_URL;

public class ProductsMainPageSteps extends ScenarioSteps {

    private ProductsMainPage productsMainPage;

    public ProductsMainPageSteps(final Pages pages) {
        this.productsMainPage = pages.getPage(ProductsMainPage.class);
    }

    @Step
    public void openProductsMainPageByPartialUrl() {
        final String fullNavigateUrl = UrlBuilder.buildFullUrl(SPORTCHEK_BASE_URL, ProductsMainPage.class);
        productsMainPage.openUrl(fullNavigateUrl);
        productsMainPage.scrollToTop();
    }

    @Step
    public void clickToItemByBrand() {
        productsMainPage.selectItemByBrand();
    }

    @Step
    public List<String> getProductsTitles() {
        return productsMainPage.getProductsTitlesText();
    }

    @Step
    public void clickToClearAllButton() {
        productsMainPage.selectClearAllButton();
    }

    @Step
    public String getResultsQuantityValue() {
        return productsMainPage.getResultsQuantityItemText();
    }
}
