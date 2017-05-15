package org.serenitybdd.demo.money.productivity.tasks;

import org.serenitybdd.demo.money.productivity.pages.GooglePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class OpenGoogle implements Task {

	@Override
	@Step("{0} opens the google page")
	public <T extends Actor> void performAs(T actor) {
		BrowseTheWeb.as(actor).onPage(GooglePage.class).open();
	}

}
