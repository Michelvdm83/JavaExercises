package PlayersGuide.TheLongGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TheLongGame {
    private String playerName;
    private int score;
    private Scanner input;

    public static void main(String[] args) {
        TheLongGame game = new TheLongGame();
        game.run();
    }

    public TheLongGame() {
        input = new Scanner(System.in);
    }

    public void run() {
        playerName = askInput("Please enter your name: ");
        String file = playerName.concat(".txt");
        Path filePath = Path.of(file);
        if (Files.exists(filePath)) {
            try {
                score = Integer.parseInt(Files.readString(filePath));
                System.out.println(score);
            } catch (Exception e) {
                System.out.println("Something went wrong!");
            }
        } else {
            score = 0;
            try {
                Files.createFile(filePath);

            } catch (IOException e) {
                System.out.println("can't create the file");
            }
        }

        while (true) {
            String newInput = askInput("Just keep typing:\n");
            score += newInput.length();
            System.out.println(score);
            if (newInput.equals("io")) break;
        }
        try {
            Files.writeString(filePath, score + "");
        } catch (IOException e) {
            System.out.println("Couldn't save your score");
        }
    }

    private String askInput(String text) {
        System.out.print(text);
        return input.nextLine().toLowerCase();
    }
}
