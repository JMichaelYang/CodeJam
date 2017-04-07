package utilities;

public class Output
{
    private String[] outputs;
    public String[] GetOutputs() { return this.outputs; }

    public Output(String[] outputs)
    {
        this.outputs = outputs;
    }

    public Output()
    {
        this.outputs = new String[0];
    }
}
