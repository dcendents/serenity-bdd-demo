package org.serenitybdd.demo.control.fooling.steps;

import org.serenitybdd.demo.control.fooling.pages.GooglePage;
import org.serenitybdd.demo.control.fooling.pages.ProxyBlockedPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class EmployeeSteps extends ScenarioSteps {

    public EmployeeSteps(Pages pages) {
        super(pages);
    }

    @Step
    public void opens_the_search_page() {
        onSearchPage().open();
    }

    @Step
    public void searches_for(String search_terms) {
        onSearchPage().searchFor(search_terms);
    }

    @Step
    public void dares_to_open_page(String linkName) {
    	
Serenity.takeScreenshot();

    	onSearchPage().clickOn(linkName);
    }

    @Step
    public void should_be_reminded_site_is_blocked(String category) {
    	onProxyPage().titleShouldContain("Access denied");
    	onProxyPage().bodyShouldContain("categorization: \"" + category + "\"");
    }

    private GooglePage onSearchPage() {
        return getPages().get(GooglePage.class);
    }

    private ProxyBlockedPage onProxyPage() {
        return getPages().get(ProxyBlockedPage.class);
    }
}