package org.fashionstore;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class SignUpNewUserTest {
    private WebDriver driver;
    private MainPage main_Page;
    private AuthenticationPage authentication_Page;
    private WebDriverWait driver_Wait;
    private CreateAccountPage create_Account_Page;
    private UserInfoPage userInfoPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("http://automationpractice.com");
        main_Page = new MainPage((ChromeDriver) driver);
        authentication_Page = new AuthenticationPage((ChromeDriver) driver);
        create_Account_Page = new CreateAccountPage((ChromeDriver) driver);
        driver_Wait = new WebDriverWait(driver, Duration.ofSeconds(55));
        userInfoPage = new UserInfoPage((ChromeDriver) driver);
    }

    @Test
    public void sigUp_New_User() {
        main_Page.clickSignInButton();
        authentication_Page.input_Email_To_Create_Account("elena" + authentication_Page.getEmailRandoms() + "@gmail.com");
        driver_Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='create-account_form']")));
        create_Account_Page.inputRegistrationForm("Elena", "Robertson",
                "123456", "Wall Street 5", "User City",
                "09899", "+124086675", "Some address");

        driver_Wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text()," +
                        "'Welcome to your account. Here you can manage all of your personal information and orders.')]")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://automationpractice.com/index.php?controller=my-account");
        System.out.println("URL is matching");
    }
    @After
    public void close() {
        driver.quit();
    }
}
