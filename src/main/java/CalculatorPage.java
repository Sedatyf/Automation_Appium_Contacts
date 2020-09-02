import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorPage {

	private AndroidDriver<AndroidElement> driver;

	public CalculatorPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.android.calculator2:id/digit_3")
	MobileElement btn_digit3;
	
	@AndroidFindBy(id="com.android.calculator2:id/digit_4")
	MobileElement btn_digit4;
	
	@AndroidFindBy(id="com.android.calculator2:id/op_mul")
	MobileElement btn_mult;
	
	@AndroidFindBy(id="com.android.calculator2:id/eq")
	MobileElement btn_equals;
	
	@AndroidFindBy(id="com.android.calculator2:id/result")
	MobileElement field_result;
}
