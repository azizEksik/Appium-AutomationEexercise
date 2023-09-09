import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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


    AndroidDriver driver;

    @BeforeTest
    public void arabamTestSetUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam"); // hangi uygulama üzerinde calismak istiyorsak apk infodan o ouygulamanın bundleıd sini alıyoruz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity"); // uygulamayı actıktan sonra hangi sayfadan baslayacagımızı orn; anasayfa, profil .. vb. sonunda bışluk veya tire varsa silinir ham hali alınır/ info app ten Activities kısmından alıyoruz

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void arabamTest(){
        // Uygulamanın başarılı bir şeilkde yüklendigi dogrulanır
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));// her testte yapacagız(test başında)
        // Uygulamanın başarılı bir şekilde açıldıgı dorulanır
        Assert.assertTrue(driver.findElement(By.id("com.dogan.arabam:id/ivArabamLogo")).isDisplayed()); // bunu da her testte yapmalıyız(test başında)


        // Arabam kac para bolumune tıklayalım

        WebElement arabamKacParaLink = driver.findElement(By.xpath("//*[@text='Arabam kaç para?']")); // text üzerinden xpath aldık

        arabamKacParaLink.click();

        // Aracın fiyatını merak ediyorum bölümüne tıklayalım

        WebElement araciminFiyatiniMerakEdiyorumLink = driver.findElement(By.xpath("(//*[@resource-id='com.dogan.arabam:id/tvTitle'])[4]"));

        araciminFiyatiniMerakEdiyorumLink.click();

        // Wolkswagen markasini secelim



        // yil secimi yapalım

    }

}
