package org.fashionstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AuthenticationPage {
    WebDriver driver;
    private String new_User_email;
    private String email_Of_existing_User;
    private String password_Of_existing_User;

    public AuthenticationPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='form-group']//input[@id='email_create']")
    WebElement email_Field;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement create_AccountButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email_Field_For_existing_User;

    @FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
    WebElement password_Field_For_existing_User;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement sign_In_Button;


    public String getEmailRandoms() {
        String CHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        while (s.length() < 10) {
            int index = (int) (r.nextFloat() * CHARS.length());
            s.append(CHARS.charAt(index));
        }
        String sStr = s.toString();
        return sStr;
    }

    public CreateAccountPage input_Email_To_Create_Account(String new_User_email) {
        email_Field.sendKeys(new_User_email);
        create_AccountButton.click();
        return new CreateAccountPage((ChromeDriver) driver);
    }
    public UserInfoPage input_Existing_User_Data(String email_Of_existing_User, String password_Of_existing_User) {
        email_Field_For_existing_User.sendKeys(email_Of_existing_User);
        password_Field_For_existing_User.sendKeys(password_Of_existing_User);
        sign_In_Button.click();
        return new UserInfoPage((ChromeDriver) driver);
    }
}
