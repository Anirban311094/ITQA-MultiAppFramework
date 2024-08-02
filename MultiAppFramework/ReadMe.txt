Author: Anirban Chakrabarty
System Name: Rahul Chakrabarty
Email: anirbanc1994@gmail.com, anirban9051673947@gmail.com
Contact: (+91) 9674663035

About Framework:

Execution Trigger: Execute the program by running the Executor.java class. This class acts as the central driver for your automation framework.
Test Selection: Executor.java will first parse the RunManager.xlsx spreadsheet. It will look for rows where the "Execute" column contains the value "Yes."
Test Case Details: For each identified row in RunManager.xlsx, the following information will be extracted:
Application: The name of the application under test (e.g., Google / Amazon). Mention it in Settings.properties in DataTables Folder.
In PassInfos.java update the Settings.properties file path
Update other file location in Settings.properties (chromeDriverPath, chromePath, runManagerPath, pathTestScenario)
Test Case: The specific test case to be executed (e.g., TC01_Google_Login).
Keyword Identification: Next, Executor.java will consult the TestScenarios.xlsx spreadsheet. It will search for the extracted test case name (e.g., TC01_Google_Login) within the "Test Case" column of the Business_Flow sheet.
Keyword Sequence: Once the test case is found, Executor.java will identify the corresponding keyword names listed under columns like "KeyWord1," "KeyWord2," and so on (until the next blank cell is encountered). These keywords represent the specific actions to be performed in the test case. For example, login_Google and logout_Google might be keywords.
Browser Launch: Executor.java will then launch a web browser instance to begin the automation execution.
Keyword Execution: Based on the extracted keywords:
It will locate the appropriate keyword class file (e.g., Google_Keywords.java for the "Google" application).
Within the identified keyword class, it will execute the methods corresponding to the extracted keywords. In this example, it would call login_Google() and then logout_Google(). The logic for these methods would be implemented by the testers within the keyword class files.
Execution Completion:
After executing all the extracted keywords for the test case, Executor.java will close the web browser.

[The below part can not be used as of now: Under progress: 
Finally, it will generate a test execution report and save it in two locations:
CurrentExecutions folder for immediate reference.
AllExecutions folder for historical record-keeping.]