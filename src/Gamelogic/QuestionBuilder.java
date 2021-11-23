package Gamelogic;

import java.io.*;
import java.util.ArrayList;

public class QuestionBuilder {

    String category;
    String question;
    String answer1;
    String answer2;
    ArrayList arrayList = new ArrayList<String>();

    public void QuestionReader() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("/Server/Database.txt"))) {
            while ((line = br.readLine()) != null) {
                category = line.split("--")[0];
                question = line.split("<QUESTION>")[1];
                answer1 = line.split("<ANSWER>")[2];
                answer2 = line.split(",")[3];

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}