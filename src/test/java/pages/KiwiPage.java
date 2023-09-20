package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this); // WebDriver'in api'lerini kullanabilmek için WebDriver'i cast ettik
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement guest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWayCheckBox;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement fromButton;

    @FindBy(className = "android.widget.EditText")
    public WebElement fromToSearchTextBox;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toButton;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement departureButton;

}
