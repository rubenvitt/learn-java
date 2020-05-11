package de.rubeen.udemy.dreieckszahlquadrat;

/**
 * Created by Ruben Vitt - 10.01.17.
 */
public class Number {
    private int getNumber() {
        return number;
    }

    private final int number;

    public Number(int number) {
        this.number = number;
    }

    private boolean Quadrat() {
        for (int i = 0; i <= number / 2; i++) {
            if (i * i == number)
                return true;
            if (i * i > number)
                return false;
        }
        return false;
    }

    private boolean Dreieck() {
        int sum = 0;
        for (int i = 1; i < number / 2; i++) {
            sum += i;
            if(sum == number)
                return true;
            if(sum > number)
                return false;
        }
        return false;
    }

    @Override
    public String toString() {
        if(Quadrat() && Dreieck())
            return String.format("%s ist eine Quadrats- und Dreieckszahl.", getNumber());
        if(Quadrat())
            return String.format("%s ist eine Quadratszahl.", getNumber());
        if(Dreieck())
            return String.format("%s ist eine Dreieckszahl.", getNumber());
        return String.format("%s ist eine ganz normale Zahl.", getNumber());
    }
}
