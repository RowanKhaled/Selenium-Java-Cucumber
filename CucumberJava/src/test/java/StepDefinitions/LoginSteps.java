package StepDefinitions;

import base.Hooks;
import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("browser is open")
    public void openBrowser() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.openLoginPage();
    }

    @When("I enter valid username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on login")
    public void clickingOnLogin() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void dashboardOpens() {
        dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.clickAdminTab();
    }
}
