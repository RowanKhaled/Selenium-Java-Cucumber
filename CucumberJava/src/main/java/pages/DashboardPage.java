package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By adminTab = By.xpath("//span[text()='Admin']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }
}
