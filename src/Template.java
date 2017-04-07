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
        Output output = Template.Execute(input);
        System.out.println("Finished processing inputs, writing outputs...");
        FileHandler.WriteOutputFile(Template.name, output);
    }

    private static Output Execute(Input input)
    {
        String[] outputs = input.GetInputs().clone();

        for(int i = 0; i < outputs.length; i++)
        {
            System.out.println("Finding case string " + (i + 1) + " of " + outputs.length);
            String caseString = outputs[i];

            // PLACE CODE THAT MANIPULATES INPUTS HERE
            // caseString SHOULD END UP WITH THE DESIRED STRING VALUE



            // END EXECUTION

            System.out.println("Case string " + (i + 1) + " of " + outputs.length + ": " + caseString);
            outputs[i] = caseString;
        }

        return new Output(outputs);
    }
}
