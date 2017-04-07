import java.io.*;
import java.nio.file.*;

/**
 * A class that handles reading and writing of files for Google CodeJam
 */
public class FileHandler
{
    /**
     * The locations where the files for input and output can be found
     */
    protected static final String filePathInput = "C:\\Users\\Jaewon\\Documents\\CodeJam\\Input\\";
    protected static final String filePathOutput = "C:\\Users\\Jaewon\\Documents\\CodeJam\\Output\\";

    /**
     * Read the inputs into an instance of the {@link Input} class
     * @param fileName the name of the input file
     * @return a new Input object containing the contents of the {@link Input} file
     */
    public static Input ReadInputFile(String fileName)
    {
        // The number of inputs that the input file has
        int numInputs = 0;
        // The different inputs in the input file
        String[] inputs = new String[0];

        try
        {
            // A new path that points to the file that we are trying to read
            File inputLocation = new File(FileHandler.filePathInput + fileName + ".in");

            // New FileReader and BufferedReader objects to read the file
            FileReader fileReader = new FileReader(inputLocation);
            BufferedReader inputReader = new BufferedReader(fileReader);

            // Get the number of inputs from the first line of the file
            String firstLine = inputReader.readLine();
            numInputs = Integer.parseInt(firstLine);

            // Read the rest of the inputs in the file
            inputs = new String[numInputs];
            for(int i = 0; i < numInputs; i++)
            {
                inputs[i] = inputReader.readLine();
            }

            // Close the file
            inputReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return new Input(numInputs, inputs);
    }

    public static void WriteOutputFile(String fileName, Output output)
    {
        try
        {
            // A new path that points to the file that we are trying to read
            File outputLocation = new File(FileHandler.filePathOutput + fileName + ".out");

            // FileWriter and BufferedWriter objects to write the new file
            FileWriter fileWriter = new FileWriter(outputLocation);
            BufferedWriter outputWriter = new BufferedWriter(fileWriter);

            // Get the output strings to write
            String[] outputs = output.GetOutputs();
            // Write all of the outputs with Case #N appended to the front
            for (int i = 1; i <= outputs.length; i++) { fileWriter.write("Case #" + i + ": " + outputs[i]); }

            // Close the new file
            outputWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
