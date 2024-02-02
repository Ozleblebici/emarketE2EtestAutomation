package com.eurotech.pages;

import com.eurotech.utilities.DBUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;

public class Emarket {


    public static void clickButtonWithName(String buttonText){
        Driver.get().findElement(By.xpath("//button[contains(text(),'"+buttonText+"')]")).click();
    }

    public static void main(String[] args) {

        DBUtils.createConnection();
        System.out.println("DBUtils.getCellValue(\"SELECT username FROM users where id = 1 ;\") = " + DBUtils.getCellValue("SELECT username FROM users where id = 1 ;"));
    }


}
