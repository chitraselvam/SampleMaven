package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);

}
	@FindBy(id="location")
	private WebElement drpdwnLocation;
	

	@FindBy(id="hotels")
	private WebElement drpdwnHotels;
	

	@FindBy(id="room_type")
	private WebElement drpdwnRoomType;
	

	@FindBy(id="room_nos")
	private WebElement drpdwnRoomNos;
	
		
	@FindAll({@FindBy(xpath="//input[@id='datepick_in']"),@FindBy(name="datepick_in")})
	private WebElement txtCheckIn;
	

	@FindBy(xpath="//input[@id='datepick_out']")
	private WebElement txtCheckOut;
	

	@FindBy(id="adult_room")
	private WebElement drpdwnAdultPerRoom;
	

	@FindBy(id="child_room")
	private WebElement drpdwnChildrenPerRoom;
	
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	@FindBy(id="Reset")
	private WebElement btnReset;


	public WebElement getBtnSearch() {
		return btnSearch;
	}


	public WebElement getBtnReset() {
		return btnReset;
	}


	public WebElement getDrpdwnLocation() {
		return drpdwnLocation;
	}


	public WebElement getDrpdwnHotels() {
		return drpdwnHotels;
	}


	public WebElement getDrpdwnRoomType() {
		return drpdwnRoomType;
	}


	public WebElement getDrpdwnRoomNos() {
		return drpdwnRoomNos;
	}


	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}


	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}


	public WebElement getDrpdwnAdultPerRoom() {
		return drpdwnAdultPerRoom;
	}


	public WebElement getDrpdwnChildrenPerRoom() {
		return drpdwnChildrenPerRoom;
	}
	

	

}

