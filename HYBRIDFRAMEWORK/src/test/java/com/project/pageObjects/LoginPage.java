 package com.project.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Documentation details
	/*
	 @CacheLookup
	@FindBy(id="user-name")
	or
	@FindBy(how=How.ID,using ="user-name")
	 WebElement username;
	
	@FindBys({
		 @FindBy(class="custom-control-check-box"),
		 @FindBy(id="game-chk-box")
		})
	@FindAll({
		 @FindBy(id="btn", //doesn't match
		 @FindBy(name="sbmtBtn"), //Matches
		 @FindBy(class="btn-primary") //doesn't match
		})
		@CacheLookUp use when the elements changes rarely and need repeat use. 
*/
	
WebDriver driver;
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")	WebElement username;
	
	@FindBy(id="password") WebElement password;
	
	@FindBy(id="login-button")WebElement button;
	
public void setusername(String uname) {
		username.sendKeys(uname);
		}
public void setpassword(String pwd) {
		password.sendKeys(pwd);
		}
public void clickbutton() {
		button.click();
	}
}


	
	
					