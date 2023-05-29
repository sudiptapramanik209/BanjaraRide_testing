package Demo.appiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.google.common.util.concurrent.Service;

import demo.appium_Framework.Capabelity;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Test_HybrideApp extends Capabelity{
	AndroidDriver<AndroidElement> driver;
	@BeforeTest()
	private void setup() throws IOException, InterruptedException {
		service=startserver();
		driver=capablitiesss();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test(priority = 1,enabled = true)
	public void Book_Now() throws InterruptedException{
		TouchAction tact=new TouchAction(driver);
		AndroidElement elem=driver.findElement(By.id("com.forbinary.banjararide:id/link_2"));
		tact.tap(TapOptions.tapOptions().withElement(element(elem))).perform();
		AndroidElement elem1=driver.findElement(By.id("com.forbinary.banjararide:id/llMainLayout"));
		tact.tap(TapOptions.tapOptions().withElement(element(elem1))).perform();
		AndroidElement elem2=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"CB Hornet 160R\"))"));
		tact.tap(TapOptions.tapOptions().withElement(element(elem2))).perform();
		AndroidElement elem3=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"7 days \"))"));
		tact.tap(TapOptions.tapOptions().withElement(element(elem3))).perform();
		AndroidElement now=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Book Now\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(now))).perform();
		
		AndroidElement date=driver.findElement(By.id("com.forbinary.banjararide:id/llDateContainer"));
		tact.tap(TapOptions.tapOptions().withElement(element(date))).perform();
		
		driver.findElementByAccessibilityId("26 May 2023").click();
		
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	@Test(priority = 2,enabled = true)
	public void search() throws InterruptedException{
		TouchAction taction = new TouchAction(driver);
		 AndroidElement Menu =	driver.findElementByAccessibilityId("Open");
		 taction.tap(TapOptions.tapOptions().withElement(element(Menu))).perform();
		
		 AndroidElement Booking =	driver.findElement(By.xpath("//*[@text='Bookings']"));
	     taction.tap(TapOptions.tapOptions().withElement(element(Booking))).perform();
		 Thread.sleep(2000);
		   
		 AndroidElement Search =	driver.findElementById("com.forbinary.banjararide:id/search_button");
		 taction.tap(TapOptions.tapOptions().withElement(element(Search))).perform();
	      	
	     Thread.sleep(2000);
	     driver.findElementById("com.forbinary.banjararide:id/search_src_text").sendKeys("activa");
	      	
	      	
	     AndroidElement Clear =	driver.findElementById("com.forbinary.banjararide:id/search_close_btn");
		 taction.tap(TapOptions.tapOptions().withElement(element(Clear))).perform();
		      
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 Thread.sleep(1000);
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	@Test(priority = 3,enabled = true)
	public void coll_us() throws InterruptedException{
		TouchAction touchAction = new TouchAction(driver);
		AndroidElement coll=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))"));
		touchAction.tap(TapOptions.tapOptions().withElement(element(coll))).perform();
		driver.activateApp("com.forbinary.banjararide");
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		//touchAction.press(PointOption.point(517, 1208)).waitAction().moveTo(PointOption.point(1019, 1193)).release().perform();
		//touchAction.press(PointOption.point(370, 1250)).waitAction().moveTo(PointOption.point(370, 200)).release().perform();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"CLEAR ALL\")")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"BanjaraRide\"]")).click();
	}
	@Test(priority=4,enabled=true)
	public void aboutUs() throws InterruptedException {
		
		AndroidElement about=driver.findElement(MobileBy.AndroidUIAutomator("text(\"About Us\")"));
		TouchAction tact=new TouchAction(driver);
		tact.tap(TapOptions.tapOptions().withElement(element(about))).perform();
		
		AndroidElement abo_us=driver.findElement(MobileBy.AndroidUIAutomator("text(\"About Company!\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(abo_us))).perform();
		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		AndroidElement Address=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Address And Contact Number.\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(Address))).perform();
		Thread.sleep(3000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
	}
	@Test(priority=5,enabled=false)
	public void Info_Center() throws IOException, InterruptedException{
		AndroidElement menu=driver.findElementByAccessibilityId("Open");
		TouchAction tact=new TouchAction(driver);
		tact.tap(TapOptions.tapOptions().withElement(element(menu))).perform();
		
		AndroidElement bookings=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Information Center\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(bookings))).perform();
		
		AndroidElement term=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Terms & Conditions\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(term))).perform();
		
		AndroidElement term1=driver.findElement(MobileBy.AndroidUIAutomator("text(\"Terms & Condition\")"));
		tact.tap(TapOptions.tapOptions().withElement(element(term1))).perform();
		
		AndroidElement pdf=driver.findElement(By.id("com.forbinary.banjararide:id/llFileLinearLayout"));
		tact.tap(TapOptions.tapOptions().withElement(element(pdf))).perform();
		
		driver.findElement(By.xpath("//*[@text='OK']")).click();
		
		driver.findElement(By.xpath("//*[@text='Drive PDF Viewer']")).click();
		Thread.sleep(2000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	@Test(enabled=true , priority=6)
	public void update_profile() throws InterruptedException{
		
		TouchAction taction = new TouchAction(driver);
		AndroidElement Menu =	driver.findElementByAccessibilityId("Open");
		taction.tap(TapOptions.tapOptions().withElement(element(Menu))).perform();
		
		AndroidElement TermsAndCondition =	driver.findElement(By.xpath("//*[@text='Profile']"));
	    taction.tap(TapOptions.tapOptions().withElement(element(TermsAndCondition))).perform();
	      
	    driver.findElementById("com.forbinary.banjararide:id/action_edit").click();
	      
	    driver.findElementById("com.forbinary.banjararide:id/edtInputProfile").clear();
	      
	    driver.findElementById("com.forbinary.banjararide:id/edtInputProfile").sendKeys("Sudipta");
	      
	    AndroidElement Back =	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎\"]");
	    taction.tap(TapOptions.tapOptions().withElement(element(Back))).perform();
	      
		AndroidElement Back1 =	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎\"]");
		taction.tap(TapOptions.tapOptions().withElement(element(Back1))).perform();
		
		
	}
	
	@Test(enabled=true , priority=7)
	public void Testcase8() throws InterruptedException{
	
		TouchAction taction = new TouchAction(driver);
		AndroidElement Menu =	driver.findElementByAccessibilityId("Open");
		taction.tap(TapOptions.tapOptions().withElement(element(Menu))).perform();
		
		AndroidElement Language =	driver.findElement(By.xpath("//*[@text='Change Language']"));
	    taction.tap(TapOptions.tapOptions().withElement(element(Language))).perform();
	      
	    AndroidElement Hindi =	driver.findElement(By.xpath("//*[@text='हिंदी']"));
	    taction.tap(TapOptions.tapOptions().withElement(element(Hindi))).perform();
		
	
		AndroidElement Menu1 =	driver.findElementByAccessibilityId("Open");
		taction.tap(TapOptions.tapOptions().withElement(element(Menu1))).perform();
			
		AndroidElement Language1 =	driver.findElement(By.xpath("//*[@text='भाषा बदलो']"));
		taction.tap(TapOptions.tapOptions().withElement(element(Language1))).perform();
		      
		AndroidElement English =	driver.findElement(By.xpath("//*[@text='ENGLISH']"));
		taction.tap(TapOptions.tapOptions().withElement(element(English))).perform();
	     
		
	}

}
