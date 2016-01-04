package Pages;


//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AmazonSearch {

	private static WebDriver sdriver = new FirefoxDriver();
	
	private static void full_test() throws Exception{
		getSystemStatus(sdriver);
		sdriver.get("http://www.amazon.com");
	 	sdriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 	sdriver.manage().window().maximize();
	 	//SaveScreenShot("AfterMaximize");
	 	sdriver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("QA Books");
	 	//SaveScreenShot("AfterTypingSearchValue");
	 	Thread.sleep(2000);
	 	
	 	//highlightElement(sdriver,sdriver.findElement(By.cssSelector("input[value='Go']")),2);
	 	//sdriver.findElement(By.cssSelector("input[value='Go']")).click();
	 	sdriver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(Keys.ENTER);
	 	Thread.sleep(2000);
	 	//SaveScreenShot("AfterPressingSearch");
	 	String valorTotal = sdriver.findElement(By.cssSelector("#s-result-count")).getText().split(" ")[2].replace(",", "");
	 	System.out.print("Total Results Shown: '"+valorTotal+"'");
	 	sdriver.close();
	 	Assert.assertTrue(Integer.parseInt(valorTotal)>9000);
	 	
	}
	
	public static void driverquit(){
		sdriver.close();
	}
	
    public static void SaveScreenShot(String strNameSeed) throws IOException {
        //String scrBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        File scrFile = ((TakesScreenshot)sdriver).getScreenshotAs(OutputType.FILE);
        System.out.println("SCREENSHOT: " +strNameSeed );
        // Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("./TestResults/" + strNameSeed + " " + getCurrentTime("YYYYMMdd_HH-mm-ss")+".png"));
    }
    
    public static String getCurrentTime(String strTimeFormat){
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(strTimeFormat);
        String strDateValue = dateFormat.format(calendar.getTime());
        System.out.println(strDateValue);
        return strDateValue;
    }

    public static void highlightElement(WebDriver driver, WebElement welement, Integer intTime) throws Exception{
    	//highlights the given element
    	//((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", welement);
    	((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", welement, "color: red; border: 3px solid red;");
    	
    	//leaves the element highlighted for a given time frame
    	Thread.sleep(intTime*1000);
    	
    	//Takes a screenshot of the highlighted element
    	SaveScreenShot("ElementHighlighted"+welement.toString());
    	
    	//un-highlights the element
    	((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", welement, "");
    }
    
    public static void getSystemStatus(WebDriver driver){
    	Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();

    	String browserName = caps.getBrowserName();
    	String browserVersion = caps.getVersion();
    	String PlatformName = caps.getPlatform().toString();

    	System.out.print("PLATAFORM: '"+PlatformName+"'. BROWSER: '"+browserName+"' v" + browserVersion + "  ");
    }
    
	public static void main( String args ) throws Exception
    {
        if (args.equals("full")){
        	full_test();
        }else {
        	System.out.print(">>> NOTHING TO DO <<<");
        }
    }
	
}
