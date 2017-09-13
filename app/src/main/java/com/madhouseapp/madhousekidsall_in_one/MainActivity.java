package com.madhouseapp.madhousekidsall_in_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView blackboard;
    private TextView alphabetText;
    private Button previous, play, next;

    private String[] alphabets = {"A  a", "B  b", "C  c", "D  d", "E  e", "F  f", "G  g", "H  h", "I  i", "J  j", "K  k",
            "L  l", "M  m", "N  n", "O  o", "P  p", "Q  q", "R  r", "S  s", "T  t", "U  u", "V  v", "W  w", "X  x", "Y  y", "Z  z"};

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting up the activity for fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        blackboard = (ImageView) findViewById(R.id.blackboard);
        alphabetText = (TextView) findViewById(R.id.alphabet_text);
        previous = (Button) findViewById(R.id.button_previous);
        play = (Button) findViewById(R.id.button_play);
        next = (Button) findViewById(R.id.button_next);

        alphabetText.setText(alphabets[counter]);

        //Initializing the animation files
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0) {
                    alphabetText.setText(alphabets[counter]);
                } else {
                    counter--;
                    alphabetText.startAnimation(fadeOut);
                    alphabetText.setText(alphabets[counter]);
                    alphabetText.startAnimation(fadeIn);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter < alphabets.length - 1) {
                    counter++;
                    alphabetText.startAnimation(fadeOut);
                    alphabetText.setText(alphabets[counter]);
                    alphabetText.startAnimation(fadeIn);
                } else {
                    alphabetText.setText(alphabets[counter]);
                }
            }
        });
    }
}
