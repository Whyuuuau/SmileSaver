plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "bangkit.android.capstone11"
    compileSdk = 34

    defaultConfig {
        applicationId = "bangkit.android.capstone11"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "BASE_URL", "\"https://smile-saver-capstone.as.r.appspot.com/\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
        mlModelBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //slider
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //camera
    implementation ("androidx.camera:camera-camera2:1.4.0-alpha02")
    implementation ("androidx.camera:camera-lifecycle:1.4.0-alpha02")
    implementation ("androidx.camera:camera-view:1.4.0-alpha02")
    implementation("org.tensorflow:tensorflow-lite-support:0.1.0")
    implementation("org.tensorflow:tensorflow-lite-metadata:0.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //retrofit converter gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Okhttp logging interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    //coil: pemuatan gambar lebih efisien
    implementation("io.coil-kt:coil:1.4.0")

    //lifecycle viewmodel dan livedata
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    //komponen activity
    implementation ("androidx.activity:activity-ktx:1.4.0")

    //camera API
    implementation ("androidx.camera:camera-camera2:1.1.0-beta03")
    implementation ("androidx.camera:camera-lifecycle:1.1.0-beta03")
    implementation ("androidx.camera:camera-view:1.1.0-beta03")

    //room database
    implementation ("androidx.room:room-ktx:2.4.0-beta01")
    implementation ("androidx.room:room-runtime:2.4.0")
    implementation ("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation ("androidx.room:room-paging:2.5.0-alpha01")

    //pengujian espresso
    implementation ("androidx.test.espresso:espresso-idling-resource:3.4.0")

    //gif
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.25")

    //maps dan location
    implementation ("com.google.android.gms:play-services-maps:18.0.2")
    implementation ("com.google.android.gms:play-services-location:19.0.1")

    //core testing libraries
    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    testImplementation ("org.mockito:mockito-core:4.4.0")
    testImplementation ("org.mockito:mockito-inline:4.4.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")

    //server palsu untuk uji http
    androidTestImplementation ("com.squareup.okhttp3:mockwebserver:4.9.3")

    //okhttp tls
    androidTestImplementation ("com.squareup.okhttp3:okhttp-tls:4.9.3")

    //tambahan espresso
    androidTestImplementation ("com.android.support.test.espresso:espresso-contrib:3.0.2")

}