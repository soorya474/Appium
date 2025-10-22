# Appium
AppiumTest
│
├── src/test/java/
│   ├── com/stream/driver/
│   │   └── CommonStudio.java        # Handles driver setup and browser reset
│   │
│   ├── com/stream/login/
│   │   └── LoginPage.java           # Page Object Model for login page (locators & actions)
│   │
│   ├── appiumTest/
│   │   └── LoginTest.java           # Data-driven test verifying valid & invalid logins
│   │
│   └── reporting/                   # TestNgReporting
│
├── testng.xml                       # TestNG suite configuration
├── pom.xml                          # Dependencies and plugins
└── README.md                        # Project documentation 

1.Clone the project
#git clone https://github.com/<your-repo>/SimplestreamAppiumCodeChallenge.git

2.Install dependencies and start appium server

3.Install and set up Android Studio

4.CommonStudio.java
Initializes AppiumDriver using UiAutomator2Options
Supports both Android and iOS using TestNG parameters
Cleans cookies and resets the browser before each test
Quits driver after the suite finishes

5.LoginPage.java

Implements Page Object Model (POM) for maintainable locators and actions:


6.LoginTest.java

Uses a DataProvider for both valid and invalid credentials.


7.testng.xml
Contains
1.Suite name
2.Platform parameter (Android / iOS)
3.Class under test
