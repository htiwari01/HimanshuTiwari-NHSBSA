package AppHooks;

import org.openqa.selenium.WebDriver;
import com.nhs.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	
	
	@Before()
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();
		
	}
	
	@After()
	public void quitBrowser() {
		driver.quit();
	}

}
