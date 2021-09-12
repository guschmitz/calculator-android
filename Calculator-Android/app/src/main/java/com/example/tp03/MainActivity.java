package com.example.tp03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fonction qui créera une minuterie de 5 secondes,
        //puis ouvrira la classe CalculatorActivity.
        new CountDownTimer(5000, 1000) {

            TextView countDownText = (TextView) findViewById(R.id.txtCountDonw);

            //Function minuterie.
            public void onTick(long pTime) {
                countDownText.setText(pTime / 1000 + "");
            }

            //Fonction effectuée à la fin de la minuterie.
            public void onFinish() {
                countDownText.setText("Les's do it!");
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}