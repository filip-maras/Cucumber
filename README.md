# CucumberProject

**Setup:**
-Install IntelliJ
-Install Java (get for e.g. JDK 11) *it was used OpenJDK-11 
-Add Java to path - Windows (JAVA_HOME=path\to\your\jdk\jdk-11)
-Install Gradle (e.g. 7.0.2)
-Add Gradle to path (;path\to\gradle-7.0.2\bin;)
-Use git to clone repository
-Download ChromeDriver, unzip it and place it to CucumberProject\src\test\java\Utils
-Add ChromeDriver to path variable (;path\to\CucumberProject\src\test\Utils;) 
-Open project with IntelliJ 
-Update ChromeDriver path in ..\Utils\InitiateDriver with path to your ChromeDriver (do not forget .exe at the end of path if you are using Win)
 (example of path "path\to\project\\SeleniumProject\\src\\test\\java\\Utils\\chromedriver.exe")
-Go to CucumberProject\src\test\java\RunTests class and run tests

Reports can be found at CucumberProject\build\cucumber-report
