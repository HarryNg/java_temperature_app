package temperatureconverter;

public class TemperatureConverter {
    public static double tempConvert(double temp, boolean isCelsius){
        if(isCelsius){
            return Math.floor((temp * 9/5 + 32) *100) /100;
        }else {
            return Math.floor((temp - 32) * 5/9 *100) /100;
        }
    }
}
