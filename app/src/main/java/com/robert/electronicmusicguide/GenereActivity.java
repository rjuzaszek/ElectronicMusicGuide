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
    String genere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genere);

        Intent intent = getIntent();
        genere = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Typeface font = Typeface.createFromAsset(getAssets(), "Star_Jedi_Rounded.ttf");

        generename = (TextView) findViewById(R.id.generename_textview);
        generename.setText(genere);
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

            case "DNB":
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
        image.setImageResource(R.drawable.houseimage);
        description.setText(R.string.housedescription);
    }

    private void setup_techno() {
        image.setImageResource(R.drawable.technoimage);
        description.setText(R.string.technoscription);
    }

    private void setup_dnb() {
        image.setImageResource(R.drawable.dnbimage);
        description.setText(R.string.dnbdescription);
    }

    private void setup_dubstep() {
        image.setImageResource(R.drawable.dubstepimage);
        description.setText(R.string.dubstepscription);
    }

    private void setup_garage() {
        image.setImageResource(R.drawable.garageimage);
        description.setText(R.string.garagedescription);
    }
}
