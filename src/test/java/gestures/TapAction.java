package gestures;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
//import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TapAction {
    @Test
    public void tapTest() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setCapability("deviceName", "AppiumP");
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", apkFile.getAbsolutePath());

        URL serverUrl = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver =new AndroidDriver(serverUrl, caps);

        WebElement  viewsButton =
                driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        WebElement expandableListsButton =
                driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableListsButton))).perform();

        WebElement elementByAccessibility =
                driver.findElementByAccessibilityId("1. Custom Adapter");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(elementByAccessibility))).perform();

        WebElement peopleNames = driver.findElement(By.xpath("//*[@text='People Names']"));
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(peopleNames))
                .withDuration(Duration.ofSeconds(2)))
                .perform();
    }
    @Test
    public void scrollTest() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumP");
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setPlatform(Platform.ANDROID);

        URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);

        WebElement  viewsButton =
                driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(viewsButton))).perform();

       // WebElement tabButton = driver.findElementByAccessibilityId("Tabs");

       WebElement tabsButton =
               driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"))");

    }
    @Test
    public void dateTest() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumP");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        caps.setPlatform(Platform.ANDROID);

        URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);

        WebElement  viewsButton =
                driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions()
                .withElement(ElementOption.element(viewsButton))).perform();

        WebElement dateWedge = driver.findElementByAccessibilityId("Date Widgets");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(dateWedge))).perform();

        WebElement inline = driver.findElementByAccessibilityId("2. Inline");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(inline))).perform();






    }

}
