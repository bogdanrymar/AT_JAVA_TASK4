package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    private static final String URL = "https://cloud.google.com/?hl=uk";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public SearchResultsPage search(String query) {
        WebElement searchButton = driver.findElement(By.className("mb2a7b"));

        delay(1);

        searchButton.click();
        searchButton.sendKeys(query);
        searchButton.submit();

        return new SearchResultsPage(driver);
    }
}