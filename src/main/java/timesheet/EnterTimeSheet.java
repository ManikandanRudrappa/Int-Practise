package timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterTimeSheet 
{
	public static void main(String[] args)
	{

		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://onecognizant.cognizant.com/");
		//PAGE1-HomePage
		
		WebElement UserID = driver.findElementById("userNameInput");
		UserID.sendKeys("788265");
		UserID.sendKeys(Keys.TAB);
		
		
		WebElement Password = driver.findElementById("passwordInput");
		Password.sendKeys("ChngePwd@454");
		Password.sendKeys(Keys.ENTER);
		
		driver.findElementByXPath("//input[@id='idSIButton9']").click();
		
		//PAGE 2-AppSearch
		WebElement EnterTS = driver.findElementById("txtPlatformBarSearch");
		EnterTS.sendKeys("timesheet");
		EnterTS.sendKeys(Keys.ENTER);
		
		driver.switchTo().frame("appFrame");
		driver.findElementByXPath("//h3[text()='Submit Timesheet']").click();
		
		
		Set<String> AllWindows =driver.getWindowHandles();
		List<String> CurrentWindow =new ArrayList<String>(AllWindows);
		driver.switchTo().window(CurrentWindow.get(0));
		
		
		//PAGE 3-TimeSheets
		
	driver.findElementByXPath("a[@id='CTS_TS_LAND_PER_DESCR30$0']").click();
		
		//PAGE 4-Final
	driver.switchTo().frame("ptifrmtgtframe");
		driver.findElementByXPath("//img[@id='CTS_EX_ACT_VW_DESCR$prompt$img$0']").click();
		
		driver.switchTo().frame("ptModFrame_1");
		driver.findElementByXPath("//a[@id='RESULT0$12']").click();
		
		
}
}