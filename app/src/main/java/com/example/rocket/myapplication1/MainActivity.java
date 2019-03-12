package com.example.rocket.myapplication1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button login;
    EditText email,password;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
         textView= findViewById(R.id.text2);
login = (Button)findViewById(R.id.button);
email = (EditText)findViewById(R.id.editText);
password =(EditText) findViewById(R.id.editText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

String s5 = email.getText().toString();
String s6 = password.getText().toString();

if(s5.equals("")||s6.equals(""))
{
    Toast.makeText(getApplicationContext(),"fieds are empty",Toast.LENGTH_SHORT).show();


}
                Boolean chkemail = db.chkemail(s5);
Boolean passchk = db.passchk(s6);
                if (chkemail== false && !passchk)
                {


                    email = (EditText)findViewById(R.id.editText);
                    Intent intent = new Intent(MainActivity.this,UserListActivity.class);
                    intent.putExtra("location", email.getText().toString());


                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"You must Register first",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Signup.class);
                    startActivity(intent);
                }

                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


               // String editText = email.getText().toString();

                Matcher matcher = Pattern.compile(validemail).matcher( email.getText().toString());


                if (matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                }


            }



            });
      textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }

            });

    }
}