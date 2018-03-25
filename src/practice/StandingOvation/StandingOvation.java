package practice.StandingOvation;

import utilities.IChallenge;

public class StandingOvation implements IChallenge {

  @Override
  public String apply(String[] input) {
    String[] split = input[0].split(" ");
    int maxShyness = Integer.valueOf(split[0]);
    int[] numPeople = new int[maxShyness + 1];
    for (int i = 0; i < split[1].length(); i++) {
      numPeople[i] = Integer.valueOf(split[1].substring(i, i + 1));
    }

    int standing = 0;
    int needed = 0;

    for(int i = 0; i < numPeople.length; i++) {
      if(numPeople[i] != 0) {
        if (standing >= i) {
          standing += numPeople[i];
        } else {
          int friends = i - standing;
          standing += numPeople[i] + friends;
          needed += friends;
        }
      }
    }

    return String.valueOf(needed);
  }
}
