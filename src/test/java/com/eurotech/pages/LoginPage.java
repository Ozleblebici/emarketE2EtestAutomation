package com.eurotech.pages;


import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // No need more, because we declared it in BasPage class
//    public LoginPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;
    @FindBy(id = "loginpage-input-email")
    public WebElement usernameInput;
    @FindBy(id = "loginpage-form-pw-input")
    public WebElement passwordInput;
    @FindBy(id = "loginpage-form-btn")
    public WebElement loginBtn;
    @FindBy(xpath = "//*[.='Invalid Credentials!']")
    public WebElement warningMessage;
    @FindBy(xpath = "//*[.='Please include a valid email!']")
    public WebElement warningMessage2;
    @FindBy (xpath = "//*[contains(text(),'valid')]")
    public WebElement warningMessage_loc;


//    @FindAll({
//            @FindBy(id = "loginpage-input-email"),
//            @FindBy(name = "email2")
//    })
//    public WebElement usernameInput2;
//
//    @FindBys({
//            @FindBy(id = "loginpage-input-email"),
//            @FindBy(name = "email3")
//    })
//    public WebElement usernameInput3;
//
//    @FindBy(css = ".menu-list")
//    public List<WebElement> menuList;


    public void login(){
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        understandBtn.click();
        loginBtn.click();
    }

    public void login(String userEmail, String password){
       usernameInput.sendKeys(userEmail);
       passwordInput.sendKeys(password);
       understandBtn.click();
       loginBtn.click();
    }

    public void loginAsStudent(){
        usernameInput.sendKeys(ConfigurationReader.get("usernameStudent"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordStudent"));
        understandBtn.click();
        loginBtn.click();
    }

    public void loginAsDeveloper(){
        usernameInput.sendKeys(ConfigurationReader.get("usernameDeveloper"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordDeveloper"));
        understandBtn.click();
        loginBtn.click();
    }
    public String  getDisappearingWarningMessage(String message){
        String actualMessage= null;
        if (message.contains("@")){
            //actualMessage = Driver.get().findElement(By.id("loginpage-input-email")).getAttribute("validationMessage");
            actualMessage = usernameInput.getAttribute("validationMessage");
            System.out.println("actualMessage = " + actualMessage);
        }else if (message.contains("valid")){
            actualMessage= warningMessage_loc.getText();
            System.out.println("actualMessage = " + actualMessage);
        }
        return actualMessage;
    }



}
