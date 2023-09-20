package tests.day_04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;

import java.time.Duration;

public class KiwiCom {

    // uygulamanin yuklendigi dogrulanir
    // uygulamanin basariyla acildigi dogrulanir
    // misafir olarak devam et e tiklanir
    // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    AndroidDriver <AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage kiwiPage = new KiwiPage();

    TouchAction touchAction = new TouchAction<>(driver);
    @Test
    public void kiwiTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(kiwiPage.guest.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.guest.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            touchAction
                    .press(PointOption.point(543,1692))
                    .release()
                    .perform();
        }

        // Trip type,one way olarak secilir
        kiwiPage.returnButton.click();
        kiwiPage.oneWayCheckBox.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        kiwiPage.fromButton.click();

        Thread.sleep(500);
        touchAction
                .press(PointOption.point(1017,136))
                .release()
                .perform();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        kiwiPage.fromToSearchTextBox.click();
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("istanbul");
        }else {
            kiwiPage.fromToSearchTextBox.sendKeys("istanbul");
        }

        Thread.sleep(2000);
        touchAction
                .press(PointOption.point(991,286))
                .release()
                .perform();

        kiwiPage.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwiPage.toButton.click();

        kiwiPage.fromToSearchTextBox.click();
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("diyarbakir");
        }else {
            kiwiPage.fromToSearchTextBox.sendKeys("diyarbakir");
        }

        Thread.sleep(2000);
        touchAction
                .press(PointOption.point(991,286))
                .release()
                .perform();

        kiwiPage.chooseButton.click();

        // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        kiwiPage.departureButton.click();

        Thread.sleep(500);
        for (int i = 0; i < 4; i++) {
            Thread.sleep(500);
            touchAction
                    .press(PointOption.point(499,1355))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(529,187))
                    .release()
                    .perform();
        }



        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    }
}
