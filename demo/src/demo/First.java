package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;


public class First extends TestngDemo{
		
   @Test
	public  void Test1() throws InterruptedException {

		
		//System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		//WebDriver driver= new ChromeDriver();
		WebDriver driver=getDriver();
		 driver.get("https://www.flipkart.com/");
		 driver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(driver,10);
		
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 //login
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")));
		WebElement phnumber= driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']"));
		phnumber.sendKeys("7395950355");
		WebElement password= driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']"));
		password.sendKeys("pragathi" +Keys.ENTER);
		boolean s=password.isDisplayed();
		if(s) {
			System.out.println("Password input is seen");
		}
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='LM6RPg']")));
		
		
		//check if homepage loaded
				String url= "https://www.flipkart.com/";
				 String geturl= driver.getCurrentUrl();
				 System.out.println("homepage " + geturl);
				 if(geturl.equals(url)){
					 System.out.println("homepage loaded");
				 }
				 else {
					 System.out.println("errrrrrr");
				 }
		//driver.navigate().to("https://www.amazon.in/");
		//Thread.sleep(5000);
		//driver.navigate().back();
		//Thread.sleep(5000);
				 
				 
		//search element and click it
		WebElement search =driver.findElement(By.xpath("//input[@class='LM6RPg']"));
	   //js.executeScript("arguments[0].click();", search);//Initialize js executer
	   try {
			//search.click();
			js.executeScript("arguments[0].click();", search);
			System.out.println("Try for search");
		} catch (StaleElementReferenceException e) {
			search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
			search.click();
			//js.executeScript("arguments[0].click();", search);
			System.out.println("block 2 for search");
			
		}
	   try {
			search.sendKeys("chana dal" + Keys.ENTER);
			System.out.println("block 1 for search entry");
		} catch (StaleElementReferenceException e) {
			search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
			search.sendKeys("chana dal" + Keys.ENTER);
			System.out.println("block 2 for search entry");
		}
		
		System.out.println("chana dal entered");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Chana Dal']"))); 
         String Parent=driver.getWindowHandle();
         System.out.println("parent "+ Parent);
         driver.findElement(By.xpath("//a[text()='Chana Dal']")).click();  
         
