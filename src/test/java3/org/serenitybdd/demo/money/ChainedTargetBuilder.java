package org.serenitybdd.demo.money;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class ChainedTargetBuilder {
    private String targetElementName;
    private List<By> locators;

    public ChainedTargetBuilder(String targetElementName) {
        this.targetElementName = targetElementName;
        this.locators = new ArrayList<>();
    }

    public ChainedTargetBuilder located(By locator) {
    	locators.add(locator);
        return this;
    }

    public ChainedTargetBuilder andThen(By locator) {
    	locators.add(locator);
        return this;
    }

    public ChainedTarget andfinally(By locator) {
    	locators.add(locator);
        return new ChainedTarget(targetElementName, locators);
    }
}
