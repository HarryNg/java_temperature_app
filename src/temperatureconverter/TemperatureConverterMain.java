package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterMain {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a temperature value and its unit of measurement (F or C): ");

        boolean start = true;

        do {
            String query = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(query)) {
                System.out.println("Program terminated. \n ```");
                start = false;
            } else {
                processInput(query);
            }
        }while (start);
    }

    public static void processInput(String input){
        String[] parts = input.split(" ");

        if(parts.length < 2){
            InputValidator.printInvalidInput();
        }else {
            String tempValue = parts[0];
            String unit = parts[1];

            if( InputValidator.isNumeric(tempValue) && unit.length()==1 ){
                double temperature = Integer.parseInt(tempValue);
                switch (unit.toLowerCase()){
                    case "c" -> System.out.println(tempValue+" C = "+ TemperatureConverter.tempConvert(temperature, true) +" F");
                    case "f" -> System.out.println(tempValue+" F = "+ TemperatureConverter.tempConvert(temperature, false) +" C");
                    default ->  InputValidator.printInvalidInput();
                }
            }else {
                InputValidator.printInvalidInput();
            }
        }
    }
}
