package org.serenitybdd.demo.control.fooling.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {

    @FindBy(name="q")
    WebElement search;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String keywords) {
        search.sendKeys(keywords, Keys.ENTER);
        waitFor(titleContains("Google Search"));
        waitForRenderedElementsToBePresent(By.linkText(keywords));
    }

    public void clickOn(String keywords) {
    	WebElementFacade link = find(By.linkText(keywords));
    	link.shouldBeVisible();
    	link.click();
    }
}