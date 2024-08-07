package com.stauto.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.stauto.UIKeywords.UIKeywords;

public class ScreenshotUtil {

	public static void takeFullPageScreenShot() {

		TakesScreenshot screenshot = (TakesScreenshot) UIKeywords.driver;
		File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
		// store screenshot in folder/location
//		Log.info(System.getProperty("user.dir") + " path");
		File dest = new File(System.getProperty("user.dir") + "\\screen1\\two.png");
		srcfile.renameTo(dest);// copy srcfile to dest
	}
}
