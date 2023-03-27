plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    `maven-publish`
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    plugins.withId("com.vanniktech.maven.publish.base") {
        afterEvaluate {
            publishing {
                repositories {
                    maven {
                        url = uri("https://maven.pkg.github.com/danielPerez97/ynab-kmp")

                        credentials {
                            username = System.getenv("GITHUB_ACTOR")
                            password = System.getenv("GITHUB_TOKEN")
                        }
                    }
                }
            }
        }
    }
}