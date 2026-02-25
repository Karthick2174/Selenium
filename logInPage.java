import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class ragulSheety {
    WebDriver driver;
    public static String URL = "https://rahulshettyacademy.com/locatorspractice/";
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
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--no-sandbox");
    	driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Setup Successfully Completed.");
    }
    public void accWeb() {
        System.out.println("Page title: " + driver.getTitle());
        System.out.println("Successfully get the title.");
    }
    public void inctpass() {
        driver.findElement(By.xpath(uName)).sendKeys(name);
        driver.findElement(By.xpath(uPassWord)).sendKeys(nPassword);
        driver.findElement(By.xpath(signInButton)).click();
        System.out.println("Successfully validate the negative case");
    }
    public void getError() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        inctpass();
        WebElement errorOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
        System.out.println("Error Message: " + errorOne.getText());
        System.out.println("Successfully get the error message.");
    }
    public String passExtract(String passWord) throws InterruptedException {
    	driver.findElement(By.linkText("Forgot your password?")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.findElement(By.xpath(nNameLocator)).sendKeys(name);
    	driver.findElement(By.xpath(nEMailLocator)).sendKeys(email);
    	driver.findElement(By.xpath(nPhoneNumberLocator)).sendKeys(nPassword);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    	Thread.sleep(2000);
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
    public static void main(String[] args) {
        ragulSheety obj = new ragulSheety();
        try {
            obj.setup();
            obj.accWeb();
            obj.inctpass();
            obj.getError();
            passWord = obj.passExtract(passWord);
            obj.logIn();
            obj.userName();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (obj.driver != null) {
                obj.driver.quit();
            }
        }
    }
}
