package utilities;

import practice.AlphabetCake;
import practice.CountingSheep;
import practice.RevengeOfThePancakes;

/**
 * A class that gets the right challenge based on the given challenge name.
 */
public class ChallengeFactory {

  /**
   * Gets the correct challenge based on the given challenge name.
   */
  public static IChallenge getChallenge(String challenge) {
    switch (challenge) {
      case "CountingSheep":
        return new CountingSheep();
      case "RevengeOfThePancakes":
        return new RevengeOfThePancakes();
      case "AlphabetCake":
        return new AlphabetCake();
      default:
        throw new IllegalArgumentException("No handler for the given challenge.");
    }
  }
}
