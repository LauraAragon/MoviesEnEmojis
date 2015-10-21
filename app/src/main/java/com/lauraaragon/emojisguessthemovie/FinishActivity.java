package com.example.lauraaragon.emojisguessthemovie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Juan Manuel on 26/09/2015.
 */
public class FinishActivity extends Activity {

    private ImageButton button_restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean win = getIntent().getBooleanExtra("win", false);
        if (win)
            setContentView(R.layout.win_layout);
        else
            setContentView(R.layout.lose_layout);

        button_restart = (ImageButton) findViewById(R.id.imageButtonRestart);
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FinishActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
