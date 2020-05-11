package de.rubeen.udemy.komischemenschenerraten;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ruben Vitt - 12.01.17.
 */
public class Game {
    private ArrayList<People> peoples;
    private People actualPeople;
    Random random = new Random();

    public Game() {
        loadPeoples();
    }

    private void loadPeoples() {
        try {
            peoples = new PeopleLoader().execute("http://www.posh24.com/celebrities").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        return actualPeople.name;
    }

    public Bitmap getNextImage() {
        int i = random.nextInt(peoples.size());
        actualPeople = peoples.get(i);
        return getImage(i);
    }

    public List<String> getAnswers() {
        ArrayList<String> result = new ArrayList<>(5);
        int position = random.nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == position)
                result.add(i, actualPeople.name);
            if (i != position)
                result.add(i, peoples.get(random.nextInt(peoples.size())).name);
            for (int j = 0; j < i; j++)
                if (result.get(j) == result.get(i))
                    i--;
        }

        return result;
    }

    private class PeopleLoader extends AsyncTask<String, Void, ArrayList<People>> {

        @Override
        protected void onPostExecute(ArrayList<People> peoples) {
            super.onPostExecute(peoples);
        }

        @Override
        protected ArrayList<People> doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                int data;
                String website = "";
                while ((data = reader.read()) != -1)
                    website += (char) data;

                Log.i("result", "Webseite geladen");
                return PeopleCreator(website);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private ArrayList<People> PeopleCreator(String website) {
            ArrayList<People> result = new ArrayList<>(150);

            Pattern patternPictures = Pattern.compile("img src=\"(.*?)\" alt=");
            Matcher matcherPictures = patternPictures.matcher(website);

            Pattern patternNames = Pattern.compile("\" alt=\"(.*?)\"");
            Matcher matcherNames = patternNames.matcher(website);
            while (matcherPictures.find() && matcherNames.find()) {
                result.add(new People(matcherNames.group(1), matcherPictures.group(1)));
            }
            return result;
        }
    }

    private Bitmap getImage(int i) {
        actualPeople = peoples.get(i);
        return loadImage(actualPeople);
    }

    private Bitmap loadImage(People people) {
        try {
            return new ImageLoader().execute(people.pictureLink).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private class ImageLoader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                Bitmap result = BitmapFactory.decodeStream(connection.getInputStream());
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
