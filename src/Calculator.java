public class Calculator {

    public int Add(String numbers) {
        String delimiter = "[,\n]";
        String negatives ="";
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
                int sum=0;
                int delimiterNumber = numbers.indexOf("//")+2; //+2 because delimiter is after "//"
                delimiter = numbers.substring(delimiterNumber, delimiterNumber+1);//delimiter is equal to 2
                numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n")+1);//numbers after without dilimiter
                String[] tableOfNumbersWithoutDelimiter = numbersWithoutDelimiter.split(delimiter); //Splitting string for pieces separated by delimiters

                for(String number:tableOfNumbersWithoutDelimiter)
                {
                    if(!number.trim().isEmpty()) //if characters exists
                    {
                        int value = convertToInt(number.trim());
                        if(value<0)     //if v
                        {
                            negatives+=" "+number.trim();
                        }
                        else {
                            sum += value;
                        }

                    }

                }
                if(!negatives.isEmpty()) //if negatives exists throw new exception
                {
                    throw new RuntimeException("negatives not allowed:" + negatives);
                }
                return sum;
            }
            else
            {
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