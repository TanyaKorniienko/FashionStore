package org.fashionstore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CreateAccountPage {
    WebDriver driver;
    private String user_Name;
    private String user_Surname;
    private String user_Password;
    private String user_Address;
    private String user_City;
    private String zip_Code;
    private String phone_Number;

    public CreateAccountPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='id_gender2']")
    WebElement gender;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement first_Name;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement last_Name;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement userPassword;

    @FindBy(xpath = "//select[@id='days']//option")
    List<WebElement> days;

    @FindBy(xpath = "//select[@id='months']//option")
    List<WebElement> months;

    @FindBy(xpath = "//select[@id='years']//option")
    List<WebElement> year;

    @FindBy(xpath = "//div[@id='uniform-newsletter']")
    WebElement newsSubs;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address;

    @FindBy(xpath = "//select[@id='id_state']//option")
    List<WebElement> states;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cities;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipcode;

    @FindBy(xpath = " //input[@id='phone_mobile']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='alias']")
    WebElement alias;

    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement submit_Button;

    public void inputRegistrationForm(String user_Name, String user_Surname, String user_Password,
                                      String user_Address, String user_City, String zip_Code,
                                      String phone_Number, String text) {
        gender.click();
        first_Name.sendKeys(user_Name);
        last_Name.sendKeys(user_Surname);
        userPassword.sendKeys(user_Password);
        address.sendKeys(user_Address);
        days.get(5).click();
        months.get(7).click();
        year.get(7).click();
        newsSubs.click();
        cities.sendKeys(user_City);
        states.get(9).click();
        zipcode.sendKeys(zip_Code);
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        phoneNumber.sendKeys((phone_Number) + n);
        alias.clear();
        alias.sendKeys(text);
        click_Submit_Button();
    }

    public UserInfoPage click_Submit_Button() {
        submit_Button.click();
        return new UserInfoPage((ChromeDriver) driver);
    }
}
