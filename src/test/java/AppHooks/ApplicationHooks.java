package AppHooks;

import org.openqa.selenium.WebDriver;
import com.nhs.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	
	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

}
