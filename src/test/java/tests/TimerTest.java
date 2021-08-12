package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.*;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.ConfigurationReaderHelper;


public class TimerTest extends BaseTest{

	private String baseUrl = ConfigurationReaderHelper.get("baseURL");
	private String browser = ConfigurationReaderHelper.get("browser");
	public HomePage homePage;

	@BeforeClass
	public void setup(){
		launchBrowser(browser);
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void timerTest10Seconds()
	{
		List<String> actualTimeInstances = new ArrayList<String>();
		List<String> expectedTimeInstances = new ArrayList<String>();
		int seconds = 10;

		// Creating expected data
		for (int i = seconds - 1; i >= 0; i--)
		{
			if(i<=1)
				expectedTimeInstances.add(i + " second");
			else
				expectedTimeInstances.add(i + " seconds");
		}

		driver.get(baseUrl);
		homePage.enterTime(Integer.toString(seconds));
		homePage.startTimer();

		String countDownText = homePage.getCountDownText();

		// Getting actual data
		while (true)
		{
			try {
				countDownText = homePage.getCountDownText();

				if (countDownText != "Time Expired!")
				{
					if (!actualTimeInstances.contains(countDownText))
					{
						actualTimeInstances.add(countDownText);
						// System.out.println("countDownText : "+ countDownText);
					}
				}
			}
			catch (UnhandledAlertException f) {
				homePage.acceptAlert();
				break;
			}
		}

		Assert.assertEquals(expectedTimeInstances, actualTimeInstances);

	}
}
