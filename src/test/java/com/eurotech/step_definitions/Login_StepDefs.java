package com.eurotech.step_definitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

//    ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch7DevEx.xlsx","Test Data");
//    List<Map<String, String>> dataList = excelUtil.getDataList();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
       // System.out.println("I open the browser and navigate to DevEx web page");
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }
    @When("The user enters teacher credentials")
    public void the_user_enters_teacher_credentials() {
       // System.out.println("I enter teacher username and password then click login button");
        loginPage.login();
    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        //System.out.println("I verify that the url change to dashboard");
        //Assert.assertTrue(100<99);
        String actualText = dashboardPage.welcomeMessage.getText();
        Assert.assertTrue(actualText.contains("Welcome"));
    }
    @When("The user enters student credentials")
    public void theUserEntersStudentCredentials() {
       // System.out.println("I enter student username and password then click login button");
        loginPage.loginAsStudent();
    }
    @When("The user enters developer credentials")
    public void theUserEntersDeveloperCredentials() {
        //System.out.println("I enter developer username and password then click login button");
        loginPage.loginAsDeveloper();
    }
//    @When("The user enters SDET credentials")
//    public void the_user_enters_sdet_credentials() {
//        System.out.println("I enter SDET username and password then click login button");
//    }

    @When("The user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String userEmail, String password) {
//        System.out.println("userEmail = " + userEmail);
//        System.out.println("password = " + password);
        loginPage.login(userEmail,password);
    }
    @Then("The welcome message contains {string}")
    public void the_welcome_message_contains(String expectedUsername) {
        String actualMessage= dashboardPage.welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        System.out.println("expectedUsername = " + expectedUsername);
        Assert.assertTrue(actualMessage.contains(expectedUsername));
    }






    @Then("The warning message contains {string}")
    public void theWarningMessageContains(String expectedMessage) {
        BrowserUtils.waitFor(2);
        loginPage.getDisappearingWarningMessage(expectedMessage);
        // to find disappearing warning message
//        String validationMessage= Driver.get().findElement(By.id("loginpage-input-email")).getAttribute("validationMessage");
//        System.out.println("validationMessage = " + validationMessage);
//        Assert.assertEquals(expectedMessage,validationMessage);
    }

    @When("The user enters {string} and row number {int}")
    public void the_user_enters_and_row_number(String sheetName, Integer rowNumber) {
//        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch7DevEx.xlsx",sheetName);
//        List<Map<String, String>> dataList = excelUtil.getDataList();
//        loginPage.login(dataList.get(rowNumber).get("Username"),dataList.get(rowNumber).get("Password"));
        loginPage.login(loginPage.getDataList().get(rowNumber).get("Username"),
                loginPage.getDataList().get(rowNumber).get("Password"));
    }
    @Then("The welcome message contains in excel {int}")
    public void the_welcome_message_contains_in_excel(Integer rowNumberForName) {
        String actualMessage=dashboardPage.welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
//        Assert.assertTrue(actualMessage.contains(dataList.get(rowNumberForName).get("Name")));
        Assert.assertTrue(actualMessage.contains(loginPage.getDataList().get(rowNumberForName).get("Name")));
    }

    @Then("The user verify that company name {int}")
    public void the_user_verify_that_company_name(Integer rowNumberForCompany) {
        String actualCompanyName= dashboardPage.getCompany(dashboardPage.getDataList().get(rowNumberForCompany).get("Company"));
        System.out.println("actualCompanyName = " + actualCompanyName);
        Assert.assertEquals(loginPage.getDataList().get(rowNumberForCompany).get("Company"),actualCompanyName);
    }


}
