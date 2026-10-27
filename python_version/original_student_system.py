"""
Student Management System - Python Version (Intentional Code Quality Issues)
Software Quality Assurance / Software Reengineering Assignment
"""

# Issue 1: Hardcoded credentials (Security Hotspot)
DB_PASSWORD = "EXAMPLE_PASSWORD_NOT_REAL"
API_KEY = "EXAMPLE_API_KEY_NOT_REAL"

# Issue 2: Poor global variable name and unused variable
s_list = []
unused_counter = 999


def add_student(s_id, name, marks, dept):
    # Issue 3: Unused local variable
    temp_flag = 1
    dummy = "dummy_val"

    # Issue 4: Magic numbers and weak validation
    if 0 <= marks <= 100:
        student = {"id": s_id, "name": name, "marks": marks, "dept": dept}
        if marks < 40:
            student["status"] = "FAIL"
        elif 40 <= marks < 50:
            student["status"] = "PROBATION"
        else:
            student["status"] = "PASS"
        s_list.append(student)
        print("Student added: " + name)
    else:
        print("Invalid marks entered!")


# Issue 5: Non-standard naming convention
def Calc_Avg():
    total = 0
    valid_count = 0
    # Duplicate iteration pattern
    for st in s_list:
        m = st["marks"]
        total = total + m
        valid_count += 1

    avg = total / valid_count if valid_count > 0 else 0
    print("======================================")
    print("Total Students: " + str(valid_count))
    print("Average Marks: " + str(avg))
    print("======================================")


def find_Highest():
    if len(s_list) == 0:
        return
    max_m = -1
    topper = ""
    # Duplicate iteration pattern
    for st in s_list:
        if st["marks"] > max_m:
            max_m = st["marks"]
            topper = st["name"]
    print("Highest Marks: " + str(max_m))
    print("Topper: " + topper)


# Issue 6: High Cyclomatic and Cognitive Complexity
def search_and_process_student(search_id, generate_report):
    found = False
    for st in s_list:
        s_id = st.get("id")
        if s_id is not None:
            if s_id.lower() == search_id.lower():
                found = True
                print("Found: " + st["name"])
                if generate_report:
                    marks = st["marks"]
                    if marks >= 80:
                        print("Grade: A")
                    else:
                        if marks >= 70:
                            print("Grade: B")
                        else:
                            if marks >= 60:
                                print("Grade: C")
                            else:
                                if marks >= 50:
                                    print("Grade: D")
                                else:
                                    print("Grade: F")
                break
    if not found:
        print("Student not found.")


# Issue 7: Broad exception catching without handling (empty except)
def risky_operation(val):
    try:
        if len(val) > 0:
            print("String present")
    except:
        pass


if __name__ == "__main__":
    add_student("S101", "Ali Khan", 85.5, "Computer Science")
    add_student("S102", "Sara Ahmed", 92.0, "Software Engineering")
    Calc_Avg()
    find_Highest()
    search_and_process_student("S102", True)
    risky_operation(None)
