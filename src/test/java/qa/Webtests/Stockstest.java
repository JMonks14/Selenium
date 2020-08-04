package qa.Webtests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stockstest {
	
	private WebDriver driver;
	
	 @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));

	    }
	 
	 @Test
	 public void findBiggestRiser() {
		 driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		 WebElement rise = driver.findElement(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a/strong"));
		 rise.click();
		 
		 List<WebElement> names = driver.findElements(By.className("name-col-align-left"));
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
		 int index = risers.indexOf(maxriser);
		 
		 
	 }

}
