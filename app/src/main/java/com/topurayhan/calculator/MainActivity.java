package com.topurayhan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Double a = 0.0;
    Double b = 0.0;
    Double c = 0.0;
    Double res = 0.0;
    String oldNumber = "";
    String newNumber = "";
    String temp = "";
    int start = 0;
    int end = 0;
    int i = 0, j = 0, k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void buttonClick(View view){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(15);

        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);
        String number = info.getText().toString();

        if(number.length() < 22) {
            switch (view.getId()) {
                case R.id.btn0:
                    if (number.equals("0")) {
                        number = "0";
                    } else {
                        number += "0";
                    }
                    break;

                case R.id.btn1:
                    if (number.equals("0")) {
                        number = "1";
                    } else {
                        number += "1";
                    }
                    break;

                case R.id.btn2:
                    if (number.equals("0")) {
                        number = "2";
                    } else {
                        number += "2";
                    }
                    break;

                case R.id.btn3:
                    if (number.equals("0")) {
                        number = "3";
                    } else {
                        number += "3";
                    }
                    break;

                case R.id.btn4:
                    if (number.equals("0")) {
                        number = "4";
                    } else {
                        number += "4";
                    }
                    break;

                case R.id.btn5:
                    if (number.equals("0")) {
                        number = "5";
                    } else {
                        number += "5";
                    }
                    break;

                case R.id.btn6:
                    if (number.equals("0")) {
                        number = "6";
                    } else {
                        number += "6";
                    }
                    break;

                case R.id.btn7:
                    if (number.equals("0")) {
                        number = "7";
                    } else {
                        number += "7";
                    }
                    break;

                case R.id.btn8:
                    if (number.equals("0")) {
                        number = "8";
                    } else {
                        number += "8";
                    }
                    break;

                case R.id.btn9:
                    if (number.equals("0")) {
                        number = "9";
                    } else {
                        number += "9";
                    }
                    break;


                // Decimal Button function and error handling
                case R.id.btnPoint:
//                    String str = number.substring(number.length)
                    if (number.contains(".") && !(number.contains("(") || number.contains(")") ||
                            number.contains("+") || number.contains("-") || number.contains("×") || number.contains("÷"))) {
                        break;
                    }
                    else {
                        number += ".";
                        k++;
                    }
                    break;


                // Open Bracket Button function and error handling
                case R.id.btnOB:
                    if (number.equals("0")) {
                        number = "(";
                        i++;
                    } else {
                        number += "(";
                        i++;
                    }
                    break;


                // Closed Bracket Button function and error handling
                case R.id.btnCB:
                    String str1 = number.substring(number.length() - 1);
                    if(j < i) {
                        if (number.contains("(") && !str1.equals("(")) {
                            number += ")";
                            j++;
                        } else if (number.equals("0")) {
                            number = "";
                            break;
                        } else {
                            break;
                        }
                    }
                    else{
                        break;
                    }
                    break;


                // Addition Button function and error handling
                case R.id.btnAdd:
                    if (number.equals("0")) {
                        number = "";
                        break;
                    } else {
                        String str = number.substring(number.length() - 1);
                        if (str.equals("+") || (str.equals("(") && number.length()==1)) {
                            break;
                        }
                        else if (str.equals("-") || str.equals("×") || str.equals("÷") || str.equals("(")){
                            number = number.substring(0, number.length() - 1);
                            number += "+";
                        }
                        else {
                            number += "+";
                        }
                    }
                    break;


                // Subtraction Button function and error handling
                case R.id.btnSub:
                    if (number.equals("0")) {
                        number = "-";
                    }
                    else {
                        String str = number.substring(number.length() - 1);
                        if (str.equals("-")) {
                            break;
                        }
                        else if (str.equals("(") && number.length()==1){
                            number += "-";
                        }
                        else if (str.equals("+") || str.equals("(")){
                            number = number.substring(0, number.length() - 1);
                            number += "-";
                        }
                        else {
                            number += "-";
                        }
                    }
                    break;


                // Division Button function and error handling
                case R.id.btnDiv:
                    if (number.equals("0")) {

                        number += "÷";
                    }
                    else {
                        String str = number.substring(number.length() - 1);
                        if (str.equals("÷")|| (str.equals("(") && number.length()==1)) {
                            break;
                        }
                        else if (str.equals("+") || str.equals("×") || str.equals("-") || str.equals("(")){
                            number = number.substring(0, number.length() - 1);
                            number += "÷";
                        }
                        else {
                            number += "÷";
                        }
                    }
                    break;


                // Multiplication Button function and error handling
                case R.id.btnMul:
                    if (number.equals("0")) {
                        number += "×";
                        break;
                    } else {
                        String str = number.substring(number.length() - 1);
                        if (str.equals("×")|| (str.equals("(") && number.length()==1)) {
                            break;
                        }
                        else if (str.equals("+") || str.equals("÷") || str.equals("-") || str.equals("(")){
                            number = number.substring(0, number.length() - 1);
                            number += "×";
                        }
                        else {
                            number += "×";
                        }
                    }
                    break;

            }

            if (number.equals("")){
                info.setText("0");
                result.setText("");
            }
            else {
                info.setText(number);
                result.setText("= " + number);
//                String str = calculateResult();
            }

        }
        else{
            vibrator.vibrate(100);
        }

    }


    public void clearAll(View view) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(15);

        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        a = 0.0;
        b = 0.0;
        c = 0.0;
        info.setText("0");
        result.setText("");
    }


    @SuppressLint("SetTextI18n")
    public void clearOneDigit(View view) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(15);

        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        String str = info.getText().toString();
        String chopString = str.substring(0, str.length() - 1);
        if (chopString.length() > 0){
            info.setText(chopString);
            result.setText("= " + chopString);
        }
        else if(chopString.length() == 0){
            a = 0.0;
            b = 0.0;
            c = 0.0;
            info.setText("0");
            result.setText("");
        }

    }


    @SuppressLint("SetTextI18n")
    public String calculateResult(){
        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        String res; String input;
        String str = info.getText().toString();

        input = str.replace('×', '*');
        input = str.replace('÷', '/');
     // input = str.replace('+', '+');
     // input = str.replace('-', '-');

        double temp = Double.parseDouble(input);
        res = Double.toString(temp);

        result.setText("= " + res);
        return res;
    }


    public void equalButtonEvent(View view){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(15);

        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        String res = calculateResult();
        info.setText(res);
        result.setText("");
    }
}