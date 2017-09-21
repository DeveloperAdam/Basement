package com.techease.basement;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.techease.basement.R.layout.activity_log_in;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    Button btnSignUp,btnLogIn;
    TextView textView,textView2;
    Typeface t1;
    EditText editTextUser,editTextPass;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_log_in);

        //Button for going to sign up screen
        btnSignUp = (Button) findViewById(R.id.btnSignUpLIscreen);
       btnSignUp.setOnClickListener(this);
        //Button for going to Dashboard
        btnLogIn=(Button)findViewById(R.id.btnLogIn);
       btnLogIn.setOnClickListener(this);

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
        editTextUser=(EditText)findViewById(R.id.etUsernameLogIn);
        editTextPass=(EditText)findViewById(R.id.etPasswordLogIn);
        editTextUser.setTypeface(t1);
        editTextPass.setTypeface(t1);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LogIn.this, MainActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSignUpLIscreen)
        {
            startActivity(new Intent(LogIn.this,MainActivity.class));
            finish();
        }else
        if(view.getId()==R.id.btnSignUp)
        {
            startActivity(new Intent(LogIn.this,MainActivity.class));
            finish();
        }else if(view.getId()==R.id.btnLogIn)
        {
            loginuser(editTextUser.getText().toString(),editTextPass.getText().toString());
        }
    }
    public void loginuser(String Username, final String Password)
    {
        auth.signInWithEmailAndPassword(Username,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful())
                {
                    if(Password.length()<6)
                    {
                        Toast.makeText(LogIn.this,"Password must be over 6",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        startActivity(new Intent(LogIn.this, NavigationDrawer.class));
                    }
                }
            }
        });
    }
}
