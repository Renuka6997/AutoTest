package com.app.step;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AppStep {

	WebDriver driver;

	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rebammid\\eclipse-workspace\\Application\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^User is able to access the url of the application$")
	public void user_is_able_to_access_the_url_of_the_application() throws Throwable {
		driver.get("http://automationpractice.com/index.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@When("^User clicks on sign in button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		WebElement a = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a"));
		a.click();
		WebElement em = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input"));
		em.sendKeys("riya@gmail.com");
		WebElement acc = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"));
		acc.click();
	}

	@Then("^User should be able to create an account by entering firstname and lastname$")
	public void user_should_be_able_to_create_an_account_by_entering_firstname_and_lastname(DataTable details)
			throws Throwable {
		List<List<String>> ele = details.raw();
		WebElement f = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input"));
		f.sendKeys(ele.get(0).get(0));
		WebElement l = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input"));
		l.sendKeys(ele.get(0).get(1));
		WebElement p = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[5]/input"));
		p.sendKeys("Renu123");
	}

	@Then("^User should be able to register by adding address$")
	public void user_should_be_able_to_register_by_adding_address() throws Throwable {
		WebElement add = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input"));
		add.sendKeys("345/6, abc street");
		WebElement city = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input"));
		city.sendKeys("visakhapatnam");
		WebElement st = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select"));
		Select s = new Select(st);
		s.selectByValue("1");
		WebElement zip = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input"));
		zip.sendKeys("00000");
		WebElement con = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[9]/div/select"));
		Select o = new Select(con);
		o.selectByValue("21");
		WebElement ph = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[13]/input"));
		ph.sendKeys("9989790345");
		WebElement ref = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input"));
		ref.sendKeys("222/3, amazon street");
		WebElement reg = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span"));
		reg.click();
	}

	@Then("^User should be able to add the product to the cart$")
	public void user_should_be_able_to_add_the_product_to_the_cart() throws Throwable {
		String expect1 = "My account - My Store";
		String actual1 = driver.getTitle();
		if(actual1.equalsIgnoreCase(expect1))
		{
			System.out.println("Account is validated");
		}
		else {
			System.out.println("false");
		}
		WebElement w = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(w).perform();
		WebElement t = driver.findElement(
				By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		t.click();
		WebElement ca = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li"));
		Actions act = new Actions(driver);
		act.moveToElement(ca).perform();
		WebElement c = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/div[2]/a[1]/span"));
		c.click();
	}

	@After
	@Then("^User should be able to purchase the product$")
	public void user_should_be_able_to_purchase_the_product() throws Throwable {
		WebElement pur = driver.findElement(
				By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
		pur.click();
		WebElement pur1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span"));
		pur1.click();
		String expect2 = "Order - My Store";
		String actual2 = driver.getTitle();
		if(actual2.equalsIgnoreCase(expect2))
		{
			System.out.println("Order is validated");
		}
		else {
			System.out.println("false");
		}
		WebElement pur2 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
		pur2.click();
		WebElement pur3 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
		pur3.click();
		WebElement ch = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input"));
		ch.click();
		WebElement pur4 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span"));
		pur4.click();
		WebElement pay = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a"));
		pay.click();
		WebElement conf = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span"));
		conf.click();
		driver.quit();
	}
}
