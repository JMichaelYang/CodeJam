import practice.RevengeOfThePancakes;
import utilities.ChallengeBase;
import utilities.FileHandler;
import utilities.Input;
import utilities.Output;

public class MainExec
{
    //TODO: Change these file paths to match the local system
    private static final String inputPath = "C:\\Users\\Jaewon\\Documents\\CodeJam\\Input\\";
    private static final String outputPath = "C:\\Users\\Jaewon\\Documents\\CodeJam\\Output\\";

    //TODO: Change this name to match the current challenge's input file name
    private static final String name = "RevengeOfThePancakes";

    public static void main(String[] args)
    {
        //TODO: Change this line to match the current challenge
        ChallengeBase challenge = new RevengeOfThePancakes();

        Input input = FileHandler.ReadInputFile(inputPath, MainExec.name);
        System.out.println("Processing inputs...");
        Output output = MainExec.execute(challenge, input);
        System.out.println("Finished processing inputs, writing outputs...");
        FileHandler.WriteOutputFile(outputPath, MainExec.name, output);
    }

    private static Output execute(ChallengeBase challenge, Input input)
    {
        String[] outputs = input.GetInputs().clone();

        for(int i = 0; i < outputs.length; i++)
        {
            System.out.println("Finding case string " + (i + 1) + " of " + outputs.length);
            String caseString = challenge.Manipulate(outputs[i]);
            System.out.println("Case string " + (i + 1) + " of " + outputs.length + ": " + caseString);
            outputs[i] = caseString;
        }

        return new Output(outputs);
    }
}
