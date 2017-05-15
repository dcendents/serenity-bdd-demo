package org.serenitybdd.demo.money.productivity.tasks;


import static org.openqa.selenium.Keys.RETURN;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import java.util.List;

import org.serenitybdd.demo.money.productivity.pages.GooglePage;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class PerformSearch implements Task {

	private List<String> searchValues;

	public PerformSearch(List<String> values) {
		this.searchValues = values;
	}

	@Override
	@Step("{0} searches for #searchValues")
	public <T extends Actor> void performAs(T theActor) {
		String toSearch = Joiner.on(" ").join(searchValues);

        theActor.attemptsTo(
        		Enter.theValue(toSearch).into(GooglePage.SEARCH_INPUT),
        		Hit.the(RETURN).keyIn(GooglePage.SEARCH_INPUT)
        );

		BrowseTheWeb.as(theActor).waitFor(titleContains("Google Search"));
		BrowseTheWeb.as(theActor).waitForRenderedElementsToBePresent(By.linkText(searchValues.get(0)));
	}

	public static PerformSearch of(String... values) {
		return Instrumented.instanceOf(PerformSearch.class).withProperties(ImmutableList.copyOf(values));
	}

}
