package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import com.eurotech.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

//    @FindBy(id = "rcc-confirm-button")
//    public WebElement understandBtn;
    @FindBy(className = "nav__menu-item") // with css=> #navbar-menu-list2>li
    public List<WebElement> menuList;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement developers;
    @FindBy(xpath = "//a[text()='All Posts']")
    public WebElement allPost;
    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    public void navigateToMenu(String menuName){
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }

    public void navigateToSubmenu(String subMenu){
        Driver.get().findElement(By.xpath("//span[text()='"+subMenu+"']")).click();
    }

    public String getCommonText(String element){
        return Driver.get().findElement(By.xpath("//td[text()='"+element+"']")).getText();
    }

    public List<Map<String,String>> getDataList(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch7DevEx.xlsx","Test Data");
        List<Map<String, String>> dataList = excelUtil.getDataList();
        return dataList;
    }

}
