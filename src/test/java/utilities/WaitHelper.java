package utilities;

import org.openqa.selenium.WebDriver;

public class WaitHelper {
	private WebDriver driver;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
	}

	public int getExplicitTimeout() {
		return Integer.parseInt(ConfigurationReaderHelper.get("explicit.wait"));
	}
}
