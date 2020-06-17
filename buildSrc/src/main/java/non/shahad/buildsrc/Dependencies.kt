object Apps {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val applicationId = "non.shahad.mmtimes"
    const val versionCode = 1
    const val versionName = "1.0"
    const val TEST_INSTRUMENTATION_RUNNER = "android.support.test.runner.AndroidJUnitRunner"
}


object BuildPlugins {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtension = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}


object Versions {
    const val kotlin = "1.3.61"
    const val gradle = "4.0.0-alpha09"
    const val appcompat = "1.1.0"
    const val constraint = "1.1.3"

    const val coreKTX = "1.3.0"
    const val FRAGMENT_KTX = "1.2.4"

    // Life Cycle
    const val lifecycle = "2.2.0"

    // Navigation
    const val nav = "2.3.0-rc01"

    const val material = "1.3.0-alpha01"

    const val legacy = "1.0.0"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"

    // KTX
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    // Navigation
    const val NAV_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val NAV_UI = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"

    // Material
    const val MATERIAL = "com.google.android.material:material:${Versions.material}"

    // Legacy
    const val LEGACY = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

}