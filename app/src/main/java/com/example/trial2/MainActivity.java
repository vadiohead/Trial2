package com.example.trial2;

import androidx.appcompat.app.*;

import android.view.*;
import android.content.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick1(View v) {
        Intent i = new Intent(this, Lesson1_1.class);
        startActivity(i);
    }

    public void onClick2(View v) {
        Intent i = new Intent(this, Lesson2_1.class);
        startActivity(i);
    }

    public void onClick3(View v) {

    }
}