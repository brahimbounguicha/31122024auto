package Pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class DellHome {
	
	@FindBy(xpath="/html/body/div[4]/header/section/header/div[2]/div[2]/nav/ul/li/button/span")
	List<WebElement> menus; 
	
	@FindBy(xpath="/html/body/div[4]/header/section/header/div[2]/div[2]/nav/ul/li[3]/ul/li/button")
	List<WebElement> submenus;
	
	@FindBy(xpath="/html/body/div[4]/header/section/header/div[2]/div[2]/nav/ul/li[3]/ul/li[3]/ul/li/a")
	List<WebElement> ProduitList;
	
	@FindBy(xpath="/html/body/main/div[2]/div[1]/section/div[2]/div/div/h1")
	WebElement verifPage;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/a[1]")
	WebElement acceptko;
	
	
	@FindBy(xpath="/html/body/div[4]/header/section/header/div[1]/div[2]/div[2]/div/a/span")
	WebElement switche;
	
	
	public DellHome() {
		PageFactory.initElements(Config.driver, this);
	}
	
	
	public void mousehoverOnMenuByName(String menuname,String subMenuName) throws Exception {
		Thread.sleep(5000);
		
		acceptko.click();
		
		WebDriverWait wait = new WebDriverWait(Config.driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(switche));
		
		
		Config.attente(10);
		try {
		for(WebElement menu:menus) {
			System.out.println(menu.getText());
			System.out.println("testmenu");
			if(menu.getText().contains(menuname)) {
				Actions actions = new Actions(Config.driver);
				actions.moveToElement(menu).perform();
				
				
				Config.attente(10);
				try {
				for(WebElement submenu:submenus) {
					System.out.println("test1");
					System.out.println(submenu.getText());
					if(submenu.getText().contains(subMenuName)) {
						
						actions.moveToElement(submenu).perform();
					}
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void clickOnProduit(String produitName) {
		Config.attente(10);
		try {
		for(WebElement produit:ProduitList) {
			if(produit.getText().contains(produitName)) {
				produit.click();
			}
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void verifProduct(String produitName) {
		
		Assert.assertEquals(produitName, verifPage.getText());
		
		
		
	}

}
