package com.gameso.a1xxbetbonuses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GameLevelOneActivity extends AppCompatActivity {
    private boolean loose;
    private int bonusIcon  = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level_one);

        Button buttonExitLevelOne = findViewById(R.id.buttonExitLevelOne);
        buttonExitLevelOne.setOnClickListener(onClickExitLevelOne);

        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageView imageView4 = findViewById(R.id.imageView4);
        ImageView imageView5 = findViewById(R.id.imageView5);
        ImageView imageView6 = findViewById(R.id.imageView6);
        ImageView[] icons = new ImageView[]{imageView3, imageView4, imageView5, imageView6};
        for(ImageView icon : icons){
            icon.setOnClickListener(onClickCardListener);
            String iconName = getResources().getResourceEntryName(icon.getId());
            icon.setTag(iconName);
        }
    }

    View.OnClickListener onClickExitLevelOne = view -> finishAffinity();

    private int getRandomBonus(){
        int bonusId;
        if(Math.random() > 0.5) {
            bonusId = R.drawable.win_icon;
            loose = false;
        } else {
            bonusId = R.drawable.lose_icon;
            loose = true;
        }
        return bonusId;
    }


    View.OnClickListener onClickCardListener = view -> {
        ImageView clickedView = (ImageView) view;
        clickedView.setImageResource(getRandomBonus());
        if(loose) {
            Intent intent = new Intent(GameLevelOneActivity.this, GameLooseActivity.class);
            startActivity(intent);
            finish();
        } else if (bonusIcon != 1) {
            Toast.makeText(GameLevelOneActivity.this, "Great! Find another one", Toast.LENGTH_SHORT).show();
            bonusIcon--;
            clickedView.setClickable(false);
        } else {
            Intent intentLevelTwo = new Intent(GameLevelOneActivity.this, GameLevelTwoActivity.class);
            startActivity(intentLevelTwo);
            finish();
        }
    };
}