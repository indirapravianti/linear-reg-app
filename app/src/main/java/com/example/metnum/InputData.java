package com.example.metnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputData extends AppCompatActivity {
    float[] X;
    float[] Y;
    float sumX = 0, sumY = 0, sumXY = 0, sumXX = 0, errorTotal = 0;
    float a, b;
    int i = 0;
    int n;
    Button btnCalculate;
    EditText editTextX;
    EditText editTextY;
    TextView result;
    TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        Intent intent = getIntent();
        X = new float[100];
        Y = new float [100];
        btnCalculate = findViewById(R.id.btnCalculate);
        editTextX = findViewById(R.id.editTextX);
        editTextY = findViewById(R.id.editTextY);
        result = findViewById(R.id.textViewResult);
        errorText = findViewById(R.id.textViewError);
        n = Integer.parseInt(intent.getStringExtra("EXTRA_N"));

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                X[i] = Float.parseFloat(editTextX.getText().toString());
                Y[i] = Float.parseFloat(editTextY.getText().toString());
                if(i < n) {
                    editTextX.getText().clear();
                    editTextY.getText().clear();
                    ++i;
                    Log.v("n adalah = ", String.valueOf(n));
                    Log.v("i adalah = ", String.valueOf(i));
                    if (i == n-1){
                        btnCalculate.setText("CALCULATE");
                    }
                    if(i == n){
                        for(int w = 0; w < n; w++) {
                            sumX += X[w];
                            sumY += Y[w];
                            sumXY += (X[w] * Y[w]);
                            sumXX += (X[w] * X[w]);

                            Log.v("nilai X", String.valueOf(X[w]));
                            Log.v("nilai Y", String.valueOf(Y[w]));
                        }

                        Log.v("nilai sumX", String.valueOf(sumX));
                        Log.v("nilai sumY", String.valueOf(sumY));
                        Log.v("nilai sumXY", String.valueOf(sumXY));
                        Log.v("nil3ai sumXX", String.valueOf(sumXX));

                        //btnCalculate.setVisibility(View.GONE);
                        b = ((n*sumXY) - (sumX * sumY)) / ((n * sumXX) - (sumX*sumX));
                        a = (sumY / n) - ((sumX / n) * b);
                        for(int w = 0; w < n; w++){
                            errorTotal += (Y[w] - a - b * X[w]) *(Y[w] - a - b * X[w]);
                        }
                        Log.v("nilai a", String.valueOf(a));
                        Log.v("nilai b", String.valueOf(b));
                        result.setText("The regression line is Y = " + a + " + " + b + " X");
                        errorText.setText("The sum of error is " + errorTotal);
                    }
                }

            }
        });



    }

}
