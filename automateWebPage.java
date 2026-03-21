import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import java.io.File;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
class automateWebPage {
    WebDriver driver;
    static int millisecond = 5000;
    static int second = 10;
    static int i,clickCount = 0;
    static String URL = "https://rahulshettyacademy.com/locatorspractice/";
    static String URLOne = "https://rahulshettyacademy.com/dropdownsPractise/";
    static String URLTwo = "https://rahulshettyacademy.com/AutomationPractice/";
    static String URLThree = "https://amazon.com/";
    static String uName = "//input[@placeholder='Username']";
    static String uPassWord = "//input[@placeholder='Password']";
    static String signInButton = "(//button[@class='submit signInBtn'])[1]";
    static String nNameLocator = "(//input[@type='text'])[1]";
    static String nEMailLocator = "(//input[@type='text'])[2]";
    static String nPhoneNumberLocator = "(//input[@type='text'])[3]";
    static String newPasswordLocator = "//p[@class='infoMsg']";
    static String resetButton = "//button[normalize-space()='Reset Login']";
    static String goToLogInButton = "(//button[normalize-space()='Go to Login'])[1]";
    static String logInSuccessLocator = "//p[text()='You are successfully logged in.']";
    static String loggedInUserNameLocator = "div[class='login-container'] h2";
    static String depatureCityName = "//a[@value='MAA']";
    static String arrivalCityName = "(//a[@text='Bengaluru (BLR)'])[2]";
    static String doneButtonLocator = "(//input[@type='button'])[1]";
    static String oneWaytripRadioButtonLocator = "//input[@value='OneWay']";
    static String twoWaytripRadioButtonLocator = "//input[@value='RoundTrip']";
    static String roundtripRadioButtonLocator = "//input[@value='TripPlanner']";
    static String countryNameLocator = "//input[@id='autosuggest']";
    static String name = "Karthick";
    static String email = "abc@123.com";
    static String nPassword = "9876543210";
    static String countryNameSortForm = "Ind";
    static String countryName = "india";
    static String passWord = "A";
    static String fromName = "Che";
    static String toName = "Be";
    static String testName =  "A";
    static String countryDropDownName;
    static String value;
    static String valueOne;
    static String titleOne;
    static String titleTwo;
    static String titleThree;
    static String fromCityName;
    static String toCityName;
    static WebElement dropDownLocator;
    static WebElement adultLocator;
    static WebElement incrementCountLocalator;
    static WebElement incrementCountValueText;
    static WebElement fromDropDown;
    static WebElement toDropDown;
    static WebElement doneButton;
    static WebElement departureCityElement;
    static WebElement arrivalCityElement;
    static WebElement oneWayTripRadioButton;
    static WebElement twoWayTripRadioButton;
    static WebElement roundtripRadioButton;
    static WebElement countryDropDown;
    void setup() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--no-sandbox");
    	options.addArguments("--headless");
    	driver = new ChromeDriver(options);
        driver.get(URL);
        titleOne = driver.getTitle();
        System.out.println("Title of the page: " + titleOne);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
        System.out.println("Setup Successfully Completed.");
    } 
    void inctpass() {
        driver.findElement(By.xpath(uName)).sendKeys(name);
        driver.findElement(By.xpath(uPassWord)).sendKeys(nPassword);
        driver.findElement(By.xpath(signInButton)).click();
        System.out.println("Successfully validate the negative case");
    }
    void getError() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        inctpass();
        WebElement errorOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error")));
        System.out.println("Error Message: " + errorOne.getText());
        System.out.println("Successfully get the error message.");
    }
    String passExtract(String passWord) throws InterruptedException {
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
        Thread.sleep(millisecond);
    	return passWord;
    }
    void logIn() throws InterruptedException {
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
    void userName() {
    	String loggedInUserName = driver.findElement(By.cssSelector(loggedInUserNameLocator)).getText();
    	String[] tempName = loggedInUserName.split(" ");
    	String getName = tempName[1];
    	getName = getName.replace(",", "");
    	System.out.println("Logged In User Name: "+ getName);
    	System.out.println("Successfully get logged in user name. " + name);
    	Assert.assertEquals("Hello " +name+ ",", "Hello " +getName+ ",");
    }
    void move() {
    	driver.get(URL);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	System.out.println("Title of the page: " + titleOne);
    	driver.navigate().to(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	driver.get(URLOne);
        titleTwo = driver.getTitle();
        System.out.println("Title of the page: " + titleTwo);
    }
    void staticDropDown() {
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
    void addAdultCountOne() throws InterruptedException {
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
    	 driver.findElement(By.xpath(doneButtonLocator)).click();
    	 System.out.println("Number of Time Clicked: " + clickCount);
    	 Thread.sleep(millisecond);
    }
    void dropDown() throws InterruptedException {
    	driver.get(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
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
    }
    void typeOfTrip(int i) {
    	driver.get(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	if(i==0) {
    		oneWayTripRadioButton = driver.findElement(By.xpath(oneWaytripRadioButtonLocator));
    		oneWayTripRadioButton.click();
    		System.out.println("One Way Trip");
    	}
    	else if (i==1) {
    		twoWayTripRadioButton = driver.findElement(By.xpath(twoWaytripRadioButtonLocator));
    		twoWayTripRadioButton.click();
    		System.out.println("Two Way Trip");
    	}
    	else if (i==2){
    		roundtripRadioButton = driver.findElement(By.xpath(roundtripRadioButtonLocator));
    		roundtripRadioButton.click();
    		System.out.println("Round Trip");
    	}
    	else{
    		System.out.print("incorrect selection");
    	}
    }
    void autoSuggestion(){
    	driver.get(URLOne);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	countryDropDown = driver.findElement(By.xpath(countryNameLocator));
    	countryDropDown.sendKeys(countryNameSortForm);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	WebElement countryCode = driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')]//a[text()='India']"));
    	countryCode.click();
    }
    void checkBoxSelection() {
    	driver.get(URLTwo);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    	int count = checkboxes.size();
    	System.out.println("Total checkboxes: " + count);
    }
    void datPicker() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	WebElement yearLocator = driver.findElement(By.cssSelector(".ui-datepicker-year"));
    	yearLocator.click();
    	String year = yearLocator.getText();
    	System.out.println("Year: " + year);
    }
    void alertAction() {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);
        alert.accept();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"confirmbtn\"]")).click();
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        System.out.println("Alert Message: " + alertText);
        driver.switchTo().alert().accept();
    }
    void tabs() {
    	driver.switchTo().newWindow(WindowType.TAB);
    	driver.get(URL);
    	titleTwo = driver.getTitle();
    	System.out.println("New Title Name: " + titleTwo);
    }
    void actions() throws InterruptedException {
    	driver.get(URLThree);
    	Thread.sleep(millisecond);
    	Actions action = new Actions(driver);
    	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    	action.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
    	driver.manage().deleteAllCookies();
    }
    void dragAndDrop(){
    	driver.get("https://jqueryui.com/droppable/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
    	driver.findElement(By.id("draggable")).click();
    	Actions action = new Actions(driver);
    	WebElement source = driver.findElement(By.id("draggable"));
    	WebElement target = driver.findElement(By.id("droppable"));
    	action.dragAndDrop(source, target).build().perform();
    	driver.switchTo().defaultContent();
    	System.out.println("Drag and Drop success");
    }
    void numberOfTags() {
    	driver.get("https://demoapps.qspiders.com/ui/link?sublist=0");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	System.out.println("Number of tags: " + driver.findElement(By.tagName("a")).getSize());
    }
    void multiTabs() {
    	driver.get("https://www.qafox.com/selenium/selenium-practice/");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	WebElement tags = driver.findElement(By.xpath("//div[@itemprop='text']"));
    	System.out.println("Number tags was presence: " + tags.findElements(By.tagName("a")).size());
    }
    	void screenShots() {
    	    try {
    	        driver.get("https://www.qafox.com/selenium/selenium-practice/");
    	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	        File dest = new File("D:\\2\\screenshot.png");
    	        FileUtils.copyFile(src, dest);
    	        System.out.println("Screen shot taken.");
    	    } catch (Exception e) {
    	        e.printStackTrace();   // check console for any IOException or WebDriver errors
    	    }
    	}
    public static void main(String[] args) {
    	automateWebPage obj = new automateWebPage();
        try {
            obj.setup(); 
            obj.inctpass();        
            obj.getError();        
            passWord = obj.passExtract(passWord);         
            obj.logIn();           
            obj.userName();          
            obj.move(); 
            obj.typeOfTrip(i);
            obj.dropDown();  
            obj.datPicker();
            obj.addAdultCountOne();
            obj.staticDropDown();
            obj.autoSuggestion();
            obj.checkBoxSelection();
            obj.alertAction();
            obj.tabs();
            obj.actions();
            obj.dragAndDrop();
            obj.numberOfTags();
            obj.multiTabs();
            obj.screenShots();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (obj.driver != null) {
                obj.driver.quit();
            }
        }
    }
}