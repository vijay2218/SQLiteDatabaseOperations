package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    Button logout;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<String> arrayList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        logout = (Button)findViewById(R.id.user_logout);
        recyclerView = (RecyclerView)findViewById(R.id.userRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<String>();
        context = this;


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        Cursor data = databaseHelper.getData();

        while (data.moveToNext()){
            arrayList.add(data.getString(1));

        }

        adapter = new ListAdapter(context,arrayList);
        recyclerView.setAdapter(adapter);

    }

    public void onUserLogout(View view) {

        Intent intent = new Intent(UserList.this,UserLogin.class);
        startActivity(intent);
        finish();

    }
}
