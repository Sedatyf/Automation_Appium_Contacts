import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ContactPage extends MenuPage {
	private AndroidDriver<AndroidElement> driver;

	public ContactPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_first_name")
	MobileElement field_first_name;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_surname")
	MobileElement field_surname;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_number")
	MobileElement field_number;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_email")
	MobileElement field_mail;
}
