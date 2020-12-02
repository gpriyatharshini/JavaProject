package demo;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;


	public class TestngDemo {
	    protected static ThreadLocal<ChromeDriver> driver=new ThreadLocal<>();
	    
	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Chromedriver\\\\chromedriver.exe");
	        driver.set(new ChromeDriver());
	    }
	    
	    
	    
	    public WebDriver getDriver() {
	        return driver.get();
	        
	    }
	    
	    
	    
	    @AfterMethod
	    public void tearDown() {
	    	getDriver().close();
	        getDriver().quit();
	    }

	 

	}

