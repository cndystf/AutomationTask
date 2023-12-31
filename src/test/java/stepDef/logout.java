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

public class logout {
    WebDriver driver;
    String baseUrl = "https:www.saucedemo.com/";

    @Given("user open url via browser")
    public void userOpenUrlViaBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user click login")
    public void userClickLogin() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user redirected to homepage and menu")
    public void userRedirectedToHomepageAndMenu() {
        String homepageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(homepageAssert, "Swag Labs");
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).isDisplayed();
    }

    @When("user click menu button")
    public void userClickMenuButton() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @And("user click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user back to login page")
    public void userBackToLoginPage() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }
}
