# Selenium E2E

*A simple java based test automation project*

**Technology Used :** Java, TestNG, Selenium, Maven, Apache POI, Apache Log4j



### Prerequisites
Latest Eclipse IDE
Java 8

### Features
* No Tread.sleep or implicit wait used 
* Test case execution is driven by TestNG xml
* Drivers needed to execute the tests are inlcuded in the /src/test/resources/executables.
* The config.properties file located in the /src/test/resources/properties can be changed to change your test browser (for chrome, no need to change anything).
* Data Driven Design Pattern
* Page Factory Design Pattern
* Fluent Builder Design Pattern for pages 
* Singleton Pattern - used Singleton Enum for WebDriver, WebDriverWait and to load Config 

### Running the project
1. Download the zip or clone the Git repository.
1. Unzip the zip file (if you downloaded one).
1. Open Command Prompt and Change directory (cd) to folder containing pom.xml
1. Open Eclipse
1. File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
1. Select the right project
1. Right Click on the file and Run as Maven Test
