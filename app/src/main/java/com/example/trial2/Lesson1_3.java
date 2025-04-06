package com.example.trial2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Lesson1_3 extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button check;
    Button showHint;

    Animation slidein;
    Animation fadein;
    Animation fadeout;

    String correctAnswer = "һайнаар";
    String s = "y";

    ViewGroup viewGroup;
    ImageView mark;
    TextView text1;
    TextView text2;
    TextView hint;
    TextView hint2;
    TextView clause;
    TextView correction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate_word);

        clause = findViewById(R.id.clause);
        clause.setText("хорошо");
        hint = findViewById(R.id.hint);
        hint.setText("һайнаар");
        correction = findViewById(R.id.text2);
        correction.setText("Правильный ответ: һайнаар");

        Button btn1 = findViewById(R.id.btn1);
        btn1.setText("гэр");
        Button btn2 = findViewById(R.id.btn2);
        btn2.setText("муугаар");
        Button btn3 = findViewById(R.id.btn3);
        btn3.setText("һайнаар");
        Button btn4 = findViewById(R.id.btn4);
        btn4.setText("морин");

        hint = findViewById(R.id.hint);
        hint.setAlpha(0);
        hint2 = findViewById(R.id.hint2);
        hint2.setAlpha(0);

        check = findViewById(R.id.check);
        check.setEnabled(false);
        showHint = findViewById(R.id.showHint);

        viewGroup = findViewById(R.id.response);
        viewGroup.setAlpha(0);
        mark = findViewById(R.id.mark);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        slidein = AnimationUtils.loadAnimation(this, R.anim.slidein);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
    }

    boolean hintVisibility = false;
    public void showHintToggle(View v) {
        Log.d("HINT_TOGGLE", "Interaction found");
        if(hintVisibility == false) {
            Log.d("HINT_TOGGLE", "Hint enabled");
            hintVisibility = true;
            hint.setAlpha(1);
            hint.startAnimation(fadein);
            hint2.setAlpha(1);
            hint2.startAnimation(fadein);
        }
        else {
            Log.d("HINT_TOGGLE", "Hint disabled");
            hintVisibility = false;
            hint.setAlpha(0);
            hint.startAnimation(fadeout);
            hint2.setAlpha(0);
            hint2.startAnimation(fadeout);

        }
    }

    public void onClickAnswer1 (View v) {
        btn1 = (Button) v;
        s = btn1.getText().toString();
        findViewById(R.id.btn1).setBackground(getDrawable(R.drawable.button_grid_selected));
        findViewById(R.id.btn2).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn3).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn4).setBackground(getDrawable(R.drawable.button_grid));
        check.setEnabled(true);
    }
    public void onClickAnswer2 (View v) {
        btn2 = (Button) v;
        s = btn2.getText().toString();
        findViewById(R.id.btn2).setBackground(getDrawable(R.drawable.button_grid_selected));
        findViewById(R.id.btn1).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn3).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn4).setBackground(getDrawable(R.drawable.button_grid));
        check.setEnabled(true);
    }
    public void onClickAnswer3 (View v) {
        btn3 = (Button) v;
        s = btn3.getText().toString();
        findViewById(R.id.btn3).setBackground(getDrawable(R.drawable.button_grid_selected));
        findViewById(R.id.btn2).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn1).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn4).setBackground(getDrawable(R.drawable.button_grid));
        check.setEnabled(true);
    }
    public void onClickAnswer4 (View v) {
        btn4 = (Button) v;
        s = btn4.getText().toString();
        findViewById(R.id.btn4).setBackground(getDrawable(R.drawable.button_grid_selected));
        findViewById(R.id.btn2).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn3).setBackground(getDrawable(R.drawable.button_grid));
        findViewById(R.id.btn1).setBackground(getDrawable(R.drawable.button_grid));
        check.setEnabled(true);
    }


    Random random = new Random();
    int r;
    /*String[] correctStr = {getString(R.string.awesome), getString(R.string.correct),
                        getString(R.string.amazing), getString(R.string.great),
                        getString(R.string.perfect), getString(R.string.keepGoing)};*/
    String[] correctStr = {"Так держать!", "Хорошо!", "Верно!"};
    String incorrect = "Неверно";
    public void onClickCheck (View v) {
        r = random.nextInt(correctStr.length);
        check = (Button) v;
        if(s.equals(correctAnswer)) {
            viewGroup.setAlpha(1);
            viewGroup.startAnimation(slidein);
            mark.setImageDrawable(getDrawable(R.drawable.tick_mark));
            text1.setText(correctStr[r]);
            text2.setVisibility(View.INVISIBLE);
            check.setBackground(getDrawable(R.drawable.green));
            check.setText("ПРОДОЛЖИТЬ");
            check.setOnClickListener(this::Continue);

            disableButtons();
        }
        else {
            viewGroup.setAlpha(1);
            viewGroup.startAnimation(slidein);
            mark.setImageDrawable(getDrawable(R.drawable.x_mark));
            text1.setText(incorrect);
            text2.setVisibility(View.VISIBLE);
            check.setBackground(getDrawable(R.drawable.red));
            check.setText("ПОНЯТНО");
            check.setOnClickListener(this::Continue);

            disableButtons();
        }

    }

    public void disableButtons() {
        findViewById(R.id.btn1).setEnabled(false);
        findViewById(R.id.btn2).setEnabled(false);
        findViewById(R.id.btn3).setEnabled(false);
        findViewById(R.id.btn4).setEnabled(false);
    }

    public void Continue (View v) {
        finish();
    }
}