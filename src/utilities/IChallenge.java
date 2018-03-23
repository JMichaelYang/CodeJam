package utilities;

/**
 * Interface that contains the method that allows implementors to perform operations on the given
 * input.
 */
public interface IChallenge {

  /**
   * Method in which to insert all code that completes the challenges.
   *
   * @param input the input string
   * @return The modified output string.
   */
  String apply(String input);
}
