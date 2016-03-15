package com.robert.electronicmusicguide;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.robert.electronicmusicguide.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = (TextView) findViewById(R.id.title_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "Star_Jedi_Rounded.ttf");
        title.setTypeface(font);

        ((Button)findViewById(R.id.house_button)).setTypeface(font);
        Button b2 = (Button) findViewById(R.id.dnb_button);
        b2.setTypeface(font);
        Button b3 = (Button) findViewById(R.id.dubstep_button);
        b3.setTypeface(font);
        Button b4 = (Button) findViewById(R.id.garage_button);
        b4.setTypeface(font);
        Button b5 = (Button) findViewById(R.id.techno_button);
        b5.setTypeface(font);
    }

    public void showHouseActivity(View view) {
        Intent intent = new Intent(this, GenereActivity.class);
        String genere = ((Button)view).getText().toString();
        intent.putExtra(EXTRA_MESSAGE, genere);
        startActivity(intent);
    }
}
