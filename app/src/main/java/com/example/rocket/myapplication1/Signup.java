package com.example.rocket.myapplication1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Signup extends AppCompatActivity {
    DatabaseHelper db;
EditText e_mail,e1,e2,e3;
Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db = new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 =(EditText)findViewById(R.id.editText5);
        e3 = (EditText )findViewById(R.id.editText6);
        e_mail = (EditText)findViewById(R.id.editText4);
        signup =(Button)findViewById(R.id.button1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e_mail.getText().toString();
                String s3 = e2.getText().toString();
                String s4 = e3.getText().toString();
                if(s2.equals("")||s1.equals("")||s3.equals("")||s4.equals(""))

{
  Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_SHORT).show();

}
else
   if (s3.equals(s4)){
     Boolean chkemail = db.chkemail(s2);
     if (chkemail== true){
Boolean insert =db.insert(s1,s2,s3);
if (insert==true){
Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();


}

     }
     else{
Toast.makeText(getApplicationContext(),"Email already registered",Toast.LENGTH_SHORT).show();

                }



                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String editText = e_mail.getText().toString();

                Matcher matcher = Pattern.compile(validemail).matcher( e_mail.getText().toString());


                if (matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                }


            }
            else
   {
       Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
   }


//amitsun.noida@gmail.com
        }
    });
}
    public static void showDebugDBAddressLogToast(Context context) {
        if (BuildConfig.DEBUG) {
            try {
                Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
                Method getAddressLog = debugDB.getMethod("getAddressLog");
                Object value = getAddressLog.invoke(null);
                Toast.makeText(context, (String) value, Toast.LENGTH_LONG).show();
            } catch (Exception ignore) {
                Log.d("url","database");

            }
        }
    }
}