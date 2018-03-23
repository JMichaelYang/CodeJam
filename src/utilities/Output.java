package utilities;

/**
 * An immutable object that contains the outputs for a particular problem.
 */
public class Output {

  private final String[] outputs;

  /**
   * Gets the outputs that were found from the question.
   *
   * @return the outputs from the problem.
   */
  public String[] getOutputs() {
    String[] temp = new String[outputs.length];
    System.arraycopy(outputs, 0, temp, 0, outputs.length);
    return temp;
  }

  /**
   * Creates a new {@code Output} object with the given outputs.
   *
   * @param outputs the outputs from the given problem.
   */
  public Output(String[] outputs) {
    this.outputs = outputs;
  }
}
