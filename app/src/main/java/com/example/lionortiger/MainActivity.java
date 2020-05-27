package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    enum Player {ONE, TWO, NoONE}

    Player currentPlayer = Player.ONE;
    Player[] playerChoices = new Player[9];
    int[][] winnerRowColumn = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    private boolean gameOver = false;
    private Button resetBtn;
    private GridLayout gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerChoices[0] = Player.NoONE;
        playerChoices[1] = Player.NoONE;
        playerChoices[2] = Player.NoONE;
        playerChoices[3] = Player.NoONE;
        playerChoices[4] = Player.NoONE;
        playerChoices[5] = Player.NoONE;
        playerChoices[6] = Player.NoONE;
        playerChoices[7] = Player.NoONE;
        playerChoices[8] = Player.NoONE;

        resetBtn = findViewById(R.id.resetButton);
        gridView = findViewById(R.id.gridLayout);


        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    public void imageViewIsTapped(View imageView) {
        ImageView tappedImageView = (ImageView) imageView;
        int tImageTag = Integer.parseInt(tappedImageView.getTag().toString());
        if (playerChoices[tImageTag] == Player.NoONE && gameOver == false) {
            tappedImageView.setTranslationX(-2000);
            playerChoices[tImageTag] = currentPlayer;
            if (currentPlayer == Player.ONE) {
                tappedImageView.setImageResource(R.drawable.lion);
                currentPlayer = Player.TWO;
            } else if (currentPlayer == Player.TWO) {
                tappedImageView.setImageResource(R.drawable.tiger);
                currentPlayer = Player.ONE;
            }
            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
            for (int[] winnerColumns : winnerRowColumn) {

                if (playerChoices[winnerColumns[0]] == playerChoices[winnerColumns[1]] &&
                        playerChoices[winnerColumns[1]] == playerChoices[winnerColumns[2]]
                        && playerChoices[winnerColumns[0]] != Player.NoONE) {
                    gameOver = true;
                    String winnerOfGame = "";
                    resetBtn.setVisibility(View.VISIBLE);
                    if (currentPlayer == Player.ONE) {
                        winnerOfGame = "Player Two";
//                    Toast.makeText(this, "Player Two is the winner", Toast.LENGTH_SHORT).show();
                    } else if (currentPlayer == Player.TWO) {
                        winnerOfGame = "Player One";
//                    Toast.makeText(this, "Player One is the winner", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(this, winnerOfGame + " is the winner", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    //Reset game
    private void resetGame() {
        for (int i = 0; i < gridView.getChildCount(); i++) {
            ImageView imageView = (ImageView) gridView.getChildAt(i);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.0f);
        }
        currentPlayer = Player.ONE;
        playerChoices[0] = Player.NoONE;
        playerChoices[1] = Player.NoONE;
        playerChoices[2] = Player.NoONE;
        playerChoices[3] = Player.NoONE;
        playerChoices[4] = Player.NoONE;
        playerChoices[5] = Player.NoONE;
        playerChoices[6] = Player.NoONE;
        playerChoices[7] = Player.NoONE;
        playerChoices[8] = Player.NoONE;
        gameOver = false;
        resetBtn.setVisibility(View.INVISIBLE);

    }
}
