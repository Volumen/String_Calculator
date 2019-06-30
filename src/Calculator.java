public class Calculator {
    private int counter=0;

    public int Add(String numbers) {
        counter++; //one more invoked added one values to counter
        String numbersWithoutDelimiter;
        int delimiterNumber;
        String delimiter = "[,\n]";
        //Splitting string for pieces separated by delimiters
        String[] table = numbers.split(delimiter);
        String[] tableOfNumbersWithoutDelimiter ;
        //Checking input string
        //if input string is equal to 0
        if (numbers.isEmpty()) {
            return 0;
        }
        //if input string is equal to 1
        else if (numbers.length() == 1) {
            return convertToInt(numbers);
        }
        //Checking if input string is longer than 1
        else {
            if (numbers.startsWith("//"))
            {
                if(numbers.startsWith("//["))
                {
                    delimiterNumber = numbers.indexOf("//[") + 3;//becaue delimiter is after "//["
                    delimiter = numbers.substring(delimiterNumber, numbers.indexOf("]"));
                    if(numbers.contains("]["))
                    {
                        //getDelimiters(numbers);
                        int[] tableOfDecimiters= new int[10];
                        int j=0;
                        for(int i =0; i<numbers.length();i++)
                        {
                            //if ']' appears, his number is saved, because of it, we now where are adding ne decimiters
                             if(numbers.charAt(i)==']') {
                                tableOfDecimiters[j] = i;
                                j++;
                            }
                        }
                        for (int k =1;k<j;k++) {
                            delimiter += "|" + numbers.substring(tableOfDecimiters[k - 1] + 2, tableOfDecimiters[k]);//addind delimiters
                        }
                    }
                    numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n")+1);//numbers after without dilimiter
                    tableOfNumbersWithoutDelimiter =numbersWithoutDelimiter.split(delimiter); //Splitting string for pieces separated by delimiters
                }
                else {
                    delimiterNumber = numbers.indexOf("//") + 2; //+2 because delimiter is after "//"
                    delimiter = numbers.substring(delimiterNumber, delimiterNumber + 1);//delimiter is equal to 2
                    numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n")+1);//numbers after without dilimiter
                    tableOfNumbersWithoutDelimiter =numbersWithoutDelimiter.split(delimiter); //Splitting string for pieces separated by delimiters
                }

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
    public int GetCalledCount()
    {
        return counter;
    }
}