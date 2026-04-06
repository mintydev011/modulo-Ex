package com.mint.moduloex;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button modCalculatorButton;
    Button ceasarCypherButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modCalculatorButton = findViewById(R.id.btnMod);
        ceasarCypherButton = findViewById(R.id.btnCaesar);

        modCalculatorButton.setOnClickListener(v -> openModCalculator());
        ceasarCypherButton.setOnClickListener(v -> openCeasarCypher());
    }

    private void openModCalculator(){
        Intent intent = new Intent(this, ModCalculatorActivity.class);
        startActivity(intent);
    }

    private void openCeasarCypher(){
        Intent intent = new Intent(this, CeasarCypherActivity.class);
        startActivity(intent);
    }

}