package Login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsLoginPage {
	WebDriver driver;
	WebDriverWait wait;

	public ElementsLoginPage(WebDriver driver){
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement id;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login-button")
	WebElement button;
	@FindBy(css="h3[data-test='error']")
	WebElement error;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement message;
	
	public void loginValid(String username, String password1) {
		id.sendKeys(username);
		password.sendKeys(password1);
		button.click();	
		System.out.println(driver.getTitle());
		
		
	}
}
