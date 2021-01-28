package stepdefs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Configreader;
import factory.Driverfactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Desktoppage;
import pages.HPpage;
import pages.Homepage;
import pages.Initialpage;
import pages.Loginpage;
import utilities.ActionsClass;
import utilities.Excelreader;

public class Homepagedefs {
	
	Loginpage lp;
	ActionsClass acts;
	HashMap<String, String> hs;
	Properties props;
	Homepage hp;
	HPpage hpg;
	Desktoppage dp;
	Initialpage ip;
	WebDriverWait wt;
	
	@Before
	public void instantiate() throws IOException {
		lp = new Loginpage(Driverfactory.returnDriver());
		acts = new ActionsClass(Driverfactory.returnDriver());
		hp = new Homepage(Driverfactory.returnDriver());
		hpg = new HPpage(Driverfactory.returnDriver());
		hs= new HashMap<String,String>();
		props = Configreader.readConfig();
		ip = new Initialpage(Driverfactory.returnDriver());
		dp = new  Desktoppage(Driverfactory.returnDriver());
		wt = new WebDriverWait(Driverfactory.returnDriver(), 50);
		
	}
	
	 @Given("^User is already logged into the application$")
	    public void user_is_already_logged_into_the_application() throws IOException, InterruptedException  {
		 hs = Excelreader.excelRead("E:\\\\ework\\\\tutninja\\\\src\\\\main\\\\java\\\\Excel\\\\testdata.xlsx");
		 ip.hoverMouse();
		 ip.clickLogin();
		 Thread.sleep(10000);
		 lp.enterUsername(hs.get("username"));
		 lp.enterPassword(hs.get("password"));
		 Thread.sleep(3000);
		 lp.clickSubmit();
		 Thread.sleep(4000);
		 
	
		 
		 
	    }

	    @Given("^User is already present on the home page$")
	    public void user_is_already_present_on_the_home_page()  {
	    	
	   	 String title = acts.returnPageTitle();
		 System.out.println(title);
		 String tit = props.getProperty("home_title");
		 System.out.println(tit);
	Assert.assertEquals(tit, title);
	        
	    }

	    @When("^User hovers over the Desktops tab and clicks on it$")
	    public void user_hovers_over_the_desktops_tab_and_clicks_on_it() throws InterruptedException  {
	        hp.clickDesktops();
	    }

	    @When("^User clicks on Show All Desktops option$")
	    public void user_clicks_on_show_all_desktops_option() throws InterruptedException  {
	        hp.clickShowAll();
	        Thread.sleep(4000);
	    }

	    @When("^User clicks on addto cart button of HP Laptop$")
	    public void user_clicks_on_addto_cart_button_of_hp_laptop() throws InterruptedException {
	     dp.shoppingButtonClick();
	     Thread.sleep(5000);
	    }

	    @When("^User clicks on Add to cart button$")
	    public void user_clicks_on_add_to_cart_button() throws InterruptedException {
	        hpg.clickCart();
	    }

	    @When("^User clicks on logout button then user should be logged out successfully$")
	    public void user_clicks_on_logout_button_then_user_should_be_logged_out_successfully() throws InterruptedException  {
	       hpg.clickAccount();
	       Thread.sleep(1000);
	       hpg.clickLogout();
	    }

	    @Then("^A list should get displayed containing options pc and mac$")
	    public void a_list_should_get_displayed_containing_options_pc_and_mac()  {
	       Assert.assertTrue(hp.pcDsiplayed()); 
	        Assert.assertTrue(hp.macDsiplayed());
	    }

	    @Then("^Desktops page should get displayed to the User$")
	    public void desktops_page_should_get_displayed_to_the_user()  {
	        String title = acts.returnPageTitle();
	        String tit = props.getProperty("Desktops");
	        System.out.println(title);
	        System.out.println(tit);
	        Assert.assertEquals(tit, title);
	    }

	    @Then("^HP laptop page should get displayed$")
	    public void hp_laptop_page_should_get_displayed()  {
	      
	        
	       String tit = props.getProperty("HP_Page");
	       wt.until(ExpectedConditions.titleIs(tit));
	       String title = acts.returnPageTitle();
	       System.out.println(title);
	       System.out.println(tit);
	       
	       Assert.assertEquals(tit, title);
	    }

	    @Then("^User must be able to see a success message$")
	    public void user_must_be_able_to_see_a_success_message() {
	        Assert.assertTrue(hpg.successDisp());
	    }

	    @And("^User must be able to see HP LP3065 laptop$")
	    public void user_must_be_able_to_see_hp_lp3065_laptop() {
	       Assert.assertTrue(dp.hpDisplayed()); 
	    }

	    @And("^User must be able to change the qty and enter qty as ex:2$")
	    public void user_must_be_able_to_change_the_qty_and_enter_qty_as_ex2() throws InterruptedException  {
	       hpg.clearAndEnterQty();
	    }

	    @And("^User must be able to see the qty entered by him in the cart with respecive amount$")
	    public void user_must_be_able_to_see_the_qty_entered_by_him_in_the_cart_with_respecive_amount()  {
	        Assert.assertTrue(hpg.userValdisp());
	    }
	    
	    
	    
// 27-01-2021 @Darshan
	    
	    @Then("^User clicks on the cart button$")
	    public void user_clicks_on_the_cart_button() {
	       hp.clickCart();
	    }

	    @Then("^User Verifies if item is removed correctly$")
	    public void user_verifies_if_item_is_removed_correctly() throws InterruptedException  {
	    	  Thread.sleep(5000);
		       acts.refreshPage();
		       hp.clickCart();
		       boolean status=hp.itemRemoved();
		       System.out.println(status);
	        
	    }

	    @And("^User clicks on Remove Button if any item is available$")
	    public void user_clicks_on_remove_button_if_any_item_is_available() throws InterruptedException  {
	        hp.clickRemove();
	      
	    }

	 // 27-01-2021 @Darshan	
	
	
	
	

}
