package JaganAcademy.ActiTestcases;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Actipageobjects.BaseClass;
import Actipageobjects.CreateCustomerPageClass;
import Actipageobjects.LoginPage;
import Utilityclases.PropertyUtility;


public class CreateCustomerTest extends BaseClass  {

	WebDriver driver;
	ExtentReports reports;
	WebDriverWait wait;
	//PropertyUtility p;
	@BeforeTest
	public void getExtentReports() {
		
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"sparkhtmlreports.html");
		 reports=new ExtentReports();
		sparkreporter.config().setEncoding("utf-8");
		sparkreporter.config().setDocumentTitle("Automation test Results");
		sparkreporter.config().setTheme(Theme.DARK);
		 reports.attachReporter(sparkreporter);
		 reports.setSystemInfo("Automation engineer", "s.jagannadham");
	
	
	}

	@BeforeClass
	public void launchBrowser() throws Throwable {
		opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		//driver.get("https://demo.actitime.com/login.do");
		driver.get(p.fetchProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 2, dependsOnMethods = { "getLogin" })
	public void addCustomer() {
		CreateCustomerPageClass p = new CreateCustomerPageClass(driver);
		p.getTask().click();
		p.getAddNew().click();
		p.getAddCustomer().click();
		p.getAddCname().sendKeys("java");
		p.getCreateCustomer().click();
		getvisibleele(wait, driver);
		p.getCloseButton().click();
		gethandleAleAcces(driver);
	}

	@Test(priority = 1)
	public void getLogin() throws Exception {
		LoginPage lp = new LoginPage(driver);
       p=new PropertyUtility();
	//	lp.getUserId().sendKeys("admin");
       lp.getUserId().sendKeys(p.fetchProperty("un"));
		
		lp.getPassword().sendKeys(p.fetchProperty("pwd"));
		lp.getSubmit().click();
	}

	@AfterClass
	public void logout() {
		
		CreateCustomerPageClass p = new CreateCustomerPageClass(driver);
		p.getLogout().click();
		reports.flush();
		driver.close();
	}

}
