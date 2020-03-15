package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test7;

import com.hillel.ua.common.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=20")
public class ProductsMainPage extends AbstractPage {

    private static final String ITEM_BY_BRAND = "(//span[@class='checkbox'])[13]";
    private static final String PRODUCTS_TITLES = "//span[@class='product-title-text']";
    private static final String CLEAR_ALL_BUTTON = "//a[@class='facets-side__footer-link facets-side__clear-link']";
    private static final String RESULTS_QUANTITY_ITEM = "//div[@data-module-type='ResultsQuantity']";

    public ProductsMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectItemByBrand() {
        moveToElement(ITEM_BY_BRAND);
        findBy(ITEM_BY_BRAND).waitUntilVisible().click();
    }

    public void selectClearAllButton() {
        moveToElement(CLEAR_ALL_BUTTON);
        findBy(CLEAR_ALL_BUTTON).waitUntilVisible().click();
    }

    public String getResultsQuantityItemText() {
        moveToElement(RESULTS_QUANTITY_ITEM);
        final String resultsQuantityValue = findBy(RESULTS_QUANTITY_ITEM).waitUntilVisible().getText();
        return resultsQuantityValue;
    }

    public List<String> getProductsTitlesText() {
        return findAll(PRODUCTS_TITLES)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
