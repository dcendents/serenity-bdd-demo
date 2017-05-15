package org.serenitybdd.demo.control.fooling.pages;

import static org.assertj.core.api.BDDAssertions.then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class ProxyBlockedPage extends PageObject {

    @FindBy(tagName = "body")
    WebElement body;

    public ProxyBlockedPage(WebDriver driver) {
        super(driver);
    }

    public void titleShouldContain(String title) {
		then(getTitle()).contains(title);
    }

    public void bodyShouldContain(String text) {
		then(body.getText()).contains(text);
    }

}