package org.serenitybdd.demo.money;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetResolver;

public class ChainedTarget extends Target {

    private final List<By> locators;

	public ChainedTarget(String targetElementName, List<By> locators) {
		super(targetElementName);
		this.locators = locators;

		if (locators.size() < 2) {
			throw new UnsupportedOperationException("The LinkedTarget expects at least 2 selectors");
		}
	}

    public static ChainedTargetBuilder these(String targetElementName) {
        return new ChainedTargetBuilder(targetElementName);
    }

    public WebElementFacade resolveFor(Actor theActor) {
        TargetResolver resolver = new TargetResolver(BrowseTheWeb.as(theActor).getDriver());

        WebElementFacade resolvedTarget = resolver.find(locators.get(0));

        for (int i = 0; i < locators.size(); i++) {
        	resolvedTarget = resolvedTarget.find(locators.get(i));
        }

        return resolvedTarget;
    }

    public List<WebElementFacade> resolveAllFor(Actor actor) {
        TargetResolver resolver = new TargetResolver(BrowseTheWeb.as(actor).getDriver());

        WebElementFacade resolvedTarget = resolver.find(locators.get(0));

        for (int i = 0; i < locators.size() - 1; i++) {
        	resolvedTarget = resolvedTarget.find(locators.get(i));
        }

        return resolvedTarget.thenFindAll(locators.get(locators.size() - 1));
    }

	@Override
	public Target called(String name) {
		return new ChainedTarget(name, locators);
	}

    @Override
    public String getCssOrXPathSelector() {
        throw new UnsupportedOperationException("The getCssOrXPathSelector() method is not supported for By-type Targets");
    }

	@Override
	public Target of(String... parameters) {
		throw new UnsupportedOperationException("The of() method is not supported for By-type Targets");
	}
}
