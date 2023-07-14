package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;

public class Emarket {


    public static void clickButtonWithName(String buttonText){
        Driver.get().findElement(By.xpath("//button[contains(text(),'"+buttonText+"')]")).click();
    }


}
