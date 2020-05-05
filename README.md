Create mobile Automation steps - for Android
1. Download android studio and install android sdk
    https://developer.android.google.cn/studio/

2. If the android command doesn't work, can not use latest android tools file due to the android command is deprecated since Android SDK Tools25.2.3
so download a old version from : https://dl.google.com/android/repository/tools_r25.2.3-windows.zip

3. If can not Can not use the latest haxm version, download from this link and replace the folder $ANDROID_HOME/extras/intel/Hardware_Accelerated_Execution_Manager
  https://github.com/intel/haxm/releases/tag/v7.5.1
  
4. project dependence
    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>7.0.0</version>
        </dependency>

    </dependencies>
5. install Appium:
https://github.com/appium/appium-desktop/releases/tag/v1.15.1
You can update the version to download different version appium（如果下载不了，就用迅雷找资源下载）

6. get app package and activity
  1> adb shell pm list packages                                  列出所有的包名（不知道包名的情况，需要执行查找包名）appPackage
  2> adb shell dumpsys package XXX                               查看某个包的具体信息(前提是需要知道包名是什么)     appActivity
  3> adb shell "dumpsys activity | grep mFocusedActivity"        查看当前resume的是哪个activity 
  4> adb shell "logcat | grep ActivityManager"                   查看当前正在运行的Activity
  5> adb shell "logcat | grep Displayed"                         查看当前正在运行的Activity

    adb shell dumpsys window | findstr mCurrentFocus 查看当前打开的app的appPackage 和appActivity

7.appium 启动的session的时候如果碰到 Error  Could not connect to server; are you sure it's running?
是选成Custom Server 了，需要选Automatic Server 去start session
