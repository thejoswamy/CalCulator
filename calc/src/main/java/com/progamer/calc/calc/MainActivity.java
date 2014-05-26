package com.progamer.calc.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView inputView;
    private Button clearButton;
    private Button deleteButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button dotButton;
    private Button plusButton;
    private Button minusButton;
    private Button multiplyButton;
    private Button divideButton;
    private Button equalsButton;

    private String buffer = "";
    private double value1 = 0;
    private double value2 = 0;
    private char operator = 0;
    private boolean sign = false; //check to make sure -,. are followed by number.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputView = (TextView) findViewById(R.id.textView);
        clearButton = (Button) findViewById(R.id.clear_button);
        deleteButton = (Button) findViewById(R.id.delete_button);
        oneButton = (Button) findViewById(R.id.one_button);
        twoButton = (Button) findViewById(R.id.two_button);
        threeButton = (Button) findViewById(R.id.three_button);
        fourButton = (Button) findViewById(R.id.four_button);
        fiveButton = (Button) findViewById(R.id.five_button);
        sixButton = (Button) findViewById(R.id.six_button);
        sevenButton = (Button) findViewById(R.id.seven_button);
        eightButton = (Button) findViewById(R.id.eight_button);
        nineButton = (Button) findViewById(R.id.nine_button);
        zeroButton = (Button) findViewById(R.id.zero_button);
        dotButton = (Button) findViewById(R.id.dot_button);
        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        multiplyButton = (Button) findViewById(R.id.multiply_button);
        divideButton = (Button) findViewById(R.id.divide_button);
        equalsButton = (Button) findViewById(R.id.equals_button);

        clearButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        equalsButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.clear_button:
                buffer = "";
                value1 = 0;
                operator = 0;
                inputView.setText(buffer);
                break;
            case R.id.delete_button:
                if (buffer.length() > 0)
                    buffer = buffer.substring(0, buffer.length()-1);
                inputView.setText(buffer);
                break;
            case R.id.one_button:
                buffer += 1;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.two_button:
                buffer += 2;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.three_button:
                buffer += 3;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.four_button:
                buffer += 4;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.five_button:
                buffer += 5;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.six_button:
                buffer += 6;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.seven_button:
                buffer += 7;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.eight_button:
                buffer += 8;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.nine_button:
                buffer += 9;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.zero_button:
                buffer += 0;
                inputView.setText(buffer);
                sign = false;
                break;
            case R.id.dot_button:
                buffer += ".";
                sign = true;
                inputView.setText(buffer);
                break;
            case R.id.plus_button:
                if (buffer.length() > 0 && operator != 0 && !sign) {
                    value2 = Double.parseDouble(buffer);
                    value1 = calculate(value1, value2, operator);
                    inputView.setText(Double.toString(value1));
                    operator = '+';
                    buffer = "";
                } else if (buffer.length() > 0 && operator == 0 && !sign) {
                    value1 = Double.parseDouble(buffer);
                    operator = '+';
                    buffer = "";
                }
                break;
            case R.id.minus_button:
                if (buffer.length() > 0 && operator != 0 && !sign) {
                    value2 = Double.parseDouble(buffer);
                    value1 = calculate(value1, value2, operator);
                    inputView.setText(Double.toString(value1));
                    operator = '-';
                    buffer = "";
                } else if (buffer.length() > 0 && operator == 0 && !sign) {
                    value1 = Double.parseDouble(buffer);
                    operator = '-';
                    buffer = "";
                } else if (buffer.length() == 0) {
                    buffer += '-';
                    inputView.setText(buffer);
                    sign = true;
                }
                break;
            case R.id.multiply_button:
                if (buffer.length() > 0 && operator != 0 && !sign) {
                    value2 = Double.parseDouble(buffer);
                    value1 = calculate(value1, value2, operator);
                    inputView.setText(Double.toString(value1));
                    operator = '*';
                    buffer = "";
                } else if (buffer.length() > 0 && operator == 0 && !sign) {
                    value1 = Double.parseDouble(buffer);
                    operator = '*';
                    buffer = "";
                }
                break;
            case R.id.divide_button:
                if (buffer.length() > 0 && operator != 0 && !sign) {
                    value2 = Double.parseDouble(buffer);
                    value1 = calculate(value1, value2, operator);
                    inputView.setText(Double.toString(value1));
                    operator = '/';
                    buffer = "";
                } else if (buffer.length() > 0 && operator == 0 && !sign) {
                    value1 = Double.parseDouble(buffer);
                    operator = '/';
                    buffer = "";
                }
                break;
            case R.id.equals_button:
                if (buffer.length() > 0 && operator != 0) {
                    value2 = Double.parseDouble(buffer);
                    value1 = calculate(value1, value2, operator);
                    inputView.setText(Double.toString(value1));
                    operator = 0;
                    buffer = Double.toString(value1);
                } else if (buffer.length() == 0 && operator != 0) {
                    inputView.setText(Double.toString(value1));
                    buffer = "";
                }
                break;

            default:
                break;
        }
    }

    private double calculate(double val1, double val2, char op) {

        double result = 0;

        switch (op) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                result = val1 / val2;
                break;
        }

        return result;
    }

}