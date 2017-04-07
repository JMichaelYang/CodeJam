public class Input
{
    private int numInputs;
    public int GetNumInputs() { return  this.numInputs; }

    private String[] inputs;
    public String[] GetInputs() { return this.inputs; }

    public Input(int numInputs, String[] inputs)
    {
        this.numInputs = numInputs;
        this.inputs = inputs;
    }
}
