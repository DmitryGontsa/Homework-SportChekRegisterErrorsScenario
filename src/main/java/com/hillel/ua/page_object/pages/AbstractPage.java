package com.hillel.ua.page_object.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver webDriver) {
        super(webDriver);
        getDriver().manage().window().maximize();
        waitForAngularRequestsToFinish();
        scrollToTop();
    }

    public void scrollToTop() {
        final String scrollScript = "window.scrollTo(0, -1000);";
        getJavascriptExecutorFacade().executeScript(scrollScript);
    }

    public void scrollToWebElement(final String xPathOrCssLocator) {
        WebElement element = getDriver().findElement(By.xpath(xPathOrCssLocator));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public Actions moveToElement(String xpathOrCSSLocator) {
        Actions builder = new Actions(getDriver());
        Actions hoverOverLocationSelector = builder.moveToElement(findBy(xpathOrCSSLocator));
        hoverOverLocationSelector.perform();
        return hoverOverLocationSelector;
    }
}
