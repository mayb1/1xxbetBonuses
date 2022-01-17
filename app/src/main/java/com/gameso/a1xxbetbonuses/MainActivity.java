package com.gameso.a1xxbetbonuses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.buttonStart);
        Button buttonExit = findViewById(R.id.buttonExit);
        buttonStart.setOnClickListener(onClickStart);
        buttonExit.setOnClickListener(onClickExit);
    }

    View.OnClickListener onClickStart = view -> {
        Intent intent = new Intent(MainActivity.this, GameLevelOneActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickExit = view -> finishAffinity();
}