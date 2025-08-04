# QA Automation Assessment

This repository contains the technical solution for the QA Automation assessment. It includes UI test automation using Selenium WebDriver, TestNG, and Java.

## Tech Stack

- Java 21.0.8
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager
- Page Object Model design

---

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/ShaliniR9/SimplePracticeTask.git
cd SimplePracticeTask/
```

### 2. Prerequisites

- Java (JDK 11 or higher)
- Maven
- Chrome browser

### 3. Configure Properties

Update the `config.properties` file under `src/test/java/resources`:

```properties
email=your-email@example.com
password=your-password
taskName=Basic UI Test
description=Sample task creation and completion
date=08/01/2025
time=11:00 AM
clientName=John Doe
teamName=QA Team
```

### 4. Run Tests

```bash
mvn clean test
```

---

##  Project Structure

```
src
├── test
│   └── java
│       └── simpleTask           # Page Object classes
├── test
│   └── java
│       └── simpleTaskTest           # TestNG test classes
│
└── resources
    └──java
	└── config.properties
 	   			# Test data and login credentials
```

---

## Sample Test Case Flow

- Log in with credentials from `config.properties`
- Navigate to task page
- Create a new task
- Mark the task as complete
- Verify task completion status

---

## Author

Shalini,
QA Automation Engineer