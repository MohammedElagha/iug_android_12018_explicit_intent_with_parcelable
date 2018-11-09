package com.example.mohammed_elagha.explicitintentwithparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idEditText, nameEditText, gpaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEditText = findViewById(R.id.std_id);
        nameEditText = findViewById(R.id.std_name);
        gpaEditText = findViewById(R.id.std_gpa);

        Button nextButton = findViewById(R.id.next_btn);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idEditTextContent = idEditText.getText().toString();
                String nameEditTextContent = nameEditText.getText().toString();
                String gpaEditTextContent = gpaEditText.getText().toString();

                if(!idEditTextContent.trim().equals("") && !nameEditTextContent.trim().equals("") && !gpaEditTextContent.trim().equals("")) {
                    int id = Integer.parseInt(idEditTextContent);
                    String name = nameEditTextContent;
                    double gpa = Double.parseDouble(gpaEditTextContent);

                    Student student = new Student();
                    student.setId(id);
                    student.setName(name);
                    student.setGpa(gpa);

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("student", student);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "One or More EditText is/are Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
