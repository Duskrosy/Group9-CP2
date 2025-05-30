## Group 9 CP2

GUI-Trial and better file-handling for the MotorPH App

##  *How to Run*

1. Make sure you have **Java 17+** and **Maven** installed.

```Here's the link to download Java
https://www.oracle.com/ph/java/technologies/downloads/
```
```Here's how to install Maven:
https://phoenixnap.com/kb/install-maven-windows
```
3. Clone the project or download the ZIP.
4. From the root directory, run:


```bash
mvn clean compile exec:java
```

## **Use credentials from login.txt to log in**

Example Admin - **EID: 10000 PW: admin1234**

Example User - **EID: 10001 PW: password123**

## 🧾 Features

- **Login System**  
  - Secure login using `employeeID` and password  
  - Admin and User role-based access control  
- **Employee Dashboard**  
  - My Info panel: displays personal and employment details  
  - Time Tracker: logs time-in and time-out, flags late entries  
  - Payroll panel: filters payroll entries by ID and cutoff date  
  - Admins can view all employees' data  
- **Dynamic File-Based Storage**  
  - Reads from and writes to `employee_data.txt`, `login.txt`, and `payroll_data.txt`  
  - Appends new time logs and uses them to compute cut-off-based payroll  
- **UI Components**  
  - Swing GUI with tabbed interface  
  - Logout tab styled in red and placed at the far-right  
  - Tables dynamically render data from files with formatting (e.g., ₱ currency sign)

##**What I'm proud of honestly:**
- Cutoff periods are automatically determined by date (15 and 30 of each month).
- Payroll entries are automatically captured using the Time Tracker.
- You can toggle 12-hour and 24-hour formats in the Time Tracker.

## Group Members:
- Gavril (Pogi)
- DAYANG GWAPA

## Built With
Java (JDK 17)
Maven
Swing (javax.swing)

