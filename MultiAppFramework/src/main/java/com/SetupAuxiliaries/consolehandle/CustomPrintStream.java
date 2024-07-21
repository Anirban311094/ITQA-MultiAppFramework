package com.SetupAuxiliaries.consolehandle;


import java.io.FileOutputStream;
import java.io.PrintStream;

public class CustomPrintStream extends PrintStream {
    private final PrintStream consolePrintStream;
    private final PrintStream filePrintStream;

    public CustomPrintStream(PrintStream consolePrintStream, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.consolePrintStream = consolePrintStream;
        this.filePrintStream = new PrintStream(fileOutputStream);
    }

    @Override
    public void println(String x) {
        consolePrintStream.println(x); // Print to console
        filePrintStream.println(x);    // Write to file
    }

    @Override
    public void print(String x) {
        filePrintStream.print(x); // Write to file only
    }

    @Override
    public void print(Object obj) {
        filePrintStream.print(obj); // Write to file only
    }

    // Override other print methods as needed
}

