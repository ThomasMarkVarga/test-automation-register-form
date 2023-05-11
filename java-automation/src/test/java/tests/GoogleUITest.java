package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleUITest {
    WebDriver driver;
    String url;
    String browser;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void SearchOnGoogleTest(){
        driver = new ChromeDriver();
        driver.get("http://google.com");

        WebElement acceptCookieButton = driver.findElement(By.id("L2AGLb"));
        acceptCookieButton.click();

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Atelierul Digital");
        searchInput.sendKeys(Keys.ENTER);
    }

}
