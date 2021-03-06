 package com.example.bartoszujazdowski.androidcalculator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SimpleModeActivity extends AppCompatActivity {

    protected EditText resultET;
    protected EditText resultText;

    protected StringBuilder input = new StringBuilder();
    protected Calculate calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mode);
        this.initialize();
    }

    protected void initialize(){
        this.calculate = new Calculate();
        resultText = (EditText) findViewById(R.id.resultNumber);
        resultText.setText(input);
        resultET = (EditText) findViewById(R.id.result);
    }

    public void onClickPlusMinus(View view){
        if (this.input.length() == 0){
            return;
        }
        Double val = Double.parseDouble(this.input.toString());
        if (val < 0){
            this.input.deleteCharAt(0);
        } else {
            this.input.insert(0, '-');
        }
        this.refreshInput();
    }

    public void onClickBack(View view){
        int len = this.input.length()-1;
        if(len < 0){
            return;
        }
        this.input = this.input.deleteCharAt(len);
        this.refreshInput();
    }

    private void refreshInput(){
        this.resultET.setText( this.calculate.getFirstNum().toString() );
        this.resultText.setText(this.input);
    }

    public void onClickAction(View view){
        Button action = (Button) view;
        if (this.input.length() > 0) {
            this.calculate.setNum(Double.parseDouble(input.toString()));
        }
        try {
            this.calculate.setAction(Action.get(action.getText().toString()));
        } catch (ArithmeticException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        this.input = new StringBuilder();
        this.refreshInput();
    }

    public void onClickEquals(View view){
        if (this.input.length() > 0) {
            try {
                this.calculate.setNum(Double.parseDouble(this.input.toString()));
            } catch (NumberFormatException ex){
                Toast.makeText(this.getApplicationContext(), "Enter correct number!", Toast.LENGTH_LONG);
            }
        }
        try {
            this.calculate.equal();
        } catch (ArithmeticException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        this.input = new StringBuilder();
        this.refreshInput();
    }

    public void onClickDelete(View view){
        if (this.input.length() == 0){
            this.calculate.clear();
        } else {
            this.input = new StringBuilder();
        }
        this.refreshInput();
    }

    public void onClickDigit(View view){
        Button digit = (Button) view;
        CharSequence ch = digit.getText();
        this.input.append(ch);
        this.refreshInput();
    }

    public void onClickComa(View view) throws Exception {
        if ( this.input.indexOf(".") != -1 ){
            return;
        }
        this.input.append(".");
        this.refreshInput();
    }
}
