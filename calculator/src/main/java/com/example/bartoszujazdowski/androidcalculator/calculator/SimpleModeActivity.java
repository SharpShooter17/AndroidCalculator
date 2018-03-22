package com.example.bartoszujazdowski.androidcalculator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SimpleModeActivity extends AppCompatActivity {

    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button delButton;
    private Button divButton;
    private Button multipleButton;
    private Button minusButton;
    private Button addButton;

    private EditText resultText;

    private double result = 0.0;
    private double input = 0.0;

    private List<Button> actionButtons;
    private List<Button> numberButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mode);
        initialize();
    }

    private void initialize(){
        resultText = (EditText) findViewById(R.id.resultNumber);
        resultText.setText("0");

        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        delButton = (Button) findViewById(R.id.delButton);
        divButton = (Button) findViewById(R.id.divButton);
        multipleButton = (Button) findViewById(R.id.multipleButton);
        minusButton = (Button) findViewById(R.id.minusButton);
        addButton = (Button) findViewById(R.id.plusButton);

        numberButtons = new ArrayList<>();
        numberButtons.add(num0);
        numberButtons.add(num1);
        numberButtons.add(num2);
        numberButtons.add(num3);
        numberButtons.add(num4);
        numberButtons.add(num5);
        numberButtons.add(num6);
        numberButtons.add(num7);
        numberButtons.add(num8);
        numberButtons.add(num9);

        actionButtons = new ArrayList<>();
        actionButtons.add(divButton);
        actionButtons.add(multipleButton);
        actionButtons.add(minusButton);
        actionButtons.add(addButton);

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleModeActivity.this.result = 0.0;
                SimpleModeActivity.this.input = 0.0;
            }
        });

        for(Button digit : numberButtons){
        }
    }

    public void onClickDigit(View view){

    }
}
