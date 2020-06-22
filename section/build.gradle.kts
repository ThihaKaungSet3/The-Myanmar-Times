import Apps.compileSdk

plugins{
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtension)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(compileSdk)

    defaultConfig {

        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)

        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = Apps.TEST_INSTRUMENTATION_RUNNER

    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }


        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}

dependencies {
    implementation(project(ModuleDependency.RESOURCE))
    implementation(project(ModuleDependency.CORE))
    implementation(project(ModuleDependency.NAVIGATION))

    implementation(Libs.RETROFIT)
    implementation(Libs.MOSHI)

    implementation(Libs.NAV_UI)
    implementation(Libs.NAV_FRAGMENT_KTX)

    implementation(Libs.appcompat)
    implementation(Libs.constraint)
    implementation(Libs.kotlin)
    implementation(Libs.CORE_KTX)

    // Dagger
    implementation(Libs.DAGGER)
    implementation(Libs.DAGGER_ANDROID)
    implementation(Libs.DAGGER_ANDROID_SUPPORT)
    kapt(Libs.DAGGER_ANNOTATION)
    kapt(Libs.DAGGER_COMPILER)

}