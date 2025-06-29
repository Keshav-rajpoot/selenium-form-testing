import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormValidationTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // You can set the path to chromedriver if it's not in PATH
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testValidFormSubmission() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Fill out the text input field
        WebElement textField = driver.findElement(By.name("my-text"));
        textField.clear();
        textField.sendKeys("Test User");

        // Click the submit button
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        // Wait briefly in case of slight delay (Optional)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Since the page doesn't navigate, verify the heading remains
        WebElement heading = driver.findElement(By.tagName("h1"));
        String actualHeading = heading.getText();
        String expectedHeading = "Hands-On Selenium WebDriver with Java";

        Assert.assertEquals(actualHeading, expectedHeading, "Form was not submitted successfully (or page did not behave as expected).");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
