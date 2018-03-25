package utilities;

public class DefaultInputHandler implements IInputHandler {

  @Override
  public String[][] translate(String[] raw) {
    String[][] temp = new String[raw.length][];
    for(int i = 0; i < raw.length; i++) {
      temp[i] = new String[1];
      temp[i][0] = raw[i];
    }
    return temp;
  }
}
