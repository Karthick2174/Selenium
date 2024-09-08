import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDwon {

public static void main (String [] args) throws InterruptedException {
	WebDriver Driver = new ChromeDriver();
	Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	Driver.manage().window().maximize();
	WebElement DropDown2 = Driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select select = new Select(DropDown2);
	Thread.sleep(2000);
	select.selectByIndex(1);
	System.out.println(select.getFirstSelectedOption().getText());
	Thread.sleep(2000);
	select.selectByValue("USD");
	System.out.println(select.getFirstSelectedOption().getText());
	Thread.sleep(2000);
	select.selectByVisibleText("AED");
	System.out.println(select.getFirstSelectedOption().getText());
	Driver.quit();
	}
}
