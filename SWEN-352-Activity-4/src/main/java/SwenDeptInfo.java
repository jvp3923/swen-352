import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwenDeptInfo {
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
        public void testSwenDeptInfo() throws Exception {
            driver.get(baseUrl+"www.rit.edu");
            WebElement cookies = driver.findElement(By.xpath("/html/body/div[3]/section/div[2]"));
            cookies.click();
            WebElement academicsDropDown = driver.findElement(By.xpath("//*[@id=\"main-nav--link--academics\"]"));
            academicsDropDown.click();
            WebElement colleges = driver.findElement(By.xpath("/html/body/div[3]/header[2]/section[3]/nav/div/ul/li[2]/div/div/ul[2]/li[1]/a"));
            colleges.click();
            WebElement golisano = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div[3]/div/div/div/div/div/div/div/div/ul/li[3]/a"));
            golisano.click();
            WebElement contact = driver.findElement(By.xpath("/html/body/div[3]/footer/section[1]/div/section[2]/nav/ul/li[7]/a"));
            contact.click();
            WebElement departmentDropDown = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[1]/p/a/span[3]"));
            departmentDropDown.click();
            WebElement name = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[2]/div/div/article/div/div[2]/div[1]/a"));
            System.out.println(name.getText());
            WebElement email = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[2]/div/div/article/div/div[3]/div[1]/a"));
            System.out.println(email.getText());
            WebElement title = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[2]/div/div/article/div/div[2]/div[2]"));
            System.out.println(title.getText());
            WebElement department = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[2]/div/div/article/div/div[2]/div[3]"));
            System.out.println(department.getText());
            WebElement college = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div[3]/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div[7]/div[2]/div/div/article/div/div[2]/div[4]"));
            System.out.println(college.getText());
            WebElement address = driver.findElement(By.xpath("/html/body/div[3]/footer/section[1]/div/section[1]/div[2]/div/div[1]/p[2]"));
            System.out.println(address.getText());
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
