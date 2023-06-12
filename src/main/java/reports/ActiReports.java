package reports;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ActiReports {
	WebDriver driver;
	
public static void getExtentreports()
{
	ExtentSparkReporter sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"sparkhtmlreports.html");
	ExtentReports reports=new ExtentReports();
	sparkreporter.config().setEncoding("utf-8");
	sparkreporter.config().setDocumentTitle("Automation test Results");
	sparkreporter.config().setTheme(Theme.DARK);
	 reports.attachReporter(sparkreporter);
	 reports.setSystemInfo("Automation engineer", "s.jagannadham");
	
	
}
}
