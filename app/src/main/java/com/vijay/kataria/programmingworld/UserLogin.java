package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserLogin extends AppCompatActivity {

    EditText username,password;
    Button userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        username = (EditText)findViewById(R.id.user_username);
        password  = (EditText)findViewById(R.id.user_password);
    }

    public void userLogin(View view) {

        if(username.getText().toString().equals("vijay") && password.getText().toString().equals("kataria")){
            Intent intent = new Intent(UserLogin.this,UserList.class);
            startActivity(intent);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_name",username.getText().toString());
        editor.putString("user_password",password.getText().toString());
        editor.commit();
    }

    public void onUserLogout(View view) {
        Intent intent = new Intent(UserLogin.this,UserLogin.class);
        startActivity(intent);
        finish();

    }
}
