import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

import static java.lang.System.in;
import static javafx.scene.input.KeyCode.F;

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

        // A new path that points to the file that we are trying to read
        Path inputLocation = Paths.get(FileHandler.filePathInput + fileName + ".txt");

        try
        {
            // New InputStream and BufferedReader objects to read the file
            InputStream inputStream = Files.newInputStream(inputLocation);
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));

            // Get the number of inputs from the first line of the file
            String firstLine = inputReader.readLine();
            numInputs = Integer.parseInt(firstLine);

            // Read the rest of the inputs in the file
            inputs = new String[numInputs];
            for(int i = 0; i < numInputs; i++)
            {
                inputs[i] = inputReader.readLine();
            }
        }
        catch (IOException e)
        {
            System.err.println(e);
        }

        return new Input(numInputs, inputs);
    }
}
