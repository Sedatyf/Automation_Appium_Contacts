import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public abstract class MenuPage {
	private AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/fragment_fab")
	MobileElement btn_add;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"More options\"]")
	MobileElement btn_moreOptions;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]")
	MobileElement widgetMoreOptions_delete;
	
	@AndroidFindBy(id="android:id/button1")
	MobileElement askDeleteYes;
}