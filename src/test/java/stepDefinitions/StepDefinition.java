package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import setup.Setup;

public class StepDefinition extends Setup {
    @Given("user visits the portal")
    public void user_visits_the_portal() {
        driver.get("https://www.saucedemo.com/");
    }
    //    @When("user inputs valid username and password")
    //    public void user_inputs_valid_username_and_password() {
    //        LoginPage loginPage=new LoginPage(driver);
    //        loginPage.doLogin("standard_user","secret_sauce");
    //    }
    @When("user inputs valid {string} and {string}")
    public void userInputsValidAnd(String username, String password) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin(username,password);
    }
    @Then("User can see error message")
    public void user_can_see_error_message() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.errorTitle();

    }

    @Then("user  logs into the dashboard")
    public void userLogsIntoTheDashboard() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.assertTitle();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
