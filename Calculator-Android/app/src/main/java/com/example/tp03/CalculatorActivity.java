package com.example.tp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity{

    //Déclaration des variables.
    TextView vDisplay;

    private double vNum;
    private boolean vCalculate = false;
    private boolean vUpdate = false;
    private String vOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //Chaque bouton est attribué à une variable via findViewById.
        Button vBtn0 = (Button) findViewById(R.id.btn0);
        Button vBtn1 = (Button) findViewById(R.id.btn1);
        Button vBtn2 = (Button) findViewById(R.id.btn2);
        Button vBtn3 = (Button) findViewById(R.id.btn3);
        Button vBtn4 = (Button) findViewById(R.id.btn4);
        Button vBtn5 = (Button) findViewById(R.id.btn5);
        Button vBtn6 = (Button) findViewById(R.id.btn6);
        Button vBtn7 = (Button) findViewById(R.id.btn7);
        Button vBtn8 = (Button) findViewById(R.id.btn8);
        Button vBtn9 = (Button) findViewById(R.id.btn9);
        Button vBtnPoint = (Button) findViewById(R.id.btnPoint);
        Button vBtnSum = (Button) findViewById(R.id.btnSum);
        Button vBtnSub = (Button) findViewById(R.id.btnSub);
        Button vBtnMult = (Button) findViewById(R.id.btnMult);
        Button vBtnDiv = (Button) findViewById(R.id.btnDiv);
        Button vBtnC = (Button) findViewById(R.id.btnC);
        Button vBtnEqual = (Button) findViewById(R.id.btnEqual);

        vDisplay = (TextView)findViewById(R.id.txtResult);

        //Chaque bouton appelle sa fonction correspondante en utilisant setOnClickListener.
        vBtn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("0");
            }
        });
        vBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("1");
            }
        });
        vBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("2");
            }
        });
        vBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("3");
            }
        });
        vBtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("4");
            }
        });
        vBtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("5");
            }
        });
        vBtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("6");
            }
        });
        vBtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("7");
            }
        });
        vBtn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("8");
            }
        });
        vBtn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked("9");
            }
        });
        vBtnPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numClicked(".");
            }
        });
        vBtnSum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sumClicked();
            }
        });
        vBtnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                subClicked();
            }
        });
        vBtnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multClicked();
            }
        });
        vBtnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClicked();
            }
        });
        vBtnEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                equalClicked();
            }
        });
        vBtnC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearClicked();
            }
        });

    }

    //Fonction appelée lors de la saisie d'un numéro.
    //Utilisé pour définir le nombre sur le display et changer la valeur de vUpdate si il est True.
    public void numClicked(String str) {
        if(vUpdate){
            vUpdate = false;
        }else{
            if(!vDisplay.getText().equals("0"))
                str = vDisplay.getText() + str;
        }
        vDisplay.setText(str);
    }

    //Fonction appelée lors de la saisie de +.
    //Sert à définir le vOperato égal à +, vUpdate égal à True.
    //Si vCalculate est égal à False, vNum sera égal au nombre saisi précédemment et changera vCalculate en True.
    //Si vCalculate est True, il appellera la fonction calculation et changera vDisplay à la valeur de vNum.
    public void sumClicked(){
        if(vCalculate){
            calculation();
            vDisplay.setText(String.valueOf(vNum));
        }else{
            vNum = Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vCalculate = true;
        }
        vOperator = "+";
        vUpdate = true;
    }

    //Fonction appelée lors de la saisie de -.
    //Sert à définir le vOperato égal à -, vUpdate égal à True.
    //Si vCalculate est égal à False, vNum sera égal au nombre saisi précédemment et changera vCalculate en True.
    //Si vCalculate est True, il appellera la fonction calculation et changera vDisplay à la valeur de vNum.
    public void subClicked(){
        if(vCalculate){
            calculation();
            vDisplay.setText(String.valueOf(vNum));
        }else{
            vNum = Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vCalculate = true;
        }
        vOperator = "-";
        vUpdate = true;
    }

    //Fonction appelée lors de la saisie de X.
    //Sert à définir le vOperato égal à X, vUpdate égal à True.
    //Si vCalculate est égal à False, vNum sera égal au nombre saisi précédemment et changera vCalculate en True.
    //Si vCalculate est True, il appellera la fonction calculation et changera vDisplay à la valeur de vNum.
    public void multClicked(){
        if(vCalculate){
            calculation();
            vDisplay.setText(String.valueOf(vNum));
        }else{
            vNum = Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vCalculate = true;
        }
        vOperator = "x";
        vUpdate = true;
    }

    //Fonction appelée lors de la saisie de ÷.
    //Sert à définir le vOperato égal à /, vUpdate égal à True.
    //Si vCalculate est égal à False, vNum sera égal au nombre saisi précédemment et changera vCalculate en True.
    //Si vCalculate est True, il appellera la fonction calculation et changera vDisplay à la valeur de vNum.
    public void divClicked(){
        if(vCalculate){
            calculation();
            vDisplay.setText(String.valueOf(vNum));
        }else{
            vNum = Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vCalculate = true;
        }
        vOperator = "/";
        vUpdate = true;
    }

    //Fonction appelée lors de la saisie de =.
    //La fonction appelle la fonction Calc, change la valeur de vUpdate en True et vCalculate en False.
    public void equalClicked(){
        calculation();
        vUpdate = true;
        vCalculate = false;
    }

    //Fonction appelée lors de la saisie de C.
    //La function change la valeur de vUpdate en True, vCalculate en False, vNum en 0,
    // efface la valeur de vOperator et affiche la valeur 0 en Display.
    public void clearClicked(){
        vCalculate = false;
        vUpdate = true;
        vNum = 0;
        vOperator = "";
        vDisplay.setText("0");
    }

    //Fonction de calcul.
    private void calculation(){
        //Ajoutez la valeur de vNum avec le nombre sur le Display.
        //Modifie la valeur d'affichage du résultat de la somme.
        if(vOperator.equals("+")){
            vNum = vNum + Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vDisplay.setText(String.valueOf(vNum));
        }
        //Diminuez la valeur de vNum avec le nombre sur le Display.
        //Modifie la valeur d'affichage du résultat de la soustraction.
        if(vOperator.equals("-")){
            vNum = vNum - Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vDisplay.setText(String.valueOf(vNum));
        }
        //Multipliez la valeur de vNum par le nombre sur le Display.
        //Modifie la valeur d'affichage du résultat de la multiplication.
        if(vOperator.equals("x")){
            vNum = vNum * Double.valueOf(vDisplay.getText().toString()).doubleValue();
            vDisplay.setText(String.valueOf(vNum));
        }

        //Divisez la valeur vNum par le nombre sur le Display.
        if(vOperator.equals("/")){
            //Si le nombre sur le Display est zéro, cela indique l'erreur sur le Display.
            if(Double.valueOf(vDisplay.getText().toString()).doubleValue() == 0 || Double.valueOf(vDisplay.getText().toString()).doubleValue() == 0.0){
                vDisplay.setText("ERROR - Div par zéro");
            }else{
                //Utilisez try pour effectuer la division.
                //Modifie la valeur d'affichage du résultat de la division.
                try{
                    vNum = vNum / Double.valueOf(vDisplay.getText().toString()).doubleValue();
                    vDisplay.setText(String.valueOf(vNum));
                //Si vous renvoyez une erreur, elle s'affichera à le Display.
                }catch(ArithmeticException e){
                    vDisplay.setText("ERROR");
                }
            }
        }
    }
}