# Android Mobile Automaion Demo

[![Build Status](https://travis-ci.org/cucumber/cucumber-java-skeleton.svg?branch=master)](https://travis-ci.org/cucumber/cucumber-java-skeleton)

This is the simple build script setup for Cucumber, Appium using Java for android mobile automation.

There is a single feature file with one scenario. The scenario has three steps, two of them pending. See if you can make them all pass!

## Get the code

Git:

    git clone https://github.com/cucumber/cucumber-java-skeleton.git
    
Or simply [download a zip](https://github.com/majdy86/Mobile_Automation.git/archive/master.zip) file.

## Use Maven

Open a command window and run:

    mvn clean test

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(Cucumber.class)` annotation on the `RunCukesTest`
class tells JUnit to kick off Cucumber.


## Overriding options

The Cucumber runtime parses command line options to know what features to run, where the glue code lives, what plugins to use etc.
When you use the JUnit runner, these options are generated from the `@CucumberOptions` annotation on your test.

Sometimes it can be useful to override these options without changing or recompiling the JUnit class. This can be done with the
`cucumber.options` system property. The general form is:

Using Maven:

    mvn -Dcucumber.options="..." test

Let's look at some things you can do with `cucumber.options`. Try this:

    -Dcucumber.options="--help"

That should list all the available options.

*IMPORTANT*

When you override options with `-Dcucumber.options`, you will completely override whatever options are hard-coded in
your `@CucumberOptions` or in the script calling `cucumber.api.cli.Main`. There is one exception to this rule, and that
is the `--plugin` option. This will not _override_, but _add_ a plugin. The reason for this is to make it easier
for 3rd party tools (such as [Cucumber Pro](https://cucumber.pro/)) to automatically configure additional plugins by appending arguments to a `cucumber.properties`
file.

### Tools & environment:

macOS Catalina 10.15.2

This project has been tested against the following tools:

Appium: 1.15.1.20191013.2 & 1.17.0-beta.1

Apache-Maven: 3.6.2

openjdk version : 13.0.2" &  oracle64: 1.8.0.221

npm: 6.14.1

Android Studio: 3.6.1

Emulators:
Pixel 3a XL API 28
Galaxy Nexus API 28
Pixel C API 29 (Tablet)
Nexus 9 API 27 Tablet
Nexus 6P API 22


### Report:

Allure Test Report has been used for this project.

to generate the allure report and open it in your browser run the following command:

    mvn allure:serve
    
### Happy Automation Testing  :)