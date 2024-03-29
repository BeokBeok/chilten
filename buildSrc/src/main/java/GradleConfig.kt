object Version {
    const val KOTLIN = "1.5.10"
    const val COMPOSE = "1.0.0"
    const val HILT = "2.37"
}

object ProjectConfig {
    const val GRADLE = "com.android.tools.build:gradle:7.0.0"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
    const val HILT_ANDROID_GRADLE_PLUGIN =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT}"
}

object AndroidConfig {
    const val COMPILE_SDK = 30
    const val APP_ID = "com.beok.chilten"
    const val MIN_SDK = 23
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object Dependencies {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Version.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:1.3.0"
    const val MATERIAL = "com.google.android.material:material:1.1.0"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.2.0-beta01"
}

object ComposeConfig {
    const val UI = "androidx.compose.ui:ui:${Version.COMPOSE}"
    const val MATERIAL = "androidx.compose.material:material:${Version.COMPOSE}"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Version.COMPOSE}"
    const val RUNTIME_LIVEDATA = "androidx.compose.runtime:runtime-livedata:${Version.COMPOSE}"
    const val ACTIVITY = "androidx.activity:activity-compose:1.3.0-rc02"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha08"
}

object AccompanistConfig {
    const val COIL = "com.google.accompanist:accompanist-coil:0.14.0"
}

object HiltConfig {
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT}"
}

object NetworkConfig {
    private const val RETROFIT_VER = "2.9.0"
    private const val MOSHI_VER = "1.12.0"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VER"

    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.8.1"

    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VER"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VER"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VER"
}

object LifecycleConfig {
    private const val LIFECYCLE_VER = "2.3.0-beta01"

    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VER"
    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VER"
}
