package com.topurayhan.calculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    int i = 0, j = 0, k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void buttonClick(View view) throws ScriptException {
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
                    String str3 = number.substring(number.length()-1);
                    String input = number;
                    input = input.replace('×', '*');
                    input = input.replace('÷', '/');

                    List<String> list = new ArrayList<String>(Arrays.asList(number.split("[)(+-÷×]")));
                    if (str3.equals(".") || number.contains(".") && !(number.contains("(") || number.contains(")") ||
                        number.contains("+") || number.contains("-") || number.contains("×") || number.contains("÷")) ) {
                        break;
                    }
                    else {
                        number += ".";
                        k++;
                    }
                    break;


                // Open Bracket Button function and error handling
                case R.id.btnOB:
                    String str4 = number.substring(number.length()-1);
                    if (number.equals("0")) {
                        number = "(";
                        i++;
                    }
                    else if (str4.equals("0") || str4.equals("1") || str4.equals("2") || str4.equals("3") || str4.equals("4") ||
                            str4.equals("5") || str4.equals("6") || str4.equals("7") || str4.equals("8") || str4.equals("9") || str4.equals(")")){
                        number += "×(";
                        i++;
                    }
                    else {
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
                char check;
                check = number.charAt(number.length()-1);
                if (check != '+' || check != '-' || check != '×' || check != '÷' || check!= '(' && (number.contains("+")
                        || number.contains("-") || number.contains("×") || number.contains("÷"))){
                    String res = calculateResult();
                    result.setText("= "+ res);
                }

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
            info.setText("0");
            result.setText("");
        }

    }


    @SuppressLint("SetTextI18n")
    public String calculateResult() {
        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        String res = "";
        String str = info.getText().toString();

        str = str.replace('×', '*');
        str = str.replace('÷', '/');
        str = str.replace('(', ' ');
        str = str.replace(')', ' ');


        if(str.length() > 1){

            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("rhino");

            double temp = 0.0;

            try {
                temp = (double)scriptEngine.eval(str);
            } catch (ScriptException e) {
                e.printStackTrace();
            }

            if(temp == Double.POSITIVE_INFINITY || temp == Double.NEGATIVE_INFINITY){
                res = Double.toString(temp);
            }
            else{
                res = Double.toString(temp);
                String decimal = res.split("\\.")[1];

                if (decimal.equals("0")){
                    res = res.split("\\.")[0];
                }
            }
        }


        result.setText("= " + res);
        return res;
    }


    public void equalButtonEvent(View view) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(15);

        TextView info = findViewById(R.id.info);
        TextView result = findViewById(R.id.result);

        String str = info.getText().toString();

        String res = calculateResult();
        info.setText(res);
        result.setText("");
    }
}