package com.robert.electronicmusicguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GenereActivity extends AppCompatActivity implements View.OnClickListener {

    TextView generename;
    ImageView image;
    TextView description;
    String genere;
    ImageButton playerbutton;
    MediaPlayer mediaPlayer = null;

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
        playerbutton = (ImageButton) findViewById(R.id.player_button);
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
        mediaPlayer = MediaPlayer.create(this, R.raw.housesound);
        mediaPlayer.setLooping(true);
    }

    private void setup_techno() {
        image.setImageResource(R.drawable.technoimage);
        description.setText(R.string.technoscription);
        mediaPlayer = MediaPlayer.create(this, R.raw.technosound);
        mediaPlayer.setLooping(true);
    }

    private void setup_dnb() {
        image.setImageResource(R.drawable.dnbimage);
        description.setText(R.string.dnbdescription);
        mediaPlayer = MediaPlayer.create(this, R.raw.dnbsound);
        mediaPlayer.setLooping(true);
    }

    private void setup_dubstep() {
        image.setImageResource(R.drawable.dubstepimage);
        description.setText(R.string.dubstepscription);
        mediaPlayer = MediaPlayer.create(this, R.raw.dubstepsound);
        mediaPlayer.setLooping(true);
    }

    private void setup_garage() {
        image.setImageResource(R.drawable.garageimage);
        description.setText(R.string.garagedescription);
        mediaPlayer = MediaPlayer.create(this, R.raw.garagesound);
        mediaPlayer.setLooping(true);
    }

    public void onClick(View view) {
        mediaPlayer.start();
        playerbutton.setBackgroundResource(R.drawable.stop);
        playerbutton.setOnClickListener(new HandleStopClick());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mediaPlayer.release();
        mediaPlayer = null;
    }

    private class HandleStopClick implements View.OnClickListener {
        public void onClick(View view) {
            mediaPlayer.pause();
            playerbutton.setBackgroundResource(R.drawable.play);
            playerbutton.setOnClickListener(GenereActivity.this);
        }
    }
}
