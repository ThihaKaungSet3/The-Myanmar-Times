
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
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtension = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val butterKnife = "com.jakewharton.butterknife"
    const val butterKnifeGradle = "com.jakewharton:butterknife-gradle-plugin:${Versions.butterKnifeGradle}"
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
    const val butterKnifeGradle = "10.1.0"
    const val gradle = "4.1.0"

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

    // Dagger
    const val DAGGER = "2.26"
    const val hilt = "2.28-alpha"
    const val hilt_viewmodel = "1.0.0-alpha01"

    const val RxJava = "2.2.20"

    const val retrofit = "2.7.1"


    const val timber = "4.7.1"

    // Adapter Delegate
    const val adapterDelegate = "4.3.0"

    // Coil
    const val coil = "0.11.0"

    // Epoxy
    const val epoxy = "4.0.0-beta4"
    const val epoxy_paging = "2.18.0"

    // Store
    const val store = "4.0.0-alpha06"

    const val room = "2.2.5"

    // Stetho
    const val stetho = "1.5.1"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"

    // KTX
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
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

    // Dagger-Hilt
    const val HILT = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_viewmodel}"
    const val HILT_VIEWMODEL_COMPILER = "androidx.hilt:hilt-compiler:${Versions.hilt_viewmodel}"

    // Dagger
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android:${Versions.DAGGER}"
    const val DAGGER_ANDROID_SUPPORT = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
    const val DAGGER_ANNOTATION = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"

    const val RXJAVA = "io.reactivex.rxjava2:rxjava:${Versions.RxJava}"

    // Timber
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.timber}"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val RX_CALL_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    // Adapter delegate
    const val ADAPTER_DELEGATE = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:${Versions.adapterDelegate}"
    const val ADAPTER_DELEGATE_BINDING = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:${Versions.adapterDelegate}"

    // Epoxy
    const val EPOXY = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val EPOXY_DATABINDING = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
    const val EPOXY_ANNOTATION = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    const val EPOXY_PAGIN = "com.airbnb.android:epoxy-paging:${Versions.epoxy_paging}"

    // Store
    const val STORE = "com.dropbox.mobile.store:store4:${Versions.store}"

    // Stetho
    const val STETHO = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val STETHO_OKHTTP = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

    const val ROOM = "androidx.room:room-runtime:${Versions.room}"
    const val ROOM_RX = "androidx.room:room-rxjava2:${Versions.room}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.room}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.room}"

    // Coil
    const val COIL = "io.coil-kt:coil:${Versions.coil}"

}