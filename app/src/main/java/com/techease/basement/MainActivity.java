package com.techease.basement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnSignIn,btnSignUp,btnRegister;
    Typeface t1;
    EditText etuser,etemail,etpass,etcpass;
    EditText date;
    DatePickerDialog datePickerDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignIn=(Button)findViewById(R.id.btnSignIN);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LogIn.class);
                startActivity(intent);
                finish();
            }
        });
        textView=(TextView)findViewById(R.id.tvTerms);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DummyText.class);
                startActivity(intent);
                finish();
            }
        });

        t1=Typeface.createFromAsset(this.getAssets(), "fonts/Av.otf");
        //t2=Typeface.createFromAsset(this.getAssets(),"fonts/ac.otf");
        //t3=Typeface.createFromAsset(this.getAssets(),"fonts/gold.ttf");

        btnSignIn.setTypeface(t1);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
         btnSignUp.setTypeface(t1);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        btnRegister.setTypeface(t1);

        etuser=(EditText)findViewById(R.id.etUsername);
        etemail=(EditText)findViewById(R.id.etEmail);
        etpass=(EditText)findViewById(R.id.etPassword);
        etcpass=(EditText)findViewById(R.id.etCPassword);

        etcpass.setTypeface(t1);
        etpass.setTypeface(t1);
        etemail.setTypeface(t1);
        etuser.setTypeface(t1);

        date = (EditText) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}
