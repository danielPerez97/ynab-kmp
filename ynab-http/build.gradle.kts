plugins {
    id("java-library")
    kotlin("jvm")
    alias(libs.plugins.mavenPublish)
}

dependencies {
    implementation(project(":json"))

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.lib)
    implementation(libs.retrofit)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.kotlin.serialization.json.converter)

    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.okhttp.mockwebserver)
    testImplementation(libs.junit.jupiter.api)
    runtimeOnly(libs.junit.jupiter.engine)
}

tasks.withType<Test>() {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
    testLogging.setShowStandardStreams(true)
}