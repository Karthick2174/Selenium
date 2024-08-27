import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpanTextCompare {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("Https://google.com");
		WebElement p = driver.findElement(By.name("q"));
		p.sendKeys("Selenium Key");
		p.submit();
        WebElement spanElement = driver.findElement(By.className("VuuXrf"));
        String actualSpanText = spanElement.getText();
        String expectedSpanText = "Selenium";
        if (actualSpanText.equals(expectedSpanText)) {
            System.out.println("Text matches: " + actualSpanText);
        } else {
            System.out.println("Text does not match. Found: " + actualSpanText);
        }
        driver.quit();
    }
}
