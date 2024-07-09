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
            switch(query[0]){
                case "exit" -> {
                    System.out.println("Program terminated. \n ```");
                    start = false;
                }
                default -> {
                    boolean isNumeric = query[0].chars().allMatch( Character::isDigit );
                    if(query.length == 2 && isNumeric && query[1].length()<2){
                        switch (query[1].toLowerCase()){
                            case "c" -> System.out.println(query[0]+" C = "+ tempConvert(Integer.parseInt(query[0]), true) +" F");
                            case "f" -> System.out.println(query[0]+" F = "+ tempConvert(Integer.parseInt(query[0]), false) +" C");
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