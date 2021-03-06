package Calculator;
import java.util.Arrays;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class BMICalculator implements Calculator {
    private int weight;
    private int height;

    public BMICalculator(int weight, int height){
        if (weight > 0){
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Inappropriate weight");
        }
        if (height > 0){
            this.height = height;
        } else {
            throw new IllegalArgumentException("Inappropriate height");
        }
    }

    @Override
    public String calculate() {
        Double bmi = weight / pow(height/100d, 2);
        return String.format("%.1f", bmi).replaceAll(",","\\.");
    }

    @Override
    public String interpret() {
        double[] limitValues = {15,16,18.5,25,30,35,40,45,50,60,1000};
        String[] labels = {"very severely underweight",
                           "severely underweight",
                           "underweight",
                           "normal",
                           "overweight",
                           "moderate obese",
                           "severely obese",
                           "very severely obese",
                           "morbidly obese",
                           "super obese",
                           "hyper obese"};
        double bmiValue = Double.parseDouble(calculate());
        int index = abs(-1 * (Arrays.binarySearch(limitValues,bmiValue) + 1));
        return labels[index];
    }
}