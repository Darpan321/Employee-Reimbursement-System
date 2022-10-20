package dev.ers.steps;

import dev.ers.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeReimbursementSteps {
    public WebDriver driver= LoginRunner.driver;
    @Given("The employee is on the reimbursement page")
    public void the_employee_is_on_the_reimbursement_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("dp@gmail.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("dp12345");
        WebElement login=driver.findElement(By.id("login"));
        login.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Employee Homepage",driver.getTitle());
        WebElement link2=driver.findElement(By.xpath("/html/body/nav[1]/ul/li[2]/a"));
        link2.click();
    }

    @When("The employee presses on view")
    public void the_employee_presses_on_view() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/table/tr[1]/td[6]/button")));
        WebElement view=driver.findElement(By.xpath("/html/body/div[1]/div/table/tr[1]/td[6]/button"));
        view.click();
    }

    @Then("employee should be redirected to Manager View Reimbursement page")
    public void employee_should_be_redirected_to_manager_view_reimbursement_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleIs("Employee View Reimbursement"));

        assertEquals("Employee View Reimbursement",driver.getTitle());
    }

    @Then("employee should see reimbursement details")
    public void employee_should_see_reimbursement_details() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reasonvalue")));
    }

    @When("The employee clicks the browser back button")
    public void the_employee_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().back();
    }

    @Then("The employee should be on the home page and the title of page is Employee Reimbursement")
    public void the_employee_should_be_on_the_home_page_and_the_title_of_page_is_employee_reimbursement() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("dp@gmail.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("dp12345");
        WebElement login=driver.findElement(By.id("login"));
        login.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Employee Homepage",driver.getTitle());
    }

    @When("The employee presses on submit request")
    public void the_employee_presses_on_submit_request() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addreimbursement")));
        WebElement button=driver.findElement(By.id("addreimbursement"));
        button.click();
    }

    @Then("employee should be redirected to Employee Reimbursement page")
    public void employee_should_be_redirected_to_employee_reimbursement_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleIs("Employee Reimbursement"));

        assertEquals("Employee Reimbursement",driver.getTitle());
    }

    @Then("employee types in {string} into the date")
    public void employee_types_in_into_the_date(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("input")));
        WebElement date=driver.findElement(By.id("date"));
        date.sendKeys(string);
    }

    @Then("employee types in {string} into the time")
    public void employee_types_in_into_the_time(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement time=driver.findElement(By.id("time"));
        time.sendKeys(string);
    }

    @Then("employee types in {string} into the location")
    public void employee_types_in_into_the_location(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement location=driver.findElement(By.id("location"));
        location.sendKeys(string);
    }

    @Then("employee types in {string} into the description")
    public void employee_types_in_into_the_description(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement description=driver.findElement(By.id("description"));
        description.sendKeys(string);
    }

    @Then("employee types in {string} into the cost")
    public void employee_types_in_into_the_cost(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement cost=driver.findElement(By.id("cost"));
        cost.sendKeys(string);
    }

    @Then("employee types in {string} into the grading format")
    public void employee_types_in_into_the_grading_format(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement gradingformat=driver.findElement(By.id("gradingformat"));
        gradingformat.sendKeys(string);
    }

    @Then("employee selects {string} for event type from drop down")
    public void employee_selects_for_event_type_from_drop_down(String string) {
        // Write code here that turns the phrase above into concrete actions
//        Select event=new Select(driver.findElement(By.id("event")));
//        event.selectByValue(string);
    }

    @Then("employee types in {string} into the justification")
    public void employee_types_in_into_the_justification(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement justification=driver.findElement(By.id("justification"));
        justification.sendKeys(string);
    }

    @Then("employee clicks on submit")
    public void employee_clicks_on_submit() {
        // Write code here that turns the phrase above into concrete actions
        WebElement submit=driver.findElement(By.id("submit"));
        submit.click();
    }

    @Then("A alert should appear")
    public void a_alert_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @When("The employee presses on update")
    public void the_employee_presses_on_update() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"reimbursementdataemployee\"]/tr[3]/td[7]/button")));
        WebElement update=driver.findElement(By.xpath("//*[@id=\"reimbursementdataemployee\"]/tr[3]/td[7]/button"));
        update.click();
    }

    @Then("employee should see all details inputted")
    public void employee_should_see_all_details_inputted() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
    }
    @Then("The employee views reimbursement amount")
    public void the_employee_views_reimbursement_amount() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        WebElement emailid=driver.findElement(By.id("email"));
        emailid.sendKeys("dp@gmail.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("dp12345");
        WebElement login=driver.findElement(By.id("login"));
        login.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("Message")));
        assertEquals("Employee Homepage",driver.getTitle());
        WebElement link2=driver.findElement(By.xpath("/html/body/nav[1]/ul/li[2]/a"));
        link2.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("reimbursementamount")));
        WebElement view=driver.findElement(By.id("reimbursementamount"));
        view.getText();
    }


}
