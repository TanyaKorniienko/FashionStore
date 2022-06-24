package org.fashionstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
    WebDriver driver;
    public MainPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div//a[@class='login']")
    WebElement signInButton;

    public AuthenticationPage clickSignInButton(){
        signInButton.click();
        return new AuthenticationPage((ChromeDriver) driver);
    }
}
