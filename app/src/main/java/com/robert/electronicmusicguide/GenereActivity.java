package com.robert.electronicmusicguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class GenereActivity extends AppCompatActivity {

    TextView generename;
    ImageView image;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genere);

        Intent intent = getIntent();
        String genere = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Typeface font = Typeface.createFromAsset(getAssets(), "Star_Jedi_Rounded.ttf");

        generename = (TextView) findViewById(R.id.generename_textview);
        generename.setTypeface(font);
        image = (ImageView) findViewById(R.id.generephoto_imageview);
        description = (TextView) findViewById(R.id.description_textview);
        ((TextView)findViewById(R.id.descriptiontitle_textview)).setTypeface(font);
        ((TextView)findViewById(R.id.playertitle_textview)).setTypeface(font);

        switch (genere) {
            case "House":
                setup_house();
                break;

            case "Techno":
                setup_techno();
                break;

            case "Dubstep":
                setup_dubstep();
                break;

            case "Drum and bass":
                setup_dnb();
                break;

            case "Garage":
                setup_garage();
                break;

            default:
                throw new IllegalArgumentException("Niewłaściwy gatunek muzyczny!");
        }
    }

    private void setup_house() {
        generename.setText("House");
        image.setImageDrawable(Drawable.createFromPath("@drawable/houseimage"));
        description.setText("Opis");
    }

    private void setup_techno() {
        generename.setText("Techno");
        image.setImageDrawable(Drawable.createFromPath("@drawable/technoimage"));
        description.setText("Opis");
    }

    private void setup_dnb() {
        generename.setText("Drum and bass");
        image.setImageDrawable(Drawable.createFromPath("@drawable/dnbimage"));
        description.setText("Opis");
    }

    private void setup_dubstep() {
        generename.setText("Dubstep");
        image.setImageDrawable(Drawable.createFromPath("@drawable/dubstepimage"));
        description.setText("Opis");
    }

    private void setup_garage() {
        generename.setText("Garage");
        image.setImageDrawable(Drawable.createFromPath("@drawable/garageimage"));
        description.setText("Opis");
    }
}
