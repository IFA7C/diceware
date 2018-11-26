package password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PairReader {
    private final static String FILE_NAME = "/Diceware.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    List<ArrayList<String>> getListOfPairs() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));

        ArrayList<ArrayList<String>> listOfPairs = new ArrayList<>();
        String zeile;

        while ((zeile = reader.readLine()) != null) {
            String[] pair = zeile.split(";");

            listOfPairs.add(new ArrayList<>(Arrays.asList(pair)));
        }

        return listOfPairs;
    }
}
