package com.example.metnum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    EditText editTextn;
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextn =findViewById(R.id.editTextn);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = Integer.parseInt(editTextn.getText().toString());
                Intent intent = new Intent(MainActivity.this, InputData.class);
                intent.putExtra("EXTRA_N", editTextn.getText().toString());
                startActivity(intent);
            }
        });
    }
}
