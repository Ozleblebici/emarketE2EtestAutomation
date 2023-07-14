package com.eurotech.step_definitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DashboardMenu_StepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Then("The user should be able to see following menu")
    public void the_user_should_be_able_to_see_following_menu(List<String> expectedList) {
        System.out.println("expectedList.size() = " + expectedList.size());
        System.out.println("expectedList = " + expectedList);

        /** List<String> actualList = new ArrayList<>();
         System.out.println("actualList.size() = " + actualList.size());
         for (WebElement el : dashboardPage.menuList) {
         actualList.add(el.getText());
         }*/

        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menuList);
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(expectedList, actualList);
    }

    @When("The user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userCredentials) {
        System.out.println("userCredentials = " + userCredentials);
        loginPage.login(userCredentials.get("username"),userCredentials.get("password"));
        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains(userCredentials.get("message")));
    }
    @Then("The user should be able to see following editAdd menu")
    public void the_user_should_be_able_to_see_following_edit_add_menu(List<String> expectedMenu) {
        System.out.println("expectedMenu.size() = " + expectedMenu.size());
        System.out.println("expectedMenu = " + expectedMenu);
        List<String> actualMenu=BrowserUtils.getElementsText(dashboardPage.editAddMenu);
        System.out.println("actualMenu = " + actualMenu);
        Assert.assertEquals(expectedMenu,actualMenu);
    }
}
