package StepDef;

import Helper.Config;
import Helper.Utils;
import Pages.DellHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DellHomeStepDef {
	
	
	@Given("admin is on homepage")
	public void admin_is_on_homepage() throws Exception {
		Config.confChrome();
		Config.maximizeWindow();
		
		Config.driver.get(Utils.getproprety("Web_Portal_Link"));
	    
		
	}

	@When("admin mousehover on menu {string} and submenu {string}")
	public void admin_mousehover_on_menu_and_submenu(String menutitle, String submenutitle) throws Exception {
		DellHome page = new DellHome();
	page.mousehoverOnMenuByName(menutitle, submenutitle);	
	  
	}

	@When("admin click on product {string}")
	public void admin_click_on_product(String producttitle) {
		DellHome page = new DellHome();
		page.clickOnProduit(producttitle);
	  
	}

	@Then("admin is directed to the page {string}")
	public void admin_is_directed_to_the_page(String producttitle) {
		DellHome page = new DellHome();
		page.verifProduct(producttitle);
	 
	}


}
