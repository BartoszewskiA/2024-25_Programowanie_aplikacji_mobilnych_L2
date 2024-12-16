package com.example.lab08p01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView_01, imageView_02, imageView_03, imageView_04;
    Button button_01, button_02, button_03, button_04;
    int[] obrazki = {R.drawable.wilk01,
            R.drawable.wilk02,
            R.drawable.wilk03,
            R.drawable.wilk04};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageView_01 = findViewById(R.id.a2_iv_01);
        imageView_02 = findViewById(R.id.a2_iv_02);
        imageView_03 = findViewById(R.id.a2_iv_03);
        imageView_04 = findViewById(R.id.a2_iv_04);
        button_01 = findViewById(R.id.a2_btn_01);
        button_02 = findViewById(R.id.a2_btn_02);
        button_03 = findViewById(R.id.a2_btn_03);
        button_04 = findViewById(R.id.a2_btn_04);
        imageView_01.setImageResource(obrazki[0]);
        imageView_02.setImageResource(obrazki[1]);
        imageView_03.setImageResource(obrazki[2]);
        imageView_04.setImageResource(obrazki[3]);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencja = new Intent();
                int id = v.getId();
                if (id == R.id.a2_btn_01)
                    intencja.putExtra("obraz", obrazki[0]);
                else if (id == R.id.a2_btn_02)
                    intencja.putExtra("obraz", obrazki[1]);
                else if (id == R.id.a2_btn_03)
                    intencja.putExtra("obraz", obrazki[2]);
                else
                    intencja.putExtra("obraz", obrazki[3]);
                setResult(RESULT_OK, intencja);
                finish();
            }
        };
        imageView_01.setOnClickListener(sluchacz);
        imageView_02.setOnClickListener(sluchacz);
        imageView_03.setOnClickListener(sluchacz);
        imageView_04.setOnClickListener(sluchacz);

    }
}