 package com.example.bartoszujazdowski.androidcalculator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SimpleModeActivity extends AppCompatActivity {

    private Button delButton;

    private EditText resultET;
    private EditText resultText;

    private StringBuilder input = new StringBuilder();
    private Calculate calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mode);
        this.calculate = new Calculate();
        initialize();
    }

    private void initialize(){
        resultText = (EditText) findViewById(R.id.resultNumber);
        resultText.setText(input);
        resultET = (EditText) findViewById(R.id.result);
        delButton = (Button) findViewById(R.id.delButton);
    }

    private void refreshInput(){
        this.resultET.setText( this.calculate.getFirstNum().toString() );
        this.resultText.setText(this.input);
    }

    public void onClickAction(View view){
        Button action = (Button) view;
        this.calculate.setNum(Double.parseDouble(input.toString()));
        this.calculate.setAction(Action.get(action.getText().toString()));
        this.input = new StringBuilder();
        this.refreshInput();
    }

    public void onClickEquals(View view){
        this.calculate.setNum(Double.parseDouble(this.input.toString()));
        this.calculate.equal();
        this.input = new StringBuilder(this.calculate.getFirstNum().toString());
        this.refreshInput();
    }

    public void onClickDelete(View view){
        this.calculate.clear();
        this.input = new StringBuilder();
        this.refreshInput();
    }

    public void onClickDigit(View view){
        Button digit = (Button) view;
        CharSequence ch = digit.getText();
        this.input.append(ch);
        this.refreshInput();
    }

    public void onClickComa(View view) throws Exception {
        if ( input.indexOf(".") != -1 ){
            return;
        }
        input.append(".");
        refreshInput();
    }
}
