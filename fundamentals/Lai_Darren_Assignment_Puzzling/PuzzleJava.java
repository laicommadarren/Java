import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJava {
    Random randMachine = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> tenRolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
        tenRolls.add(randMachine.nextInt(20));
        }
        return tenRolls;
    }

    public char getRandomLetter() {
        ArrayList<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        int randomLetterIndex = randMachine.nextInt(26);
        return letters.get(randomLetterIndex);
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            char passwordLetter = getRandomLetter();
            password += passwordLetter;
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int number) {
        ArrayList<String> passwordSet = new ArrayList<>();
        for (int j = 0; j < number; j++) {
            passwordSet.add(generatePassword());
        }
        return passwordSet;
    }
}

