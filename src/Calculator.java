public class Calculator {

    public int Add(String numbers) {
        String delimiter = "[,\n]";
        //Splitting string for pieces separated by delimiters
        String[] table = numbers.split(delimiter);
        //Checking input string
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.length() == 1) {
            return convertToInt(numbers);
        }
        else {
            if (numbers.startsWith("//"))
            {
                String numbersWithoutDelimiter;
                int delimiterNumber = numbers.indexOf("//")+2; //+2 because delimiter is after "//"
                delimiter = numbers.substring(delimiterNumber, delimiterNumber+1);//delimiter is equal to 2
                numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n")+1);//numbers after without dilimiter
                String[] tableOfNumbersWithoutDelimiter = numbersWithoutDelimiter.split(delimiter); //Splitting string for pieces separated by delimiters
                return getSum(tableOfNumbersWithoutDelimiter);
            }
            else
            {
                return getSum(table);
            }
        }
    }
    private int getSum(String[] numbers)//Getting sum of inputs values
    {
        String negatives ="";
        int sum = 0;
        for (String number : numbers)
        {
            if(!number.trim().isEmpty()) //if characters exists
            {
                int value = convertToInt(number.trim());
                if (value < 0)     //if value is negative
                {
                    negatives += " " + number.trim();
                }
            }
            if(convertToInt(number)<=1000)
            {
                sum += convertToInt(number);
            }
        }
        if(!negatives.isEmpty()) //if negatives exists throw new exception
        {
            throw new RuntimeException("negatives not allowed:" + negatives);
        }
        return sum;
    }
    private int convertToInt(String number)//Converting String to Int
    {
        return Integer.parseInt(number);
    }
}