package frame1;

import org.testng.Assert;
import org.testng.annotations.Test;

import frame.PageObjects;

public class PageTest {
	PageObjects loginobj;
	//BasePage bp;
	public PageTest() {
		loginobj=new PageObjects();
		//bp=new BasePage();
	}
	
	@Test (priority = 0)
	public void verifyWomen() {
		Assert.assertTrue(loginobj.getWomen().isDisplayed());
	}
	@Test (priority = 1)
	public void verifyDress() {
		Assert.assertTrue(loginobj.getDress().isDisplayed());
	}
	@Test (priority = 2)
	public void verifyTShirt() {
		Assert.assertTrue(loginobj.getTshirt().isDisplayed());
	}
	@Test (priority = 3)
	public void navigateTitle() {
		System.out.println(loginobj.DressName());
		System.out.println(loginobj.WomenName());
		System.out.println(loginobj.TshirtName());
	}
	@Test (enabled = false)
	public void Newsletter() {
		System.out.println(loginobj.getNewsletter());
	}
	@Test (priority = 5)
	public void SizeDisplay() {
		Assert.assertTrue(loginobj.getSize1().isDisplayed());
		System.out.println(loginobj.getSize1().getText());
		Assert.assertTrue(loginobj.getSize2().isDisplayed());
		System.out.println(loginobj.getSize2().getText());
		Assert.assertTrue(loginobj.getSize3().isDisplayed());
		System.out.println(loginobj.getSize3().getText());
	}
	@Test (priority = 6)
	public void checkCounts() {
		Assert.assertEquals(loginobj.checkCount(), loginobj.getNumberofCounts());
		System.out.println(loginobj.checkCount());
		System.out.println(loginobj.getNumberofCounts());
	}
	@Test (priority = 7)
	public void Cart() {
		loginobj.addtocart();
		System.out.println("Item added to Cart Successfully");
	}
	@Test (priority= 8)
	public void getFollowUs() {
		Assert.assertTrue(loginobj.CheckFollowUs().isDisplayed());
	}
	@Test (priority = 9)
	public void getProductDescription() {
		Assert.assertTrue(loginobj.checkProductDescription().isDisplayed());
		System.out.println(loginobj.checkProductDescription().getText());
	}
}
