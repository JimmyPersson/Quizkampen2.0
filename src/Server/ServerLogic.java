package Server;

import java.io.*;
import java.util.ArrayList;

public class ServerLogic {
    File file;
    private BufferedReader bufferedReader;
    private String category;
    private ArrayList<String> categoryList = new ArrayList();


    public ServerLogic() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("src/Server/Database.txt"));

    }
    public ArrayList CategoryGetter () throws IOException {
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
             if (line.startsWith("???C")) {
             categoryList.add(bufferedReader.readLine());
        }
        }
        return categoryList;
    }
}
