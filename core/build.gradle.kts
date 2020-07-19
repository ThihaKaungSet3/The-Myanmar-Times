
plugins{
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtension)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(Apps.compileSdk)

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

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Libs.appcompat)
    implementation(Libs.constraint)
    implementation(Libs.kotlin)
    implementation(Libs.MATERIAL)
    implementation(Libs.LEGACY)

    implementation(Libs.CORE_KTX)
    implementation(Libs.VIEWMODEL_KTX)
    implementation(Libs.LIFECYCLE_KTX)

    implementation(Libs.TIMBER)

    implementation(Libs.RETROFIT)
    implementation(Libs.MOSHI)

    implementation(Libs.COIL)

    implementation(Libs.EPOXY)
    implementation(Libs.EPOXY_DATABINDING)
    kapt(Libs.EPOXY_ANNOTATION)

    implementation(Libs.STORE)

    implementation(Libs.STETHO)
    implementation(Libs.STETHO_OKHTTP)
    
    implementation(Libs.DAGGER)
    implementation(Libs.DAGGER_ANDROID)
    implementation(Libs.DAGGER_ANDROID_SUPPORT)
    kapt(Libs.DAGGER_ANNOTATION)
    kapt(Libs.DAGGER_COMPILER)

}