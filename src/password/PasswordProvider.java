package password;

import dice.DiceCup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordProvider {
    private DiceCup diceCup = new DiceCup(5);
    private StringBuilder password = new StringBuilder();
    private PairReader pairReader = new PairReader();

    private List<Character> listOfCharacters = Arrays.asList('!', '"', '§', '$', '%', '/', '(', ')', '=', '/');

    public String getPassword(int teilanzahl) throws IOException {
        List<ArrayList<String>> listOfPairs = pairReader.getListOfPairs();

        for (int i = 0; i < teilanzahl; i++) {
            diceCup.shake();
            String rollResult = diceCup.getRollResult();

            for (ArrayList<String> pair : listOfPairs)
                if (pair.get(0).equals(rollResult))
                    password.append(pair.get(1));

            if (i < teilanzahl - 1) {
                Random random = new Random();
                char randomChar = listOfCharacters.get(random.nextInt(listOfCharacters.size()));

                password.append(randomChar);
            }
        }

        return password.toString();
    }
}
