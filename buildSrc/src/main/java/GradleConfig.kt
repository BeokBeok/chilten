object Version {
    const val KOTLIN = "1.4.10"
    const val COMPOSE = "1.0.0-alpha06"
}

object ProjectConfig {
    const val GRADLE = "com.android.tools.build:gradle:4.2.0-alpha15"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}"
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
}

object ComposeConfig {
    const val UI = "androidx.compose.ui:ui:${Version.COMPOSE}"
    const val MATERIAL = "androidx.compose.material:material:${Version.COMPOSE}"
    const val UI_TOOLING = "androidx.ui:ui-tooling:${Version.COMPOSE}"
}
