package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserType extends AppCompatActivity {

    Button admin,user;
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        admin = (Button) findViewById(R.id.admin);
        user = (Button) findViewById(R.id.user);

    }



    public void onAdminLogin(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name",DEFAULT);
        String password = sharedPreferences.getString("password",DEFAULT);
        if(name.equals(DEFAULT)|| password.equals(DEFAULT)){
            Intent intent = new Intent(UserType.this,AdminLogin.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(UserType.this,AdminList.class);
            startActivity(intent);
        }

    }

    public void onUserLogin(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("user_name",DEFAULT);
        String password = sharedPreferences.getString("user_password",DEFAULT);
        if(name.equals(DEFAULT)|| password.equals(DEFAULT)){
            Intent intent = new Intent(UserType.this,UserLogin.class);
            startActivity(intent);
        }else{
            Intent intent1 = new Intent(UserType.this,UserList.class);
            startActivity(intent1);
        }

    }
}
