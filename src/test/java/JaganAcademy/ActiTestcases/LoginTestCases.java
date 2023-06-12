package JaganAcademy.ActiTestcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Actipageobjects.BaseClass;
import Actipageobjects.LoginPage;
import Utilityclases.PropertyUtility;


public class LoginTestCases extends BaseClass {

	WebDriver driver;
	@BeforeClass
	public void launchBrowser() throws Exception {
		
		opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
	p	=new PropertyUtility();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
	//	driver.get(p.fetchProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test()
	public void getSignin() throws Throwable {
		 LoginPage lp = new LoginPage(driver);
		 PropertyUtility  p=new PropertyUtility();

		lp.getUserId().sendKeys("admin");
		//lp.getUserId().sendKeys(p.fetchProperty("un"));
	lp.getPassword().sendKeys("manager");
	//	lp.getPassword().sendKeys(p.fetchProperty("pwd"));
	
	    lp.getSubmit().click();
		LoginPage.verfication();
		
	}
	@Test
	public void titleValidation()
	{
		String actualTitle=driver.getTitle();
		System.out.println("the page title is : "+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
