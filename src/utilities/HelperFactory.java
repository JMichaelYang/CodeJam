package utilities;

import practice.StandingOvation.StandingOvation;

/**
 * A class that gets the right challenge based on the given challenge name.
 */
public class HelperFactory {

  /**
   * Gets the correct challenge based on the given challenge name.
   */
  public static IChallenge getChallenge(String challenge) {
    switch (challenge) {
      case "StandingOvation":
        return new StandingOvation();
      default:
        throw new IllegalArgumentException("No handler for the given challenge.");
    }
  }

  public static IInputHandler getHandler(String challenge) {
    switch (challenge) {
      case "StandingOvation":
        return new DefaultInputHandler();
      default:
        return new DefaultInputHandler();
    }
  }
}
