package com.gameso.a1xxbetbonuses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameWinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        Button buttonWinExit = findViewById(R.id.buttonLooseExit);
        Button buttonWinAgain = findViewById(R.id.buttonTryAgainLoose);
        buttonWinAgain.setOnClickListener(onClickTryWinAgain);
        buttonWinExit.setOnClickListener(onClickWinExit);
    }

    View.OnClickListener onClickTryWinAgain = view -> {
        Intent intent = new Intent(GameWinActivity.this, GameLevelOneActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickWinExit = view -> finishAffinity();

}