import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testSpecifiedDelimiter()//Step 4 - testing specified delimiter
    {
        assertEquals(calculator.Add("//&\n4&3&22"),29);
    }

    @Test
    public void testNegativiesValues() //Step 5 - testing an exception
    {
        try {
            calculator.Add("//&\n4&-3&-22");
        }
        catch (RuntimeException e)
        {
            assertEquals("negatives not allowed: -3 -22", e.getMessage());
        }
    }

    @Test
    public void testGreaterNumberThan1000() //Step 6 - testing values bigger than 1000
    {
        assertEquals(1149, calculator.Add("//;\n3;46;1001;1000;100;1240"));
    }
}
