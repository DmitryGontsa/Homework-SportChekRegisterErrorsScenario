package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test8;

import com.hillel.ua.common.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

@PartialUrl(value = "categories/kids/boys/jackets/product/helly-hansen-boys-cascade-insulated-jacket-332867009.html#332867009%5Bcolor%5D=332867009_04")
public class SportChekProductPage extends AbstractPage {

    private static final String ITEMS_BY_SIZE = "//a[@class='option-tiles__item ']";
    private static final String ADD_TO_CART_BUTTON = "//button[@class='add-cart product-detail__button product-detail__button-icon']";
    private static final String SHOPPING_CART_ICON = "//a[@class='header-cart__trigger drawer-ui__toggle']";

    public SportChekProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectRandomlyItemBySize() {
        List<WebElementFacade> itemsBySize = getItemsBySize();
        Random rand = new Random();
        WebElementFacade randomWebElement = itemsBySize.get(rand.nextInt(itemsBySize.size()));
        randomWebElement.waitUntilVisible().click();
    }

    public void clickOnAddToCartButton() {
        moveToElement(ADD_TO_CART_BUTTON);
        findBy(ADD_TO_CART_BUTTON).waitUntilVisible().click();
    }

    public SportChekShoppingCartPage clickOnShoppingCartIcon() {
        moveToElement(SHOPPING_CART_ICON);
        findBy(SHOPPING_CART_ICON).waitUntilVisible().click();
        return new SportChekShoppingCartPage(getDriver());
    }

    public List<WebElementFacade> getItemsBySize() {
        // Предусмотрел фильтрацию недоступных для выбора размеров, с помощью xPath выражения: ITEMS_BY_SIZE = "//a[@class='option-tiles__item ']";
        List<WebElementFacade> webElements = findAll(ITEMS_BY_SIZE);
        return webElements;
    }
}
