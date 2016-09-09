# SlideMenuWithAPT

Implement slidemenu with android.support.v4.widget.DrawerLayout

1. Butter knife 的使用，如下，来自ButterKnife的GitHub
    Configure your project-level build.gradle to include the 'android-apt' plugin:

        buildscript {
          repositories {
            mavenCentral()
           }
          dependencies {
            classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
          }
        }
    Then, apply the 'android-apt' plugin in your module-level build.gradle and add the Butter Knife dependencies:

        apply plugin: 'android-apt'

        android {
          ...
        }

        dependencies {
          compile 'com.jakewharton:butterknife:8.4.0'
          apt 'com.jakewharton:butterknife-compiler:8.4.0'
        }
    Note: If you are using the new Jack compiler with version 2.2.0 or newer you do not need the 'android-apt' plugin and can instead replace apt with annotationProcessor when declaring the compiler dependency.
    

2. remove the title of the theme of Theme.AppCompat.Light.DarkActionBar, please set the following attribute:
    <item name="windowActionBar">false</item>
    <item name="windowNoTitle">true</item>        
Be carefull! The attributes are "windowActionBar"  and "windowNoTitle", not "android:windowActionBar" or "android:windowNoTitle"

Attribute "windowNoTitle" will be used on SDK 23 or newer.



3. 侧滑菜单的实现
布局文件的根是 android.support.v4.widget.DrawerLayout,包含两部分，一部分是显示内容显示区域，一部分是菜单。
并且，在代码位置上，菜单部分，必须在内容显示区域的下面,如下：
<android.support.v4.widget.DrawerLayo
    ...
    >
    <!-- 下面是内容显示区域 -->
    <LinearLayout
        ...
        >
        ...
    </LinearLayout>
    
    
    <!-- 下面是内容测边菜单区域，一定要包含一个属性
    android:layout_gravity="start" 标识这该部分为侧滑部分 -->
    <LinearLayout
        ...
        android:layout_gravity="start"
        >
        ...
    </LinearLayout>

</android.support.v4.widget.DrawerLayout>

