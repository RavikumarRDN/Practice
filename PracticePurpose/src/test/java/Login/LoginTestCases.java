package Login;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class LoginTestCases {
	WebDriver driver;
	ElementsLoginPage ep;
	
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		ep=new ElementsLoginPage(driver);
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test(dataProvider = "loginData")
	public void loginwithvalidcredentials(String user, String pass) {
		ep.loginValid(user, pass);
	}
	
	@Test(dataProvider="logindata1")
	public void loginwithinvalidcredentials(String user1,String pass1) {
		ep.loginValid(user1, pass1);
	}
	 @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"standard_user", "secret_sauce"},
	            {"locked_out_user", "secret_sauce"},
	            {"problem_user", "secret_sauce"},
	            {"performance_glitch_user", "secret_sauce"}
	        };
	    }
	 
	 @DataProvider(name = "loginData1")
	    public Object[][] getData1() {
	        return new Object[][] {
	            {"standa_user", "sect_sauce"},
	            {"lock_out_user", "seet_sauce"},
	            {"problem_user", "seet_sauce"},
	            {"performance_glitch_r", "secretauce"}
	        };
	    }
	
	 
   

}
