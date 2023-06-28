# :common module

The `common` module is used to provide all the commonly used elements throughout the app. Doing this 
we can avoid duplicated code. 

`common` module includes: 
  - `common:android`:- It provides all the common code, constants, composables, strings.
    -- for eg: NetworkMonitor we use to check current network status. As we have added in the common module. 
    it can injected and used without re-writing it for each and every module. 
    -- We can also add all commonly used composable components like button, topBar, loadingWheel here.
  - `common:jvm`:- Here we can add all custom extension commonly used through out the app. It normally should not have any android dependency.
  - `common:palette` :- Here we have added app theme, drawables that can be used throughout the App.
