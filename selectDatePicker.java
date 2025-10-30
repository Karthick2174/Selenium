import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


import org.openqa.selenium.By;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver Drive = new ChromeDriver();
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
      //Method 2
        String year = "2026";
        String month = "May";
        String day = "20";
        Drive = new ChromeDriver();
        Drive.get("https://jqueryui.com/datepicker/");
        Thread.sleep(5000);
        Drive.manage().window().maximize();
        Thread.sleep(5000);
        Drive.switchTo().frame(0);
        Drive.findElement(By.xpath("//input[@id='datepicker']")).click();
        Thread.sleep(5000);
        while(true) {
        	String currentMonth = Drive.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
        	String currentYear = Drive.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
        	if(currentMonth.equals(month) && currentYear.equals(year)){
        		System.out.print("currentMonth : " + currentMonth);
        		System.out.print(" currentYear : " + currentYear);
        		break;
        	}
        	Drive.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        	Thread.sleep(5000);
        }
        
        List<WebElement> alldates = Drive.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for(WebElement dt : alldates) {
        	if(dt.getText().equals(day)) {
        		dt.click();
        	}
        }
        System.out.println();
        Drive.close();
       
    }
}
