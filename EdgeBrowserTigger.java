import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test1 {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
       WebDriver driver1 = new EdgeDriver();
       driver1.get("https://www.google.com");
      driver1.get("https://www.github.com/Karthick2174/Java_Program");
       driver1.manage().window().maximize();
       driver1.manage().window().minimize();
       driver1.manage().window().maximize();
       driver1.getTitle();
       System.out.println(driver1.getTitle());
       System.out.println(driver1.getCurrentUrl());
      driver1.quit();
    }
}
