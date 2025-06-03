import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormValidationTest extends BaseTest {

    @Test
    public void testValidFormSubmission() {
        driver.findElement(By.name("first_name")).sendKeys("Keshav");
        driver.findElement(By.name("last_name")).sendKeys("Rajpoot");
        driver.findElement(By.name("email")).sendKeys("test@example.com");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("address")).sendKeys("123 Main St");
        driver.findElement(By.name("city")).sendKeys("Jabalpur");
        new Select(driver.findElement(By.name("state"))).selectByVisibleText("California");
        driver.findElement(By.name("zip")).sendKeys("482001");
        driver.findElement(By.name("website")).sendKeys("https://example.com");
        driver.findElement(By.cssSelector("input[value='yes']")).click();
        driver.findElement(By.name("comment")).sendKeys("This is a test.");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        boolean successAlertPresent = driver.getPageSource().contains("Success");
        Assert.assertTrue(successAlertPresent, "Success message not found!");
    }
}