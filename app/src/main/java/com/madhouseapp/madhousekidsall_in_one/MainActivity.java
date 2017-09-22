package com.madhouseapp.madhousekidsall_in_one;

import android.graphics.Typeface;
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

    private String[] alphabets = {"A a", "B b", "C c", "D d", "E e", "F f", "G g", "H h", "I i", "J j", "K k",
            "L l", "M m", "N n", "O o", "P p", "Q q", "R r", "S s", "T t", "U u", "V v", "W w", "X x", "Y y", "Z z"};

    private int counter = 0;
    private Typeface chalkduster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting up the activity for fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        chalkduster = Typeface.createFromAsset(getAssets(), "chalkduster.ttf");
        blackboard = (ImageView) findViewById(R.id.blackboard);
        alphabetText = (TextView) findViewById(R.id.alphabet_text);
        previous = (Button) findViewById(R.id.button_previous);
        play = (Button) findViewById(R.id.button_play);
        next = (Button) findViewById(R.id.button_next);

        alphabetText.setText(alphabets[counter]);
        alphabetText.setTypeface(chalkduster);

        //Initializing the animation files
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeIn.setStartOffset(Long.parseLong("150"));
        final Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        fadeIn.setStartOffset(Long.parseLong("150"));


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                if (counter < 0) {
                    counter = alphabets.length - 1;
                }
                fadeIn.setStartOffset(Long.parseLong("150"));
                fadeIn.setStartOffset(Long.parseLong("150"));
                alphabetText.startAnimation(fadeOut);
                alphabetText.setText(alphabets[counter]);
                alphabetText.setTypeface(chalkduster);
                alphabetText.startAnimation(fadeIn);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter > alphabets.length - 1) {
                    counter = 0;

                }

                fadeIn.setStartOffset(Long.parseLong("150"));
                fadeIn.setStartOffset(Long.parseLong("150"));
                alphabetText.startAnimation(fadeOut);
                alphabetText.setText(alphabets[counter]);
                alphabetText.setTypeface(chalkduster);
                alphabetText.startAnimation(fadeIn);
            }
        });
    }
}
