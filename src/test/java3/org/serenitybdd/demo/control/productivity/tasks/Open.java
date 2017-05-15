package org.serenitybdd.demo.control.productivity.tasks;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Open implements Task {

	private String theLink;

	public Open(String value) {
		this.theLink = value;
	}

	@Override
	@Step("{0} clicks on the link #theLink")
	public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Click.on(Target.the("the link").located(By.linkText(theLink))));
	}

	public static Open theLink(String value) {
		return Instrumented.instanceOf(Open.class).withProperties(value);
	}

}
