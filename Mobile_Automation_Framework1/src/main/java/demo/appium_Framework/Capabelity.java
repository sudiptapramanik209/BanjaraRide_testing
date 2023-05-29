package demo.appium_Framework;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Capabelity {
	
	
	public static String deviceName;
	public static String platformName;
	public static String apppackage;
	public static String appactivity;
	public static String chromedriver;
	public static AppiumDriverLocalService service;
	
	
	public AppiumDriverLocalService startserver()
	{
		boolean flag = checkifserverisRunning(4723);
		if(!flag)
		{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		
		return service;
		
	}
	
	public static boolean checkifserverisRunning(int port)
	{
		boolean isServerRunning=false;
		ServerSocket serversocket;
		try{
			serversocket = new ServerSocket(port);
			serversocket.close();
		}
		catch(IOException e)
		{
			isServerRunning = true;
		}
		finally {
			serversocket=null;
		}
		return isServerRunning;
	}

	// i am used real device
//	public static AppiumDriverLocalService startserver() {
//		service=AppiumDriverLocalService.buildDefaultService();
//		service.start();
//		return service;
//	}
	
	
	
//	public static void startEmulator() throws IOException, InterruptedException {
//	    Runtime.getRuntime().exec("C:\\Users\\sudipta pramanik\\OneDrive\\Desktop\\emulator.bat");
//	    Thread.sleep(30000);
//	    return;
//		}

	public static AndroidDriver<AndroidElement> capablitiesss() throws IOException, InterruptedException {

		FileReader fis=new FileReader(System.getProperty("user.dir")+"//src//main//java//Global.Properties");
		Properties ps=new Properties();
		ps.load(fis);
		
		deviceName=ps.getProperty("deviceName");
		platformName=ps.getProperty("platformName");
		apppackage=ps.getProperty("apppackage");
		appactivity=ps.getProperty("appactivity");
		chromedriver=ps.getProperty("chromeexcutible");
		
		DesiredCapabilities des = new DesiredCapabilities();
		des.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		des.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		des.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,apppackage);
		des.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
		des.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		des.setCapability(MobileCapabilityType.NO_RESET, true);
		des.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriver);
		//if(deviceName.contains("sudipta")) {
//	    	startEmulator();
	    //}
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),des);
		return driver;
	}
}
