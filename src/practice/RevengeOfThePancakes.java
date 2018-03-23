package practice;

import utilities.IChallenge;

public class RevengeOfThePancakes implements IChallenge {

  @Override
  public String apply(String input) {
    Integer numFlips = 0;
    Boolean isCorrect = false;
    char[] chars = input.toCharArray();

    while (!isCorrect) {
      char lastChar = chars[0];
      Integer finalIndex = -1;

      for (int i = 1; i < chars.length; i++) {
        if (chars[i] != lastChar) {
          finalIndex = i;
          break;
        } else {
          lastChar = chars[i];
        }
      }

      if (finalIndex == -1) {
        if (chars[0] == '-') {
          finalIndex = chars.length - 1;
          flipChars(finalIndex, chars);
          numFlips++;
        }

        isCorrect = true;
      } else {
        flipChars(finalIndex - 1, chars);
        numFlips++;
      }
    }

    return numFlips.toString();
  }

  private char[] flipChars(int max, char[] input) {
    char[] chars = input;
    for (int i = 0; i < max + 1; i++) {
      if (chars[i] == '-') {
        chars[i] = '+';
      } else {
        chars[i] = '-';
      }
    }
    return chars;
  }
}
