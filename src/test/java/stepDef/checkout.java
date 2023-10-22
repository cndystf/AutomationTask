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

public class checkout {
    WebDriver driver;
    String baseUrl = "https:www.saucedemo.com/";

    @Given("user open url from browser")
    public void userOpenUrlFromBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input the valid username")
    public void userInputTheValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input the valid password")
    public void userInputTheValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user tap login")
    public void userTapLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user see the home page")
    public void userSeeTheHomePage() {
        String homepageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(homepageAssert, "Swag Labs");
    }

    @When("user add wanted item to cart")
    public void userAddWantedItemToCart() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Then("user see the number badge in cart icon")
    public void userSeeTheNumberBadgeInCartIcon() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).isDisplayed());
    }

    @When("user click cart icon")
    public void userClickCartIcon() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("user redirected to your cart page")
    public void userRedirectedToYourCartPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("user redirected to checkout information page")
    public void userRedirectedToCheckoutInformationPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @And("user input firstname")
    public void userInputFirstname() {
        driver.findElement(By.id("first-name")).sendKeys("Cindy");
    }

    @And("user input lastname")
    public void userInputLastname() {
        driver.findElement(By.id("last-name")).sendKeys("Steffani");
    }

    @And("user input zip code")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("10210");
    }

    @When("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user redirected to checkout overview page")
    public void userRedirectedToCheckoutOverviewPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @When("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user redirected to checkout complete page")
    public void userRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }
}
