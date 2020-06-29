import Apps.compileSdk

plugins{
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtension)
    id(BuildPlugins.kotlinKapt)
    id(BuildPlugins.butterKnife)
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
            isShrinkResources = false
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

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(ModuleDependency.RESOURCE))
    implementation(project(ModuleDependency.CORE))
    implementation(project(ModuleDependency.NAVIGATION))
    implementation(project(ModuleDependency.DETAIL))

    implementation(Libs.appcompat)
    implementation(Libs.MATERIAL)
    implementation(Libs.constraint)
    implementation(Libs.kotlin)

    implementation(Libs.CORE_KTX)
    implementation(Libs.VIEWMODEL_KTX)
    implementation(Libs.FRAGMENT_KTX)

    implementation(Libs.RETROFIT)
    implementation(Libs.MOSHI)

    implementation(Libs.NAV_UI)
    implementation(Libs.NAV_FRAGMENT_KTX)

    implementation(Libs.EPOXY)
    implementation(Libs.EPOXY_DATABINDING)
    kapt(Libs.EPOXY_ANNOTATION)

    implementation(Libs.DAGGER)
    implementation(Libs.DAGGER_ANDROID)
    implementation(Libs.DAGGER_ANDROID_SUPPORT)
    kapt(Libs.DAGGER_ANNOTATION)
    kapt(Libs.DAGGER_COMPILER)

    implementation(Libs.ROOM)
    implementation(Libs.ROOM_COMPILER)
    kapt(Libs.ROOM_KTX)

    implementation(Libs.COIL)

    implementation(Libs.STORE)


}