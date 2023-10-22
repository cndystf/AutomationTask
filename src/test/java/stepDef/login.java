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

public class login {
    WebDriver driver;
    String baseUrl = "https:www.saucedemo.com/";
    @Given("user open browser")
    public void userOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @And("user open url")
    public void userOpenUrl() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input username")
    public void userInputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password")
    public void userInputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user redirected to homepage")
    public void userRedirectedToHomepage() {
        String homepageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(homepageAssert, "Swag Labs");
    }

    @And("user input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
    }

    @Then("user see error message")
    public void userSeeErrorMessage() {
        String errorAssert = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorAssert, "Epic sadface: Username and password do not match any user in this service");
    }
}
