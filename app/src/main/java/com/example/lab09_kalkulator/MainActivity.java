package com.example.lab09_kalkulator;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab09_kalkulator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sluchaczCyfr();
    }

    private void sluchaczCyfr()
    {
        binding.p0.setOnClickListener(e -> dodajCyfre("0"));
        binding.p1.setOnClickListener(e -> dodajCyfre("1"));
        binding.p2.setOnClickListener(e -> dodajCyfre("2"));
        binding.p3.setOnClickListener(e -> dodajCyfre("3"));
        binding.p4.setOnClickListener(e -> dodajCyfre("4"));
        binding.p5.setOnClickListener(e -> dodajCyfre("5"));
        binding.p6.setOnClickListener(e -> dodajCyfre("6"));
        binding.p7.setOnClickListener(e -> dodajCyfre("7"));
        binding.p8.setOnClickListener(e -> dodajCyfre("8"));
        binding.p9.setOnClickListener(e -> dodajCyfre("9"));
    }

    private void dodajCyfre(String number) {
    }

}