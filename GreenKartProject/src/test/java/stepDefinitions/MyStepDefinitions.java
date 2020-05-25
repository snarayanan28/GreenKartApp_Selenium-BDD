package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import cucumberAutomation.Base;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class MyStepDefinitions extends Base {
	public WebDriver driver;
	HomePage homePage;
	CheckOutPage checkoutPage;

    @Given("^User is on Greencart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
        driver= Base.getDriver();
   }
  
    @When("^User searched for (.+) Vegetable$")
    public void user_searched_for_something_vegetable(String strArg1) throws Throwable {
    	homePage = new HomePage(driver);
    	homePage.getSearch().sendKeys(strArg1);  
    	Thread.sleep(3000);    	
    }
    
    @Then("^\"([^\"]*)\" results are displayed$")
    public void something_results_are_displayed(String strArg1) throws Throwable {
    	Assert.assertTrue(homePage.getProductName().getText().contains(strArg1));
    }
    
    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
    	homePage.increment().click();
    	homePage.addToCart().click();
    }

    @And("^User proceeded to Checkout page for purchase$")
    public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
    	driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
    	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
    }
    
    @Then("^verify selected (.+) items are displayed in Check out page$")
    public void verify_selected_items_are_displayed_in_check_out_page(String name) throws Throwable {
        System.out.println("Verification");        
    }
}