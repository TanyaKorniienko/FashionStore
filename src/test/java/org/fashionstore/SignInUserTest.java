package org.fashionstore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignInUserTest {
    private WebDriver driver;
    private MainPage main_Page;
    private AuthenticationPage authentication_Page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com");
        main_Page = new MainPage((ChromeDriver) driver);
        authentication_Page = new AuthenticationPage((ChromeDriver) driver);
    }

    @Test
    public void sign_In_User() {
        main_Page.clickSignInButton();
        authentication_Page.input_Existing_User_Data("elenarobertson37+81@gmail.com", "123456");
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://automationpractice.com/index.php?controller=my-account");
        System.out.println("URL is matching");
    }

    @After
    public void close() {
        driver.quit();
    }
}
