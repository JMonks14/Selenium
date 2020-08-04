package qa.Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FTSEpage {
	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[3]/a/strong")
	private WebElement fallLink;
	
	public void navFallers() {
		this.fallLink.click();
	}

	public FTSEpage() {
		// TODO Auto-generated constructor stub
	}

}
