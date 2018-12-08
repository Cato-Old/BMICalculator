package Calculator;

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
        return null;
    }

    @Override
    public String interpret() {
        return null;
    }
}