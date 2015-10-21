package com.example.lauraaragon.emojisguessthemovie;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

import mundo.App;
import mundo.Movie;

/**
 * Created by Laura Aragon on 21/09/2015.
 */
public class GameActivity extends Activity {

    private App application;

    private MediaPlayer mp;

    private MediaPlayer mpD;

    private Button buttonOk;

    private int current;

    private Movie currentMovie;

    private ImageView imageView;

    private ImageView ganar;

    private EditText inputText;

    private ArrayList<Integer> seleccionadas;

    private boolean[] ganadas = new boolean[]{
            false, false, false, false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        seleccionadas = new ArrayList<>();
        current = 0;
        Random random = new Random();
        int i = 0;
        while (i < 4) {
            int numberRandom = random.nextInt(28);
            if (!seleccionadas.contains(numberRandom)) {
                seleccionadas.add(numberRandom);
                i++;
            }
        }
        application = new App();
        currentMovie = application.getMovie(seleccionadas.get(current));
        inputText = (EditText) findViewById(R.id.txtInput);
        imageView = (ImageView) findViewById(R.id.imageEmoji);
        ganar = (ImageView) findViewById(R.id.ganar);
        imageView.setImageResource(R.drawable.img_1);
        buttonOk = (Button) findViewById(R.id.buttonOk);
        String uri = "@drawable/img_" + currentMovie.getId();
        int image = getResources().getIdentifier(uri, null, getPackageName());
        imageView.setImageResource(image);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current < 3) {
                    String input = inputText.getText().toString();
                    if (currentMovie.
                            check(input)) {
                        buttonOk.setEnabled(false);
                        ganadas[current] = true;
                        current++;
                        currentMovie = application.getMovie(seleccionadas.get(current));
                        mp = MediaPlayer.create(GameActivity.this, R.raw.aplausos);
                        mp.start();
                        mp.setVolume(1, 1);
                        buttonOk.setBackgroundResource(R.drawable.ganar);
                        final Handler handler = new Handler();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                inputText.setText("");
                                buttonOk.setEnabled(true);
                                String uri = "@drawable/img_" + currentMovie.getId();
                                int image = getResources().getIdentifier(uri, null, getPackageName());
                                imageView.setImageResource(image);
                                buttonOk.setBackgroundResource(R.drawable.ok);
                            }
                        }, 1000);
                    } else {
                        buttonOk.setEnabled(false);
                        ganadas[current] = false;
                        current++;
                        currentMovie = application.getMovie(current);
                        mpD = MediaPlayer.create(GameActivity.this, R.raw.grillo);
                        mpD.start();
                        mpD.setVolume(1, 1);
                        buttonOk.setBackgroundResource(R.drawable.perder);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                inputText.setText("");
                                buttonOk.setEnabled(true);
                                String uri = "@drawable/img_" + currentMovie.getId();
                                int image = getResources().getIdentifier(uri, null, getPackageName());
                                imageView.setImageResource(image);
                                buttonOk.setBackgroundResource(R.drawable.ok);
                            }
                        }, 1000);
                    }
                } else {
                    String input = inputText.getText().toString();
                    if (currentMovie.
                            check(input)) {
                        ganadas[current] = true;
                    }
                    int numero_ganadas = 0;

                    for (int i = 0; i < ganadas.length; i++) {
                        if (ganadas[i])
                            numero_ganadas += 1;
                    }
                    Intent intent = new Intent(GameActivity.this, FinishActivity.class);
                    if (numero_ganadas > 2) {
                        intent.putExtra("win", true);
                    } else {
                        intent.putExtra("win", false);
                    }
                    startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameActivity.this, StartActivity.class);
        startActivity(intent);
    }
}
