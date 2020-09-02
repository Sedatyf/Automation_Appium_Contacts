import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewContactPage {

	private AndroidDriver<AndroidElement> driver;

	public NewContactPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_first_name")
	MobileElement input_firstName;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_surname")
	MobileElement input_surName;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_number")
	MobileElement input_number;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_email")
	MobileElement input_email;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/save")
	MobileElement btn_save;
}
