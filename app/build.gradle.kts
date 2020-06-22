
plugins{
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtension)
    id(BuildPlugins.kotlinKapt)

}

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
        applicationId = Apps.applicationId
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
            isShrinkResources = false
        }


        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

dependencies {
    implementation(project(ModuleDependency.CORE))
    implementation(project(ModuleDependency.RESOURCE))
    implementation(project(ModuleDependency.NAVIGATION))

    implementation(project(ModuleDependency.FORYOU))
    implementation(project(ModuleDependency.TODAY))
    implementation(project(ModuleDependency.SECTION))

    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    implementation(Libs.constraint)
    implementation(Libs.MATERIAL)
    implementation(Libs.LEGACY)
    implementation(Libs.RETROFIT)
    implementation(Libs.MOSHI)

    implementation(Libs.TIMBER)

    implementation(Libs.CORE_KTX)
    implementation(Libs.VIEWMODEL_KTX)

    implementation(Libs.NAV_UI)
    implementation(Libs.NAV_FRAGMENT_KTX)

    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

    // Dagger
    implementation(Libs.DAGGER)
    implementation(Libs.DAGGER_ANDROID)
    implementation(Libs.DAGGER_ANDROID_SUPPORT)
    kapt(Libs.DAGGER_ANNOTATION)
    kapt(Libs.DAGGER_COMPILER)


}