         //changing window handle
         System.out.println(driver.getTitle());
         for(String child:driver.getWindowHandles()) {
        	 driver.switchTo().window(child);
         }
         System.out.println(driver.getTitle());
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pincodeInputId']")));
         
         
         //enter pincode
         WebElement pincode=driver.findElement(By.xpath("//input[@id='pincodeInputId']"));
         pincode.sendKeys("600054");
         WebElement check=driver.findElement(By.xpath("//*[@class='_2aK_gu']"));
         check.click();
         
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='_2AkmmA _32EClk _2DCAah'])[2]")));
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //add to basket
         Actions a= new Actions(driver);
        
        	 WebElement add1= driver.findElement(By.xpath("(//button[@class='_2AkmmA _32EClk _2DCAah'])[2]"));
        	 a.moveToElement(add1);
        	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        	 add1.click();
        	 System.out.println("ADD items");
        
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='GO TO BASKET']")));
       
         
         //go to basket
         WebElement go=driver.findElement(By.xpath("//*[text()='GO TO BASKET']"));
         go.click();
         System.out.println("GO TO BASKET");
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2AkmmA _2Rr3iH']")));
       driver.findElement(By.xpath("//button[@class='_2AkmmA _2Rr3iH']")).click();
       System.out.println("came out of go to basket");
       
       
       //Add to cart
       WebElement cart= driver.findElement(By.className("_3ko_Ud"));
       cart.click();
        System.out.println("clicked add to cart");
        
        //Place order
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']")));
        WebElement place= driver.findElement(By.xpath("//button[@class='_2AkmmA iwYpF9 _7UHT_c']"));
        place.click();
        System.out.println("Place order");
        
        //address change
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='_3Jk8fm'])[2]")));
        WebElement address= driver.findElement(By.xpath("(//button[@class='_3Jk8fm'])[2]"));
        address.click();
        System.out.println("address change");
        
      //address edit
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='FoDyGO']")));
        WebElement edit= driver.findElement(By.xpath("//button[@class='FoDyGO']"));
        edit.click();
        System.out.println("address edit");
        
        //address name
        WebElement adname= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[1]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        adname.clear();
        adname.sendKeys("Senadhian G");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address Change name");
        
        
      //address mob
        WebElement mob= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[2]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mob.clear();
        mob.sendKeys("9790941827");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address Change Mobile number");
        
      //address pincode
        WebElement pin= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[3]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        pin.clear();
        pin.sendKeys("600063");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address pincode");
        
      //address locality
        WebElement locality= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[4]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        locality.clear();
        locality.sendKeys("poonamalle");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address locality");
        
        
        //address area
        WebElement area= driver.findElement(By.xpath("(//*[@name='addressLine1'])[1]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        area.clear();
        area.sendKeys("plot no: 4677");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address area");
        
        
        //address city
        WebElement city= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[5]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        city.clear();
        city.sendKeys("poonamalle");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address city");
        
      //address landmark
        WebElement landmark= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[6]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        landmark.clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address landmark");
        
        
      //address altmob
        WebElement altmob= driver.findElement(By.xpath("(//input[@class='_16qL6K _366U7Q'])[7]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        altmob.clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("address alternate mobile");
        
        
        //save and deliver here
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement delivery= driver.findElement(By.xpath("//button[@class='_2AkmmA EqjTfe _7UHT_c']"));
        delivery.click();
        System.out.println("save and deliver here");
        
        
        //confirm checkbox
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement confbox= driver.findElement(By.xpath("(//div[@class='_6ATDKp'])[1]"));
       boolean b=confbox.isEnabled();
        if(b==true) {
        	System.out.println("first address is selected"); 	
        }
        WebElement conf= driver.findElement(By.xpath("//button[@class='_2AkmmA _1dTEZX _1eFTEo']"));
    	conf.click();
    	System.out.println("confirm address");
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	
        
        //check box
    	
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_6ATDKp'])[2]")));
        WebElement ab= driver.findElement(By.xpath("(//div[@class='_6ATDKp'])[2]"));
       // js.executeScript("arguments[0].click();", ab);
       
       
  
                  try {
						ab.click();
						System.out.println("block 1 for search entry");
					} catch (StaleElementReferenceException e) {
						ab= driver.findElement(By.xpath("(//div[@class='_6ATDKp'])[2]"));
					//	ab.click();
						js.executeScript("arguments[0].click();", ab);
						System.out.println("block 2 for search entry");
					}
        	
                  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println("check box");
        
       
        //click continue to proceed to checkout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='to-payment']")));
        WebElement checkout=driver.findElement(By.xpath("//*[@id='to-payment']"));
        checkout.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.wait(4000);
       //Thread.sleep (4000);
       System.out.println("clicked continue to proceed to checkout");
       System.out.println("Test1 thread id is " +Thread.currentThread().getId());
	}

	
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Test
   	public  void Test2() throws InterruptedException {
   		// TODO Auto-generated method stub
   		//System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
   		//WebDriver driver= new ChromeDriver();
   		WebDriver driver=getDriver();
   		 driver.get("https://www.amazon.in/");
   		 driver.manage().window().maximize();
   		 WebDriverWait wait = new WebDriverWait(driver,10);
   		 JavascriptExecutor js = (JavascriptExecutor)driver;
   		 //to perform hover
   		 WebElement searchBtn = driver.findElement(By.linkText("Computers"));
   		 Actions action = new Actions(driver);
   		 action.moveToElement(driver.findElement(By.linkText("Pantry"))).perform();
   		 searchBtn.click();
   		 
   		 
   		 WebElement b= driver.findElement(By.xpath("(//a[@id='nav-hamburger-menu'])[1]"));
   		 b.click();
   		 System.out.println("click successful");
   		 List<WebElement> l=driver.findElements(By.xpath("//*[@class='hmenu hmenu-visible']"));
   		 int c=l.size();
   		 System.out.println("count successful  "+c);
   		 
   		 
   		// Select sel=  new Select(driver.findElement(By.id("nav-hamburger-menu"))); 
   		 //if(sel.isMultiple()) {
   			// System.out.println("count successful  ");
   	//	 }
   		 System.out.println("Test 2 thread id is " +Thread.currentThread().getId());
   		
   	}
   	
    
    
    
    
    
    
    @Test
    public  void Test3() throws InterruptedException {
   		// TODO Auto-generated method stub
   		//System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
   		//WebDriver driver= new ChromeDriver();
   		WebDriver driver=getDriver();
   		 driver.get("https://www.testandquiz.com/selenium/testing.html");
   		 driver.manage().window().maximize();
   		 WebDriverWait wait = new WebDriverWait(driver,10);
   		 JavascriptExecutor js = (JavascriptExecutor)driver;
   		 //to perform select
   		 WebElement dropdown = driver.findElement(By.id("testingDropdown"));
   		 Select sel=new Select(dropdown);
   		 sel.selectByValue("Performance");
   	
   		 //to double click
   		 WebElement doubleclick= driver.findElement(By.id("dblClkBtn"));
   		 Actions act= new Actions(driver);
   		 act.doubleClick(doubleclick).perform();
   		 
   		 //handling alerts
   		 driver.switchTo().alert().accept();
   		 
   		 //drag and drop
   		 WebElement source= driver.findElement(By.id("sourceImage"));
   		WebElement dest= driver.findElement(By.id("targetDiv"));
   		 act.dragAndDrop(source, dest).build().perform();
   		 
   		System.out.println("Test3 thread id is " +Thread.currentThread().getId());
   		 
    }
}














		