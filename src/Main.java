import temperatureconverter.TemperatureConverterMain;

import java.util.Scanner;

import static studentgrade.StudentGradeMain.run;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a temperature value and its unit of measurement (F or C): ");
        boolean start = true;

        System.out.println("Welcome to the Main Application");
        System.out.println("1: Temperature Converter");
        System.out.println("2: Student Grade Management");
        System.out.println("Type 'exit' to terminate");

        do {
            System.out.print("[Main] Select an option: ");
            String[] query = scanner.nextLine().split(" ");
            String firstInput = query[0];
            switch(firstInput){
                case "exit" -> {
                    System.out.println("[Main] Program terminated. \n ```");
                    start = false;
                }
                case "1" -> TemperatureConverterMain.run();
                case "2" -> run();
                default -> System.out.println("Invalid option. Please enter 1, 2, or 'exit'. ");
            }
        }while (start);
    }


}