public class Calculator {

    public int Add(String numbers)
    {
        //Splitting string to two pieces
        String[] table = numbers.split(",");
        //Checking input string
        if(numbers.isEmpty())
        {
            return 0;
        }
        else if(numbers.length()==1)
        {
            return convertToInt(numbers);
        }
        else
        {
            return getSum(table);
        }
    }
    private int getSum(String[] numbers)//Getting sum of inputs values
    {
        int sum = 0;
        for (String number : numbers) {
            sum += convertToInt(number);
        }
        return sum;
    }
    private int convertToInt(String number)//Converting String to Int
    {
        return Integer.parseInt(number);
    }
}