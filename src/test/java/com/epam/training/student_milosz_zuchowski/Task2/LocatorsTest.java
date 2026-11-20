package com.epam.training.student_milosz_zuchowski.Task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocatorsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.epam.com/");
    }

    @Test
    public void locatorsTest() {
        //1-id
        WebElement accept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", accept);

        //5-LinkText
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Careers"))).click();

        //7-cssSelector
        WebElement startSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pinned-button a[href*='/jobs']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", startSearch);

        //2-name
        WebElement keyword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        keyword.sendKeys("Java");

        //10-xpath
        WebElement searchBtn = wait.until(d ->
                keyword.findElement(By.xpath("./ancestor::form//button[@type='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);

        //9-xpath
        WebElement job = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//a[contains(@href,'/vacancy/')])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", job);

        //4-tag
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        assertTrue(heading.getText().contains("Java") || driver.getPageSource().contains("Java"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
