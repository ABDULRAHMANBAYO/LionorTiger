package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    enum Player {ONE, TWO}

    enum PlayerSelection {LION, TIGER}

    Player currentPlayer = Player.ONE;

    Player[] playerChoice = new Player[9];

    int[][] winnerRowColumn = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    PlayerSelection[][] playerSelections = new PlayerSelection[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageViewIsTapped(View imageView) {
        ImageView tappedImageView = (ImageView) imageView;
        tappedImageView.setTranslationX(-2000);
        int tImageTag = Integer.parseInt(tappedImageView.getTag().toString());
        playerChoice[tImageTag] = currentPlayer;
//        for (int m = 0; m < playerChoice.length; m++)
//            for (int i = 0; i < 2; i++)
//                for (int j = 0; j < 2; j++)
//                    playerSelections[i][j] = playerChoice[tImageTag]);


        if (currentPlayer == Player.ONE) {

            tappedImageView.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if (currentPlayer == Player.TWO) {
            tappedImageView.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }
        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
    }
}
