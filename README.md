# Temperature Converter

You are tasked to develop a temperature converter program in Java. The program will accept temperature values in Fahrenheit, Celsius, and convert them to their corresponding values in the other units.

## Requirements

1. Prompt the user to input a temperature value and a temperature scale (either Celsius or Fahrenheit).
2. Convert the temperature to the opposite scale and display the result.
3. Handle invalid user inputs by displaying an error message and prompting the user to enter valid inputs.
4. Write a function called `tempConvert` to perform the temperature conversions.
5. Use `switch` statement to determine which conversion function to use based on the user's input for the temperature scale.
6. Application should run continuously, but have option to terminate the program.
7. Upload a screenshot in the PR of testing application in your terminal.

## Examples

Your program does not need to look exactly like the example below, but should have similar features

````
Please enter a temperature value and its unit of measurement (F or C):
45 F
45 F = 7.22 C

Please enter a temperature value and its unit of measurement (F or C):
input C
Invalid input. Please enter a valid temperature value and its unit of measurement (F or C):

Please enter a temperature value and its unit of measurement (F or C):
30 X
Invalid input. Please enter a valid temperature value and its unit of measurement (F or C):

Please enter a temperature value and its unit of measurement (F or C):
exit

Program terminated.

````
---
### Student Grade Management System (Optional)

You are tasked with developing a Student Grade Management System. The program will allow users (teachers) to manage student information and grades. The system should be able to perform the following tasks:

#### Requirements
1. **Add New Student**:
    - Prompt the user to input student details (ID, name, and age).
    - Store the student details in a collection.

2. **Add Grades**:
    - Prompt the user to input the student ID and the course name.
    - Allow the user to input multiple grades for a student in a course.
    - Store the grades in a way that they can be retrieved for calculations.

3. **Calculate Average Grade**:
    - Calculate the average grade for a student in a specific course.

4. **Display Student Information**:
    - Display the details of a student along with their grades and average grades for each course.

5. **Save to File**:
    - Save all student information and their grades to a file.

6. **Load from File**:
    - Load student information and their grades from a file.

7. **Handle Invalid Inputs**:
    - Display appropriate error messages for invalid inputs and prompt the user to enter valid data.

8. **Exit Program**:
    - Provide an option to exit the program.
