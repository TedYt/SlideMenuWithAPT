# SlideMenuWithAPT

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
    
    
