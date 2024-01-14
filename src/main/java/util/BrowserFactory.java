package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		try {
			Properties prop = new Properties();
			FileReader fileReader = new FileReader("src\\main\\java\\configuration\\config.properties");
			prop.load(fileReader);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static WebDriver init() {
		readConfig();
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else {
				System.out.println("please use a valid browser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
