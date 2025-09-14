package StepDefinitions;

import org.testng.Assert;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddUserPage;
import pages.AdminPage;
import pages.DashboardPage;

public class AdminSteps {
	
	
  DashboardPage dashboardPage;
  AdminPage adminPage;
  AddUserPage addUserPage;
  int numberOfRecords;
  

  @When("I navigate to the Admin tab")
  public void naviagateToAdminTab() {
      dashboardPage = new DashboardPage(Hooks.driver);
      dashboardPage.clickAdminTab();
      adminPage = new AdminPage(Hooks.driver);

  }

  @And("I get the current number of records")
  public void getNumberOfRecords () {
      numberOfRecords= adminPage.getRecordsCount();
      
  }

  @And("I add a new user with userInput {string} and employeeInput {string} and passwordInput {string}")
  public void addNewUser (String userInput, String employeeInput, String passwordInput) {
	  addUserPage.addUser(userInput, employeeInput, passwordInput);
  }

  @Then("the number of records should increase by 1")
  public void recordsIncreaseByOne() {
	  int newRecordsCount= adminPage.getRecordsCount();
      Assert.assertEquals(newRecordsCount, numberOfRecords + 1); 
  }
  
  @When("I search for the user {string}")
  public void searchForUser(String username) {
	  adminPage.enterUsername(username);
	  
  }
  
  @When("I delete the user {string}")
  public void deleteUser() {
	  adminPage.clickDelete();
	  adminPage.clickConfirmDelete();
	  
  }
  
  @When("the number of records should decrease by 1")
  public void numberOfRecordsIncrease() {
	  adminPage = new AdminPage(Hooks.driver);
	  int recordsAfterDeletion= adminPage.getRecordsCount();
	  Assert.assertEquals(recordsAfterDeletion, numberOfRecords);
	  
  }
  
  

}
