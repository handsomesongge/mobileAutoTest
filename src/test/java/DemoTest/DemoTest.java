package DemoTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class DemoTest {

//    private AppiumDriver driver;

    @Test
    public void setParam() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");//设置平台
        capabilities.setCapability("deviceName","emulator-5554");//指定测试机的ID，即虚拟机的名字通过adb devices 获取
        capabilities.setCapability("platformVersion","10.0");//平台版本，Android操作系统版本
        capabilities.setCapability("appPackage","com.google.android.youtube");//App的包名
        capabilities.setCapability("appActivity","com.google.android.apps.youtube.app.WatchWhileActivity");//打开App后到的页面
        capabilities.setCapability("noReset",true);//是否重置：true为不重置
        //下面三个一般不用设置
        capabilities.setCapability("unicodeKeyboard",true);//屏蔽手机上的软键盘
        capabilities.setCapability("resetKeyboard",true);//屏蔽上的软键盘
        capabilities.setCapability("automationName","UiAutomator2");//设置自动化工具，验证Toast 吐司信息出现
        //创建一个android 驱动，通过脚本将指令发给Appium，appium 就会驱动虚拟机
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElementById("Trending").click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElementsByXPath("//android.widget.Button[@content-desc=\"Library\"]").get(0).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.youtube:id/menu_search").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementById("com.google.android.youtube:id/search_edit_text").sendKeys("hahahahatest");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.getScreenshotAs();
        driver.quit();

    }

}
