import Apps.compileSdk

plugins{
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtension)
    id(BuildPlugins.kotlinKapt)

}

android {
    compileSdkVersion(compileSdk)

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
        }


        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}

dependencies {
    implementation(project(ModuleDependency.CORE))
    implementation(project(ModuleDependency.TODAY))
    implementation(project(ModuleDependency.FORYOU))
    implementation(project(ModuleDependency.SECTION))
    implementation(project(ModuleDependency.RESOURCE))

    implementation(Libs.appcompat)
    implementation(Libs.constraint)
    implementation(Libs.MATERIAL)
    implementation(Libs.kotlin)
    implementation(Libs.CORE_KTX)
    implementation(Libs.VIEWMODEL_KTX)
    implementation(Libs.NAV_UI)
    implementation(Libs.NAV_FRAGMENT_KTX)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

}

