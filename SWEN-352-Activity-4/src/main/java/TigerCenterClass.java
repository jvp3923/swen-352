import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

class TigerCenterClass {
    private WebDriver driver;

    private String baseUrl;

    @BeforeEach
    void setUp() throws Exception {
        Browser browser = Browser.FIREFOX; // Can be changed to Browser.CHROME
        driver = browser.setUpDriver();
        baseUrl = "https://"; // TARGET URL
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        //driver.quit();
    }

    @Test
    public void testClassSearchButton() throws Exception {
        driver.get(baseUrl+"tigercenter.rit.edu/tigerCenterApp/landing");
        WebElement classButton = driver.findElement(By.xpath("//*[@id=\"angularApp\"]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/landing-page/div/div/div/div/div[4]/a[1]"));
        assertEquals("Class Search", classButton.getText());
        classButton.click();
        Select semester = new Select(driver.findElement(By.className("bigTermPickerWidthFix")));
        semester.selectByVisibleText("2023-24 Fall (2231)");
        WebElement course = driver.findElement(By.className("completer-input"));
        course.clear();
        course.sendKeys("SWEN 352");
        WebElement searchButton = driver.findElement(By.className("classSearchSearchButton"));
        searchButton.click();
        WebElement className = driver.findElement(By.className("classSearchResultsDisplayName"));
        System.out.println(className.getText());
        WebElement days = driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/div[4]/div[5]/app-class-search-row/div/div[1]/div/div[7]/div[1]/div/span[1]"));
        System.out.println(days.getText());
        WebElement location = driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/div[4]/div[5]/app-class-search-row/div/div[1]/div/div[8]/div/div[1]/div/a/p"));
        System.out.println(location.getText());
        WebElement professor = driver.findElement(By.xpath("/html/body/div[1]/app-root/div[2]/mat-sidenav-container[2]/mat-sidenav-content/div[2]/class-search/div/div[2]/div[4]/div[5]/app-class-search-row/div/div[1]/div/div[9]/div/div/div/a/p"));
        System.out.println(professor.getText());
    }

    private enum Browser {
        CHROME("webdriver.chrome.driver",
                "chromedriver",
                ChromeDriver::new),
        FIREFOX("webdriver.gecko.driver",
                "/Users/dylanmorton/IdeaProjects/SWEN-352-Activity-4/drivers/geckodriver",
                FirefoxDriver::new);

        private final String driverPropertyKey;
        private final String driverBaseName;
        private final Supplier<WebDriver> webDriverSupplier;

        Browser(String driverPropertyKey,
                String driverBaseName,
                Supplier<WebDriver> webDriverSupplier) {
            this.driverPropertyKey = driverPropertyKey;
            this.driverBaseName = driverBaseName;
            this.webDriverSupplier = webDriverSupplier;
        }

        private WebDriver setUpDriver() {
            String driverName = this.driverBaseName;
            if (System.getProperty("os.name").startsWith("Windows")) {
                driverName += ".exe";
            }
            System.setProperty(this.driverPropertyKey, driverName);
            return this.webDriverSupplier.get();
        }
    }
}
