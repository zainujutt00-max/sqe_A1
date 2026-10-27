# Step-by-Step Guide: Capturing the 7 Required SonarQube Screenshots

This guide walks you through the easiest and most effective ways to run static analysis on the created code and take the **7 required screenshots** for your assignment submission.

---

## 🎯 The 7 Screenshots You Need:

| # | Screenshot Name | Where to find it | What it should display |
|---|---|---|---|
| **1** | **SonarQube Project Dashboard** | Project Overview page | Overall score card showing **Quality Gate: FAILED**, Bugs (1), Vulnerabilities (1), Hotspots (1), Code Smells (8), Duplications (14.8%). |
| **2** | **Bugs Identified** | **Issues** tab -> Filter: `Bug` | Rule: *"A 'NullPointerException' could be thrown; 'input' is nullable here"* on line 169. |
| **3** | **Vulnerabilities / Security Hotspots** | **Security Hotspots** tab | Rule: *"Hard-coded credentials are security-sensitive"* on line 22 (`DB_PASSWORD`). |
| **4** | **Code Smells** | **Issues** tab -> Filter: `Code Smell` | List of issues (Cognitive Complexity > 15, empty catch block, unused variables, naming conventions). |
| **5** | **Duplicated Code** | **Measures** tab -> `Duplications` | Duplication percentage (14.8%) and highlighted duplicate loop blocks. |
| **6** | **Quality Gate** | **Quality Gates** tab | Criteria that caused the project to fail (Security Hotspot unreviewed, maintainability rating). |
| **7** | **Detailed Issue Explanation & Suggested Fix** | Click on any issue in SonarQube | The Rule view showing **"Why is this an issue?"**, **"How can I fix it?"**, and the **"Compliant Solution"** code snippet. |

---

## 🚀 Option 1: Using SonarCloud (Recommended & Free, Zero Installation)

SonarCloud is SonarQube hosted in the cloud by SonarSource. It has the exact same engine and UI:

1. **Upload your code to GitHub:**
   - Create a free public repository on GitHub named `sonarqube-student-management`.
   - Commit the files from the `original/` folder:
     - `StudentManagementSystem.java`
     - `sonar-project.properties`
2. **Log into SonarCloud:**
   - Go to [https://sonarcloud.io](https://sonarcloud.io).
   - Click **Log in** with GitHub.
3. **Import Project:**
   - Click **"+"** in the top right -> **Analyze new project**.
   - Select your GitHub repository.
   - SonarCloud will run automatic analysis within 30 seconds.
4. **Capture Screenshots 1 to 7:**
   - Follow the table above and take clear screenshots using `Windows Key + Shift + S`.
5. **After Refactoring (Before/After comparison):**
   - Push the files from `refactored/` (`StudentManagementSystem.java` and `Student.java`).
   - Re-run analysis or wait for the automatic scan.
   - Capture the new green **Quality Gate: PASSED** dashboard.

---

## 💻 Option 2: Using VS Code SonarLint (Instant Local Analysis)

Since VS Code is already installed on your PC:

1. Open VS Code.
2. Go to **Extensions** (`Ctrl + Shift + X`) and search for **SonarLint** (by SonarSource).
3. Click **Install**.
4. Open the file:
   `C:\Users\HP 840 G5\.gemini\antigravity\scratch\sonarqube_assignment\original\StudentManagementSystem.java`
5. In VS Code:
   - Click on any underlined line (e.g. `DB_PASSWORD`, `catch (Exception e) {}`, or `Calc_Avg`).
   - In the bottom panel, open the **SonarLint** tab.
   - You will see the complete breakdown of rules, why it is an issue, and the suggested compliant fix!
   - This provides the exact Sonar rule descriptions for **Screenshot 7** and all individual issues.

---

## 🖥️ Option 3: Running SonarQube Community Edition Locally

If your instructor specifically requires the local `http://localhost:9000` SonarQube interface:

1. Download **SonarQube Community Build (ZIP)** from:
   [https://www.sonarsource.com/products/sonarqube/downloads/](https://www.sonarsource.com/products/sonarqube/downloads/)
2. Extract the ZIP file (e.g. to `C:\sonarqube`).
3. Open `C:\sonarqube\bin\windows-x86-64\StartSonar.bat` in command prompt to start the server.
4. Open your browser at `http://localhost:9000` (Default credentials: login `admin`, password `admin`).
5. Download **SonarScanner CLI for Windows**:
   [https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/](https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner/)
6. In PowerShell, navigate to:
   `C:\Users\HP 840 G5\.gemini\antigravity\scratch\sonarqube_assignment\original`
   and run:
   ```powershell
   sonar-scanner
   ```
7. Refresh `http://localhost:9000` to view and screenshot your project!
