package temperatureconverter;

public class InputValidator {
    public static boolean isNumeric(String str){
        return str.chars().allMatch( Character::isDigit );
    }

    public static void printInvalidInput(){
        System.out.println("Invalid input. Please enter a valid temperature value and its unit of measurement (F or C):");
    }

}
