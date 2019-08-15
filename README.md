Demo api project uses https://api.imgur.com/ to make api calls.
To run test need to:
1. Register https://imgur.com/
2. Register the app and obtein client id and client secret.




To Run with gradle (windows) use:
```
gradlew clean test
```

To open allure report use:
```
allure serve
```
Generated allure report will look like:

![alt text](https://github.com/shavrova/api-tests-demo/blob/master/src/test/resources/allure-scr.png)

Note: test framework uses grant_type password.
To use grant_type token need to give permissions manually before make api calls.
