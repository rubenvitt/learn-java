package de.rubeen.javaInsel;

import java.io.IOException;

/**
 * Created by Ruben Vitt - 06.06.17.
 */
public class hangman {
    final static String hangmanWord = "Sommerfest";
    static String guessedWord = "";
    static char[] guessedLetters = new char[30];
    static int maxGuesses = 10;


    public static void main(String[] args) throws IOException {
        for (char c : hangmanWord.toCharArray())
            guessedWord += "_";
        for (int guesses = 0; ; guesses++) {
            if (guesses == maxGuesses) {
                System.out.println("Zu oft geraten. Spiel verloren. - Das Wort war " + hangmanWord);
                break;
            }
        }
    }
}