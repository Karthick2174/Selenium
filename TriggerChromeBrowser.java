import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TriggerChromeBrowser {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.getTitle();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(500);
       driver.quit();

}
}
