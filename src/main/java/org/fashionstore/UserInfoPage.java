package org.fashionstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
    WebDriver driver;
    public UserInfoPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
