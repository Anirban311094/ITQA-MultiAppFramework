package com.Results.GenerateReport;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {

    private final List<TestStep> testSteps;
    private String testCaseName;
    private String startTime;
    private String endTime;
    private String finalResult;
    private final String reportFolderPath;
    private final String screenshotFolderPath;

    
    public Report() {
        this.testSteps = new ArrayList<>();
        this.testCaseName = com.Results.GenerateReport.PassInfos.getCurrentTestCaseName();
        startTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        reportFolderPath = createReportFolder();
        screenshotFolderPath = reportFolderPath + File.separator + "screenshot";
        new File(screenshotFolderPath).mkdirs(); // Create screenshot folder
    }

    private String createReportFolder() {
        String folderPath = "CurrentExecution" + File.separator + "reportFolder-" + startTime;
        new File(folderPath).mkdirs();
        return folderPath;
    }

    public void updateTestLog(String step, String description, Status status) {
        getTestSteps().add(new TestStep(step, description, status));
        if (status == Status.SCREENSHOT) {
            // Capture screenshot logic goes here and save to screenshot folder
        }
    }

    public void finalizeReport(String finalResult) {
        this.finalResult = finalResult;
        endTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        generateHTMLReport();
    }

    private void generateHTMLReport() {
        String filePath = reportFolderPath + File.separator + "report.html";
        StringBuilder reportContent = new StringBuilder();

        // Build HTML report structure with header, table, and footer
        reportContent.append("<html><head><title>Test Case Report</title></head><body>");
        reportContent.append("<h1>Test Case: ").append(testCaseName).append("</h1>");
        reportContent.append("<p>Start Time: ").append(startTime).append("</p>");
        reportContent.append("<p>End Time: ").append(endTime).append("</p>");
        reportContent.append("<table><tr>");
        reportContent.append("<th>Serial No.</th><th>Test Step</th><th>Description</th><th>Step Result</th><th>Screenshot</th></tr>");
        for (TestStep step : getTestSteps()) {
            reportContent.append("<tr><td>").append(step.getSerialNo()).append("</td>");
            reportContent.append("<td>").append(step.getStep()).append("</td>");
            reportContent.append("<td>").append(step.getDescription()).append("</td>");
            reportContent.append("<td>").append(step.getResult()).append("</td>");
            reportContent.append("<td>").append(step.getScreenshotPath()).append("</td></tr>");
        }
        reportContent.append("</table>");
        reportContent.append("<p>Final Result: ").append(finalResult).append("</p>");
        reportContent.append("</body></html>");

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(reportContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TestStep> getTestSteps() {
		return testSteps;
	}

	private class TestStep {
        private final String step;
        private final String description;
        private final Status status;
        private final int serialNo;
        private String screenshotPath;

        public TestStep(String step, String description, Status status) {
            this.step = step;
            this.description = description;
            this.status = status;
            this.serialNo = getTestSteps().size() + 1;
            this.screenshotPath = ""; // Set screenshot path if captured
        }

        public String getSerialNo() {
            return String.valueOf(serialNo);
        }

        public String getStep() {
            return step;
        }

        public String getDescription() {
            return description;
        }

        public String getResult() {
            return status.name();
        }

        public String getScreenshotPath() {
            return screenshotPath;
        }
    }
}
