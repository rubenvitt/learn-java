package de.rubeen.udemy.wetterapp;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by Ruben Vitt - 15.01.17.
 */
public class Weather {
    private String apiKey;

    public Weather(String apiKey) {
        this.apiKey = apiKey;
    }

    public WeatherObject getWeatherObject(String city) {
        String urlString = getConnectionString(city);

        try {
            String content = new JSONDownloader().execute(urlString).get();
            JSONObject jsonObject = new JSONObject(content);
            JSONArray weatherArray = new JSONArray(jsonObject.getString("weather"));
            JSONObject jsonTemperature = new JSONObject(jsonObject.getString("main"));
            jsonObject = weatherArray.getJSONObject(0);

            return new WeatherObject(jsonObject.getString("main"), jsonObject.getString("description"), jsonTemperature.getString("temp"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new WeatherObject("undefined", "undefined", "undefined");
    }

    private String getConnectionString(String city) {
        return new StringBuilder("http://api.openweathermap.org/data/2.5/weather?units=metric&q=").append(city).append("&appid=").append(apiKey).toString();
    }

    private class JSONDownloader extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                String urlString = params[0];
                StringBuilder resultBuilder = new StringBuilder();
                URL url = new URL(urlString);
                Log.i("URL", urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());

                int data = 0;
                while ((data = reader.read()) != -1)
                    resultBuilder.append((char) data);

                return resultBuilder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

}
