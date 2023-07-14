package com.eurotech.step_definitions;

import com.eurotech.pages.Emarket;
import com.eurotech.utilities.Driver;
import com.mysql.cj.exceptions.DataReadException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class Emartket_UI_Step {

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

        Driver.get().get("http://localhost:8080/"+moduleName);
    }
}
