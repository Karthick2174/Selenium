import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selftest2{
   public static void main(String[] args) {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.google.com/");
      WebElement p=driver.findElement(By.name("q"));
      p.sendKeys("Selenium Java");
      p.submit();
      driver.navigate().to("https://www.w3schools.com/");
   }
}
