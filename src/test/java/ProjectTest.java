import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class ProjectTest {

    @Test
    void testOne() throws InterruptedException {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.WIKICAR);
        Thread.sleep(3000);
        driver.navigate().to(Helper.SAUCE);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.close();


    }

    @Test
     void testTwo()throws InterruptedException {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.WIKICAR);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.get(Helper.SAUCE);
        String firstTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Helper.WIKICAR);
        String secondTab = driver.getWindowHandle();
        Thread.sleep(3000);
        driver.switchTo().window(firstTab);
        driver.get(Helper.SAUCE);
        driver.switchTo().window(secondTab);
        driver.quit();


    }

    @Test
     void testThree() throws InterruptedException, IOException {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.WIKICAR);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        jse.executeScript("window.scrollBy(0,-(document.body.scrollHeight))");
        WebElement environmentalEffects = driver.findElement(By.id(Helper.PARAGRAPH));
        jse.executeScript("arguments[0].scrollIntoView();", environmentalEffects);
        File newFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File filePath = new File(Helper.FOLDER1 + "WIKIPHOTO" + Helper.JPG);
        FileUtils.copyFile(newFile, filePath);
        driver.quit();
    }

    @Test
    void testfour()throws IOException {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.MYSTORE);
        WebElement mystoresearch = driver.findElement(By.id(Helper.MYSTORESEARCH));
        mystoresearch.sendKeys(Helper.SEARCHTSHIRTS);
        WebElement loginBtn = driver.findElement(By.xpath(Helper.SEARCHBTN));
        loginBtn.click();

        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file2 = new File(Helper.FOLDER1+"1.jpg");
        FileUtils.copyFile(file1,file2);
        driver.quit();



    }

    @Test
    void testfive()   {
        WebDriver driver = Helper.setupDriver();
        driver.get(Helper.WIKICAR);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.WIKICARSEARCHFIELD))).sendKeys("T-SHIRT");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.WIKICARSEARCHBTN))).click();
        Assert.assertEquals(driver.getCurrentUrl(),Helper.WIKITSHIRTS);

        driver.quit();
    }



    }











