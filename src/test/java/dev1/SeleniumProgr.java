package dev1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.exec.util.*;

import java.io.*;
import java.util.Properties;

public class SeleniumProgr {
    public static void main(String[] args) throws IOException {
FileInputStream FI = new FileInputStream("src/test/config.properties");
Properties Prop = new Properties();
Prop.load(FI);
String P = Prop.getProperty("ChromePath");
System.out.println(P);
        System.setProperty("webdriver.chrome.driver", P);
        WebDriver driver=new ChromeDriver();
        // Launch Website
        driver.get("http://www.google.com/");
        //Maximize the browser
        driver.manage().window().maximize();
        // Capture screenshot and store as File
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination path
            String filePath = "C:\\Users\\prana\\Desktop\\screenshot.png";

            // Copy file to the desired location
            FileUtils.copyFile(screenshotFile, new File(filePath));

            System.out.println("Screenshot saved at: " + filePath);

            System.out.println("Error while taking screenshot: ");

    }
}
