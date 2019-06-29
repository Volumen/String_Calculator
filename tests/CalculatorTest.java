import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach //befor each test is generated new object (calculator)
    public void init()
    {
        calculator = new Calculator();
    }

    //Checking if our method works correctly
    @Test
    public void testEmptyString()
    {
        assertEquals(calculator.Add(""), 0);    //comparison two the same type of data
    }

    @Test
    public void testSingleValue()
    {
        assertEquals(calculator.Add("7"),7);
    }

    @Test
    public void testTwoValues()
    {
        assertEquals(calculator.Add("41,111"),152);
    }

    @Test
    public void testUnknownAmountOfValues()//Step 2 - testing unknown amount of values
    {
        assertEquals(calculator.Add("3,7,1"),11);
        assertEquals(calculator.Add("2,3,4,5,1,2,3"),20);
    }

    @Test
    public void testDelimiters()//Step 3 - testing new delimiter
    {
        assertEquals(calculator.Add("3\n4,3"),10);
    }
}
