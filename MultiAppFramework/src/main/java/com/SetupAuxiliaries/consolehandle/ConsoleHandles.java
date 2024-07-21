package com.SetupAuxiliaries.consolehandle;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConsoleHandles {

	public static void console_Handles() throws Exception{
		FileOutputStream errFile = new FileOutputStream("errors.txt", true); // Append mode
        PrintStream errPrintStream = new PrintStream(errFile);
        System.setErr(errPrintStream);

        // Redirect System.out to a custom PrintStream
        PrintStream customPrintStream = new CustomPrintStream(System.out, new FileOutputStream("output.txt", false)); // Overwrite mode
        System.setOut(customPrintStream);
	}
}
