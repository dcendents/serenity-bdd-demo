package org.serenitybdd.demo.money.productivity.pages;

import org.serenitybdd.demo.money.ChainedTarget;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {

	private static org.openqa.selenium.By byFormName  = By.id("searchform");
	public static Target FORM  = Target.the("Search form").located(byFormName);
	public static Target SEARCH_INPUT  = ChainedTarget.these("Search Input").located(byFormName).andfinally(By.name("q"));

}