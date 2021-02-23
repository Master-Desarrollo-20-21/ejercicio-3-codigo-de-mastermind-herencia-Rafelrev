import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyConsole {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String read(String string) {
        System.out.print(string);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
	}

	public void out(String string) {
        System.out.println(string);
	}

}
