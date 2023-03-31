plugins {
    id("java-library")
    kotlin("jvm")
    alias(libs.plugins.mavenPublish)
}

dependencies {
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.lib)

    testImplementation(libs.okhttp.mockwebserver)
    testImplementation(kotlin("test-junit5"))
    testImplementation(libs.junit.jupiter.api)
    runtimeOnly(libs.junit.jupiter.engine)
}

tasks.withType<Test>() {
    useJUnitPlatform()
}