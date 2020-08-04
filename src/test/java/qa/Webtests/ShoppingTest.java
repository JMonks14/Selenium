package qa.Webtests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingTest {
	
private WebDriver driver;
	

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

    }
    
    @Test
    public void searchTest() throws InterruptedException {
    	driver.get("http://automationpractice.com/index.php");
    	
    	WebElement search = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
    	search.sendKeys("dress");
    	search.submit();
    	
    	WebElement Item=driver.findElement(By.cssSelector("[title='Printed Dress']"));
    	assertNotNull(Item);
    	
    	Thread.sleep(5000);
    }

}
