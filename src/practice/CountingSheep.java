package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utilities.IChallenge;

public class CountingSheep implements IChallenge {

  @Override
  public String apply(String input) {
    String output = input;

    int number = Integer.parseInt(output);
    int origNumber = number;
    if (number == 0) {
      output = "INSOMNIA";
    } else {
      ArrayList<Integer> seenDigits = new ArrayList<Integer>();
      Integer[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      List<Integer> list = Arrays.asList(digits);

      ArrayList<Integer> numberDigits = new ArrayList<>(0);

      do {
        Integer digitNumber = number;

        while (digitNumber > 9) {
          numberDigits.add(digitNumber % 10);
          digitNumber /= 10;
        }
        numberDigits.add(digitNumber);

        for (Integer digit : numberDigits) {
          if (!seenDigits.contains(digit)) {
            seenDigits.add(digit);
          }
        }

        number += origNumber;
        numberDigits.clear();
      } while (!seenDigits.containsAll(list));

      output = String.valueOf(number - origNumber);
    }

    return output;
  }
}
