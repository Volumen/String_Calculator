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
            return Integer.parseInt(numbers);
        }
        else
        {
            return Integer.parseInt(table[0])+Integer.parseInt(table[1]);
        }
    }
}