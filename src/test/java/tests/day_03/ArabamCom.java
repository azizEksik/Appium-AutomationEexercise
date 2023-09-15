package tests.day_03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamCom {

    // Arabam kac para bolumune tıklayalım
    // Aracın fiyatını merak ediyorum bölümüne tıklayalım
    // Wolkswagen markasini secelim
    // yil secimi yapalım
    // model secimi yapalım
    // gövde tipini secelim
    // yakit tipini secelim
    // vites tipini secelim
    // Version secimi yapalım
    // aracin km bilgilerini girelim
    // aracin rengini secelim
    // opsiyonel donanım(varsa) secelim
    // degisen bilgisi ekleyerek tramer kaydı belirtelim
    // aracımızın fiyatının 500.000 tl den fazla oldugunu test edelim
    // uygulamayı kapatalım


    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void arabamTestSetUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam"); // hangi uygulama üzerinde calismak istiyorsak apk infodan o ouygulamanın bundleıd sini alıyoruz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity"); // uygulamayı actıktan sonra hangi sayfadan baslayacagımızı orn; anasayfa, profil .. vb. sonunda bışluk veya tire varsa silinir ham hali alınır/ info app ten Activities kısmından alıyoruz

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest() throws InterruptedException {
        // Uygulamanın başarılı bir şeilkde yüklendigi dogrulanır
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));// her testte yapacagız(test başında)
        // Uygulamanın başarılı bir şekilde açıldıgı dorulanır
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed()); // bunu da her testte yapmalıyız(test başında)


        // Arabam kac para bolumune tıklayalım

        AndroidElement arabamKacParaLink = driver.findElementByXPath("//*[@text='Arabam kaç para?']"); // text üzerinden xpath aldık

        arabamKacParaLink.click();

        // Aracın fiyatını merak ediyorum bölümüne tıklayalım

        AndroidElement araciminFiyatiniMerakEdiyorumLink = driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvTitle'])[4]");

        araciminFiyatiniMerakEdiyorumLink.click();

        // Wolkswagen markasini secelim
        TouchAction touchAction = new TouchAction<>(driver); // cihaz üzerinde parmak haraketleri yapmamızı saglayan obje

        touchAction
                .press(PointOption.point(540,1733))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
                .moveTo(PointOption.point(540,701))
                .release()
                .perform();


        /*
            press() methodu ile parmagımızı basmamız gereken yerin kordinatlarını giriyoruz

            waitAction() methodu ile yapacagımız kaydırma isleminin kaç milisaniyede gerçekleşeceğini belirtiyoruz, süreyi kısaltırsak sayfa daha hızlı kayar

            moveTo() methodu ile parmagımızı kaydıracağımız yerin kordinatlarını giriyoruz

            release() methodu ile parmagımızı kaldırıyoruz

            perform() methodu ile bu islemi gerçekleştir diyoruz

            not : yukarı kaydırmak icin x ve ye kordinat degerlerinin yerlerini degistirmemiz yeterli

         */

        AndroidElement volksWagenButton = driver.findElementByXPath("//*[@index='41']");

        volksWagenButton.click();

        // yil secimi yapalım

        AndroidElement yil = driver.findElementByXPath("//*[@text='2018']");

        yil.click();

        // model secimi yapalım
        AndroidElement model = driver.findElementByXPath("//*[@text='Passat']");

        model.click();

        // gövde tipini secelim
        AndroidElement govdeTipi = driver.findElementByXPath("//*[@text='Sedan']");

        govdeTipi.click();

        // yakit tipini secelim
        AndroidElement yakitTipi = driver.findElementByXPath("//*[@text='Benzin']");

        yakitTipi.click();

        // vites tipini secelim
        AndroidElement vitesTipi = driver.findElementByXPath("//*[@text='Düz']");

        vitesTipi.click();

        // Version secimi yapalım
        Thread.sleep(1000);
        touchAction
                .press(PointOption.point(929,617))
                .release()
                .perform(); // birinci versiyonun kordinatlarına bir kere bas

        /*
            Kordinatlar üzerinden de tıklama islemi yapabiliriz
         */

        // aracin km bilgilerini girelim
        if (driver.isKeyboardShown()){
            //  Eger keyboard gözüküyorsa
            driver.getKeyboard().pressKey("50000"); // klavyeyi kullanarak 50000 yaz
        }else {
            // keyboard gözükmükyorsa
            AndroidElement kmTextBox = driver.findElementByXPath("//*[@class='android.widget.EditText']");

            kmTextBox.sendKeys("50000");
        }

        touchAction
                .press(PointOption.point(536,753))
                .release()
                .perform(); // devam buttonunun oldugu kordinata bir kere bas

        // aracin rengini secelim
        try {
            touchAction
                    .press(PointOption.point(536,1736))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(543,716))
                    .release()
                    .perform();

            driver.findElementByXPath("//*[@text='Siyah']").click(); // siyah buttonuna bas
        }catch (Exception e){

            AndroidElement colorTextBox = driver.findElementById("com.dogan.arabam:id/et_brand");
            colorTextBox.sendKeys("Siyah");

            driver.findElementByXPath("(//*[@text='Siyah'])[2]").click(); // siyah buttonuna tıkla

        }
        // opsiyonel donanım(varsa) secelim
        driver.findElementByXPath("//*[@text='Navigasyon']").click(); // navigasyon buttonuna tıkla

        driver.findElementById("com.dogan.arabam:id/btnNext").click(); // devam buttonuna tıkla

        // degisen bilgisi ekleyerek tramer kaydı belirtelim
        driver.findElementById("com.dogan.arabam:id/iv_B0901").click(); // sag ön camurluga tıkla
        driver.findElementByXPath("(//*[@text='Değişmiş'])[2]").click(); // degismis secenegine tıkla
        driver.findElementById("com.dogan.arabam:id/btn_next").click(); // devam buttonuna tıkla
        driver.findElementById("com.dogan.arabam:id/rbHasTramerEntry").click(); // tramer kaydı var secenegine tıkla

        if (driver.isKeyboardShown()){
            // eger klavye gözüküyorsa
            driver.getKeyboard().pressKey("10000"); // klavyeden tramer kaydı fiyatı gir
        }else {
            // klavye gözükmüyorsa
            driver.findElementById("com.dogan.arabam:id/etPriceValue").sendKeys("10000"); // textBoxtan tramer fiyatı gir
        }

        driver.findElementById("com.dogan.arabam:id/btnNext").click(); // devam buttonuna tıkla

        // aracımızın fiyatının 500.000 tl den fazla oldugunu test edelim
        AndroidElement aracFiyati = driver.findElementById("com.dogan.arabam:id/tvAveragePrice");

        String actualPrice = aracFiyati.getText().replaceAll("[^0-9]",""); // rakam olmayan her şeyi yok et

        Assert.assertTrue(Integer.parseInt(actualPrice) > 500000);

        // uygulamayı kapatalım

        driver.quit();

    }

}
