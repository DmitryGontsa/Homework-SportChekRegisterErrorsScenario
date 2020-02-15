package com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test3;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SportChekHeaderPanel extends AbstractPanel {

    private static final String SHOPPING_CART_BUTTON = ".//a[@class='header-cart__trigger drawer-ui__toggle']";
    private static final String SHOPPING_CART_PANEL = ".//div[@class='header-cart__container']";

    public SportChekHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void hoverMouseOnShoppingCartIcon() {
        AbstractPage abstractPage = new AbstractPage(getDriver());
        abstractPage.scrollToTop();
        abstractPage.moveToElement(SHOPPING_CART_BUTTON);
    }

    public SportChekShoppingCartPanel getShoppingCartPanel() {
        return new SportChekShoppingCartPanel(findBy(SHOPPING_CART_PANEL), getDriverDelegate());
    }
}
