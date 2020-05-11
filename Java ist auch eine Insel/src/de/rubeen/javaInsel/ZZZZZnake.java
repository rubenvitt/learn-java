package de.rubeen.javaInsel;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ruben Vitt - 28.12.16.
 */
public class ZZZZZnake {

    private static final int XMAX = 40;
    private static final int YMAX = 10;
    private static Point playerPos;
    private static Point snakePos;
    private static Point goldPos;
    private static Point doorPos;
    private static boolean rich = false;
    private static boolean running = true;

    public static void main(String[] args) {
        setup();
        while (running) {
            draw();
            checks();
            readKeys();
            MoveSnake();
        }
    }

    /**
     * Moves the snake in direction to the player
     */
    private static void MoveSnake() {
        snakePos.x = (playerPos.x > snakePos.x) ? snakePos.x + 1 : (playerPos.x < snakePos.x) ? snakePos.x - 1 : snakePos.x;
        snakePos.y = (playerPos.y > snakePos.y) ? snakePos.y + 1 : (playerPos.y < snakePos.y) ? snakePos.y - 1 : snakePos.y;
    }

    /**
     * Reads the keystrokes and move
     * w goes up
     * s down
     * d left
     * a right
     */
    private static void readKeys() {
        switch (new Scanner(System.in).next()) {
            case "w":
                playerPos.y = Math.max(0, playerPos.y - 1);
                break;
            case "s":
                playerPos.y = Math.min(YMAX, playerPos.y + 1);
                break;
            case "d":
                playerPos.x = Math.min(XMAX, playerPos.x + 1);
                break;
            case "a":
                playerPos.x = Math.max(0, playerPos.x - 1);
                break;
        }
    }

    /**
     * Checks, if the player wins or loose.
     * rich & doorPos => win
     * snakePos => loose
     * goldPose => rich
     */
    private static void checks() {
        if (rich && playerPos.equals(doorPos)) {
            System.out.println("Congratulations, you win this game.");
            running = false;
            return;
        }

        if (playerPos.equals(snakePos)) {
            System.out.println("You loose.");
            running = false;
            return;
        }

        if (playerPos.equals(goldPos)) {
            rich = true;
            goldPos.setLocation(-1, -1);
        }
    }

    /**
     * Draw the playground.
     * & for player
     * S for Snake
     * € for Gold
     * # for door
     * . for free space
     */
    private static void draw() {
        for (int y = 0; y <= YMAX; y++) {
            for (int x = 0; x <= XMAX; x++) {

                Point p = new Point(x, y);

                if (playerPos.equals(p))
                    System.out.print('&');
                else if (snakePos.equals(p))
                    System.out.print('S');
                else if (goldPos.equals(p))
                    System.out.print('€');
                else if (doorPos.equals(p))
                    System.out.print('#');
                else
                    System.out.print('.');
            }
            System.out.println();
        }
    }


    /**
     * Adds Points for Player, Snake, Gold and door
     * No same x-values or same y-values
     */
    private static void setup() {
        Random random = new Random();
        int playerX = random.nextInt(XMAX);
        int playerY = random.nextInt(YMAX);
        int snakeX = random.nextInt(XMAX);
        int snakeY = random.nextInt(YMAX);
        int goldX = random.nextInt(XMAX);
        int goldY = random.nextInt(YMAX);
        int doorX = random.nextInt(XMAX);
        int doorY = random.nextInt(YMAX);

        while (playerX == snakeX)
            snakeX = random.nextInt(XMAX);
        while (playerY == snakeY)
            snakeY = random.nextInt(XMAX);
        while (playerX == goldX || snakeX == goldX)
            goldX = random.nextInt(XMAX);
        while (playerY == goldY || snakeY == goldY)
            goldY = random.nextInt(YMAX);
        while (playerX == doorX || snakeX == doorX || goldX == doorX)
            doorX = random.nextInt(XMAX);
        while (playerY == doorY || snakeY == doorY || goldY == doorY)
            doorY = random.nextInt(YMAX);


        playerPos = new Point(playerX, playerY);
        snakePos = new Point(snakeX, snakeY);
        goldPos = new Point(goldX, goldY);
        doorPos = new Point(doorX, doorY);
    }
}
