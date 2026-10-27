# Intentional bugs for the SQA assignment

The original Java version contains deliberately faulty teaching examples. The
refactored version is the comparison implementation. Do not use the original
version as production code.

Compile from the repository root:

```powershell
javac original/StudentManagementSystem.java
```

Run each example separately (the first three terminate with an exception):

```powershell
java -cp original StudentManagementSystem --bug-demo null
java -cp original StudentManagementSystem --bug-demo bounds
java -cp original StudentManagementSystem --bug-demo divide
java -cp original StudentManagementSystem --bug-demo string
java -cp original StudentManagementSystem --bug-demo self-assignment
```

| Case | Intentional defect | Observable result |
| --- | --- | --- |
| null | Dereference a name returned as null | NullPointerException |
| bounds | Access an array at its length | ArrayIndexOutOfBoundsException |
| divide | Divide integers by a known zero count | ArithmeticException |
| string | Compare String references with == | false although the IDs have equal text |
| self-assignment | Assign a variable to itself instead of updating its value | Marks remain 40 |

These examples provide candidates for static analysis. Actual SonarQube
findings and classifications depend on the analyzer and active quality profile;
run a fresh scan to obtain verified results. Existing report figures are not
validation of these newly added examples.
