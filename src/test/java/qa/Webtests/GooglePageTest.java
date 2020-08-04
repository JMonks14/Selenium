package qa.Webtests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
	
	private WebDriver driver;
	

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));

    }

    @Ignore
    public void test() throws InterruptedException {
        driver.get("https://google.com");
        
        WebElement images = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[2]/a"));
        images.click();

       WebElement search =  driver.findElement(By.xpath("//*[@id=\"sbtc\"]/div/div[2]/input"));
        search.sendKeys("kittens");
        search.submit();
        
        Thread.sleep(5000);
    }
    
    @Test
    public void testLogin() throws InterruptedException {
    	driver.get("http://thedemosite.co.uk/addauser.php");
    	
    	WebElement userEnter = driver.findElement(By.name("username"));
    	userEnter.sendKeys("Autoname");
    	
    	WebElement userPass = driver.findElement(By.name("password"));
    	userPass.sendKeys("Autopass");
    	
    	WebElement savebutt = driver.findElement(By.name("FormsButton2"));
    	savebutt.click();
    	
    	driver.get("http://thedemosite.co.uk/login.php");
    	
    	WebElement Enter = driver.findElement(By.name("username"));
    	Enter.sendKeys("Autoname");
    	
    	WebElement Pass = driver.findElement(By.name("password"));
    	Pass.sendKeys("Autopass");
    	
    	WebElement testbutt = driver.findElement(By.name("FormsButton2"));
    	testbutt.click();
    	
    	WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
    	assertEquals("**Successful Login**", success.getText());
    	
    	Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


