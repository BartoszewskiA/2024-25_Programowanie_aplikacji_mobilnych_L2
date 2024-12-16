package com.example.lab07p01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView iv_01, iv_02, iv_03, iv_04;
    int[] obrazki = {R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04};

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
        iv_01 = findViewById(R.id.a1_im_01);
        iv_02 = findViewById(R.id.a1_im_02);
        iv_03 = findViewById(R.id.a1_im_03);
        iv_04 = findViewById(R.id.a1_im_04);
        iv_01.setImageResource(obrazki[0]);
        iv_02.setImageResource(obrazki[1]);
        iv_03.setImageResource(obrazki[2]);
        iv_04.setImageResource(obrazki[3]);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                int wybrane_id;
                if(id == R.id.a1_im_01)
                    wybrane_id = obrazki[0];
                else if(id == R.id.a1_im_02)
                    wybrane_id = obrazki[1];
                else if(id == R.id.a1_im_03)
                    wybrane_id = obrazki[2];
                else
                    wybrane_id = obrazki[3];
                Intent intencja = new Intent(MainActivity.this, MainActivity2.class);
                intencja.putExtra("id", wybrane_id);
                startActivity(intencja);
            }
        };
        iv_01.setOnClickListener(sluchacz);
        iv_02.setOnClickListener(sluchacz);
        iv_03.setOnClickListener(sluchacz);
        iv_04.setOnClickListener(sluchacz);

    }
}