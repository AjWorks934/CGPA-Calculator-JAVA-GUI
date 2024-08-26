# CGPA Calculator Application

## Overview 📚
The CGPA Calculator is a Java-based application designed to help students calculate their Cumulative Grade Point Average (CGPA) efficiently. Developed using Java and the Swing framework, the application provides a user-friendly interface for entering academic data and obtaining an accurate representation of overall academic performance.

<img src="https://github.com/user-attachments/assets/64045378-446a-4a68-b2e3-64c329fa4479" width="300" height="250" />
<img src="https://github.com/user-attachments/assets/f708f24c-9bc5-49d2-b8d7-31c967e3e4b8" width="300" height="250" />
<img src="https://github.com/user-attachments/assets/5c7c0420-20cc-496d-91aa-4eda3702f8db" width="300" heihgt="150" />
<img src="https://github.com/user-attachments/assets/19b7019e-e568-419f-959a-8f417b377cef" width="300" height="96" />



## Features ✨
- **User-Friendly Interface:** The application features an intuitive GUI developed using Java Swing, making it easy for users to input their academic data.
- **Accurate CGPA Calculation:** It calculates CGPA using weighted averages based on the credits and grades provided by the user.
- **SGPA Integration:** Users can also input the Semester Grade Point Average (SGPA) and total credits from previous semesters, which are factored into the CGPA calculation.
- **Input Validation:** The application validates user inputs, ensuring that all data is correctly formatted and within the expected ranges.
- **Error Handling:** Clear error messages are displayed for incorrect inputs, guiding the user to correct their entries.
- **Reset Functionality:** Users can reset the inputs and perform multiple calculations within the same session.

## How It Works ⚙️

### Core Functionality
The CGPA Calculator operates through a series of input prompts and validations:

1. **Subject Entry:**
   - Users specify the number of subjects.
   - For each subject, users enter the credit points and the score obtained out of 10.
   
2. **Previous Semesters Entry:**
   - Users can enter the number of previous semesters for which they want to include SGPA.
   - For each previous semester, users input the SGPA and total credits.

3. **GPA Calculation:**
   - The application calculates the CGPA using the formula and then displayed to the user.
     
$$
\text{CGPA} = \frac{\text{Total Grade Points (current + previous semesters)}}{\text{Total Credits (current + previous semesters)}}
$$

4. **Iteration:**
   - After displaying the result, the application prompts the user if they want to perform another calculation or exit.


### Key Functions
- **`calculateGPA()`**: Main function for computing the CGPA based on user inputs.
- **`getInput(String message, String errorMessage)`**: Method for obtaining a double input from the user.
- **`getInput1(String message, String errorMessage)`**: Method for obtaining an integer input from the user.
- **`resetInputs()`**: Resets the input fields and prepares the application for another calculation round.
- **`showError(String errorMessage)`**: Displays error messages in a dialog box.
- **`showExit(String exitMessage)`**: Displays an exit message when the application is closed.

| **Component**       | **Description**                                                                 |
|---------------------|---------------------------------------------------------------------------------|
| `GPAApp1`           | Main class that contains the GUI and application logic.                         |
| `frame`             | `JFrame` variable representing the main window of the application.              |
| `numSubjectsField`  | `JTextField` variable for user input of the number of subjects.                 |
| `calculateButton`   | `JButton` variable triggering the GPA calculation when clicked.                 |
| `resultLabel`       | `JLabel` variable displaying the calculated GPA result.                         |
| `GPAApp1()`         | Constructor method initializing the `JFrame` and creating the GUI components.   |
| `createUI()`        | Method to create and configure the UI components.                               |
| `calculateGPA()`    | Method for GPA calculation, user input validation, and result display.          |
| `getInput(String, String)` | Method for receiving a double input from the user.                       |
| `getInput1(String, String)`| Method for receiving an integer input from the user.                     |
| `resetInputs()`     | Method to reset input fields and result label.                                  |
| `showError(String)` | Method to display an error message dialog.                                      |
| `showExit(String)`  | Method to display an exit message dialog.                                       |
| `main(String[])`    | Main method, invoking the application using `SwingUtilities.invokeLater`.       |

## How to Run 🚀

### Prerequisites
- **Java Development Kit (JDK)**: Ensure you have the latest version of the JDK installed on your machine.

### Steps to Run
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/CGPA-Calculator.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd CGPA-Calculator
   ```
3. **Compile the Java File:**
   ```bash
   javac GPAApp1.java
   ```
4. **Run the Application:**
   ```bash
   java GPAApp1
   ```


