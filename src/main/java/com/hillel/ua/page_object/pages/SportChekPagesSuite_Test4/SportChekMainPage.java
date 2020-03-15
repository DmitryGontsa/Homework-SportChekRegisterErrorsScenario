package com.hillel.ua.page_object.pages.SportChekPagesSuite_Test4;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.SportChekPanelsSuite_Test4.SportChekHeaderPanel;
import org.openqa.selenium.WebDriver;

public class SportChekMainPage extends AbstractPage {

    private static final String HEADER_PANEL = "//header[@class='page-header']";

    public SportChekMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SportChekHeaderPanel getHeaderPanel() {
        return new SportChekHeaderPanel(findBy(HEADER_PANEL), this);
    }
}
