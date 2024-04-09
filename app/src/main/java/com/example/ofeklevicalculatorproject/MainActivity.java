package com.example.ofeklevicalculatorproject;

import android.content.Intent;
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
            sum = sum + 1;
            number = Float.parseFloat(str);
            if (oper.equals("-"))
                resu = resu - number;
            else if (oper.equals("/")) {
                if (number != 0)
                    resu = resu / number;
                else
                    dataDisplay.setText("Math ERROR");
            }
            else if (oper.equals("*"))
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
            sum = sum + 1;
            number = Float.parseFloat(str);
            if (oper.equals("+"))
                resu = resu + number;
            else if (oper.equals("/")) {
                if (number != 0)
                    resu = resu / number;
                else
                    dataDisplay.setText("Math ERROR");
            }
            else if (oper.equals("*"))
                resu = resu * number;
            else {
                if (sum != 1)
                    resu -= number;
                else
                    if (oper.equals(""))
                        resu = number;
                    else
                        resu = Float.valueOf(-number);
            }
        }
        oper = "-";
        dataDisplay.setText("");
        dataDisplay.getHint();
    }

    public void division(View view) {
        str = dataDisplay.getText().toString();
        if (!str.isEmpty()) {
            sum = sum + 1;
            number = Float.parseFloat(str);
            if (oper.equals("-"))
                resu = resu - number;
            else if (oper.equals("+"))
                resu = resu + number;
            else if (oper.equals("*"))
                resu = resu + number;
            else {
                if (number == 0)
                    dataDisplay.setText("Math ERROR");
                else if (sum == 1)
                    resu = number;
                else
                    resu = resu / number;
            }
            oper = "/";
        }
        dataDisplay.setText("");
        dataDisplay.getHint();
    }

    public void multi(View view) {
        str = dataDisplay.getText().toString();
        if (!str.isEmpty()) {
            sum = sum + 1;
            number = Float.parseFloat(str);
            if (oper.equals("-"))
                resu = resu - number;
            else if (oper.equals("+"))
                resu = resu + number;
            else if (oper.equals("/")) {
                if (number != 0)
                    resu = resu / number;
                else
                    dataDisplay.setText("Math ERROR");
            }
            else {
                if (sum != 1)
                    resu = resu * number;
                else
                    resu = number;
            }
            oper = "*";
        }
        dataDisplay.setText("");
        dataDisplay.getHint();
    }

    public void restart(View view) {
        resu = 0;
        oper = "";
        sum = 0;
        dataDisplay.setText("");
        dataDisplay.getHint();
    }

    public void equals(View view) {
        if (oper.equals("-")) {
            str = dataDisplay.getText().toString();
            number = Float.parseFloat(str);
            resu = resu - number;
        }
        if (oper.equals("+")) {
            str = dataDisplay.getText().toString();
            number = Float.parseFloat(str);
            resu = resu + number;
        }
        if (oper.equals("/")) {
            str = dataDisplay.getText().toString();
            number = Float.parseFloat(str);
            if (number != 0) {
                resu = resu / number;
                dataDisplay.setText(resu + "");
            }
            else
                dataDisplay.setText("Math ERROR");
        }
        else
            dataDisplay.setText(resu + "");
        if (oper.equals("*")) {
            str = dataDisplay.getText().toString();
            number = Float.parseFloat(str);
            resu = resu * number;
        }
    }

    public void display2(View view) {
        Intent si = new Intent(this, MainActivity2.class);
        if (dataDisplay.getText().toString().equals("Math ERROR"))
            si.putExtra("math error", "Math ERROR");
        si.putExtra("number", resu);
        startActivity(si);
    }
}



   




