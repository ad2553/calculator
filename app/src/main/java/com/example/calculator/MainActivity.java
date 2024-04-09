package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity
{
    EditText display;
    String st;
    boolean boplus = true;
    boolean bominus = true;
    boolean bodiv = true;
    boolean bomul = true;
    boolean actable = true;
    double currentnum,currentnum2,lastanswer;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }
    public  boolean canAct(String st)
    {
            if (st.isEmpty() || st == "-" || st == "." || st == "+" || st == "-." || st == "+." || !actable)
            {
                Toast.makeText(this,"invalid input",Toast.LENGTH_LONG).show();
                return false;
            }
            else
            {
                return true;
            }


    }
    public void plusclicked(View view)
    {
        st = display.getText().toString();
        if (canAct(st))
        {
            display.setHint(st);
            display.setText("");
            currentnum = Double.parseDouble(st);
            actable = false;
            boplus = false;
        }
    }

    public void minusclicked(View view)
    {
        st = display.getText().toString();
        if (canAct(st))
        {
            display.setHint(st);
            display.setText("");
            currentnum = Double.parseDouble(st);
            actable = false;
            bominus = false;
        }
    }

    public void multiclicked(View view)
    {
        st = display.getText().toString();
        if (canAct(st))
        {
            display.setHint(st);
            display.setText("");
            currentnum = Double.parseDouble(st);
            actable = false;
            bomul = false;
        }
    }

    public void diviclicked(View view)
    {
        st = display.getText().toString();
        if (canAct(st))
        {
            display.setHint(st);
            display.setText("");
            currentnum = Double.parseDouble(st);
            actable = false;
            bodiv = false;
        }
    }

    public void resetclicked(View view)
    {
        actable = true;
        boplus = true;
        bominus = true;
        bodiv = true;
        bomul = true;
        currentnum = 0;
        currentnum2 = 0;
        display.setHint("");
        display.setText("");
    }

    public void equalsclicked(View view)
    {
        st = display.getText().toString();
        if(st.isEmpty() || st == "-" || st == "." || st == "+" || st == "-." || st == "+.")
            Toast.makeText(this,"invalid input",Toast.LENGTH_LONG).show();
        else
        {
            currentnum2 = Double.parseDouble(st);
            if (!boplus) lastanswer = currentnum+currentnum2;
            if (!bominus) lastanswer = currentnum-currentnum2;
            if (!bomul) lastanswer = currentnum*currentnum2;
            if (!bodiv) lastanswer = currentnum/currentnum2;
            display.setHint(lastanswer+"");
            display.setText("");
            actable = true;
            boplus = true;
            bominus = true;
            bodiv = true;
            bomul = true;

        }

    }

    public void creditclicked(View view)
    {
        Intent si = new Intent(this, creditActivity.class);
        si.putExtra("lastans",lastanswer);
        startActivity(si);
    }
}