package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(id="first_name"),@FindBy(name="first_name")})
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindAll({@FindBy(id="address"),@FindBy(name="address")})
	private WebElement txtBillingaddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCardNumber;
	
	@FindAll({@FindBy(id="cc_type"),@FindBy(name="cc_type")})
	private WebElement txtCardType;
	
	@FindAll({@FindBy(id="cc_exp_month"),@FindBy(name="cc_exp_month")})
	private WebElement drpdwnExpiryMonth;
	
	@FindAll({@FindBy(id="cc_exp_year"),@FindBy(name="cc_exp_year")})
	private WebElement drpdwnExpiryYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCCV;
	
	@FindAll({@FindBy(id="book_now"),@FindBy(name="book_now")})
	private WebElement btnBookNow;
	
	@FindBy(id="cancel")
	private WebElement btnCancel;

	public WebElement getTxtFirstName() {
		return txtFirstName;

}
	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtBillingaddress() {
		return txtBillingaddress;
	}


	public WebElement getTxtCardType() {
		return txtCardType;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getDrpdwnExpiryMonth() {
		return drpdwnExpiryMonth;
	}

	public WebElement getDrpdwnExpiryYear() {
		return drpdwnExpiryYear;
	}

	public WebElement getTxtCCV() {
		return txtCCV;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
}
