import Calculator.BMICalculator;import Calculator.Calculator;import junitparams.JUnitParamsRunner;import junitparams.Parameters;import org.junit.Test;import org.junit.runner.RunWith;import static org.junit.Assert.assertEquals;@RunWith(JUnitParamsRunner.class)public class BMICalculatorTest {    @Test(expected = IllegalArgumentException.class)    @Parameters({" -1, 170",                 "  1,  -1",                 "  0, 120",                 " 50,  -1",                 " 50,   0"})    public void constructTest(int weight, int height){        new BMICalculator(weight, height);    }    @Test    @Parameters({"40, 120, 27.8",                 "50, 120, 34.7"})    public void calculateTest(int weight, int height, String exp){        Calculator calc = new BMICalculator(weight, height);        assertEquals(exp, calc.calculate());    }    @Test    @Parameters({"10, very severely underweight",                 "15.5, severely underweight",                 "17, underweight",                 "20, normal",                 "27, overweight",                 "31, moderate obese",                 "36, severely obese",                 "41, very severely obese",                 "46, morbidly obese",                 "51, super obese",                 "61, hyper obese"})    public void interpretTest(String bmi, String label){        Calculator calc = new BMICalculator();        assertEquals(label, calc.interpret());    }}