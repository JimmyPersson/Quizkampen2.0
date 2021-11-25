package Server;

import java.io.*;
import java.util.ArrayList;

public class ServerLogic {
    private BufferedReader bufferedReader;
    private String category;
    private ArrayList<String> categoryList = new ArrayList();
    String playedCat;

    public ServerLogic(String playedCat) throws FileNotFoundException {
        this.playedCat = playedCat;
        bufferedReader = new BufferedReader(new FileReader("src/Server/Database.txt"));

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
