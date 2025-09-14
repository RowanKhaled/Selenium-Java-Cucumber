package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {
	
	
	WebDriver driver;
    private WebDriverWait wait;
	
	private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By password = By.xpath("//label[text()='Password']/../following-sibling::div//input");
    private By confirmPassword = By.xpath("//label[text()='Confirm Password']/../following-sibling::div//input");
    private By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div//i");
    private By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private By usernameInputField = By.xpath("//label[text()='Username']/../following-sibling::div//input");
    private By adminOption = By.xpath("//div[@role='option']//span[text()='Admin']");
    private By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div//i");
    private By statusOption = By.xpath("//div[@role='listbox']//div[text()='Enabled']");


    public AddUserPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    
    public void addUser(String usernameInput, String employeeNameInput, String passwordInput ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userRoleDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminOption)).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName)).sendKeys(employeeNameInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputField)).sendKeys(usernameInput);
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusOption)).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(passwordInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(passwordInput);
        
        clickSave();
        
    }

}
