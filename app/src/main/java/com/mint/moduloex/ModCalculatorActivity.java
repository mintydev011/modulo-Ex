package com.mint.moduloex;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ModCalculatorActivity extends AppCompatActivity {
    EditText inputA, inputM;
    Button btnCalculate;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_calculator);

        inputA = findViewById(R.id.inputA);
        inputM = findViewById(R.id.inputM);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> calculate());
    }

    private void calculate(){
        String aStr = inputA.getText().toString();
        String mStr = inputM.getText().toString();

        if (aStr.isEmpty() || mStr.isEmpty()) {
            tvResult.setText("Please fill in both fields");
            return;
        }

        long a = Long.parseLong(aStr);
        long m = Long.parseLong(mStr);

        if (m <= 0) {
            tvResult.setText("Modulus must be greater than 0");
            return;
        }

        long result = a % m;

        // Java's % can return negative for negative a, this fixes that
        if (result < 0) result += m;

        tvResult.setText("Result: " + a + " mod " + m + " = " + result);
    }
}