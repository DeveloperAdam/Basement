package com.techease.basement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techease.basement.Holder.AttributesHolder;

import java.util.Calendar;

import static com.techease.basement.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignIn,btnSignUp,btnRegister;
    Typeface t1;
    EditText etuser,etemail,etpass,etcpass;
    EditText etdate;
    DatePickerDialog datePickerDialog;
    TextView textView;
    private FirebaseAuth auth;
    public static final String Attributes="User";
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        Firebase.setAndroidContext(this);

        databaseReference= FirebaseDatabase.getInstance().getReference();


        //initializing firebae
        auth=FirebaseAuth.getInstance();

        //button for going to login screen
        btnSignIn=(Button)findViewById(R.id.btnSignIN);
        btnSignIn.setOnClickListener(this);
        //calling to dummytext class
        textView=(TextView)findViewById(R.id.tvTerms);
        textView.setOnClickListener(this);

        //initialize the typeface
        t1=Typeface.createFromAsset(this.getAssets(), "fonts/Av.otf");

        //applying font
        btnSignIn.setTypeface(t1);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnSignUp.setTypeface(t1);

        //Button after signup to go to login screen
        btnRegister=(Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        btnRegister.setTypeface(t1);

        //initializing edittext
        etuser=(EditText)findViewById(R.id.etUsername);
        etemail=(EditText)findViewById(R.id.etEmail);
        etpass=(EditText)findViewById(R.id.etPassword);
        etcpass=(EditText)findViewById(R.id.etCPassword);

        //applying font
        etcpass.setTypeface(t1);
        etpass.setTypeface(t1);
        etemail.setTypeface(t1);
        etuser.setTypeface(t1);

        //date picker button
        etdate = (EditText) findViewById(R.id.date);
        etdate.setOnClickListener(new View.OnClickListener() {
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
                                etdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnSignIN)
        {
            startActivity(new Intent(MainActivity.this,map.class));
            finish();
        }else
            if (view.getId()==R.id.textView)
            {
                startActivity(new Intent(MainActivity.this,DummyText.class));
                finish();
            }else
                if (view.getId()==R.id.btnRegister)
                {
                    signupUser(etuser.getText().toString(),etemail.getText().toString(),etpass.getText().toString(),etcpass.getText().toString(),etdate.getText().toString());

                }
    }
    public void signupUser(String User, String email, String Pass, String Cpass, final String date)
    {
        auth.createUserWithEmailAndPassword(email,User).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this,"Error: "+task.getException(),Toast.LENGTH_SHORT).show();
                }else
                {

                    Toast.makeText(MainActivity.this,"Register Success",Toast.LENGTH_SHORT).show();
                    String UsernameValue=etuser.getText().toString();
                    String EmailValue=etemail.getText().toString();
                    String DateValue= etdate.getText().toString();

                    AttributesHolder attributesHolder=new AttributesHolder(UsernameValue,EmailValue,DateValue);
                    databaseReference.child(auth.getCurrentUser().getUid()).setValue(attributesHolder);


                    startActivity(new Intent(MainActivity.this,LogIn.class));
                }
            }
        });
    }
}
