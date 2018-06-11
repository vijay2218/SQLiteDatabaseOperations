package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminLogin extends AppCompatActivity {

    EditText name,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        name = (EditText) findViewById(R.id.admin_username);
        password = (EditText) findViewById(R.id.admin_password);
        login = (Button)findViewById(R.id.login);

    }

    public void login(View view) {

        if(name.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            Intent intent = new Intent(AdminLogin.this,AdminList.class);
            startActivity(intent);
        }

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();
    }
}
