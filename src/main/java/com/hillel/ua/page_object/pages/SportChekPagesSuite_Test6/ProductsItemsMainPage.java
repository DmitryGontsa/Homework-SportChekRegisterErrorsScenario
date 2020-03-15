package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test6;

import com.hillel.ua.common.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=20")
public class ProductsItemsMainPage extends AbstractPage {

    private static final String ITEM_BY_BRAND = "(//span[@class='checkbox'])[11]";
    private static final String PRODUCTS_TITLES = "//span[@class='product-title-text']";

    public ProductsItemsMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectItemByBrand() {
        moveToElement(ITEM_BY_BRAND);
        findBy(ITEM_BY_BRAND).waitUntilVisible().click();
    }

    public List<String> getProductsTitlesText() {
        return findAll(PRODUCTS_TITLES)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
