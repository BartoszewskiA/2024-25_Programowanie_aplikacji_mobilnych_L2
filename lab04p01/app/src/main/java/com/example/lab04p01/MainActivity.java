package com.example.lab04p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int[] obrazki = {R.drawable.owoc01, R.drawable.owoc02, R.drawable.owoc03, R.drawable.owoc04};
    int poz_1=0, poz_2=0, poz_3=0;
    int kredyt = 50;
    int licnik =0;
    ImageView iv_01, iv_02, iv_03;
    Button btn_graj, btn_nowa_gra;
    TextView tv_kredyt, tv_seria;


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
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        btn_graj = findViewById(R.id.btn_graj);
        btn_nowa_gra = findViewById(R.id.btn_nowa_gra);
        tv_kredyt = findViewById(R.id.tv_kredyt);
        tv_seria = findViewById(R.id.tv_seria);
        btn_graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losuj();
                licz();
            }
        });
        btn_nowa_gra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_01.setImageDrawable(null);
                iv_02.setImageDrawable(null);
                iv_03.setImageDrawable(null);
                kredyt=50;
                licnik=0;
                tv_kredyt.setText(String.valueOf(kredyt));
                tv_seria.setText(String.valueOf(licnik));
                btn_graj.setEnabled(true);
            }
        });

    }

    private void licz() {
        if(poz_1==poz_2 && poz_2==poz_3)
            kredyt+=30;
        else if(poz_1==poz_2 || poz_1==poz_3 || poz_2==poz_3);
        else
            kredyt-=10;
        licnik++;
        tv_kredyt.setText(String.valueOf(kredyt));
        tv_seria.setText(String.valueOf(licnik));
        if(kredyt<=0)
            btn_graj.setEnabled(false);

    }

    private void losuj() {
        poz_1 = random.nextInt(obrazki.length);
        poz_2 = random.nextInt(obrazki.length);
        poz_3 = random.nextInt(obrazki.length);
        iv_01.setImageResource(obrazki[poz_1]);
        iv_02.setImageResource(obrazki[poz_2]);
        iv_03.setImageResource(obrazki[poz_3]);
    }
}