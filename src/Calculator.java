public class Calculator {

    public int Add(String numbers)
    {
        String delimiter = "[,\n]";
        //Splitting string for pieces separated by delimiters
        String[] table = numbers.split(delimiter);

        //Checking input string
        if (numbers.startsWith("//"))
        {
            String numbersWithoutDelimiter;
            int sum=0;
            int delimiterNumber = numbers.indexOf("//")+2; //+2 because delimiter is after "//"
            delimiter = numbers.substring(delimiterNumber, delimiterNumber+1);//delimiter is equal to 2
            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n")+1);
            String[] tableOfNumbersWithoutDelimiter = numbersWithoutDelimiter.split(delimiter); //Splitting string for pieces separated by delimiters

            for(String number:tableOfNumbersWithoutDelimiter)
            {
                if(!number.trim().isEmpty()) //if characters exists
                {
                    sum+=convertToInt(number.trim());
                }
            }
            return sum;
        }
        else {
            if (numbers.isEmpty()) {
                return 0;
            } else if (numbers.length() == 1) {
                return convertToInt(numbers);
            } else {
                return getSum(table);
            }
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