package org.serenitybdd.demo.control.productivity.questions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.targets.Target;

public class TheDisplayedPage extends WebElementQuestion {

	public TheDisplayedPage() {
		super(Target.the("page text").located(By.tagName("body")));
	}

}
