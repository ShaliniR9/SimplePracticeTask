package simpleTaskTest;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import simpleTask.simplePracticeComplete;
import simpleTask.simplePracticeLogin;
import simpleTask.simplePracticeTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class simpleTaskTest {
    static WebDriver driver;
    static simplePracticeLogin loginPage;
    static simplePracticeTask taskPage;
    static simplePracticeComplete completeTask;
    static Properties props;

    @BeforeClass
    public static void setUp() throws IOException {
        // Load properties from config.properties
        props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/config.properties");
        props.load(fis);

        // Initialize browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to URL
        driver.get(props.getProperty("url"));

        // Initialize page object
        loginPage = new simplePracticeLogin(driver);

        // Initialize task object
        taskPage = new simplePracticeTask(driver);

        // Initialize complete object
        completeTask = new simplePracticeComplete(driver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        String email = props.getProperty("email");
        String password = props.getProperty("password");

        loginPage.login(email, password);

        // Add your assertions or checks after login here
        System.out.println("Login executed.");

        Thread.sleep(3000); // Use WebDriverWait in real tests

        taskPage.clickTask();
        taskPage.clickcreateTask();

        Thread.sleep(2000); // Use WebDriverWait in real tests

        taskPage.createTask(
                props.getProperty("taskName"),
                props.getProperty("description"),
                props.getProperty("date"),
                props.getProperty("time"),
                props.getProperty("clientName"),
                props.getProperty("teamName"));

        Thread.sleep(2000); // Use WebDriverWait in real tests

        taskPage.clickSave();
        Thread.sleep(2000); // Use WebDriverWait in real tests

        completeTask.completeTask(props.getProperty("taskName"));

        Thread.sleep(2000); // Use WebDriverWait in real tests

        if (simplePracticeComplete.isTaskCompleted()) {
            System.out.println("Success");
        } else {
            System.out.println("Not completed");
        }
    }


    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

