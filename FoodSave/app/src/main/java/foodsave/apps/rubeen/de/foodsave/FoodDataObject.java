package foodsave.apps.rubeen.de.foodsave;

import android.content.Context;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ruben Vitt - 07.01.17.
 */
public class FoodDataObject {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValueAte() {
        return valueAte;
    }

    public void setValueAte(int valueAte) {
        this.valueAte = valueAte;
    }

    public Calendar getPurchased() {
        return purchased;
    }

    public void setPurchased(Calendar purchased) {
        this.purchased = purchased;
    }

    public MainActivityListDrawer.PriorityGroup getPriorityGroup() {
        return priorityGroup;
    }

    public void setPriorityGroup(MainActivityListDrawer.PriorityGroup priorityGroup) {
        this.priorityGroup = priorityGroup;
    }

    public String getDescription() {
        return "";
        //return value + " x " + context.getResources().getString(R.string.available) + " | " +valueAte + " x " + context.getResources().getString(R.string.consumed) + "\n" +context.getResources().getString(R.string.bought) + " "/* + DateFormat.getDateInstance().format(purchased)*/;
    }

    private Context context;
    private String title;
    private int value;
    private int valueAte;
    private Calendar purchased;
    private MainActivityListDrawer.PriorityGroup priorityGroup;

    public FoodDataObject(String title, int value, int valueAte, Calendar purchased, MainActivityListDrawer.PriorityGroup priorityGroup, Context context) {
        this.title = title;
        this.value = value;
        this.valueAte = valueAte;
        this.purchased = purchased;
        this.priorityGroup = priorityGroup;
        this.context = context;
    }
}
