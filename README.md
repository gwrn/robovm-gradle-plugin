RoboVM Gradle plugin
====================

# Usage
To use the RoboVM plugin, include in your build script:

```groovy
// Pull the plugin from Maven Central
buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
    }
    dependencies {
        classpath 'org.robovm:robovm-gradle-plugin:1.0.0-alpha-01'
    }
}

// Apply the plugin
apply plugin: 'robovm'

repositories {
    mavenCentral()
    maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
}

ext {
    // Configure your application main class
    mainClassName = "org.robovm.sample.ios.RoboVMSampleIOSApp"
    roboVMVersion = "1.0.0-alpha-01"
}

robovm {
    // Configure robovm
    iosSignIdentity = ""
    iosProvisioningProfile = ""
    iosSkipSigning = false
    stdoutFifo = ""
    stderrFifo = ""
}
```

## Tasks

The RoboVM plugin defines the following tasks:

* `launchIPhoneSimulator`: Runs Your iOS App in the iPhone Simulator.
* `launchIPadSimulator`: Runs Your iOS App in the iPad Simulator.
* `launchIOSDevice`: Runs Your iOS App in the iOS Device.
* `createIPA`: Creates .ipa file.
