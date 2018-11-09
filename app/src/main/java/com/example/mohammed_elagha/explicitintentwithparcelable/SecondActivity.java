package com.example.mohammed_elagha.explicitintentwithparcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mohammed El-Agha on 28/10/18.
 */

public class SecondActivity extends AppCompatActivity {

    TextView idVal, nameVal, gpaVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        idVal = findViewById(R.id.id_val);
        nameVal = findViewById(R.id.name_val);
        gpaVal = findViewById(R.id.gpa_val);

        Intent intent = getIntent();

        if(intent.hasExtra("student")) {
            Student student = (Student) intent.getParcelableExtra("student");

            String idValText = String.valueOf(student.getId());
            String nameValText = student.getName();
            String gpaValText = String.valueOf(student.getGpa());

            idVal.setText(idValText);
            nameVal.setText(nameValText);
            gpaVal.setText(gpaValText);
        }
    }
}
