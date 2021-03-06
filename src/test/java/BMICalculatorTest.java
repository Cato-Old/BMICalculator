import Calculator.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class BMICalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    @Parameters({" -1, 170",
                 "  1,  -1",
                 "  0, 120",
                 " 50,  -1",
                 " 50,   0"})
    public void constructTest(int weight, int height){
        new BMICalculator(weight, height);
    }

    @Test
    @Parameters({"40, 120, 27.8",
                 "50, 120, 34.7"})
    public void calculateTest(int weight, int height, String exp){
        Calculator calc = new BMICalculator(weight, height);
        assertEquals(exp, calc.calculate());
    }

    @Test
    @Parameters({"30,  180, very severely underweight",
                 "24,  125, severely underweight",
                 "30,  130, underweight",
                 "27,  120, normal",
                 "40,  120, overweight",
                 "50,  120, moderate obese",
                 "55,  120, severely obese",
                 "60,  120, very severely obese",
                 "70,  120, morbidly obese",
                 "80,  120 , super obese",
                 "120, 120, hyper obese"})
    public void interpretTest(int weight, int height, String label){
        Calculator calc = new BMICalculator(weight, height);
        assertEquals(label, calc.interpret());
    }
}