package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that handles reading and writing of files for Google CodeJam.
 */
public class FileHandler {

  private final IInputHandler handler;
  private final String inputPath;
  private final String outputPath;
  private final String fileName;

  public FileHandler(IInputHandler handler, String inputPath, String outputPath, String fileName) {
    this.handler = handler;
    this.inputPath = inputPath;
    this.outputPath = outputPath;
    this.fileName = fileName;
  }

  /**
   * Read the inputs from a file into an instance of the {@link Input} class.
   *
   * @return a new {@link Input} object containing the contents of the input file.
   */
  public Input readInputFile() {
    // The number of inputs that the input file has
    int numInputs;
    // The different inputs in the input file
    String[] inputs = new String[0];

    try {
      // A new path that points to the file that we are trying to read
      File inputLocation = new File(inputPath + fileName + ".in");

      // New FileReader and BufferedReader objects to read the file
      FileReader fileReader = new FileReader(inputLocation);
      BufferedReader inputReader = new BufferedReader(fileReader);

      // Get the number of inputs from the first line of the file
      String firstLine = inputReader.readLine();
      numInputs = Integer.parseInt(firstLine);

      // Read the rest of the inputs in the file
      inputs = new String[numInputs];
      for (int i = 0; i < numInputs; i++) {
        inputs[i] = inputReader.readLine();
      }

      // Close the file
      inputReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new Input(handler.translate(inputs));
  }

  /**
   * Writes the outputs to the correct file.
   *
   * @param output the outputs that should be written
   */
  public void writeOutputFile(Output output) {
    try {
      // A new path that points to the file that we are trying to read
      File outputLocation = new File(outputPath + fileName + ".out");

      // FileWriter and BufferedWriter objects to write the new file
      FileWriter fileWriter = new FileWriter(outputLocation);
      BufferedWriter outputWriter = new BufferedWriter(fileWriter);

      // Get the output strings to write
      String[] outputs = output.getOutputs();
      // Write all of the outputs with Case #N appended to the front
      for (int i = 0; i < outputs.length; i++) {
        fileWriter.write("Case #" + (i + 1) + ": " + outputs[i] + "\n");
      }

      // Close the new file
      outputWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
