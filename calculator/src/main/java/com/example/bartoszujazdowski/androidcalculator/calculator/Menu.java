package com.example.bartoszujazdowski.androidcalculator.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button simpleButton;
    private Button advanceButton;
    private Button aboutButton;
    private Button exitButton;

    private void init(){
        simpleButton = (Button) findViewById(R.id.simpleButton);
        advanceButton = (Button) findViewById(R.id.advanceButton);
        aboutButton = (Button) findViewById(R.id.aboutButton);
        exitButton = (Button) findViewById(R.id.exitButton);

        simpleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Menu.this, SimpleModeActivity.class);
                startActivity(intent);
            }
        });

        advanceButton.setOnClickListener((view) -> {
            Intent intent = new Intent(Menu.this, AdvancedModeActivity.class);
            startActivity(intent);
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }


}
