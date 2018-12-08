package Calculator;

import static java.lang.Math.pow;

public class BMICalculator implements Calculator {
    private int weight;
    private int height;

    public BMICalculator(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    public BMICalculator(){}

    @Override
    public String calculate() {
        Double bmi = weight / pow(height/100d, 2);
        return String.format("%.1f", bmi);
    }

    @Override
    public String interpret() {

        return null;
    }
}