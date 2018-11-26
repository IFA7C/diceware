package dice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiceCup {
    private List<Dice> diceList;

    DiceCup() {
        diceList = new ArrayList<>();
    }

    public DiceCup(int numberOfDices) {
        diceList = new ArrayList<>();

        for (int i = 0; i < numberOfDices; i++) {
            diceList.add(new Dice());
        }
    }

    void hinzufuegen(Dice oneDice) {
        diceList.add(oneDice);
    }

    void entfernen(Dice oneDice) {
        diceList.remove(oneDice);
    }

    int getAugenzahl() {
        return diceList.stream()
                .mapToInt(Dice::getPoints)
                .reduce(0, (x, y) -> x * 10 + y);
    }

    int getSum() {
        return diceList.stream()
                .mapToInt(Dice::getPoints)
                .sum();
    }

    int getMax() {
        return diceList.stream()
                .mapToInt(Dice::getPoints)
                .max().orElse(-1);
    }

    int getMin() {
        return diceList.stream()
                .mapToInt(Dice::getPoints)
                .min().orElse(-1);
    }

    double getAverage() {
        return diceList.stream()
                .mapToInt(Dice::getPoints)
                .average().orElse(-1);
    }

    long getAnzahlSechsen() {
        return diceList.stream()
                .filter(x -> x.getPoints() == 6)
                .count();
    }

    public void shake() {
        diceList.forEach(Dice::roll);
    }

    void sort() {
        diceList.sort(Comparator.comparingInt(Dice::getPoints).reversed());

    }

    void ergebnisAnzeigen() {
        diceList.forEach(System.out::print);
    }

    public String getRollResult() {
        StringBuilder builder = new StringBuilder();

        diceList.forEach(builder::append);

        return builder.toString();
    }
}
