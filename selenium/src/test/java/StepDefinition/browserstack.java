package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class browserstack {
	
	WebDriver driver;
	
	public static final String AUTOMATE_USERNAME = "amnakhalil_0se216";
	  public static final String AUTOMATE_ACCESS_KEY = "LqGqBB1kwtpmhXBbcCEa";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	  
	  public static WebDriver createWebDriver() {
	        String webdriver = System.getProperty("browser", "firefox");
	        switch(webdriver) {
	            case "firefox":
	                return new FirefoxDriver();
	            case "chrome":
	                return new ChromeDriver();
	            default:
	                throw new RuntimeException("Unsupported webdriver: " + webdriver);
	        }
	    }
	  
	  public static void main(String[] args) throws Exception {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1920x1080");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("https://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys("BrowserStack");
	    element.submit();
	    // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    try {
	    	wait.until(ExpectedConditions.titleContains("BrowserStack"));
	    	markTestStatus("passed","Yaay title contains 'BrowserStack'!",driver);
	    }
	    catch(Exception e) {
	    	markTestStatus("failed","Naay title does not contain 'BrowserStack'!",driver);
	    }
	    System.out.println(driver.getTitle());
	    driver.quit();
	  }
	  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
	  public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
	  }
	
}
