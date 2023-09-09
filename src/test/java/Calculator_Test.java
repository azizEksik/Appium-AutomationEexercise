import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Calculator_Test {


    AndroidDriver driver; // Android cihazlar için kullanılması gereken driver
    AppiumDriver appiumDriver; // hem android hem de ios cihazlar için kullanılabilen driver

    @Test
    public void test01() throws MalformedURLException {

        // Kullanici gerekli kurulumlari yapar

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL"); // cihaz ismini belirtmek icin kullandigimiz method
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android"); // isletim sistemini belirttigimiz method
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // isletim sisteminin versiyonunu belirttigimiz method
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // egerki kullandıgımız android sürümü 6 veya üstüyse "UiAutomator2" kullanılır
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\90545\\IdeaProjects\\com.Appium\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk"); // cihazda calistirmak istedigimiz app'in path'ini belirttigimiz method, ciahaza bu uygulamı yükleriz, eger yüklüyse calistiririz

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities); // capabilities'leri cihazımıza göndere bilmek için apiium server host numarasını(EndPoint) belirttigimiz method

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 saniye boyunca verdigimiz görevin calismasi icin bekleyen method

        driver.activateApp("com.google.android.calculator");// uygulamayı dosya pathi capability olarak göndermek yerine bu şekilde de başlatabiliriz
                                                                    // uygulamayı bu şekilde başlatırsak bize uygulamanın bundleId'si lazım. bunu da yükledigimiz apk info app'i ile alıyoruz

        // uygulamanın yüklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator")); // ugulamanın yüklü olup olmadığını söyleyen method

        // uygulamanın acildigini dogrular
        WebElement acButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]"));

        Assert.assertTrue(acButton.isDisplayed());

        // carpma, bolme, toplama, cikarma islemleri yaparak sonuclari dogrular

        WebElement carpmaButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]"));
        WebElement bolmeButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"divide\"]"));
        WebElement toplamaButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
        WebElement cikarmaButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"minus\"]"));

        WebElement sekizButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"8\"]"));
        WebElement sifirButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"0\"]"));
        WebElement ikiButton = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"2\"]"));

        WebElement sonucText = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"No result\"]"));

        String carpmaSonuc = "1600";
        String bolmeSonuc = "4";
        String toplamaSonuc = "100";
        String cikarmaSonuc = "60";

        sekizButton.click();
        sifirButton.click();
        carpmaButton.click();
        ikiButton.click();
        sifirButton.click();

        Assert.assertEquals(sonucText.getText(),carpmaSonuc);

        acButton.click();
        sekizButton.click();
        sifirButton.click();
        bolmeButton.click();
        ikiButton.click();
        sifirButton.click();

        Assert.assertEquals(sonucText.getText(),bolmeSonuc);

        acButton.click();
        sekizButton.click();
        sifirButton.click();
        toplamaButton.click();
        ikiButton.click();
        sifirButton.click();

        Assert.assertEquals(sonucText.getText(),toplamaSonuc);

        acButton.click();
        sekizButton.click();
        sifirButton.click();
        cikarmaButton.click();
        ikiButton.click();
        sifirButton.click();

        Assert.assertEquals(sonucText.getText(),cikarmaSonuc);

        // AC buttonuna tiklayarak ana ekrani temizler

        acButton.click();

        String sonuc= "";

        Assert.assertEquals(sonucText.getText(),sonuc);
    }

}
