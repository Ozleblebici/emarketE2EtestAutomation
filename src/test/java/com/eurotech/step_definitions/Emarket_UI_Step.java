package com.eurotech.step_definitions;

import com.eurotech.pages.Emarket;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Emarket_UI_Step {

    @Given("User navigate to login page")
    public void userNavigateToLoginPage() {
        Driver.get().get("http://localhost:8080/login");
    }

    @When("Login as admin")
    public void loginAsAdmin() {

        Driver.get().findElement(By.id("input-email")).sendKeys("admin@gmail.com");
        Driver.get().findElement(By.id("input-password")).sendKeys("12345678");
        Emarket.clickButtonWithName("Login");
    }

    @Then("Navigate to {string} module")
    public void navigateToModule(String moduleName) {

        BrowserUtils.waitFor(2);
        Driver.get().get("http://localhost:8080/"+moduleName);
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that {string} order email is {string}, order price is {string} usd")
    public void verifyThatOrderEmailIsOrderPriceIsUsd(String orderID, String orderEmail, String orderPrice) {

        String actualEmail= Driver.get().findElement(By.xpath("//div[@class='row']/div[text()='"+orderID+"']/../div[@class='col-3'][2]")).getText();
        System.out.println("actualEmail = " + actualEmail);

        Assert.assertEquals(orderEmail,actualEmail);

    }

    @And("Change {string} order id's status to {string} on UI")
    public void changeOrderIdSStatusToOnUI(String orderID, String status) {

        Driver.get().findElement(By.xpath("//div[@class='row']/div[text()='"+orderID+"']/..//*[@id='dropdown-left__BV_toggle_']")).click();

        Driver.get().findElement(By.xpath("//div[@class='row']/div[text()='"+orderID+"']/..//a[contains(text(),'"+status+"')]")).click();

        BrowserUtils.waitFor(5);
    }
}
