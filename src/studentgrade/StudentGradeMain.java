package studentgrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeMain {
    public static String getStudentDetail(Scanner scanner, String prompt){
        while(true){
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("exit")){
                System.out.println("Program is terminated. \n");
                System.exit(0);
            }
            return input;
        }
    }
    private static class Student{
        int id;
        String name;
        int age;

        public Student(int id, String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    private static Map<Integer,Student> students = new HashMap<>();

    private static void addStudent(int id, String name, int age){
        Student student = new Student(id, name, age);
        students.put(id,student);
        System.out.println("Student added: "+ name);
    }
    public static void run(){
        Scanner scanner = new Scanner(System.in);

        //    Add New Student
        //    Prompt the user to input student details (ID, name, and age).
        int id = Integer.parseInt(getStudentDetail(scanner,"Please enter student ID: "));
        String name = getStudentDetail(scanner, "Please enter student name: ");
        int age = Integer.parseInt(getStudentDetail(scanner, "Please enter student age: "));

        //    Store the student details in a collection.
        addStudent(id, name, age);

    }
}

//


//    Add Grades:
//
//    Prompt the user to input the student ID and the course name.
//    Allow the user to input multiple grades for a student in a course.
//    Store the grades in a way that they can be retrieved for calculations.
//    Calculate Average Grade:
//
//    Calculate the average grade for a student in a specific course.
//    Display Student Information:
//
//    Display the details of a student along with their grades and average grades for each course.
//    Save to File:
//
//    Save all student information and their grades to a file.
//    Load from File:
//
//    Load student information and their grades from a file.
//    Handle Invalid Inputs:
//
//    Display appropriate error messages for invalid inputs and prompt the user to enter valid data.
//    Exit Program:
//
//    Provide an option to exit the program.