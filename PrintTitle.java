import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class PrintTitle {
	public static void main(String [] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("Https://google.com");
		WebElement p = driver.findElement(By.name("q"));
		p.sendKeys("Selenium Key");
		p.submit();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
	}
}
