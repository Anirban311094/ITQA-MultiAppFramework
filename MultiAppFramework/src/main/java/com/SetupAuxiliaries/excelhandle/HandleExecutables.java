package com.SetupAuxiliaries.excelhandle;

import java.util.ArrayList;

public class HandleExecutables {
	public static String runManagerPath="C:\\Users\\Rahul Chakrabarty\\git\\ITQA-MultiAppFramework\\MultiAppFramework\\src\\main\\java\\com\\DataTables\\MainTables\\RunManager.xlsx";
	public static String runManagerSheet="Google";
	public static String pathTestScenario="C:\\Users\\Rahul Chakrabarty\\git\\ITQA-MultiAppFramework\\MultiAppFramework\\src\\main\\java\\com\\DataTables\\MainTables\\TestScenarios.xlsx";
    
	
	 //get all Executable test cases in  arraylist
    public static ArrayList<String> getExecutableTestCases() throws Exception{
    	System.out.println("call getExecutableTestCases");
    	ArrayList<String> testCases=ExcelHandles.getTheValues(runManagerPath,runManagerSheet,"Execute(Yes/No)","Yes","Test Case");
    	System.out.println("Test Cases to be executed: "+testCases);
    	return testCases;
    }
    //create packages.method
    public static String getExecutableMethodPath(String testcase) throws Exception{
    	String pathTC_Execute="com.Applications."+runManagerSheet+".bussinesscomponents."+runManagerSheet+"_Keywords."+testcase;//TODO
    	System.out.println("Executable method path: "+pathTC_Execute);
    	return pathTC_Execute;
    }
    //get all executable method for the test case passes as parameter
    public static ArrayList<String> getExecutableMethods(String testcase) throws Exception{
    	System.out.println("call getExecutableMethods");
    	 ArrayList<String> executableMethods=ExcelHandles.getAllRowValues(pathTestScenario, "BusinessFlow", "Test Case", testcase);
    	 System.out.println("Test Case: "+testcase+". Methods to be executed: "+executableMethods);
    	 return executableMethods;
    }
    
}
