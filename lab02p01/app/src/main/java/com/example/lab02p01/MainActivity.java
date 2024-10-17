package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText01, editText02, editText03;
    TextView textView02;
    public void licz(View view) {
        String wynik = "";
        double a=0, b=0, c=0;
        try {
            a = Double.parseDouble(editText01.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Pole a nie może być puste", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            b = Double.parseDouble(editText02.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Pole b nie może być puste", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            c = Double.parseDouble(editText03.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Pole c nie może być puste", Toast.LENGTH_SHORT).show();
            return;
        }

        double delta = b * b - 4 * a * c;
        wynik+="Delta=";
        wynik+=String.valueOf(delta);
        wynik+="\n";

        if(delta<0)
        {
            wynik+="Brak rozwiązań";
            textView02.setText(wynik);
            return;
        }
        if(delta==0) {
            double x = -b / (2 * a);
            x= Math.round(x * 1000.0) / 1000.0;
            wynik+="\nx1=x2=";
            wynik+=String.valueOf(x);
            textView02.setText(wynik);
            return;
        }
        double x1 = (-b - Math.sqrt(delta)) / (2 * a);
        x1 = Math.round(x1 * 1000.0) / 1000.0;
        double x2 = (-b + Math.sqrt(delta)) / (2 * a);
        x2= Math.round(x2 * 1000.0) / 1000.0;
        wynik+="x1=";
        wynik+=String.valueOf(x1);
        wynik+="\nx2=";
        wynik+=String.valueOf(x2);
        textView02.setText(wynik);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        editText03 = findViewById(R.id.editText03);
        textView02 = findViewById(R.id.textView02);
    }

    public void kasuj(View view) {
        editText01.setText("0");
        editText02.setText("0");
        editText03.setText("0");
        textView02.setText("");
    }
}