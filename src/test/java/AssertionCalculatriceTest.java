import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AssertionCalculatriceTest {
	private AndroidDriver<AndroidElement> driver;

	@Before
	public void setup() throws MalformedURLException {
		DesiredCapabilities dC = new DesiredCapabilities();
		dC.setCapability("platformName", "Android");
		dC.setCapability("deviceName", "Nexus 5X API 27");
		dC.setCapability("app", "C:/Users/formation/Downloads/Simple_Contacts_v4.5.0_apkpure.com.apk");
		dC.setCapability("appPackage", "com.android.calculator2");
		dC.setCapability("appActivity", ".Calculator");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<AndroidElement>(remoteUrl, dC);
	}

	@Test
	public void testCalc() {
		
		// Instanciation de la page
		CalculatorPage calc = new CalculatorPage(driver);
		
		// Multiplication 4 x 3
		calc.btn_digit4.click();
		calc.btn_mult.click();
		calc.btn_digit3.click();
		calc.btn_equals.click();
		
		// Vérification du résultat
		assertEquals("12", calc.field_result.getText());
	}
}
