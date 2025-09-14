package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

	private By addButton = By.xpath("//button[normalize-space()='Add']");
	private By usernameInputField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
	private By searchButton = By.xpath("//button[normalize-space()='Search']");
	private By deleteButton = By.xpath("//button//i[contains(@class,'bi-trash')]");
    private By confirmDeleteButton = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By recordsCount = By.xpath("//span[@class='oxd-text oxd-text--span']");

	
	public AdminPage(WebDriver driver) {
        this.driver = driver;
    }


	public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }
	
	public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
	
	public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    }
	
	public void clickConfirmDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton)).click();
    }
	
	public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputField)).sendKeys(username);
    }
	
	public int getRecordsCount() {
        String text = driver.findElement(recordsCount).getText();
        return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }



}
