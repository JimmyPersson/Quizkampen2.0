package Server;

import java.io.*;
import java.util.ArrayList;

public class ServerLogic {
    private BufferedReader bufferedReader;
    private String category;
    private ArrayList<String> categoryList = new ArrayList();
    PrintWriter out;
    String responseInput;

    public ServerLogic() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("C:\\Users\\jimmy\\IdeaProjects\\Quizkampen2.0\\src\\Server\\Database.txt"));
        this.out = out;
    }

    public ArrayList CategoryGetter() throws IOException {
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (line.startsWith("???C")) {
                categoryList.add(bufferedReader.readLine());
            }
        }
        return categoryList;
    }
}