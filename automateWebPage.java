import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class automateWebPage {
    WebDriver driver;
    public static int millisecond = 5000;
    public static int second = 10;
    public static String URL = "https://rahulshettyacademy.com/locatorspractice/";
    public static String URLOne = "https://rahulshettyacademy.com/dropdownsPractise/";
    public static String URLTwo = "https://automationtesting.in/";
    public static String uName = "//input[@placeholder='Username']";
    public static String uPassWord = "//input[@placeholder='Password']";
    public static String signInButton = "(//button[@class='submit signInBtn'])[1]";
    public static String name = "Karthick";
    public static String email = "abc@123.com";
    public static String nPassword = "9876543210";
    public static String nNameLocator = "(//input[@type='text'])[1]";
    public static String nEMailLocator = "(//input[@type='text'])[2]";
    public static String nPhoneNumberLocator = "(//input[@type='text'])[3]";
    public static String newPasswordLocator = "//p[@class='infoMsg']";
    public static String resetButton = "//button[normalize-space()='Reset Login']";
    public static String goToLogInButton = "(//button[normalize-space()='Go to Login'])[1]";
    public static String logInSuccessLocator = "//p[text()='You are successfully logged in.']";
    public static String passWord = "A";
    public static String loggedInUserNameLocator = "div[class='login-container'] h2";
    public static String value;
    public static String valueOne;
    public static WebElement dropDownLocator;
    public static WebElement adultLocator;
    public static WebElement incrementCountLocalator;
    public static WebElement incrementCountValueText;
    public static int i,clickCount = 0;
    public static String titleOne;
    public static String titleTwo;
    public static String titleThree;
    public static String fromName = "Che";
    public static WebElement fromDropDown;
    public static String depatureCityName = "//a[@value='MAA']";
    public static String toName = "Be";
    public static WebElement toDropDown;
    public static String arrivalCityName = "(//a[@text='Bengaluru (BLR)'])[2]";
    public static String fromCityName;
    public static String toCityName;
    public static WebElement departureCityElement;
    public static WebElement arrivalCityElement;
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--no-sandbox");
    	driver = new ChromeDriver(options);
        driver.get(URL);
        titleOne = driver.getTitle();
        System.out.println("Title of the page: " + titleOne);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
        System.out.println("Setup Successfully Completed.");
    }
    public void inctpass() {
        driver.findElement(By.xpath(uName)).sendKeys(name);
        driver.findElement(By.xpath(uPassWord)).sendKeys(nPassword);
        driver.findElement(By.xpath(signInButton)).click();
        System.out.println("Successfully validate the negative case");
    }
    public void getError() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        inctpass();
        WebElement errorOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
        System.out.println("Error Message: " + errorOne.getText());
        System.out.println("Successfully get the error message.");
    }
    public String passExtract(String passWord) throws InterruptedException {
    	driver.findElement(By.linkText("Forgot your password?")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	driver.findElement(By.xpath(nNameLocator)).sendKeys(name);
    	driver.findElement(By.xpath(nEMailLocator)).sendKeys(email);
    	driver.findElement(By.xpath(nPhoneNumberLocator)).sendKeys(nPassword);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
    	WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(resetButton)));
    	resetBtn.click();
    	String passWordText = driver.findElement(By.xpath(newPasswordLocator)).getText();
    	System.out.println(passWordText);
    	int start = passWordText.indexOf('\'') + 1;
        int end = passWordText.indexOf('\'', start);
        passWord = passWordText.substring(start, end);
        System.out.println("PassWord: "+ passWord);
        System.out.println("Successfully get the password");
        Thread.sleep(2000);
    	return passWord;
    }
    public void logIn() throws InterruptedException {
    	WebElement backToLogIn = driver.findElement(By.xpath(goToLogInButton));
    	backToLogIn.click();
    	Thread.sleep(millisecond);
    	driver.findElement(By.xpath(uName)).sendKeys(name);
        driver.findElement(By.xpath(uPassWord)).sendKeys(passWord);
        driver.findElement(By.xpath(signInButton)).click();
        String logInSuccessMessage = driver.findElement(By.xpath(logInSuccessLocator)).getText();
        System.out.println("Suucess Messsage:" + logInSuccessMessage);
        Assert.assertEquals(logInSuccessMessage, "You are successfully logged in.");
    }
    public void userName() {
    	String loggedInUserName = driver.findElement(By.cssSelector(loggedInUserNameLocator)).getText();
    	String[] tempName = loggedInUserName.split(" ");
    	String getName = tempName[1];
    	getName = getName.replace(",", "");
    	System.out.println("Logged In User Name: "+ getName);
    	System.out.println("Successfully get logged in user name. " + name);
    	Assert.assertEquals("Hello " +name+ ",", "Hello " +getName+ ",");
    }
    public void move() {
    	driver.get(URL);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	System.out.println("Title of the page: " + titleOne);
    	driver.navigate().to(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	driver.get(URLOne);
        titleTwo = driver.getTitle();
        System.out.println("Title of the page: " + titleTwo);
    }
    public void staticDropDown() {
    	driver.get(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	dropDownLocator = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 
    	Select dropDownOne = new Select(dropDownLocator);
    	dropDownOne.selectByIndex(3);
    	value = dropDownOne.getFirstSelectedOption().getText();
    	System.out.println("Drop Down Value: " + value);
    	dropDownOne.selectByVisibleText("AED");
    	value= dropDownOne.getFirstSelectedOption().getText();
    	System.out.println("Drop Down Value: " + value);
    	dropDownOne.selectByVisibleText("INR");
    	value= dropDownOne.getFirstSelectedOption().getText();
    	System.out.println("Drop Down Value: " + value);
    }
    public void addAdultCountOne() throws InterruptedException {
    	driver.navigate().refresh();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	 adultLocator = driver.findElement(By.id("divpaxinfo"));
    	 adultLocator.click() ;
    	 clickCount = 1;
    	 while(i<4) {
    		 incrementCountLocalator  = driver.findElement(By.id("hrefIncAdt"));
    		 incrementCountLocalator.click(); 
    		 ++i;
    		 ++clickCount;
    	 }
    	 System.out.println("Number of Time Clicked: " + clickCount);
    	 Thread.sleep(1000);
    }
    public void dropDown() throws InterruptedException {
    	driver.get(URLOne);
    	fromDropDown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
    	fromDropDown.click();
    	departureCityElement = driver.findElement(By.xpath(depatureCityName));
    	departureCityElement.click();
    	fromCityName = departureCityElement.getText();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	arrivalCityElement = driver.findElement(By.xpath(arrivalCityName));
    	arrivalCityElement.click();
    	toCityName = arrivalCityElement.getText();
    	System.out.println("Selected Depature and Arrival City Name: " + fromCityName + " , "+ toCityName);
    	Thread.sleep(second);
    }
    public static void main(String[] args) {
        ragulSheety obj = new ragulSheety();
        try {
            obj.setup();
            obj.inctpass();
            obj.getError();
            passWord = obj.passExtract(passWord);
            obj.logIn();
            obj.userName();
            obj.move();
            obj.staticDropDown();
            obj.addAdultCountOne();
            obj.dropDown();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (obj.driver != null) {
                obj.driver.quit();
            }
        }
    }
}
