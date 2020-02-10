package com.hillel.ua.serenity.steps.sportchek.SportChekSerenityStepsSuite_Test1;

import com.hillel.ua.page_object.pages.SportChekPagesSuite_Test1.SportChekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SportChekPredictiveSearchPanelSteps extends ScenarioSteps {

    private SportChekMainPage sportChekMainPage;

    public SportChekPredictiveSearchPanelSteps(final Pages pages) {
        this.sportChekMainPage = pages.getPage(SportChekMainPage.class);
    }

    @Step
    public List<String> getPredictiveSearchMenuItems() {
        return sportChekMainPage.getHeaderPanel().getPredictiveSearchPanel().getPredictiveSearchItems();
    }
}
