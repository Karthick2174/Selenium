import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class navigator {
	public static void main (String [] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("Https://doubleclicktest.com/");
		Thread.sleep(2000);
		driver.navigate().to("Https://google.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
		}
}
