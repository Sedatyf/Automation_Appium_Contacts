import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CreateContactContactsTest {
	// Création du AndroidDriver
	private AndroidDriver<AndroidElement> driver;
	
	@Before
	public void setup() throws MalformedURLException {
		// Paramètres de notre environnement
		DesiredCapabilities dC = new DesiredCapabilities();
		dC.setCapability("plateformName", "Android");
		dC.setCapability("deviceName", "Nexus 5X API 27");
		dC.setCapability("app", "C:/Users/formation/Downloads/Simple_Contacts_v4.5.0_apkpure.com.apk");
		dC.setCapability("appPackage", "com.simplemobiletools.contacts");
		dC.setCapability("appActivity", ".activities.MainActivity");
		
		// Adresse de notre appareil
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		
		// Envoie des paramètres au driver
		driver = new AndroidDriver<AndroidElement>(remoteUrl, dC);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() throws InterruptedException {
		// Suppression du contact fraichement créer pour rejouabilité
		ContactPage contact = new ContactPage(driver);
		contact.btn_moreOptions.click();
		contact.widgetMoreOptions_delete.click();
		contact.askDeleteYes.click();
		Thread.sleep(1000);
		
		// Fermeture de l'application
		driver.quit();
	}
	
	@Test
	public void AddContact() {
		
		// JDD
		String firstname = "Jean-Michel";
		String surname = "Autom";
		String number = "0606060606";
		String mail = "jautom@test.com";
		
		// ****** Test ******
		// Accepter les alertes pour le répertoire et le téléphone
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		// Instanciation de la page d'accueil
		ImageViewPage imageView = new ImageViewPage(driver);
		
		// Ajouter un nouveau contact
		imageView.btn_add.click();
		
			// Instanciation de la page de contact
		NewContactPage newContact = new NewContactPage(driver);
		
			// Envoie des informations du contact
		newContact.input_firstName.click();
		newContact.input_firstName.sendKeys(firstname);
		
		newContact.input_surName.click();
		newContact.input_surName.sendKeys(surname);
		
		newContact.input_number.click();
		newContact.input_number.sendKeys(number);
		
		newContact.input_email.click();
		newContact.input_email.sendKeys(mail);
		
			// Sauvegarde puis retour sur la première page
		newContact.btn_save.click();
		imageView = new ImageViewPage(driver);
		
			// Accéder à la page du contact
		imageView.contact_name.click();
		ContactPage contact = new ContactPage(driver);
		
			// Vérification des jeux de données
		assertEquals(firstname, contact.field_first_name.getText());
		assertEquals(surname, contact.field_surname.getText());
		assertEquals(number, contact.field_number.getText());
		assertEquals(mail, contact.field_mail.getText());
	}
}
