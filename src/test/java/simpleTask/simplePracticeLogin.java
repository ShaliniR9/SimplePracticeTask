package simpleTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class simplePracticeLogin {

    WebDriver driver;

    public simplePracticeLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the elements
    }

    // Find email input field
    @FindBy(id = "user_email")
    WebElement emailField;

    // Find password input field
    @FindBy(id = "user_password")
    WebElement passwordField;

    // Find login button
    @FindBy(id = "submitBtn")
    WebElement loginBtn;

    // click login
    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

}
