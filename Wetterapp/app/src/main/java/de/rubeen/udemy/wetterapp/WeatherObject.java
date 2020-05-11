package de.rubeen.udemy.wetterapp;

/**
 * Created by Ruben Vitt - 15.01.17.
 */
public class WeatherObject {
    public final String main;
    public final String description;
    public final String temperature;

    public WeatherObject(String main, String description, String temperature) {
        this.main = main;
        this.description = description;
        this.temperature = temperature;
    }
}
