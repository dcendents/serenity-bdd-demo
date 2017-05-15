package org.serenitybdd.demo.control.productivity.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class GooglePage extends PageObject {

	public static final String URL = "http://www.google.com";
	
	public static Target SEARCH_INPUT  = Target.the("Search Input").located(By.name("q"));

}