package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class addToCart {
    WebDriver driver;
    String baseUrl = "https:www.saucedemo.com/";

    @Given("user open browser and url")
    public void userOpenBrowserAndUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input a valid username")
    public void userInputAValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input a valid password")
    public void userInputAValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user login")
    public void userLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user redirected to home page")
    public void userRedirectedToHomePage() {
        String homepageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(homepageAssert, "Swag Labs");
    }

    @When("user add desired item to cart")
    public void userAddDesiredItemToCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Then("user see number badge in cart icon")
    public void userSeeNumberBadgeInCartIcon() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).isDisplayed());
    }
}
