package foodsave.apps.rubeen.de.foodsave;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Ruben Vitt - 07.01.17.
 */
public class MainActivityListDrawer {
    Context mainContext;

    public MainActivityListDrawer(MainActivity mainActivity, FoodDataObject foodDataObject) {
        //Set the context to mainActivity
        this.mainContext = mainActivity;
        //Uses the main-Linear-Layout from mainActivity
        LinearLayout layout;
        switch (foodDataObject.getPriorityGroup()) {
            case okay:
                layout = (LinearLayout) (mainActivity.findViewById(R.id.listOkay));
                break;
            case outOfDate:
                layout = (LinearLayout) (mainActivity.findViewById(R.id.listOutOfDate));
                break;
            case needToEat:
                layout = (LinearLayout) (mainActivity.findViewById(R.id.listNeedToEat));
                break;
            default:
                return;
        }
        layout.addView(makeUI(foodDataObject));
    }

    private LinearLayout makeUI(FoodDataObject foodDataObject) {
        //TODO Löschfunktion

        LinearLayout linearLayoutMain = new LinearLayout(mainContext);
        linearLayoutMain.setOrientation(LinearLayout.HORIZONTAL);
        {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, pixels(16));
            linearLayoutMain.setLayoutParams(layoutParams);
        }

        //TODO Bild einfügen in Java
        ImageView imageView = new ImageView(mainContext);
        //imageView.setImageResource(R.drawable.banane);
        LinearLayout.LayoutParams layoutParamsImage = new LinearLayout.LayoutParams(pixels(50), pixels(50));
        imageView.setLayoutParams(layoutParamsImage);

        LinearLayout linearLayoutInner = new LinearLayout(mainContext);
        linearLayoutInner.setOrientation(LinearLayout.VERTICAL);
        {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(pixels(5), 0, 0, 0);
            linearLayoutInner.setLayoutParams(layoutParams);
        }

        TextView textViewTitle = new TextView(mainContext);
        textViewTitle.setText(foodDataObject.getTitle());
        textViewTitle.setTextSize(14);
        textViewTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, pixels(17)));

        LinearLayout linearLayoutInnerInner = new LinearLayout(mainContext);
        linearLayoutInnerInner.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textViewDescription = new TextView(mainContext);
        textViewDescription.setText(foodDataObject.getDescription());
        textViewDescription.setTextSize(10);
        LinearLayout.LayoutParams layoutParamsDescription = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        textViewDescription.setLayoutParams(layoutParamsDescription);
        layoutParamsDescription.setMargins(0, pixels(5), 0, 0);

        //TODO Button-Click-Listener
        Button button = new Button(mainContext);
        button.setText(mainContext.getResources().getText(R.string.recipeIdeas));
        button.setTextSize(12);
        LinearLayout.LayoutParams layoutParamsButton = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(layoutParamsButton);

        linearLayoutMain.addView(imageView);
        linearLayoutMain.addView(linearLayoutInner);
        linearLayoutInner.addView(textViewTitle);
        linearLayoutInner.addView(linearLayoutInnerInner);
        linearLayoutInnerInner.addView(textViewDescription);
        linearLayoutInnerInner.addView(button);

        return linearLayoutMain;
    }

    private int pixels(int dp) {
        //From StackOverFlow
        return (int) ((mainContext.getResources().getDisplayMetrics().density * dp) + 0.5f);
    }


    enum PriorityGroup {
        outOfDate, needToEat, okay
    }
}
