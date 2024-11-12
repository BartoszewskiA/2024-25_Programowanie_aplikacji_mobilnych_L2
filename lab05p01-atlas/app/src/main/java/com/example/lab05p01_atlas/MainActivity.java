package com.example.lab05p01_atlas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int[] obrazy = {
            R.drawable.muchomor,
            R.drawable.borowik,
            R.drawable.maslak
    };
    String[] nazwy;
    String[] opisy;
    int pozycja = 0;
    ImageView imageView;
    TextView textView_nazwa;
    TextView textView_opis;
    Button btn_next;
    Button btn_back;

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
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);

        imageView = findViewById(R.id.imageView);
        textView_nazwa = findViewById(R.id.tv_nazwa);
        textView_opis = findViewById(R.id.tv_opis);
        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);

        textView_nazwa.setText(nazwy[pozycja]);
        textView_opis.setText(opisy[pozycja]);
        imageView.setImageResource(obrazy[pozycja]);


    }
}