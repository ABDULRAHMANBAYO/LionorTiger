package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    enum Player {ONE, TWO}

    Player currentPlayer = Player.ONE;

    Player[] playerChoice = new Player[9];

//    int [] [] arrayOfArrays = {{1,2,4},{4,5,6},{7,8,9}};

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
