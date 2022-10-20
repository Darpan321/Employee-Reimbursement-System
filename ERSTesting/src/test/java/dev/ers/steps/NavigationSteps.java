package dev.ers.steps;

import dev.ers.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class NavigationSteps {
    public WebDriver driver= LoginRunner.driver;

    @Given("The financialmanager is logged in as a financialmanager")
    public void the_financialmanager_is_logged_in_as_a_financialmanager() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("fam@ers.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("fam12345");
        WebElement submit=driver.findElement(By.id("login"));
        submit.click();
    }

    @Given("The financialmanager is on the home page")
    public void the_financialmanager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Manager Homepage",driver.getTitle());
    }

    @Then("The financialmanager should see links for Home, Reimbursement and Logout")
    public void the_financialmanager_should_see_links_for_home_reimbursement_and_logout() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link1=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[1]/a"));
        WebElement link2=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[2]/a"));
        WebElement link3=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[3]/a"));
        assertEquals("Home",link1.getText());
        assertEquals("Reimbursement",link2.getText());
        assertEquals("Logout",link3.getText());

    }

    @When("The financialmanager clicks on Reimbursement")
    public void the_financialmanager_clicks_on_reimbursement() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link2=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[2]/a"));
        link2.click();
    }

    @Then("The title of the page should be Manager Reimbursement")
    public void the_title_of_the_page_should_be_manager_reimbursement() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reimbursementdata")));
        assertEquals("Manager Reimbursement",driver.getTitle());
    }

    @When("The financialmanager clicks the browser back button")
    public void the_financialmanager_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().back();
    }

    @Then("The financialmanager should be on the home page and the title of page is Manager Homepage")
    public void the_financialmanager_should_be_on_the_home_page_and_the_title_of_page_is_manager_homepage() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Manager Homepage",driver.getTitle());
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String string) {
        // Write code here that turns the phrase above into concrete actions
       if(string.equals("Home")){
           WebElement link1=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[1]/a"));
           link1.click();
           driver.getTitle();

       }else if(string.equals("Reimbursement")){
           WebElement link2=driver.findElement(By.xpath("//*[@id=\"ManagerNavbar\"]/ul/li[2]/a"));
           link2.click();
           driver.getTitle();
       }
    }

    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.titleIs(string));

        assertEquals(string,driver.getTitle());
    }
}
