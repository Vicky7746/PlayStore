package frame;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PageObjects extends BasePage{
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement Womens;
	
	@FindBy(xpath= "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	private WebElement Dresses;
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	private WebElement TShirts;
	
	@FindBy (xpath = "//*[@id='newsletter-input']")
	private WebElement Newsletter;
	
	@FindBy (xpath = "//*[@id='newsletter_block_left']//button")
	private WebElement Button;
	
	@FindBy (xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[1]")
	private WebElement Size1;
	
	@FindBy (xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[2]")
	private WebElement Size2;
	
	@FindBy (xpath = "//*[@id='ul_layered_id_attribute_group_1']/li[3]")
	private WebElement Size3;
	
	@FindBy (xpath= "//*[@class='alert alert-danger']")
	private WebElement AlertDanger;
	
	@FindBy (xpath="//*[@class='alert alert-success']")
	private WebElement AlertSuccess;
	
	@FindBy (xpath = "//*[@class='heading-counter']")
	private WebElement SideMsg;
	
	@FindBys (@FindBy (xpath= "//*[@class='product_list grid row']/li"))
	private List<WebElement> Items;
	
	@FindBy (xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
	private WebElement Add;
	
	@FindBy (linkText="Printed Dress")
	private WebElement FirstDress;
	
	@FindBy (xpath = "//*[@class='layer_cart_product col-xs-12 col-md-6']/h2/i")
	private WebElement CartDisplay;
	
	@FindBy (xpath = "//*[@id='social_block']/ul/li")
	private WebElement Followus;
	
	@FindBy (xpath = "//*[@id='short_description_content']/p")
	private WebElement ProductDesc;
	
	public PageObjects() {
		PageFactory.initElements(driver, this);
	}
	public WebElement getWomen() {
		return Womens;
	}
	public WebElement getDress() {
		return Dresses;
	}
	public WebElement getTshirt() {
		return TShirts;
	}
	public String WomenName() {
		Womens.click();
		return driver.getTitle();
	}
	public String DressName() {
		Dresses.click();
		return driver.getTitle();
	}
	public String TshirtName() {
		TShirts.click();
		return driver.getTitle();
	}
	public String getNewsletter() {
		int random=new Random().nextInt(700000);
		String name="bala"+random+"@gmail.com";
		Newsletter.sendKeys(name);
		Button.click();
		return AlertSuccess.getText();
	}
	public WebElement getSize1() {
		Dresses.click();
		return Size1;
	}
	public WebElement getSize2() {
		Dresses.click();
		return Size2;
	}
	public WebElement getSize3() {
		Dresses.click();
		return Size3;
	}
	public int checkCount() {
		return Items.size();
	}
	public int getNumberofCounts() {
		String text=SideMsg.getText();
		String []arr=text.split(" ");
		String number=arr[2];
		int number1 = Integer.parseInt(number);
		return number1;
	}
	public void addtocart() {
		Actions ac=new Actions(driver);
		ac.moveToElement(FirstDress).moveToElement(Add).click().build().perform();
	}
	public void CartDisplayMessage() {	
		System.out.println(CartDisplay.getText());
	}
	public WebElement CheckFollowUs() {
		FirstDress.click();
		return Followus;
	}
	public WebElement checkProductDescription() {
		return ProductDesc;
	}
}
