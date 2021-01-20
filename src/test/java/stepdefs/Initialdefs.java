package stepdefs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.junit.Assert;

import factory.Driverfactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Initialpage;
import pages.Loginpage;
import utilities.ActionsClass;
import utilities.Excelreader;

public class Initialdefs {
	public static Initialpage ip;
	public static Loginpage lp;
	public static Excelreader eread;
	public Properties prop;
	public HashMap<String, String> hs;
	public ActionsClass acts;
	
	@Before
	public void initial() throws IOException {
		ip= new Initialpage(Driverfactory.returnDriver());
		lp= new Loginpage(Driverfactory.returnDriver());
		acts = new ActionsClass(Driverfactory.returnDriver());
		hs = new HashMap<String,String>();
		prop = Driverfactory.initProps();
	}
	
//	 @Given("^User is on the Initial page$")
//	    public void user_is_on_the_initial_page()  {
//	   
//	      
//	    }
	 
	   @Given("^User is on the Initial page$")
	    public void user_is_on_the_initial_page()  {
		   String title = ip.dispTitle();
		      
		      String tit = prop.getProperty("page_title");
		      
		      Assert.assertEquals(tit, title);
	       
	    }

	    @When("^User clicks on the login option$")
	    public void user_clicks_on_the_login_option() throws InterruptedException  {
	    	
	    	ip.clickLogin();
	    	Thread.sleep(4000);
	      
	    }

	    @Then("^User verifies the title of the page$")
	    public void user_verifies_the_title_of_the_page()  {
	    	
	    	String title = ip.dispTitle();
	    	String tit = prop.getProperty("page_title");
	    	System.out.println(" actual title is "+title);
	    	System.out.println(" expected title is "+tit);
	    	
	    	Assert.assertEquals(tit, title);
	        
	    }

	    @Then("^Two options Register and Logi should get displayed to the user$")
	    public void two_options_register_and_logi_should_get_displayed_to_the_user()  {
	    	
	    	boolean disp = ip.checkULList();
	    	System.out.println("disp status is "+disp);
	       
	    }

	    @Then("^User should landed on the login page$")
	    public void user_should_landed_on_the_login_page()  {
	        String title = ip.dispTitle();
	        String acctitle = prop.getProperty("Account_title");
	        
	        if(title.equals(acctitle)) {
	        	System.out.println("user is on the loginpage");
	        }
	    }

	    @And("^User hovers over the account section and clicks on it$")
	    public void user_hovers_over_the_account_section_and_clicks_on_it() throws InterruptedException {
	    	ip.hoverMouse();
	    	Thread.sleep(10000);
	     
	    }
	    
	    
	    
	    
	    
	    
	    
	    @Given("^User is already on the login page$")
	    public void user_is_already_on_the_login_page()  {
	    	System.out.println("user is on the login page");
	
	    }

	    @When("^User clicks on login button without any credentials$")
	    public void user_clicks_on_login_button_without_any_credentials() throws InterruptedException  {
	    	Thread.sleep(2000);
	   lp.clickSubmit();
	    }

	    @When("^user enters the valid username and password$")
	    public void user_enters_the_valid_username_and_password() throws IOException, InterruptedException {
	      hs= Excelreader.excelRead("E:\\\\ework\\\\tutninja\\\\src\\\\main\\\\java\\\\Excel\\\\testdata.xlsx");
	      lp.enterUsername(hs.get("username"));
	      lp.enterPassword(hs.get("password"));
	      Thread.sleep(4000);
	    }

	    @Then("^A Warning Message should get displayed$")
	    public void a_warning_message_should_get_displayed()  {
	       boolean disp = lp.warnDisp();
	       
	       Assert.assertTrue(disp);
	    }

	    @Then("^User lands on the home page$")
	    public void user_lands_on_the_home_page() throws InterruptedException  {
	     String title = acts.returnPageTitle();
	     String tit = prop.getProperty("home_title");
	     
	     Assert.assertEquals(tit, title);
	     Thread.sleep(2000);
	    }

	    @And("^User clicks on login button$")
	    public void user_clicks_on_login_button() throws InterruptedException  {
	    	Thread.sleep(3000);
	     lp.clickSubmit();
	    }

}
