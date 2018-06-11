package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.database.Cursor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListAdminData extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<String> arrayList;
    Context context;

    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_admin_data);

        recyclerView = (RecyclerView)findViewById(R.id.deleteRecycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<String>();
        context = this;

        button = (Button)findViewById(R.id.delete);
        textView = (TextView)findViewById(R.id.list);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);






        Log.d("Vijay","Displaying data in listView");

        Cursor data = databaseHelper.getData();

        while (data.moveToNext()){
            arrayList.add(data.getString(1));

        }

        adapter = new AdminListAdapter(context,arrayList);
        recyclerView.setAdapter(adapter);

    }


//    public void onDelete(View view) {
//    }
}
