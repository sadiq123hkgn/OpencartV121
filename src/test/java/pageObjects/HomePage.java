/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class HomePage extends BasePage {


	public HomePage(WebDriver driver){

		super (driver)	;	
	}


	@FindBy(xpath="//span[text()='My Account']")

	WebElement lnkMyaccount;

	@FindBy(xpath="(//a[text()='Register'])[1]")

	WebElement lnkRegister;

	@FindBy(xpath="(//a[text()='Login'])[1]")

	WebElement linkLogin;
	
	public void clickMyAccount() {
		lnkMyaccount.click();
      }

	public void clickRegister() {
		lnkRegister.click();

	}
	public void clickLogin() {
		linkLogin.click();

	}

}