package com.example.hoshiraku.dumpguessgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int rand1 = 0;
    private int rand2 = 0;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateRandomNumber();

        TextView resultLabel =  findViewById(R.id.resultLabel);
        resultLabel.setText("Point: " + points);

        Button lButton = findViewById(R.id.leftButton);
        lButton.setText(Integer.toString(rand1));
        Button rButton = findViewById(R.id.rightButton);
        rButton.setText(Integer.toString(rand2));
    }

    private void updateRandomNumber(){
        Random randy = new Random();
        rand1 = randy.nextInt(100);
        while (true){
            rand2 = randy.nextInt(100);
            if(rand1 != rand2) break;
        }
        //Log.v("verbose", "rand1: "+rand1);
        //Log.v("verbose", "rand2: "+rand2);
    }

    public void click_leftButton(View view) {
        Log.v("verbose", "Left button is clicked. ");
        if(rand1 > rand2){
            Toast.makeText(this, "You got it.", Toast.LENGTH_SHORT).show();
            points++;
        }else{
            Toast.makeText(this, "You sucked.", Toast.LENGTH_SHORT).show();
            points--;
        }
        updateRandomNumber();

        Button lButton = findViewById(R.id.leftButton);
        lButton.setText(Integer.toString(rand1));
        Button rButton = findViewById(R.id.rightButton);
        rButton.setText(Integer.toString(rand2));

        TextView resultLabel =  findViewById(R.id.resultLabel);
        resultLabel.setText("Point: " + points);
    }

    public void click_rightButton(View view) {
        Log.v("verbose", "Right button is clicked. ");
        if(rand2 > rand1){
            Toast.makeText(this, "You got it.", Toast.LENGTH_SHORT).show();
            points++;
        }else{
            Toast.makeText(this, "You sucked.", Toast.LENGTH_SHORT).show();
            points--;
        }
        updateRandomNumber();

        Button lButton = findViewById(R.id.leftButton);
        lButton.setText(Integer.toString(rand1));
        Button rButton = findViewById(R.id.rightButton);
        rButton.setText(Integer.toString(rand2));

        TextView resultLabel =  findViewById(R.id.resultLabel);
        resultLabel.setText("Point: " + points);
    }
}
