package com.dotdash_bozcan.assesmentBusra;
import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class DynamicLoading {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/dynamic_loading/2");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
//        Driver.closeDriver();
    }

    /*
    Dynamic Loading:  Dynamic Loading using Explict Waits.
     */
    @Test
    public void dynamicLoadingTest() {
        WebElement startButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Start')]"));
        startButton.click();

        WebElement textHelloWorld = Driver.get().findElement(By.xpath("//h4[contains(text(), 'Hello World!')]"));

        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.visibilityOf(textHelloWorld));

        String expectedText = "Hello World!";
        String actualText = textHelloWorld.getText();

        Assert.assertTrue(actualText.contains(expectedText));
    }
}



