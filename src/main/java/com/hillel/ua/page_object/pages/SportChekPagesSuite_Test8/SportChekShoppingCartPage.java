package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test8;

import com.hillel.ua.page_object.model.ProductModel;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class SportChekShoppingCartPage extends AbstractPage {

    private static final String PRODUCT_TITLE = "//a[@class='sc-product__title-link']";
    private static final String PRODUCT_COLOUR = "(//span[@class='sc-product__property__value']/span/..)[1]";
    private static final String PRODUCT_SIZE = "(//span[@class='sc-product__property__value']/span/..)[2]";
    private static final String PRODUCT_QUANTITY = "//input[@class='sc-product__qty']";
    private static final String PRODUCT_PRICE = "(//div[@class='sc-product__price-wrap']/span)[1]";
    private static final String PRODUCT_ESTIMATED_TOTAL_PRICE = "(//div[@class='sc-product__price-wrap']/span)[2]";

    public SportChekShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductModel getProductSpecifications() {
        String productTitle = findBy(PRODUCT_TITLE).waitUntilVisible().getText();

        String value1 = findBy(PRODUCT_COLOUR).waitUntilVisible().getText();
        String productColour = value1.substring(7);

        String value2 = findBy(PRODUCT_SIZE).waitUntilVisible().getText();
        String productSize = value2.substring(5);

        String productQuantity = findBy(PRODUCT_QUANTITY).waitUntilVisible().getAttribute("value");

        String value3 = (findBy(PRODUCT_PRICE).waitUntilVisible().getText());
        String productPrice = value3.substring(1);

        String value4 = findBy(PRODUCT_ESTIMATED_TOTAL_PRICE).waitUntilVisible().getText();
        String productEstimatedTotalPrice = value4.substring(1);

        ProductModel productModel = new ProductModel(productTitle, productColour, productSize, productQuantity, productPrice, productEstimatedTotalPrice);
        return productModel;
    }
}
