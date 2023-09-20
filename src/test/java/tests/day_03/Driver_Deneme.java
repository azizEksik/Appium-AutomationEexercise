package tests.day_03;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.HashMap;
import java.util.Map;

public class Driver_Deneme {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    @Test
    public void test01(){

        System.out.println(driver.getDeviceTime());

    }

}
