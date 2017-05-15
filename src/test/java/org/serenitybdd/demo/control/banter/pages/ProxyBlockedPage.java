package org.serenitybdd.demo.control.banter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.google.com")
public class ProxyBlockedPage extends PageObject {

    @FindBy(name="q")
    WebElement search;
    
    public ProxyBlockedPage(WebDriver driver) {
        super(driver);
    }

}