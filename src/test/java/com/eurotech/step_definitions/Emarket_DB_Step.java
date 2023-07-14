package com.eurotech.step_definitions;

import com.eurotech.utilities.DBUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class Emarket_DB_Step {


    @Then("Verify {string} order email with database record")
    public void verifyOrderEmailWithDatabaseRecord(String orderID) {
        String actualEmail = Driver.get().findElement(By.xpath("//div[@class='row']/div[text()='" + orderID + "']/../div[@class='col-3'][2]")).getText();
        System.out.println(orderID + ". order's actualEmail = " + actualEmail);

        String expectedEmail = (String) DBUtils.getCellValue("select email from orders where id=" + orderID);
        System.out.println(orderID + ". order's expectedEmail = " + expectedEmail +"\n");

        Assert.assertEquals(expectedEmail, actualEmail);
    }



    // DATABASE Practice
    @Test
    public void dbPractice(){

        DBUtils.createConnection();

        List<Object> rowList = DBUtils.getRowList("select * from orders where id=1");

        System.out.println("rowList = " + rowList);
        
        //////////////////////

        Map<String, Object> rowMap = DBUtils.getRowMap("select * from orders where id=1");

        System.out.println("rowMap = " + rowMap);

        System.out.println("rowMap.get(\"name\") = " + rowMap.get("name"));
        System.out.println("rowMap.get(\"id\") = " + rowMap.get("id"));

        ////////////////////

        // ui da urune sec tiklmadan once durumunun preparing old gore
        String actual=  (String) DBUtils.getCellValue("select * from orders where id=1");
        Assert.assertEquals("preparing", actual);

        // ui oto  , statusu complete yaptin!!


        // db ye git durumun complete old gore
      String actualStatus=  (String) DBUtils.getCellValue("select * from orders where id=1");
      Assert.assertEquals("complete", actualStatus);

    }

    @Then("Verify that {string} order status is {string} in database")
    public void verifyThatOrderStatusIsInDatabase(String orderID, String expectedStatus) {

        String actualStatus=  (String) DBUtils.getCellValue("select status from orders where id="+orderID);
        Assert.assertEquals(expectedStatus, actualStatus);
    }
}
