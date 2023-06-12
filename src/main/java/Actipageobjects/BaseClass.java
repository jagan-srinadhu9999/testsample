package Actipageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilityclases.PropertyUtility;

public class BaseClass {

	public WebDriver driver;
	public ChromeOptions opt;
     public PropertyUtility  p;
     public WebDriverWait wait;
   public static  String expectedTitle="actiTIME - Login";
   
   public static void getvisibleele(WebDriverWait wait,WebDriver driver)
   {
	   wait=new  WebDriverWait(driver, Duration.ofSeconds(20));
	 By loc=   By.xpath("//div[@id='customerLightBoxCloseButton']");
	   
	   wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
   }
   public static void gethandleAleAcces(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }

}
