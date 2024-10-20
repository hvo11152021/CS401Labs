package lesson10.labs.prob1.bugreporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import lesson10.labs.prob1.classfinder.ClassFinder;

/**
 * This class scans the package lesson10.labs.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report
 * bugreport.txt, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lesson10.labs.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		
        Map<String, List<String>> reportMap = new HashMap<>(); // I found hash map useful for this
        
        for (Class<?> cl : classes) {
            if (cl.isAnnotationPresent(BugReport.class)) {
                BugReport annotation = cl.getAnnotation(BugReport.class);
                String assignedTo = annotation.assignedTo();
                
                String reportDetails = CLASS_NAME + cl.getSimpleName() + ", " +
                                       REPORTED_BY + annotation.reportedBy() + ", " +
                                       DESCRIPTION + annotation.description() + ", " +
                                       SEVERITY + annotation.severity();
                                       
                reportMap.computeIfAbsent(assignedTo, k -> new ArrayList<>()).add(reportDetails);
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_NAME))) {
            for (Map.Entry<String, List<String>> entry : reportMap.entrySet()) {
                String assignedTo = entry.getKey();
                writer.write("Assigned To: " + assignedTo);
                writer.newLine();
                
                for (String report : entry.getValue()) {
                    writer.write(report);
                    writer.newLine();
                }
                
                writer.write("-------------------------");
                writer.newLine();
            }
        } catch (IOException e) {
            LOG.severe("Error: " + e.getMessage());
        }
        
        for (Map.Entry<String, List<String>> entry : reportMap.entrySet()) {
            String assignedTo = entry.getKey();
            System.out.println("Assigned To: " + assignedTo);
            
            for (String report : entry.getValue()) {
                System.out.println(report);
            }
            
            System.out.println("-------------------------");
        }
	}
	
	
}
