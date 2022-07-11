package com.vcentry.lab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vcentry.lab.base.BaseClass;

import junit.framework.Assert;

public class CartPage extends BaseClass {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "checkout")
	private WebElement checkout;

	@FindBy(xpath = "//a[@id='item_4_title_link']/div")
	private WebElement verifyProduct;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postalcode;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "finish")
	private WebElement finishButton;

	@FindBy(xpath = "//div[@id='checkout_complete_cotainer']/h2")
	private WebElement orderPlacedMessage;

	@SuppressWarnings("deprecation")
	public void verifyProductinCart() {
		Assert.assertEquals("Sauce Labs Backpack", verifyProduct.getText());
	}

	public void clickCheckOut() {
		Assert.assertTrue(clickElement(checkout));
	}

	public void entercheckoutDetails(String fName, String lName, String code) {
		enterText(firstName, fName);
		enterText(lastName, lName);
		enterText(postalcode, code);

	}

	public void clickFinish() {
		clickElement(continueBtn);
		clickElement(finishButton);
	}

	@SuppressWarnings("deprecation")
	public void verifyOrderPlaced() {
		Assert.assertTrue(elementDisplayed(orderPlacedMessage));

	}

}
