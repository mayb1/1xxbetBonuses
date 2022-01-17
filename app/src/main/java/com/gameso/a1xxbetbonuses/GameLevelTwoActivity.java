package com.gameso.a1xxbetbonuses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GameLevelTwoActivity extends AppCompatActivity {

    private int bonusIcon = 5;
    private boolean loose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_level_two);

        Button buttonExitLevelTwo = findViewById(R.id.buttonExitLevelTwo);
        buttonExitLevelTwo.setOnClickListener(onClickExitLevelTwo);

        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView7 = findViewById(R.id.imageView7);
        ImageView imageView9 = findViewById(R.id.imageView9);
        ImageView imageView10 = findViewById(R.id.imageView10);
        ImageView imageView11 = findViewById(R.id.imageView11);
        ImageView[] icons = new ImageView[]{imageView, imageView2, imageView7, imageView9, imageView10, imageView11};
        for(ImageView icon : icons){
            icon.setOnClickListener(onClickCardLevelTwoListener);
            String iconName = getResources().getResourceEntryName(icon.getId());
            icon.setTag(iconName);
        }
    }

    View.OnClickListener onClickExitLevelTwo = view -> finishAffinity();

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

    View.OnClickListener onClickCardLevelTwoListener = view -> {
        ImageView clickedView = (ImageView) view;
        clickedView.setImageResource(getRandomBonus());
        if(bonusIcon != 0) {
            if(loose){
                Intent intent = new Intent(GameLevelTwoActivity.this, GameLooseActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(GameLevelTwoActivity.this, "Great! Find another one", Toast.LENGTH_SHORT).show();
                bonusIcon--;
                clickedView.setClickable(false);
            }
        } else {
            Intent intent = new Intent(GameLevelTwoActivity.this, GameWinActivity.class);
            startActivity(intent);
            finish();
        }
    };
}