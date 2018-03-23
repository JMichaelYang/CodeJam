import utilities.ChallengeFactory;
import utilities.FileHandler;
import utilities.IChallenge;
import utilities.Input;
import utilities.Output;

public class MainExec {

  //TODO: Change these file paths to match the local system
  private static final String inputPath = "C:\\Users\\Jaewon Yang\\Documents\\CodeJam\\Input\\";
  private static final String outputPath = "C:\\Users\\Jaewon Yang\\Documents\\CodeJam\\Output\\";

  public static void main(String[] args) {
    if (args.length % 2 != 0) {
      throw new IllegalArgumentException("Given arguments are improperly formatted, each flag must"
          + "have a value.");
    }

    String name = null;
    String fileName = null;

    for (int i = 0; i < args.length; i += 2) {
      String flag = args[i];

      switch (flag) {
        case "-n":
          name = args[i + 1];
        case "-fn":
          fileName = args[i + 1];
      }
    }

    if (name == null) {
      throw new IllegalArgumentException("The challenge name is required, specify the name with: "
          + "-n 'name'");
    }
    if (fileName == null) {
      fileName = name;
    }

    IChallenge challenge = ChallengeFactory.getChallenge(name);

    Input input = FileHandler.readInputFile(inputPath, fileName);
    Output output = MainExec.execute(challenge, input);
    FileHandler.writeOutputFile(outputPath, fileName, output);
  }

  private static Output execute(IChallenge challenge, Input input) {
    String[] inputs = input.getInputs();
    String[] outputs = new String[inputs.length];

    for (int i = 0; i < inputs.length; i++) {
      try {
        String output = challenge.apply(inputs[i]);
        outputs[i] = output;
      } catch (Exception e) {
        throw new IllegalStateException("Failed to process input " + i + ": " + e.getMessage());
      }
    }

    return new Output(outputs);
  }
}
