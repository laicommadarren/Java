import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        
        // get 10 rolls
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);

        // get random letter
        char randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);

        // get 8 character password of letters
        String randomPassword = generator.generatePassword();
        System.out.println(randomPassword);

        ArrayList<String> randomPasswordSet = generator.getNewPasswordSet(5);
        System.out.println(randomPasswordSet);
    }
}