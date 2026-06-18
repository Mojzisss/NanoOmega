package games;

import java.io.*;
import java.util.ArrayList;

public class Leaderboard {

    public static void saveScore(String gameName, String playerName, double seconds) {
        String fileName = gameName + "games.Leaderboard.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {

            writer.write(playerName + ";" + String.format("%.2f", seconds));
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> loadScores(String gameName) {

        String fileName = gameName + "games.Leaderboard.txt";
        ArrayList<String> scores = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            return scores;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                scores.add(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return scores;
    }
}