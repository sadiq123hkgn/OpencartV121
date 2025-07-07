package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
    @Parameters({ "os", "browser" })
    public void setup(String os, String br, ITestContext context) throws IOException {
        // Load properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        // Remote Execution using Selenium Grid
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            try {
            	URL gridURL = new URL("http://192.168.29.9:4444/wd/hub");

                switch (br.toLowerCase()) {
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setPlatformName(os);
                        driver = new RemoteWebDriver(gridURL, chromeOptions);
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setPlatformName(os);
                        driver = new RemoteWebDriver(gridURL, firefoxOptions);
                        break;
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.setPlatformName(os);
                        driver = new RemoteWebDriver(gridURL, edgeOptions);
                        break;
                    default:
                        System.out.println("Unsupported browser for remote execution.");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Remote WebDriver setup failed: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        // Local Execution
        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid browser name for local execution.");
                    return;
            }
        }

        // Common browser setup
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

        // Make driver available for Listeners
        context.setAttribute("driver", driver);
    }

    @AfterClass(groups = { "Sanity", "Regression", "Master", "DataDriven" })
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Random Data Helpers
    public String randomeString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomeNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomeAlphaNumberic() {
        return randomeString() + "@" + randomeNumber();
    }

    // Screenshot Capture
    public static String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        FileUtils.copyFile(sourceFile, targetFile);

        return targetFilePath;
    }
}
