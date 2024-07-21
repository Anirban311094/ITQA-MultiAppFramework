package com.executor;

import com.Applications.Google.bussinesscomponents.Google_Keywords;
import com.Results.GenerateReport.Report;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.SetupAuxiliaries.excelhandle.*;

public class Executor {
	
	public String tc_Name;
	public static WebDriver driver;
	static HandleExecutables excelhandle=new HandleExecutables();
    public static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\Rahul Chakrabarty\\git\\ITQA-MultiAppFramework\\MultiAppFramework\\src\\main\\java\\com\\BrowserDrivers\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Rahul Chakrabarty\\git\\ITQA-MultiAppFramework\\MultiAppFramework\\src\\main\\resources\\chrome-win64\\chrome.exe");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(service, options);
    }

    public static void main(String[] args) {
        try {
        	com.SetupAuxiliaries.consolehandle.ConsoleHandles.console_Handles();
            driver = initializeDriver();
            Google_Keywords.driver = driver; // Set the driver in Google_Keywords
            System.out.println("|  |Launch|  |");
            execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred during execution!");
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("|  |Done|  |");
            }
        }
    }

    public static void execute() throws Exception {
       System.out.println("execute()");
       //Report report = null;
       excelhandle.getExecutableTestCases().forEach(testcase->{
        	System.out.println("For Test Case: "+testcase);
//        	try {
//				com.Results.GenerateReport.PassInfos.setCurrentTestCaseName(testcase);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			Report report = new Report();
        	try {
        		excelhandle.getExecutableMethods(testcase).forEach(method->{
					try {
						String methodExecute=excelhandle.getExecutableMethodPath(method);
						executeMethod(methodExecute);
						System.out.println("For getExecutableMethods - Try!");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("getExecutableMethods - Catch!");
					}
				});
				System.out.println("getExecutableMethods - Try!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("getExecutableMethods - Catch!");
			}finally {
//				 if (report != null) {
//	                    // Finalize report after all test case steps are executed
//	                    report.finalizeReport(report.getTestSteps().isEmpty() ? "Skipped" : "Failed");
//	                }
	        }
        });
    }
    
    public static void executeMethod(String methodExecute) throws Exception{
    	
    	System.out.println("executeMethod: '" + methodExecute + "'");

    	  // Split the class name and method name
    	  String className = methodExecute.substring(0, methodExecute.lastIndexOf('.'));
    	  System.out.println("executeMethod 1");
    	  String methodName = methodExecute.substring(methodExecute.lastIndexOf('.') + 1);
    	  System.out.println("executeMethod 2");

    	  // Load the class
    	  Class<?> clazz = Class.forName(className);
    	  System.out.println("executeMethod 3");

    	  // Create an instance of the class (assuming a default constructor)
    	  Object obj = clazz.getConstructor().newInstance(); 
    	  System.out.println("executeMethod 4 (Created object instance)");

    	  // Get the method
    	  Method method = clazz.getMethod(methodName);
    	  System.out.println("executeMethod 5");

    	  // Invoke the method on the object instance
    	  method.invoke(obj);
    	  System.out.println("executeMethod 6");
    	
//    	System.out.println("executeMethod: '"+methodExecute+"'");
//    	 // Split the class name and method name
//        String className = methodExecute.substring(0, methodExecute.lastIndexOf('.'));
//        System.out.println("executeMethod 1");
//        String methodName = methodExecute.substring(methodExecute.lastIndexOf('.') + 1);
//        System.out.println("executeMethod 2");
//        // Load the class
//        Class<?> clazz = Class.forName(className);
//        System.out.println("executeMethod 3");
//        // Get the method
//        Method method = clazz.getMethod(methodName);
//        System.out.println("executeMethod 4");
//        // Invoke the method
//        method.invoke(null);  // null because loging is a static method
//        System.out.println("executeMethod 5");
    }
    
    
    
   
   
    
}
