package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class creditActivity extends AppCompatActivity
{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        tv = findViewById(R.id.tv);
        Intent gi = getIntent();
        Double lastans = gi.getDoubleExtra("lastans",0.0);
        tv.setText("The last answer was: "+lastans);


    }

    public void goBack(View view)
    {
        finish();
    }
}