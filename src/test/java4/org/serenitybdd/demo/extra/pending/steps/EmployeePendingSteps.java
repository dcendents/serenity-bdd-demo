package org.serenitybdd.demo.extra.pending.steps;

import static org.assertj.core.api.BDDAssertions.then;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class EmployeePendingSteps extends ScenarioSteps {

    public EmployeePendingSteps(Pages pages) {
        super(pages);
    }

    @Step
    @Pending
    public void opens_the_search_page() {
		then(true).isFalse();
    }

    @Step
    @Pending
    public void searches_for(String search_terms) {
		then(true).isFalse();
    }

    @Step
    @Pending
    public void dares_to_open_page(String linkName) {
		then(true).isFalse();
    }

    @Step
    @Pending
    public void should_be_reminded_site_is_blocked(String category) {
		then(true).isFalse();
    }
}