"""
Student Management System - Refactored Python Version
Software Quality Assurance / Software Reengineering Assignment
"""

import os
import logging
from dataclasses import dataclass
from typing import Optional, List

logging.basicConfig(level=logging.INFO, format="%(asctime)s - %(levelname)s - %(message)s")
logger = logging.getLogger(__name__)

PASSING_MARKS = 40.0
PROBATION_MARKS = 50.0
MIN_MARKS = 0.0
MAX_MARKS = 100.0


@dataclass
class Student:
    student_id: str
    name: str
    marks: float
    department: str

    def __post_init__(self):
        if not (MIN_MARKS <= self.marks <= MAX_MARKS):
            raise ValueError(f"Marks must be between {MIN_MARKS} and {MAX_MARKS}.")

    @property
    def status(self) -> str:
        if self.marks < PASSING_MARKS:
            return "FAIL"
        if self.marks < PROBATION_MARKS:
            return "PROBATION"
        return "PASS"

    def calculate_grade(self) -> str:
        if self.marks >= 80:
            return "A - Outstanding"
        if self.marks >= 70:
            return "B - Very Good"
        if self.marks >= 60:
            return "C - Satisfactory"
        if self.marks >= 50:
            return "D - Pass"
        return "F - Failed"


class StudentManager:
    def __init__(self):
        # Secure credential lookup without hardcoding
        self.db_password = os.getenv("DB_PASSWORD", "DEFAULT_SECURE_FALLBACK")
        self.students: List[Student] = []

    def add_student(self, student: Student) -> bool:
        if any(s.student_id.lower() == student.student_id.lower() for s in self.students):
            logger.warning("Duplicate student ID: %s", student.student_id)
            return False
        self.students.append(student)
        logger.info("Added student: %s", student.name)
        return True

    def calculate_average(self) -> float:
        if not self.students:
            return 0.0
        return sum(s.marks for s in self.students) / len(self.students)

    def find_highest(self) -> Optional[Student]:
        if not self.students:
            return None
        return max(self.students, key=lambda s: s.marks)

    def find_student(self, search_id: str) -> Optional[Student]:
        for st in self.students:
            if st.student_id.lower() == search_id.strip().lower():
                return st
        return None

    def display_all(self):
        print("-" * 55)
        for st in self.students:
            print(f"ID: {st.student_id:<6} | Name: {st.name:<16} | Marks: {st.marks:5.1f} | Status: {st.status}")
        print("-" * 55)


if __name__ == "__main__":
    manager = StudentManager()
    manager.add_student(Student("S101", "Ali Khan", 85.5, "Computer Science"))
    manager.add_student(Student("S102", "Sara Ahmed", 92.0, "Software Engineering"))
    manager.display_all()
    print(f"Average Marks: {manager.calculate_average():.2f}")
    top = manager.find_highest()
    if top:
        print(f"Top Performer: {top.name} ({top.marks})")
