# In Development
Please be aware this library is far from complete or usable.

# ynab-kmp
ynab-kmp stands for "You Need A Budget - Multiplatform". It is a library for interfacing with YNAB's own [developer API][1] leveraging [Kotlin's
Multiplatform Features][2] so it can be used on Android with iOS and JS planned for the future.

# Modules
Currently there are two modules: 'json' and 'ynab-http'. 'json' holds all the JSON data classes using kotlinx.serialization, and 'http' is a JVM/Android 
only module that will provide Okhttp interceptors and Retrofit interfaces for use with the YNAB developer API.

To test, run the following:  
`./gradlew :json:clean :json:check`  
`./gradlew :ynab-http:clean :ynab-http:check`

# Current Goals
* Provide API's that can fully support [Personal Access Tokens][3] and [OAuth Applications][4] per the YNAB documentation.
* Have the project be feature-complete enough to build an Android App that provides a widget to view a users age of money


[1]: https://api.youneedabudget.com/#hello
[2]: https://kotlinlang.org/lp/mobile/
[3]: https://api.youneedabudget.com/#personal-access-tokens
[4]: https://api.youneedabudget.com/#outh-applications
