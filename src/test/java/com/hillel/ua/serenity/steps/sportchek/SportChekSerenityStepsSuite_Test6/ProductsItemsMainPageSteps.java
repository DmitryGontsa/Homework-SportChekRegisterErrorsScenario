package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test6;

import com.hillel.ua.common.UrlBuilder;
import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test6.ProductsItemsMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

import static com.hillel.ua.common.EnvironmentProperties.SPORTCHEK_BASE_URL;

public class ProductsItemsMainPageSteps extends ScenarioSteps {

    private ProductsItemsMainPage productsItemsMainPage;

    public ProductsItemsMainPageSteps(final Pages pages) {
        this.productsItemsMainPage = pages.getPage(ProductsItemsMainPage.class);
    }

    @Step
    public void openProductsMainPageByPartialUrl() {
        final String fullNavUrl = UrlBuilder.buildFullUrl(SPORTCHEK_BASE_URL, ProductsItemsMainPage.class);
        productsItemsMainPage.openUrl(fullNavUrl);
        productsItemsMainPage.scrollToTop();
    }

    @Step
    public void selectItemByBrand() {
        productsItemsMainPage.selectItemByBrand();
    }

    @Step
    public List<String> getProductsTitles() {
        return productsItemsMainPage.getProductsTitlesText();
    }
}
