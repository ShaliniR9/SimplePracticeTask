# TASKS CHECKLIST

This file documents the analytical checklist completed as part of the QA assessment.

---

### Functional Test Automation Tasks

-  Automate login functionality with valid credentials
  - If wrong credentials are provided the login shouldn't successful
-  Create a new task using form inputs (name, description, date, time, clientName, teamName)
  - If the mandatory fields are not filled in, an error message should appear and user 
-  Save the task and verify successful creation
-  Apply filters (Assigned To, Status)
-  Mark task as "Completed"
  - If the task is incomplete, the task should be under incomplete list
-  Validate task status as "Completed" in the UI

---

### Technical Implementation

-  Used Page Object Model
-  Implemented WebDriverWait for reliable waits
-  Parameterized test data using `config.properties`
-  Used TestNG framework
-  Implemented proper locator strategies (XPath, CSS, ID & ClassName)
-  Code optimized and structured for maintainability

---

### Assumptions Made

- Credentials and test data are read from a local config file
- The environment is assumed to be stable without random UI changes
---

### Final Note

All functional flows are automated and successfully verified through test runs.