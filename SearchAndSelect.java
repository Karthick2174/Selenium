import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selftest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();       
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver tutorial");
            searchBox.submit();
            TimeUnit.SECONDS.sleep(5);
            List<WebElement> results = driver.findElements(By.cssSelector("h3"));
            System.out.println(driver.getTitle());
            if (results.size() > 2) {
                results.get(2).click();
                TimeUnit.SECONDS.sleep(10);
                driver.quit(); 
            } 
        } 
    }
