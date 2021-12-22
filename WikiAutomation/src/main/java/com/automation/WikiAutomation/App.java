package com.automation.WikiAutomation;

import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  
       try {
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Drivers/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        
	        //open chrome browser and redirect to wikipedia
	        driver.get("https://www.wikipedia.org/");
	        
	        //click on english tag
	        driver.findElement(By.id("js-link-box-en")).click();
	        Thread.sleep(1000);
	        
	        //click on all portal
            driver.findElement(By.linkText("All portals")).click();
            Thread.sleep(1000);
            
            //click on A-Z index
            driver.findElement(By.cssSelector("#mw-content-text > div.mw-parser-output > div:nth-child(4) > ul > li:nth-child(9) > a")).click();
            Thread.sleep(1000);
            
            //click on N
            driver.findElement(By.xpath("//*[@id=\'toc\']/tbody/tr[29]/td[1]/b/a")).click();
            Thread.sleep(1000);
            
            //click on N page
            driver.findElement(By.xpath("//*[@id=\'mw-content-text\']/div[3]/ul/li[1]/a")).click();
            
            //get all 3 top data
            String first=driver.findElement(By.xpath("//*[@id=\'toc\']/ul/li[1]/a/span[2]")).getText();
            String firstdata=driver.findElement(By.xpath("//*[@id=\'mw-content-text\']/div[1]/p[3]")).getText();
            String second=driver.findElement(By.xpath("//*[@id=\'toc\']/ul/li[2]/a/span[2]")).getText();
            String seconddata=driver.findElement(By.xpath("//*[@id=\'mw-content-text\']/div[1]/p[4]")).getText();
            String third=driver.findElement(By.xpath("//*[@id=\'toc\']/ul/li[3]/a/span[2]")).getText();
            String thirddata=driver.findElement(By.xpath("//*[@id=\'mw-content-text\']/div[1]/p[8]")).getText();
            
            //store data in array
            String[][] arr= {{first,firstdata},{second,seconddata},{third,thirddata}};
            Thread.sleep(1000);
            String str = "SomeMoreTextIsHere";
            File newTextFile = new File(System.getProperty("user.dir")+"//src//main//java//Output//output.txt");

            FileWriter fw = new FileWriter(newTextFile);
            for(int i=0;i<arr.length;i++) {
            	for(int j=0;j<arr[0].length;j++) {
            		fw.write(arr[i][j]+"\n");
            	}
            }
            fw.close();
            
            
            
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }
    }
}
