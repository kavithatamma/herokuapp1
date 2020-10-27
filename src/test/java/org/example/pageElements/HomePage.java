package org.example.pageElements;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverManager {
    @FindBy(linkText = "Form Authentication")
    private WebElement FormAuthentication;

    public void clickFormAuthentication(){
        FormAuthentication.click();
    }
}
