# SBAFramework

Java-Cucumber
Built using Java, Selenium, Gradle, Cucumber.

Web Page Object based test automation skeleton with parallel option

Resources
Git
Gradle
Cucumber-JVM
Cucumber-JVM API
Git Clone Project
You will need to download and install Git
Install Git For Windows Here
Use default options or as preferred.
When on the projects github page click on clone or download button(green button below contributor) and copy the HTTP url
if you are having trouble finding it then copy this url and replace the placeholderUsername with your own
https://github.com/placeholderUsername/java-gradle-selenium-cucumber-parallel-skeleton.git
Open your CLI(command line interface) and cd(change directory) into the directory/folder where you want to download this project (It is recommended to create a directory for your git projects).
Ex: cd git-projects
Use git clone to download the project with the following command with your username
git clone https://github.com/placeholderUsername/java-selenium-cucumber-skeleton.git
Setup
Download Java
Download and get Java installed from here (you can use other jdk's. This is to just get you started)

Mac OSX:
1. Open a terminal and proceed with the following: $ open ~/.bash_profile 
2. Set environment variables

export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=${PATH}:$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$JAVA_HOME/bin

3. Save changes, reopen terminal and enter the following.

Homebrew: $ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
After installation: $ brew doctor should state Your system is ready to brew
Git:$ brew install git
Windows OS:
Set windows variables:

open powershell as admin > enter rundll32 sysdm.cpl,EditEnvironmentVariables to open windows variables
Create and set following for SYSTEM VARIABLES. You will click on the NEW button to create a variable.
Variable name -> JAVA_HOME
Variable path -> path\to\javaSDK (put path to your actual sdk which is usually in your ProgramFiles folder)
Select Path in SYSTEM Variables and click Edit then click New and enter the following for the variables created:
%JAVA_HOME%\bin
Close the admin powershell instance
Install IntelliJ:
When intellij is open do the following Import Project > find where you git cloned the project to and select it > Gradle > continue through the steps to import project.

Install cucumber plugins

File > Preferences/Settings_ > Plugins > Marketplace:
Cucumber for Java
google-java-format
How to use: Enable the plugin in Other Settings
Ctrl + Alt + L to format or right click on file > Reformat Code
Usage:
Local
Local drivers are created automatically and you should not need to do anything other than supply the deviceName
Remote
Start Selenium Session
Set -DisRemote="true" in CLI (command line interface)
Install Selenium: $ selenium-standalone install
Start Selenium: $ selenium-standalone start
Running tests
Gradle Wrapper Command Line Test Runs

Open your Terminal/Powershell(if you open the terminal from intelliJ you don't need to cd) and cd(change directory) to project path on your system

Example: C:\Users\yourUserHere\git-projects\projectName

now that we are in the project directory we can use gradlew tasks to get more info about the project and how to run tests with it. Scroll up and locate the cucumber groups for project info!
NOTE: use .\gradlew with powershell !!!
Reports and screenshots are located here for local viewing!!! C:\Users\yourUserHere\git-projects\projectName\TestResults

Run the project with this command

gradlew clean build giphyEnv neatGifTest cucumber
IntelliJ
Create a run configuration. This will allow you to run Scenarios by right clicking them and selecting run in IntelliJ

Create new Cucumber Java run configuration: Run > Edit Configurations > Templates > Cucumber Java
Main class: io.cucumber.core.cli.Main
Glue: core.setup core.test.steps
Program Arguments (copy and paste this into the program arguments after expanding)
-p
pretty
--add-plugin
de.monochromata.cucumber.report.PrettyReports:TestResults/Reports/cucumber-html
-p
json:TestResults/Reports/cucumber-report.json
Feature or folder path: /path/to/features
Example /Users/your_username/project_name/src/test/resources/features
Framework Workflow
Config: (core/utilities/setup/Config.java)

This is where we create the desired capabilities for our devices based off the current platform.
getDeviceCapabilities() deserializes jsonData/devices.json JSON data
Hooks: (core/utilities/setup/Hooks.java)

We use the createDriver from CreateSharedDrivers to set the drivers and perform actions based on test conditions.
beforeScenario() configures data, drivers, and variables for test run.
afterScenario() Setup will be set to false after all tests ran and The driver will be quit. On scenario failure a screenshot will be taken
PageObjectBase: (core/base/PageObjectBase.java)

This houses general use methods. The constructor sets the driver variable so this class can be used as a super.
getField(elementField) Is how we use string parameters in gherkin steps to use elements on pages/modules
