package com.dotdash_bozcan.assesmentBusra;

import com.dotdash_bozcan.utilities.ConfigurationReader;
import com.dotdash_bozcan.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(ConfigurationReader.get("baseUrl") + "/dropdown");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);

    }

    @Test
    public void dropDownBySelect() {

        WebElement dropdownList = Driver.get().findElement(By.id("dropdown"));

        Select select = new Select(dropdownList);

        List<WebElement> options = select.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        String optionZero = options.get(0).getText();
        System.out.println("optionZero = " + optionZero);
        String optionOne = options.get(1).getText();
        System.out.println("optionOne = " + optionOne);
        String optionTwo = options.get(2).getText();
        System.out.println("optionTwo = " + optionTwo);

        Assert.assertEquals(optionZero, "Please select an option");
        Assert.assertEquals(optionOne, "Option 1");
        Assert.assertEquals(optionTwo, "Option 2");

    }


}


