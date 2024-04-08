package com.example.ofeklevicalculatorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText dataDisplay;
    Button credits, restart, equal, multiplication, division, plus, sub;
    float number, resu;
    int sum;
    String oper, str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sub = findViewById(R.id.sub);
        dataDisplay = findViewById(R.id.dataDisplay);
        credits = findViewById(R.id.credits);
        restart = findViewById(R.id.restart);
        equal = findViewById(R.id.equal);
        multiplication = findViewById(R.id.multiplication);
        division = findViewById(R.id.division);
        plus = findViewById(R.id.plus);

        resu = 0;
        sum = 0;
        oper = "";
        str = "";
    }


    public void plus(View view) {
        str = dataDisplay.getText().toString();
        if (!str.isEmpty()) {
            sum += 1;
            number = Float.parseFloat(str);
            if (oper.equals("-"))
                resu = resu - number;
            else if (oper.equals("/")) {
                if (number == 0)
                    dataDisplay.setText("Math ERROR");
                else
                    resu = resu / number;
            } else if (oper.equals("*"))
                resu = resu * number;
            else
                resu = resu + number;
            oper = "+";
        }
        dataDisplay.setText("");
        dataDisplay.getHint();
    }

    public void sub(View view) {
        str = dataDisplay.getText().toString();
        if (!str.isEmpty()) {
            sum+=1;
            number = Float.parseFloat(str);
            if (oper.equals("+"))
                resu = resu + number;
            else if (oper.equals("/")) {
                if (number == 0)
                    dataDisplay.setText("Math ERROR");
                else
                    resu = resu / number;
            } else if (oper.equals("*"))
                resu = resu * number;


        }
    }

    public void restart(View view) {
        sum=0;
        dataDisplay.setText("");
        resu=0;
        oper="";
    }



