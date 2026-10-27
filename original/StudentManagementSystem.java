import java.util.*;

/**
 * Student Management System - Original Version (Intentional Code Quality Issues)
 * Created for Software Quality Assurance / Reengineering Assignment
 *
 * INTENTIONAL CODE QUALITY DEFECTS INCLUDED:
 * 1. Hardcoded Credentials / Security Hotspot (DB_PASSWORD, API_KEY)
 * 2. Poor naming conventions (variable names like s, x, a, m, method names like Calc_Avg)
 * 3. High Cyclomatic & Cognitive Complexity (searchAndProcessStudent has deeply nested ifs and loops)
 * 4. Duplicate Code (calculation and printing logic duplicated across methods)
 * 5. Weak/Empty Exception Handling (catch (Exception e) {} without logging or rethrowing)
 * 6. Unused Variables and Dead Code (tempCounter, unusedFlag)
 * 7. Hard-coded magic numbers (e.g., 40, 50, 100, 3.5 without constants)
 * 8. Potential NullPointerException / Bug (calling methods on nullable objects without checks)
 * 9. Standard output logging code smell (System.out.println instead of standard logger)
 * 10. Raw types / non-type-safe collections (List without generics)
 */
public class StudentManagementSystem {

    // Issue 1: Hardcoded credentials (Security Hotspot / Vulnerability)
    public static final String DB_PASSWORD = "EXAMPLE_PASSWORD_NOT_REAL";
    public static final String SECRET_API_KEY = "EXAMPLE_API_KEY_NOT_REAL";

    // Issue 2: Poor variable naming and raw type usage
    public static ArrayList sList = new ArrayList();
    public static int count = 0;

    // Issue 3: Unused class field (Code Smell)
    private static int unusedCounter = 999;

    public static void main(String[] args) {
        System.out.println("Starting Student Management System...");

        // Add sample students
        addStudent("S101", "Ali Khan", 85.5, "Computer Science");
        addStudent("S102", "Sara Ahmed", 92.0, "Software Engineering");
        addStudent("S103", "Bilal Tariq", 38.0, "Electrical Engineering");
        addStudent("S104", "Zainab Fatima", 74.5, "Data Science");

        // Display all students
        displayStudentInfo();

        // Calculate and display average
        Calc_Avg();

        // Find highest marks
        find_Highest();

        // Search student with complex nested logic
        searchAndProcessStudent("S102", true);

        // Weak exception handling demonstration
        riskyOperation(null);
    }

    // Function 1: Add student (Contains unused variables and magic numbers)
    public static void addStudent(String id, String name, double marks, String dept) {
        // Issue 4: Unused local variable
        int tempFlag = 1;
        String dummy = "dummy_val";

        // Issue 5: Weak validation using magic numbers
        if (marks >= 0 && marks <= 100) {
            Map student = new HashMap();
            student.put("id", id);
            student.put("name", name);
            student.put("marks", marks);
            student.put("dept", dept);

            // Magic number comparison
            if (marks < 40) {
                student.put("status", "FAIL");
            } else if (marks >= 40 && marks < 50) {
                student.put("status", "PROBATION");
            } else {
                student.put("status", "PASS");
            }

            sList.add(student);
            count++;
            System.out.println("Student added: " + name);
        } else {
            System.out.println("Invalid marks entered!");
        }
    }

    // Function 2: Calculate average marks (Poor method name & duplicate logic)
    public static void Calc_Avg() {
        double total = 0;
        int validCount = 0;

        // Duplicate code block 1 (Iterating and summing marks)
        for (int i = 0; i < sList.size(); i++) {
            Map st = (Map) sList.get(i);
            double m = (Double) st.get("marks");
            total = total + m;
            validCount++;
        }

        double avg = total / validCount;
        System.out.println("======================================");
        System.out.println("Total Students: " + validCount);
        System.out.println("Total Marks Sum: " + total);
        System.out.println("Average Marks of Students: " + avg);
        System.out.println("======================================");
    }

    // Function 3: Find highest marks (Duplicate iteration logic & poor variable naming)
    public static void find_Highest() {
        if (sList.size() == 0) {
            System.out.println("No records found.");
            return;
        }

        double max = -1.0;
        String topStudent = "";

        // Duplicate code block 2 (Similar iteration pattern repeated)
        for (int i = 0; i < sList.size(); i++) {
            Map st = (Map) sList.get(i);
            double m = (Double) st.get("marks");
            if (m > max) {
                max = m;
                topStudent = (String) st.get("name");
            }
        }

        System.out.println("======================================");
        System.out.println("Highest Marks: " + max);
        System.out.println("Topper Student Name: " + topStudent);
        System.out.println("======================================");
    }

    // Function 4: Display student information (Duplicated printing layout)
    public static void displayStudentInfo() {
        System.out.println("----------- Student List -----------");
        for (int i = 0; i < sList.size(); i++) {
            Map st = (Map) sList.get(i);
            // Issue 6: Verbose duplicate formatting
            System.out.println("ID: " + st.get("id") + " | Name: " + st.get("name") +
                               " | Marks: " + st.get("marks") + " | Dept: " + st.get("dept") +
                               " | Status: " + st.get("status"));
        }
        System.out.println("------------------------------------");
    }

    // Function 5: Search for a student (High Cyclomatic Complexity & Deep Nesting)
    public static void searchAndProcessStudent(String searchId, boolean generateReport) {
        boolean found = false;

        // Issue 7: High cyclomatic complexity (> 10) and cognitive complexity with nested conditions
        for (int i = 0; i < sList.size(); i++) {
            Map st = (Map) sList.get(i);
            String id = (String) st.get("id");

            if (id != null) {
                if (id.equalsIgnoreCase(searchId)) {
                    found = true;
                    System.out.println("Found student: " + st.get("name"));

                    if (generateReport) {
                        double marks = (Double) st.get("marks");
                        if (marks >= 80) {
                            System.out.println("Grade: A - Outstanding Performance");
                        } else {
                            if (marks >= 70) {
                                System.out.println("Grade: B - Very Good");
                            } else {
                                if (marks >= 60) {
                                    System.out.println("Grade: C - Satisfactory");
                                } else {
                                    if (marks >= 50) {
                                        System.out.println("Grade: D - Pass");
                                    } else {
                                        System.out.println("Grade: F - Failed");
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Student with ID " + searchId + " not found.");
        }
    }

    // Issue 8: Weak exception handling and Null Pointer Risk (Bug)
    public static void riskyOperation(String input) {
        try {
            // Issue: Potential NullPointerException if input is null
            if (input.equals("TEST")) {
                System.out.println("Matching test string");
            }
        } catch (Exception e) {
            // Issue: Empty catch block (Sonar Code Smell / Bug: Either rethrow or log)
        }
    }
}
