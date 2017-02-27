# TAB Appium Server

The appium server for use with the `TAB_mobile_integration_test` repository.

## Getting Started

1. Ensure you have Homebrew.
2. Install brew dependencies `brew install node`
3. Run `./tab-appium-server setup` then `./tab-appium-server deps`
4. Check install `./tab-appium-server doctor`
5. Run `./tab-appium-server android`

## Tips

- Ensure you can run the AVD with the app without the appium server
- Ensure you can run the iOS simulator
- Run the appium doctor to locate any issuesAdded
- Install cucumber for JAVA plugin
- Appium support Android 6.0 well for 7.0 there are bug in it.

# TAB Mobile Testing

Multi-platform iOS and android testing spike powered with cucumber-jvm to support Behaviour Driven Development.
 
## Getting Started - Mobile App Automation

Be sure to checkout the `TAB_mobile_integration_test` project and ensure that is running.

1. Download and use IntelliJ to open this gradle project.
2. In the project view, locate the class `MobileTest`
3. Right click and select "Create a Run Configuration", make sure created with Junit one, don't use gradle one
4. Ensure tasks is `cleanTests test`
5. Ensure vm options is `-Dspring.profiles.active=android` or `-Dspring.profiles.active=ios`
 
## Tips

- You can only test android or ios one at a time
- Run the server in ios or android mode then on the client use the corresponding spring profile

## Code Layout

- `src/main/java/au/com/tabcorp/domain` is for domain objects
- `src/test/java/com/tabcorp/steps` is for steps organised by domain objects
- `src/test/java/com/tabcorp/screens` is for objects representing a mobile screen
- `src/test/resources/features` is for the features gherkin files
- `src/test/resources/journeys` is for the happy scenario user experience journey gherkin files

## Test Classes

There are three different types of tests:

1. Feature Tests - to act as acceptance tests

## Definition of Ready

Team makeup:

- Business analysts who collate and organise business requirements and own the feature gherkin files
- User experience designers who analyse user flows, document happy/rainy scenarios and own the journey gherkin files
- Quality assurance testers who organise and code tests own the steps and screens
- Developers implement the system and assist in implementing the ids for the screens

Process of readiness:

- BAs document user stories and detailed requirements
- QAs together with BAs and DEVs detail user stories into gherkin features 
- UX designers document happy and rainy day scenarios with BAs
- QAs together with UX designers and DEVs detail user stories into gherkin journeys

## Documentation Feedback

- Company overview
- Group overview
- Product overview
- Screen flows with steps
- Dictionary for acronyms
- User journeys

# Info

Appium - Easier and faster testing:

1. language choice - using java as a statically typed language, there is a deeper skill pool both internally and what is available on market
2. ide tool - using intellij technical debt can be easier to manage via well known refactoring tools and methods (intellij, refactoring book by m. fowler)
3. cucumber best practices - starting off using the Cucumber for Java book’s recommendation and modify as necessary
4. industry leader automation framework - attracts a larger talent pool and larger available community resources
5. team collaboration - since every single dev team member knows java, code management, tools, techniques can be shared and testing can be done by developers as well

QA - Faster coding:

1. single screen - not needing to write two different screens in calabash
2. code review - manage structure, manage naming, manage debt
3. feature ownership - by ba’s and input from testers and developers
4. screen assistance - help from developers to create the screens, but also can be done by testers
5. multiple pipelines
6. android automation
7. faster development by not sleeping inside testing code for each screen