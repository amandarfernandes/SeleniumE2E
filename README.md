# Selenium App

* A simple java based test automation project *

Technology Used : Java, TestNG, Selenium, Maven, Apache POI, Apache Log4j
Framework Used: Data Driven

### Prerequisites
Latest Eclipse IDE
Java 8

### Features
*  uses a properties file as an object repository
*  CSSSelector element locator
*  test case execution is driven by TestNG xml
*  takes screenshot of failed test cases
*  the drivers needed to execute the tests are inlcuded in the /src/test/resources/executables folder.
*  the config.properties file located in the /src/test/resources/properties folder can be changed to change your test browser.

### Running the project
1. Download the zip or clone the Git repository.
1. Unzip the zip file (if you downloaded one).
1. Open Command Prompt and Change directory (cd) to folder containing pom.xml
1. Open Eclipse
1. File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
1. Select the right project
1. Right Click on the file and Run as Maven Test
