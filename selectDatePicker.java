import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class selectDatePicker {
    public static void main(String[] args) throws InterruptedException {
        WebDriver Drive = new ChromeDriver();
        //Method 1
        try {
            Drive.get("https://jqueryui.com/datepicker/");
            Thread.sleep(2000); // Wait for page load
            Drive.manage().window().maximize();
            Thread.sleep(2000);
            Drive.switchTo().frame(0); 
            Drive.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/01/2025");
            System.out.println("Date filled successfully!!");
        } catch (Exception e) {
            System.err.println("Test Failed! Error: " + e.getMessage());
            
        } finally {
            Thread.sleep(3000);
            if (Drive != null) {
                Drive.quit(); 
            }
        }
    }
}
