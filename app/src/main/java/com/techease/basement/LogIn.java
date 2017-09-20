package com.techease.basement;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    Button btnSignUp,btnLogIn;
    TextView textView,textView2;
    Typeface t1;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        btnSignUp = (Button) findViewById(R.id.btnSignUpLIscreen);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogIn=(Button)findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, NavigationDrawer.class);
                startActivity(intent);
                finish();
            }
        });
        t1=Typeface.createFromAsset(this.getAssets(), "fonts/Av.otf");
        textView=(TextView)findViewById(R.id.textView);
        textView.setTypeface(t1);
        btnLogIn.setTypeface(t1);
        btnSignUp.setTypeface(t1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView2.setTypeface(t1);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogIn.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        editText1=(EditText)findViewById(R.id.etUsernameLogIn);
        editText2=(EditText)findViewById(R.id.etPasswordLogIn);
        editText1.setTypeface(t1);
        editText2.setTypeface(t1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogIn.this, MainActivity.class);
        startActivity(intent);
        finish();


    }
}
