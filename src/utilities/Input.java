package utilities;

/**
 * An immutable object that contains the inputs that were given by the problem's input file.
 */
public class Input {

  // The number of inputs given by the file.
  public final int numInputs;

  private final String[][] inputs;

  /**
   * Returns a copy of the inputs for this problem.
   *
   * @return This problem's inputs as an array.
   */
  public String[][] getInputs() {
    String[][] temp = new String[inputs.length][];
    System.arraycopy(inputs, 0, temp, 0, inputs.length);
    return temp;
  }

  /**
   * Creates an inputs object with the given inputs.
   */
  public Input(String[][] inputs) {
    if (inputs == null) {
      throw new IllegalArgumentException("Given inputs were null.");
    }

    this.numInputs = inputs.length;
    this.inputs = inputs;
  }
}
