# SwitchAdbWiFiConnectIp
Switch AdbWiFiConnect plugin 's IP

修改AdbWiFiConnect插件的IP地址。

1.首先用USB线与手机连接，然后使用AdbWiFiConnect插件进行连接。这样就会有连接记录，后续就能修改ip了。

![](http://linmilin.com/img/jietu/20200417105253.png)


2.在根工程的`build.gradle`中配置。
```$groovy
buildscript {
    repositories {
        google()
        jcenter()
    
        //配置这个
        maven {
            url "https://plugins.gradle.org/m2/"
        }
        
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.2'

        //配置这个
        classpath "gradle.plugin.com.linmilin.adbwificonnectip:AdbWifiConnectIpPlugin:1.0.4"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

```

3. 在应用module中`build.gradle`中配置

```$xslt
//使用插件
apply plugin: "com.linmilin.ip.adbwificonnect"


//设置ip地址。
SwitchAdbWiFiIp{
    ip '192.168.5.155'
}

android{

}

```

4. 在`gradle`面板中执行`SwitchAdbWiFiConnectIp`这个Task。就可以修改ip。


> 手机要打开‘开发者模式’，并允许USB调试。