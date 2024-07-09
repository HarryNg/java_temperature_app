import java.util.Scanner;

public class Main {

    static double tempConvert(double temp, boolean isC){
        if(isC){
            temp = temp * 9/5 + 32;
        }else {
            temp = (temp - 32) * 5/9;
        }
        return Math.floor(temp*100)/100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a temperature value and its unit of measurement (F or C): ");
        Boolean start = true;
        do {
            String[] query = scanner.nextLine().split(" ");
            String firstInput = query[0];
            switch(firstInput){
                case "exit" -> {
                    System.out.println("Program terminated. \n ```");
                    start = false;
                }
                default -> {
                    boolean isNumeric = firstInput.chars().allMatch( Character::isDigit );
                    if(query.length == 2 && isNumeric && query[1].length()<2){
                        String secondInput = query[1];
                        switch (secondInput.toLowerCase()){
                            case "c" -> System.out.println(firstInput+" C = "+ tempConvert(Integer.parseInt(firstInput), true) +" F");
                            case "f" -> System.out.println(firstInput+" F = "+ tempConvert(Integer.parseInt(firstInput), false) +" C");
                            default ->  System.out.println("Invalid input. Please enter a valid temperature value and its unit of measurement (F or C):");
                        }
                    }else {
                        System.out.println("Invalid input. Please enter a valid temperature value and its unit of measurement (F or C):");
                    }
                }
            }
        }while (start);
    }


}