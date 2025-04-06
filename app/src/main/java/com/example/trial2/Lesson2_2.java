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

public class Lesson2_2 extends AppCompatActivity {

    Random random = new Random();

    Button button;
    Button check;
    Button showHint;
    Button showHint2;
    Button clearButton;

    Animation slidein;
    Animation fadein;
    Animation fadeout;

    String correctAnswer = "У нас есть книга и у них есть большое письмо";
    String s = "y";

    ViewGroup viewGroup;
    ImageView mark;
    TextView ResponseField;
    TextView text1;
    TextView text2;

    TextView hint; TextView hint2;
    TextView hint3; TextView hint4;
    TextView hint5; TextView hint6;
    TextView hint7; TextView hint8;

    Button btn1; Button btn2; Button btn3; Button btn4; Button btn5; Button btn6;
    Button btn7; Button btn8; Button btn9; Button btn10; Button btn11; Button btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate_sentence_8_12);

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

        slidein = AnimationUtils.loadAnimation(this, R.anim.slidein);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        hint = findViewById(R.id.hint);
        hint.setAlpha(0);
        hint2 = findViewById(R.id.hint2);
        hint2.setAlpha(0);
        hint3 = findViewById(R.id.hint3);
        hint3.setAlpha(0);
        hint4 = findViewById(R.id.hint4);
        hint4.setAlpha(0);
        hint5 = findViewById(R.id.hint5);
        hint5.setAlpha(0);
        hint6 = findViewById(R.id.hint6);
        hint6.setAlpha(0);
        hint7 = findViewById(R.id.hint7);
        hint7.setAlpha(0);
        hint8 = findViewById(R.id.hint8);
        hint8.setAlpha(0);

        hint.setText("мы");
        hint2.setText("у нас есть книга");
        hint3.setText("и");
        hint4.setText("они");
        hint5.setText("большой");
        hint6.setText("у них есть письмо");
        hint7.setText("и");
        hint8.setText("у них есть овца");

        btn1 = findViewById(R.id.btn1); btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3); btn4  = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5); btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7); btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9); btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11); btn12 = findViewById(R.id.btn12);
        Button[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6,
                            btn7, btn8, btn9, btn10, btn11, btn12};

        for(int i = 0; i <= buttons.length; i++) {
            buttons[i].setText(scramble());
        }

    }

    public String scramble() {
        Log.d("SCRAMBLE_METHOD", "UNIVERSITY OF HONG KONG");
        String[] str = correctAnswer.trim().split(" ");
        int r = random.nextInt(str.length);
        String label = str[r];
        do {
            if(label.equals("")) {
                r = random.nextInt(str.length);
                label = str[r];
            }
        }while(label == "");
        str[r] = "";
        return label;
    }

    boolean hintVisibility = false;
    public void showHintToggle(View v) {
        if(hintVisibility == false) {
            hintVisibility = true;
            hint.setAlpha(1);
            hint.startAnimation(fadein);
        }
        else {
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
    boolean hintVisibility3 = false;
    public void showHintToggle3(View v) {
        if(hintVisibility3 == false) {
            hintVisibility3 = true;
            hint3.setAlpha(1);
            hint3.startAnimation(fadein);
        }
        else {
            hintVisibility3 = false;
            hint3.setAlpha(0);
            hint3.startAnimation(fadeout);
        }
    }
    boolean hintVisibility4 = false;
    public void showHintToggle4(View v) {
        if(hintVisibility4 == false) {
            hintVisibility4 = true;
            hint4.setAlpha(1);
            hint4.startAnimation(fadein);
        }
        else {
            hintVisibility4 = false;
            hint4.setAlpha(0);
            hint4.startAnimation(fadeout);
        }
    }
    boolean hintVisibility5 = false;
    public void showHintToggle5(View v) {
        if(hintVisibility5 == false) {
            hintVisibility5 = true;
            hint2.setAlpha(1);
            hint2.startAnimation(fadein);
        }
        else {
            hintVisibility5 = false;
            hint5.setAlpha(0);
            hint5.startAnimation(fadeout);
        }
    }
    boolean hintVisibility6 = false;
    public void showHintToggle6(View v) {
        if(hintVisibility6 == false) {
            hintVisibility6 = true;
            hint6.setAlpha(1);
            hint6.startAnimation(fadein);
        }
        else {
            hintVisibility6 = false;
            hint6.setAlpha(0);
            hint6.startAnimation(fadeout);
        }
    }
    boolean hintVisibility7 = false;
    public void showHintToggle7(View v) {
        if(hintVisibility7 == false) {
            hintVisibility7 = true;
            hint2.setAlpha(1);
            hint2.startAnimation(fadein);
        }
        else {
            hintVisibility7 = false;
            hint7.setAlpha(0);
            hint7.startAnimation(fadeout);
        }
    }
    boolean hintVisibility8 = false;
    public void showHintToggle8(View v) {
        if(hintVisibility8 == false) {
            hintVisibility8 = true;
            hint8.setAlpha(1);
            hint8.startAnimation(fadein);
        }
        else {
            hintVisibility8 = false;
            hint8.setAlpha(0);
            hint8.startAnimation(fadeout);
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

    int r;
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
        Intent i = new Intent(this, Lesson2_3.class);
        startActivity(i);
        finish();
    }
}