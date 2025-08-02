package simpleTask;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class simplePracticeComplete {
    static WebDriver driver;

    public simplePracticeComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the elements
    }

    //Find Assign Filter
    @FindBy(id = "ember193")
    WebElement assignFilter;

    @FindBy(xpath = "//div[contains(@class, 'item ember-view')]//span[normalize-space()='QA Supervisor']")
    WebElement assignValue;

    @FindBy(xpath = "//button[contains(@class, 'utility-button-style') and span[normalize-space()='Incomplete']]")
    WebElement statusFilter;

    @FindBy(xpath = "//div[contains(@class, 'item ember-view')]//span[normalize-space()='All']")
    WebElement statusValue;

    @FindBy(className = "utility-search")
    WebElement searchField;

    @FindBy(className = "checkable-circle")
    WebElement markComplete;

    public void completeTask(String taskName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(assignFilter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(assignValue)).click();

        wait.until(ExpectedConditions.elementToBeClickable(statusFilter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(statusValue)).click();

        searchField.sendKeys(taskName);

        wait.until(ExpectedConditions.elementToBeClickable(markComplete)).click();
    }

    public static boolean isTaskCompleted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'I26t1')]//div[contains(@class,'M+cYT')]//div[contains(@class,'item')]")
        ));
        String text = element.getText();
        System.out.println(text);
        return text.contains("Completed");
    }




}
