package utilities;

import java.io.*;

/**
 * A class that handles reading and writing of files for Google CodeJam
 */
public class FileHandler
{
    /**
     * Read the inputs into an instance of the {@link Input} class
     * @param fileName the name of the input file
     * @return a new utilities.Input object containing the contents of the {@link Input} file
     */
    public static Input ReadInputFile(String filePathInput, String fileName)
    {
        // The number of inputs that the input file has
        int numInputs = 0;
        // The different inputs in the input file
        String[] inputs = new String[0];

        try
        {
            // A new path that points to the file that we are trying to read
            File inputLocation = new File(filePathInput + fileName + ".in");

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

            System.out.println("Read file from " + inputLocation.getAbsolutePath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return new Input(numInputs, inputs);
    }

    public static void WriteOutputFile(String filePathOutput, String fileName, Output output)
    {
        try
        {
            // A new path that points to the file that we are trying to read
            File outputLocation = new File(filePathOutput + fileName + ".out");

            // FileWriter and BufferedWriter objects to write the new file
            FileWriter fileWriter = new FileWriter(outputLocation);
            BufferedWriter outputWriter = new BufferedWriter(fileWriter);

            // Get the output strings to write
            String[] outputs = output.GetOutputs();
            // Write all of the outputs with Case #N appended to the front
            for (int i = 1; i <= outputs.length; i++)
            {
                fileWriter.write("Case #" + i + ": " + outputs[i - 1] + System.getProperty("line.separator"));
            }

            // Close the new file
            outputWriter.close();

            System.out.println("Wrote file to " + outputLocation.getAbsolutePath());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
