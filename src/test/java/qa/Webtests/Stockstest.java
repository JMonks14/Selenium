package qa.Webtests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import qa.Tests.FTSEpage;

public class Stockstest {
	
	private WebDriver driver;
	private FTSEpage ftsepage;
	
	 @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));
	        ftsepage = PageFactory.initElements(driver, FTSEpage.class);
	        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	    }
	 
	 @Ignore
	 public void findBiggestRiser() throws InterruptedException {
		 driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers");
//		 WebElement rise = driver.findElement(By.cssSelector("title = 'View risers"));
//		 rise.click();
		 
		 List<WebElement> names = driver.findElements(By.cssSelector("[class^='link-headline {Sedol']"));
		 List<WebElement> prices = driver.findElements(By.cssSelector("[data-field='change']"));
		 ArrayList<Double> risers = new ArrayList<Double>();
		 ArrayList<String> snames = new ArrayList<String>();
		 
		 for (WebElement price: prices) {
			 risers.add(Double.parseDouble(price.getText()));
		 }
		 for (WebElement name: names) {
			 snames.add(name.getText());
		 }
		 double maxriser = Collections.max(risers);
		 int index = risers.indexOf(maxriser)-1;
		 System.out.println(maxriser);
		 String bRiser=snames.get(index);
		 System.out.println(bRiser);
		 
//		 for (double item:risers) {
//			 System.out.println(item);
//		 }
//		 
//		 for (String item:snames) {
//			 System.out.println(item);
//		 }
		 
		 Thread.sleep(10000);
		 
	 }
	 
	    @Test
	    public void findBiggestFaller() throws InterruptedException {
	    	driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/");
	    	    	
	    	this.ftsepage.navFallers();	    	
	    	 List<WebElement> names = driver.findElements(By.cssSelector("[class^='link-headline {Sedol']"));
			 List<WebElement> prices = driver.findElements(By.cssSelector("[data-field='change']"));
			 ArrayList<Double> fallers = new ArrayList<Double>();
			 ArrayList<String> snames = new ArrayList<String>();
			 
			 for (WebElement price: prices) {
				 fallers.add(Double.parseDouble(price.getText()));
			 }
			 for (WebElement name: names) {
				 snames.add(name.getText());
			 }
			 double maxfaller = Collections.min(fallers);
			 int index = fallers.indexOf(maxfaller)-1;
			 System.out.println(maxfaller);
			 String bfaller=snames.get(index);
			 System.out.println(bfaller);
	    	
	    	Thread.sleep(10000);
	    	
	    }
	    @After
	    public void tearDown() {
	        driver.quit();
	    }

}
