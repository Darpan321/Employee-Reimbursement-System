package dev.ers.steps;

import dev.ers.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LoginPositiveSteps {
    public WebDriver driver= LoginRunner.driver;
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
    }

    @When("The user types {string} into emailid input")
    public void the_user_types_into_emailid_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys(string);
    }

    @When("The user types {string} into password input")
    public void the_user_types_into_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(string);
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement submit=driver.findElement(By.id("login"));
        submit.click();
    }

    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        if(string=="Employee"){
            assertEquals("Employee Homepage",driver.getTitle());
        }else if(string=="FinancialManager"){
            assertEquals("Manager Homepage",driver.getTitle());
        }
    }

    @Then("The user should see their name {string} on the home page")
    public void the_user_should_see_their_name_on_the_home_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        WebElement message= driver.findElement(By.id("Message"));
        assertEquals("Welcome "+string,message.getText());
    }

    @When("The user types in fam@ers.com into the emailid input")
    public void the_user_types_in_fam_ers_com_into_the_emailid_input() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("fam@ers.com");
    }

    @When("The user types in fam123 into the password input")
    public void the_user_types_in_fam123_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("fam123");
    }
    @Then("The user should see an alert saying they have the wrong password")
    public void the_user_should_see_an_alert_saying_they_have_the_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("password dont match",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    @When("The user types in fam@ers into the emailid input")
    public void the_user_types_in_fam_ers_into_the_emailid_input() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("fam@ers");
    }

    @When("The employee types in fam1 into the password input")
    public void the_employee_types_in_fam1_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("fam1");
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement submit=driver.findElement(By.id("login"));
        submit.click();
    }

    @Then("The employee should see an alert saying no user with that emailid found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_emailid_found() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("User not found",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
}
