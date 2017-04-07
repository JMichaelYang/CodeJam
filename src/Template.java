import utilities.FileHandler;
import utilities.Input;
import utilities.Output;

public class Template
{
    private static final String name = "Template";

    public static void main(String[] args)
    {
        Input input = FileHandler.ReadInputFile(Template.name);
        System.out.println("Processing inputs...");
        Output output = Template.execute(input);
        System.out.println("Finished processing inputs, writing outputs...");
        FileHandler.WriteOutputFile(Template.name, output);
    }

    /**
     * Method in which to insert all code that completes the challenges
     * @param input the input string
     * @return The modified output string
     */
    private static String manipulate(String input)
    {
        String output = input;

        return output;
    }

    private static Output execute(Input input)
    {
        String[] outputs = input.GetInputs().clone();

        for(int i = 0; i < outputs.length; i++)
        {
            System.out.println("Finding case string " + (i + 1) + " of " + outputs.length);
            String caseString = Template.manipulate(outputs[i]);
            System.out.println("Case string " + (i + 1) + " of " + outputs.length + ": " + caseString);
            outputs[i] = caseString;
        }

        return new Output(outputs);
    }
}
