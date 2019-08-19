package com.example.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.util.Random;
import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private int win=0;
    private int loss=0;
    private float ratio=0;
    int cpuMove(){
        Random r = new Random();
        int x = r.nextInt(3);
        x += 1;
        return x;
    }
    float ratioFunc(int win, int loss){
        float winF = win;
        float lossF = loss;
        if(loss == 0 || lossF == 0){
            return win;
        }
        else{
            float r = winF/lossF;
            BigDecimal out = new BigDecimal(r).setScale(3,RoundingMode.HALF_UP);
            float f = out.floatValue();
            return f;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rockButton = (Button) findViewById(R.id.rockButton);
        Button paperButton = (Button) findViewById(R.id.paperButton);
        Button scissorButton = (Button) findViewById(R.id.scissorButton);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);
        final TextView winNumber = (TextView) findViewById(R.id.winNumber);
        final TextView lossNumber = (TextView) findViewById(R.id.lossNumber);
        final TextView ratioNumber = (TextView) findViewById(R.id.ratioNumber);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int move = cpuMove();
                if(move == 1) {
                    textView3.setText("CPU chose Rock");
                    textView4.setText("It's a TIE!");
                    ratio = ratioFunc(win,loss);
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else if(move == 2){
                    textView3.setText("CPU chose Paper");
                    textView4.setText("You lost!");
                    loss++;
                    lossNumber.setText("Loss: "+Integer.toString(loss));
                    ratio = ratioFunc(win,loss);
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else{
                    textView3.setText("CPU chose Scissor");
                    textView4.setText("You Won!");
                    win++;
                    winNumber.setText("Wins: "+Integer.toString(win));
                    ratio = ratioFunc(win,loss);
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int move = cpuMove();
                if(move == 1) {
                    textView3.setText("CPU chose Rock");
                    textView4.setText("You won!");
                    win++;
                    winNumber.setText("Wins: "+Integer.toString(win));
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else if(move == 2){
                    textView3.setText("CPU chose Paper");
                    textView4.setText("It's a TIE!");
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else{
                    textView3.setText("CPU chose Scissor");
                    textView4.setText("You lost!");
                    loss++;
                    lossNumber.setText("Loss: "+Integer.toString(loss));
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
            }
        });

        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int move = cpuMove();
                if(move == 1) {
                    textView3.setText("CPU chose Rock");
                    textView4.setText("You lost!");
                    loss++;
                    lossNumber.setText("Loss: "+Integer.toString(loss));
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else if(move == 2){
                    textView3.setText("CPU chose Paper");
                    textView4.setText("You Won!");
                    win++;
                    winNumber.setText("Wins: "+Integer.toString(win));
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
                else{
                    textView3.setText("CPU chose Scissor");
                    textView4.setText("It's a TIE!");
                    ratio = win/loss;
                    ratioNumber.setText("Ratio: "+Float.toString(ratio));
                }
            }
        });

    }
}
