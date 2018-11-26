package dice;

import java.util.Random;

class Dice {
    private int points;
    private Random generator;

    Dice() {
        points = 0;
        generator = new Random();
    }

    int getPoints() {
        return this.points;
    }

    void roll() {
        points = generator.nextInt(6) + 1;
    }

    @Override
    public String toString() {
        return "" + this.getPoints();
    }
}