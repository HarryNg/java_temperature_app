package studentgrade;

import java.util.*;

public class StudentGradeMain {
    private static final String EXIT_COMMAND = "exit";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a valid options or type 'exit' to terminate.";
    private static final String INPUT_NOT_FOUND_MESSAGE = "Student not found. Please re-pick the option and provide a correct ID";
    private static final String OPERATION_PROMPT = """
            Please pick your options:   
            1: Add new student  
            2: Add grades  
            3: Calculate average grade  
            4: Display student information 
            5: Save to file  
            6: Load from file  
            exit: Exit program""";
    private static final String STUDENT_ID_PROMPT = "Please enter student ID: ";
    private static final String SUCCESS_PROMPT = """
    
    Operation completed. Please pick another options to continue or 'exit' to terminate program. 
    1: Add Student 2: Add grades 3: Average 4: Display student info 5: Save to file 6: Load exit: Exit.
    """;
    public static void allowExit(String str){
        if(str.equalsIgnoreCase(EXIT_COMMAND)){
            System.out.println("Program is terminated. \n");
            System.exit(0);
        }
    }
    public static String getStudentDetail(Scanner scanner, String prompt){
        while(true){
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            allowExit(input);
            return input;
        }
    }
    public static List<Double> getGrades(Scanner scanner, String prompt){
        while(true){
            System.out.println(prompt);
            String[] inputs = scanner.nextLine().trim().split(" ");
            String input = inputs[0];
            allowExit(input);

            try{
                List<Double> grades = new ArrayList<>();
                for (String grade:inputs){
                    grades.add(Double.parseDouble(grade));
                }
                return grades;
            }catch (NumberFormatException e){
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }
    private static class Course{
        String courseName;

        public Course(String courseName){
            this.courseName = courseName;
        }

        @Override
        public String toString(){
            return courseName;
        }
    }
    private static class Student{
        int id;
        String name;
        int age;
        Map<Course, List<Double>> grades;

        public Student(int id, String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
            this.grades = new HashMap<>();
        }

        @Override
        public String toString(){
            return "ID: "+ id + " Name: " + name + " Age: " +age + " Grade: "+grades;
        }

        public void addGrade(Course course, double grade){
            if(!grades.containsKey(course)){
                grades.put(course, new ArrayList<>());
            }
            grades.get(course).add(grade);
        }
        public void addGrades(Course course, List<Double> grade){
            if(!grades.containsKey(course)){
                grades.put(course, new ArrayList<>());
            }
            grades.get(course).addAll(grade);
        }
    }

    private static Map<Integer,Student> students = new HashMap<>();
    private static Map<String,Course> courses = new HashMap<>();

    private static boolean isStudent(int id){
        return students.containsKey(id);
    }
    private static void addStudent(int id, String name, int age){
        Student student = new Student(id, name, age);
        students.put(id,student);
        System.out.println("Student added: "+ name);
        System.out.println(SUCCESS_PROMPT);
    }

    private static void getStudent(int id){
        if(isStudent(id)){
            System.out.println(students.get(id).toString());
            System.out.println(SUCCESS_PROMPT);
        }else {
            System.out.println(INPUT_NOT_FOUND_MESSAGE);
        }
    }

    private static void addGrade(int id, String courseName, List<Double> grade){
        if(isStudent(id)){
            Course course = courses.get(courseName);
            if(course==null){
                course = new Course(courseName);
                courses.put(courseName, course);
            }
            students.get(id).addGrades(course,grade);
            students.get(id).toString();
            System.out.println(SUCCESS_PROMPT);
        }else {
            System.out.println(INPUT_NOT_FOUND_MESSAGE);
        }

    }
    public static void run(){
        boolean continueRunning = true;
        System.out.println(OPERATION_PROMPT);

        Scanner scanner = new Scanner(System.in);

        do{
            String input = scanner.nextLine().trim();
            switch (input.toLowerCase()){
                case EXIT_COMMAND -> {
                    System.out.println(EXIT_COMMAND);
                    continueRunning = false;
                }
                case "1" -> {
                    //    Prompt the user to input student details (ID, name, and age).
                    int id = Integer.parseInt(getStudentDetail(scanner,STUDENT_ID_PROMPT));
                    String name = getStudentDetail(scanner, "Please enter student name: ");
                    int age = Integer.parseInt(getStudentDetail(scanner, "Please enter student age: "));

                    //    Store the student details in a collection.
                    addStudent(id, name, age);
                }
                case "2" -> {
                    //    Prompt the user to input the student ID and the course name.
                    int id = Integer.parseInt((getStudentDetail(scanner,STUDENT_ID_PROMPT )));
                    String courseName = getStudentDetail(scanner,"Please enter course name ");
                    List<Double> grade = getGrades(scanner,"Please enter student grade ");
                    addGrade(id,courseName,grade);

                }
                case "4" -> {
                    int id = Integer.parseInt((getStudentDetail(scanner,STUDENT_ID_PROMPT )));
                    getStudent(id);
                }
                default -> System.out.println(INVALID_INPUT_MESSAGE);
            }

//            getStudent(id);
        }while (continueRunning);


        //    Add Grades:


        //    Allow the user to input multiple grades for a student in a course.
        //    Store the grades in a way that they can be retrieved for calculations.
    }
}

//



//

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