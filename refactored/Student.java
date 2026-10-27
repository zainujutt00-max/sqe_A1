package refactored;

import java.util.Objects;

/**
 * Model class representing a Student entity.
 * Provides encapsulation, type safety, and clean domain representation.
 */
public class Student {
    private final String id;
    private final String name;
    private final double marks;
    private final String department;

    public Student(String id, String name, double marks, String department) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty.");
        }
        if (marks < 0.0 || marks > 100.0) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.id = id.trim();
        this.name = name.trim();
        this.marks = marks;
        this.department = department != null ? department.trim() : "Undeclared";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getDepartment() {
        return department;
    }

    public String getAcademicStatus() {
        if (marks < 40.0) {
            return "FAIL";
        } else if (marks < 50.0) {
            return "PROBATION";
        } else {
            return "PASS";
        }
    }

    public String calculateGrade() {
        if (marks >= 80.0) {
            return "A - Outstanding Performance";
        } else if (marks >= 70.0) {
            return "B - Very Good";
        } else if (marks >= 60.0) {
            return "C - Satisfactory";
        } else if (marks >= 50.0) {
            return "D - Pass";
        } else {
            return "F - Failed";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("ID: %-6s | Name: %-16s | Marks: %5.1f | Dept: %-22s | Status: %s",
                id, name, marks, department, getAcademicStatus());
    }
}
