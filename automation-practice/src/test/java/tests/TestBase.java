package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    protected PageFactory page;
    protected static String browser;

    @BeforeMethod
    public void setUp() throws IOException {
        System.getProperties().load(new FileReader("src/test/resources/data.properties"));
        browser = System.getProperty("browser");
        initializeDriver(browser);
        page = new PageFactory(driver);
        openApplication();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--ignore-certificate-error");
                chromeOptions.addArguments("--ignore-ssl-errors");
                chromeOptions.addArguments("--allow-running-insecure-content");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
                chromeOptions.addArguments("--disable-extensions");
                //chromeOptions.addArguments("--incognito");
                //chromeOptions.addArguments("--headless=new");
                chromeOptions.setExperimentalOption("useAutomationExtension", false);

                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--ignore-certificate-error");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--ignore-ssl-errors");
                firefoxOptions.addArguments("--allow-running-insecure-content");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--no-sandbox");
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("ignore-certificate-error", true);
                edgeOptions.setCapability("disable-dev-shm-usage", true);
                edgeOptions.setCapability("no-sandbox", true);
                edgeOptions.setCapability("ignore-ssl-errors", true);
                edgeOptions.setCapability("allow-running-insecure-content", true);
                edgeOptions.setCapability("start-maximized", true);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
    }
    private void openApplication() {
        String url = System.getProperty("url");
        driver.manage().window().maximize();
        driver.get(url);
    }
}


