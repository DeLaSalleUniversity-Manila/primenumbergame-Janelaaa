package com.example.janela.primenumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int number = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();

    }

    public void onClickPrime(View view){
        if(isPrime(number)){
            //toast here
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Previous Number: " + number, Toast.LENGTH_SHORT).show();
        }

        start();

    }

    public void onClickComposite(View view){
        if(!isPrime(number)){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            score -= 5;
            Toast.makeText(this, "Previous Number: " + number, Toast.LENGTH_SHORT).show();
        }

        start();
    }


    private boolean isPrime(int value){
        for (int divisor = 2; divisor < value; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private void displayRandomNumber(){
        Random random = new Random();
        number = 2 + random.nextInt(999);
        TextView tnum = (TextView) findViewById(R.id.number);
        tnum.setText("" + number);
    }

    private void displayScore(){
        TextView tscore = (TextView) findViewById(R.id.score);
        tscore.setText("Score: " + score);

    }
    private void start(){
        displayScore();
        displayRandomNumber();
    }
}
