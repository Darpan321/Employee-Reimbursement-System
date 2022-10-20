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

public class ManagerReimbursementSteps {
    public WebDriver driver= LoginRunner.driver;

    @Given("The financialmanager is on the reimbursement page")
    public void the_financialmanager_is_on_the_reimbursement_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("fam@ers.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("fam12345");
        WebElement login=driver.findElement(By.id("login"));
        login.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Manager Homepage",driver.getTitle());
        WebElement link2=driver.findElement(By.xpath("/html/body/nav[2]/ul/li[2]/a"));
        link2.click();
    }

    @When("The financialmanager presses on view")
    public void the_financialmanager_presses_on_view() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/table/tr[1]/td[6]/button")));
        WebElement view=driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tr[1]/td[6]/button"));
        view.click();
    }

    @Then("financialmanager should be redirected to Manager View Reimbursement page")
    public void financialmanager_should_be_redirected_to_manager_view_reimbursement_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleIs("Manager View Reimbursement"));

        assertEquals("Manager View Reimbursement",driver.getTitle());
    }

    @Then("financialmanager should see reimbursement details")
    public void financialmanager_should_see_reimbursement_details() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reasonvalue")));
    }

    @When("The financialmanager presses the browser back button")
    public void the_financialmanager_presses_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().back();
    }

    @Then("The financialmanager should be on the home page and the title of page is Manager Reimbursement")
    public void the_financialmanager_should_be_on_the_home_page_and_the_title_of_page_is_manager_reimbursement() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("fam@ers.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("fam12345");
        WebElement login=driver.findElement(By.id("login"));
        login.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Manager Homepage",driver.getTitle());
    }

    @Then("financialmanager presses on Approve")
    public void financialmanager_presses_on_approve() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("approve")));
        WebElement approve=driver.findElement(By.id("approve"));
        approve.click();
    }

    @Then("financialmanager enters a reason to approve")
    public void financialmanager_enters_a_reason_to_approve() {
        // Write code here that turns the phrase above into concrete actions
        WebElement reason=driver.findElement(By.id("reason"));
        reason.sendKeys("No reason");
    }

    @Then("financialmanager presses on Update")
    public void financialmanager_presses_on_update() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
    }

    @Then("financialmanager presses on Reject")
    public void financialmanager_presses_on_reject() {
        // Write code here that turns the phrase above into concrete actions
        WebElement reject=driver.findElement(By.id("reject"));
        reject.click();
    }

    @Then("financialmanager enters a reason to reject")
    public void financialmanager_enters_a_reason_to_reject() {
        // Write code here that turns the phrase above into concrete actions
        WebElement reason=driver.findElement(By.id("reason"));
        reason.sendKeys("No reason");
    }

}
