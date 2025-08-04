package simpleTask;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class simplePracticeTask {
    WebDriver driver;

    public simplePracticeTask(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes the elements
    }

    //Find Task button
    @FindBy(id = "ember76")
    WebElement TaskBtn;

    //Find create Task button
    @FindBy(id = "ember183")
    WebElement CreateTaskBtn;

    //Find Task Name field
    @FindBy(id = "title")
    WebElement taskNameField;

    //Find description field
    @FindBy(id = "description")
    WebElement descriptionField;

    //Find datePicker
    @FindBy(name="datePicker")
    WebElement datepicker;

    //Find time
    @FindBy(id = "timePicker")
    WebElement timefield;

    //Find dropdown
    @FindBy(id = "ember240")
    WebElement dropdown;

    //Find dropdownvalue
    @FindBy(id = "spds-menu-item-254")
    WebElement dropdownvalue;

    //Find clientdropdown
    @FindBy(id = "ember271")
    WebElement clientdropdown;

    //Find clientdropdownvalue
    @FindBys({
            @FindBy(css = ".select-box__input.altered-placeholder-shown")
    })
    List<WebElement> dropdownvalues;

    //Find AssignedTeam
    @FindBy(id = "ember275")
    WebElement AssignedTo;


    //Find savebutton
    @FindBy(xpath = "//button[normalize-space(text())='Save']")
    WebElement saveBtn;


    // click Task
    public void clickTask(){
        TaskBtn.click();
    }

    // click create Task
    public void clickcreateTask(){
        CreateTaskBtn.click();
    }

    public void createTask(String taskName, String description, String date,
                           String time, String clientName, String teamName)
            throws InterruptedException {

        taskNameField.sendKeys(taskName);
        descriptionField.sendKeys(description);

        // Set date and time
        datepicker.sendKeys(date);
        datepicker.sendKeys(Keys.TAB);
        timefield.sendKeys(time);

        // Select dropdown values
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownvalue));
        dropdownvalue.click();


        // Select client from dropdown
        clientdropdown.click();
        selectDropdownValue(dropdownvalues.get(0), clientName);

        // Assign to team
        AssignedTo.click();
        selectDropdownValue(dropdownvalues.get(0), teamName);
    }

    private void selectDropdownValue(WebElement inputField, String value)
            throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(inputField));

        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);

        // Wait briefly for dropdown options to load
        Thread.sleep(2000);

        // Use keyboard to select
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void clickSave() {
        saveBtn.click();
    }
}
