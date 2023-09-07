import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Calculator_Test {


    AndroidDriver driver; // Android cihazlar için kullanılması gereken driver
    AppiumDriver appiumDriver; // hem android hem de ios cihazlar için kullanılabilen driver

    @Test
    public void test01() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL"); // cihaz ismini belirtmek icin kullandigimiz method
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android"); // isletim sistemini belirttigimiz method
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // isletim sisteminin versiyonunu belirttigimiz method
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // egerki kullandıgımız android sürümü 6 veya üstüyse "UiAutomator2" kullanılır
        capabilities.setCapability(MobileCapabilityType.APP,
                "C:\\Users\\90545\\IdeaProjects\\com.Appium\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk"); // cihazda calistirmak istedigimiz app'in path'ini belirttigimiz method

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities); // capabilities'leri cihazımıza göndere bilmek için apiium server host numarasını(EndPoint) belirttigimiz method

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 saniye boyunca verdigimiz görevin calismasi icin bekleyen method


    }

}
