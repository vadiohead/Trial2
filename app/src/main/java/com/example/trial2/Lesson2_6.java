package com.example.trial2;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Random;

public class Lesson2_6 extends AppCompatActivity {

    Button button;
    Button check;
    Button showHint;
    Button showHint2;
    Button clearButton;

    Animation slidein;
    Animation fadein;
    Animation fadeout;

    String correctAnswer = "У него есть книга";
    String s = "y";

    ViewGroup viewGroup;
    ImageView mark;
    TextView ResponseField;
    TextView text1;
    TextView text2;
    TextView hint;
    TextView hint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate_sentence_8_12);

        showHint = findViewById(R.id.showHint);
        showHint.setText("Тэрэ");
        showHint2 = findViewById(R.id.showHint2);
        showHint2.setText("номтой");

        Button btn1 = findViewById(R.id.btn1);
        btn1.setText("него");
        Button btn2 = findViewById(R.id.btn2);
        btn2.setText("есть");
        Button btn3 = findViewById(R.id.btn3);
        btn3.setText("ты");
        Button btn4 = findViewById(R.id.btn4);
        btn4.setText("У");
        Button btn5 = findViewById(R.id.btn5);
        btn5.setText("машина");
        Button btn6 = findViewById(R.id.btn6);
        btn6.setText("книга");

        ResponseField = findViewById(R.id.ResponseField);

        check = findViewById(R.id.check);
        check.setEnabled(false);
        showHint = findViewById(R.id.showHint);
        showHint2 = findViewById(R.id.showHint2);

        viewGroup = findViewById(R.id.response);
        viewGroup.setAlpha(0);
        mark = findViewById(R.id.mark);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        hint = findViewById(R.id.hint);
        hint.setAlpha(0);
        hint2 = findViewById(R.id.hint2);
        hint2.setAlpha(0);

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
        }
        else {
            Log.d("HINT_TOGGLE", "Hint disabled");
            hintVisibility = false;
            hint.setAlpha(0);
            hint.startAnimation(fadeout);
        }
    }

    boolean hintVisibility2 = false;
    public void showHintToggle2(View v) {
        if(hintVisibility2 == false) {
            hintVisibility2 = true;
            hint2.setAlpha(1);
            hint2.startAnimation(fadein);
        }
        else {
            hintVisibility2 = false;
            hint2.setAlpha(0);
            hint2.startAnimation(fadeout);
        }
    }

    public void add(View v) {
        ResponseField.setText(ResponseField.getText().toString()+button.getText().toString()+" ");
    }

    public void buttonClick(View v) {
        button = (Button) v;
        add(v);
        check.setEnabled(true);
        v.setEnabled(false);
        v.setBackground(getDrawable(R.drawable.button_oval_selected));
    }

    public void clear(View v) {
        clearButton = (Button) v;
        ResponseField.setText("");
        check.setEnabled(false);
        findViewById(R.id.btn1).setEnabled(true);
        findViewById(R.id.btn1).setBackground(getDrawable(R.drawable.button_oval));
        findViewById(R.id.btn2).setEnabled(true);
        findViewById(R.id.btn2).setBackground(getDrawable(R.drawable.button_oval));
        findViewById(R.id.btn3).setEnabled(true);
        findViewById(R.id.btn3).setBackground(getDrawable(R.drawable.button_oval));
        findViewById(R.id.btn4).setEnabled(true);
        findViewById(R.id.btn4).setBackground(getDrawable(R.drawable.button_oval));
        findViewById(R.id.btn5).setEnabled(true);
        findViewById(R.id.btn5).setBackground(getDrawable(R.drawable.button_oval));
        findViewById(R.id.btn6).setEnabled(true);
        findViewById(R.id.btn6).setBackground(getDrawable(R.drawable.button_oval));
    }

    Random random = new Random();
    int r;
    /*String[] correctStr = {getString(R.string.awesome), getString(R.string.correct),
                        getString(R.string.amazing), getString(R.string.great),
                        getString(R.string.perfect), getString(R.string.keepGoing)};*/
    String[] correctStr = {"Так держать!", "Хорошо!", "Верно!"};
    String incorrect = "Неверно";
    public void onClickCheck(View v) {
        check = (Button) v;
        s = ResponseField.getText().toString().trim();
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
        findViewById(R.id.btn5).setEnabled(false);
        findViewById(R.id.btn6).setEnabled(false);
        findViewById(R.id.clearButton).setEnabled(false);
    }

    public void Continue (View v) {
        Intent i = new Intent(this, Lesson2_7.class);
        startActivity(i);
        finish();
    }

}
