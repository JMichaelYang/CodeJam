import utilities.FileHandler;
import utilities.Input;
import utilities.Output;

public class Template
{
    private static final String name = "Template";

    public static void main(String[] args)
    {
        Input input = FileHandler.ReadInputFile(Template.name);
        Output output = Template.Execute(input);
        FileHandler.WriteOutputFile(Template.name, output);
    }

    private static Output Execute(Input input)
    {
        return new Output();
    }
}
