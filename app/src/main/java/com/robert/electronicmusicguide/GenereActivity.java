package com.robert.electronicmusicguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                setup_genere(R.drawable.houseimage, R.string.housedescription, R.raw.housesound);
                break;

            case "Techno":
                setup_genere(R.drawable.technoimage, R.string.technoscription, R.raw.technosound);
                break;

            case "Dubstep":
                setup_genere(R.drawable.dubstepimage, R.string.dubstepscription, R.raw.dubstepsound);
                break;

            case "DNB":
                setup_genere(R.drawable.dnbimage, R.string.dnbdescription, R.raw.dnbsound);
                break;

            case "Garage":
                setup_genere(R.drawable.garageimage, R.string.garagedescription, R.raw.garagesound);
                break;

            default:
                throw new IllegalArgumentException("Niewłaściwy gatunek muzyczny!");
        }
    }

    private void setup_genere(int picture, int text, int sound) {
        image.setImageResource(picture);
        description.setText(text);
        mediaPlayer = MediaPlayer.create(this, sound);
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
