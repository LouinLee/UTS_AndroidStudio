package com.example.uts_louin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize both buttons
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Set up click listeners
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        button1.setOnClickListener(view -> navigateTo(SepActivity.class));
        button2.setOnClickListener(view -> navigateTo(FormActivity.class));
    }

    private void navigateTo(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}