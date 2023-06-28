# Sports Network App

The `Sports Network` App provided all the sports feed with most recent on the top.
<br>
<br>
*What the sample looks like:*<br>

<img src="https://github.com/pareen1504/SportsNetwork/assets/13451186/16638005-fe9c-4b00-bd22-cc9dda8ea0b3" alt="home_screen" width="30%">
<img src="https://github.com/pareen1504/SportsNetwork/assets/13451186/705409ac-cfd0-43d5-910c-e60aee58a149" alt="feed_screen" width="30%">


For convenience, the `:common` module has been added, which contains utilities, extension functions and compose elements used in
most projects and the `:common:palette` module which contains themes, styles, colors for the project.

The `:core` module has been added, for network service and can also be used for analytics and cache using datastore. 

## Stack
- Android Jetpack + Compose
- Android App modularization
- Kotlin
- MV/I/VM
- Retrofit, Coroutines, Moshi, OkHttp
- Android ViewModel
- Hilt
- Gradle DSL


# Dependencies used
- accompanist
- kotlin
- kotlinxCoroutines
- junit
- appcompat
- material
- hilt
- retrofit
- androidxCompose
- materialCompose
- androidxCore
- androidxCoreSplashscreen
- androidxLifecycle
- androidxActivity
- okhttp
- moshi
- json

# Written previously on a personal project
- Compose theme used in `common:palette` is from my previous project.
- `build-logic` approach is heavily based on
  [https://developer.squareup.com/blog/herding-elephants/](https://developer.squareup.com/blog/herding-elephants/)
  and
  [https://github.com/jjohannes/idiomatic-gradle](https://github.com/jjohannes/idiomatic-gradle).

# What portion of the code do you feel is most important for us to review more closely?
- The entire code structure. As the principles of Clean Architecture are followed.

# If you were to continue to develop the project, what are things you would add, change, or improve?
- The Api response should be changed so we can accommodate sport and ui (eg: images, videos in feed, Ads for monetization) of different types.
- Need to add a dataDependency module so we don't need to add data module implementation of each feature in our app module. This will create a facade for the hilt to provide required implementation of the data module  


# Things to be added for production ready.
- Compliance with code-style
    -- `Detekt`, `Ktlint` libraries to maintain a uniform code style. So Before pushing, we can check the new code for compliance with the rules using the `./gradlew ktFormat && ./gradlew detekt` command, or configure
        task in Android Studio. 
    -- CI/CD to be configured with Detekt, Ktlint to check the project with Push, Pull Request and Git workflows.

- Git hooks
    -- `pre-code-commit` guidelines, to makes sure PR structure required for the workflow.

- implement Crashlytics and Analytics
- Multi-language support.


## Tests


