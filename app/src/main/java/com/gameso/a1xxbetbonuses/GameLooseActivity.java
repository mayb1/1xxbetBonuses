package com.gameso.a1xxbetbonuses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameLooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_loose);

        Button buttonLooseExit = findViewById(R.id.buttonLooseExit);
        Button buttonTryAgainLoose = findViewById(R.id.buttonTryAgainLoose);
        buttonTryAgainLoose.setOnClickListener(onClickTryAgainLoose);
        buttonLooseExit.setOnClickListener(onClickLooseExit);
    }

    View.OnClickListener onClickTryAgainLoose = view -> {
        Intent intent = new Intent(GameLooseActivity.this, GameLevelOneActivity.class);
        startActivity(intent);
        finish();
    };

    View.OnClickListener onClickLooseExit = view -> finishAffinity();

}