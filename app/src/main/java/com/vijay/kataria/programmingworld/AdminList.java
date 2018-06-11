package com.vijay.kataria.programmingworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminList extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText editLanguage;
    Button add,viewData,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list);

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        editLanguage = (EditText)findViewById(R.id.editLanguage);
        add = (Button)findViewById(R.id.addRow);
        viewData = (Button)findViewById(R.id.viewData);
        logout = (Button)findViewById(R.id.logout);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addLanguage(editLanguage.getText().toString(),databaseHelper);
            }
        });
    }

    public void addLanguage(String newEntry, DatabaseHelper databaseHelper) {

        String data = editLanguage.getText().toString();
        if(editLanguage.length() != 0){
            boolean insertData = databaseHelper.addData(newEntry);
            if(insertData){
                Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
            editLanguage.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"Please first enter any language",Toast.LENGTH_SHORT).show();
        }
    }


    public void btnViewData(View view) {
        Intent intent = new Intent(AdminList.this,ListAdminData.class);
        startActivity(intent);
    }

    public void onLogout(View view) {
        Intent intent = new Intent(AdminList.this,AdminLogin.class);
        startActivity(intent);
        finish();
    }
}
