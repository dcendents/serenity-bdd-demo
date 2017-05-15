package org.serenitybdd.demo.money.productivity.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {

	public static Target SEARCH_INPUT  = Target.the("Search Input").located(By.name("q"));

}