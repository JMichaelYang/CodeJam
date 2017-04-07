package practice;

import utilities.FileHandler;
import utilities.Input;
import utilities.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSheep
{
    private static final String name = "CountingSheep";

    public static void main(String[] args)
    {
        Input input = FileHandler.ReadInputFile(CountingSheep.name);
        System.out.println("Processing inputs...");
        Output output = CountingSheep.Execute(input);
        System.out.println("Finished processing inputs, writing outputs...");
        FileHandler.WriteOutputFile(CountingSheep.name, output);
    }

    /**
     * Method in which to insert all code that completes the challenges
     * @param input the input string
     * @return The modified output string
     */
    private static String manipulate(String input)
    {
        String output = input;

        int number = Integer.parseInt(output);
        int origNumber = number;
        if(number == 0) { output = "INSOMNIA"; }
        else
        {
            ArrayList<Integer> seenDigits = new ArrayList<Integer>();
            Integer[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            List<Integer> list = Arrays.asList(digits);

            ArrayList<Integer> numberDigits = new ArrayList<>(0);

            do
            {
                Integer digitNumber = number;

                while(digitNumber > 9)
                {
                    numberDigits.add(digitNumber % 10);
                    digitNumber /= 10;
                }
                numberDigits.add(digitNumber);

                for(Integer digit : numberDigits)
                {
                    if(!seenDigits.contains(digit))
                    {
                        seenDigits.add(digit);
                    }
                }

                number += origNumber;
                numberDigits.clear();
            } while(!seenDigits.containsAll(list));

            output = String.valueOf(number - origNumber);
        }

        return output;
    }

    private static Output Execute(Input input)
    {
        String[] outputs = input.GetInputs().clone();

        for(int i = 0; i < outputs.length; i++)
        {
            System.out.println("Finding case string " + (i + 1) + " of " + outputs.length);
            String caseString = CountingSheep.manipulate(outputs[i]);
            System.out.println("Case string " + (i + 1) + " of " + outputs.length + ": " + caseString);
            outputs[i] = caseString;
        }

        return new Output(outputs);
    }
}
