package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdminListAdapter extends RecyclerView.Adapter<AdminListAdapter.MyViewHolder> {

    LayoutInflater inflater;
    ArrayList<String> arrayList;
    Context context;
    public AdminListAdapter(Context context, ArrayList<String> arrayList){
        inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public AdminListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.deleterow, parent, false);
        AdminListAdapter.MyViewHolder holder = new AdminListAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AdminListAdapter.MyViewHolder holder, final int position) {


        holder.textView.setText(arrayList.get(position));
       final String name = arrayList.get(position);
        Log.d("Vijay","Name = "+name);
      // final int id = Integer.parseInt(arrayList.get(position));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper databaseHelper = new DatabaseHelper(context);
                //Cursor data = databaseHelper.getItemID(name);
                
                databaseHelper.deleteName(name);
                delete(position);
                notifyDataSetChanged();
                //Log.d("Vijay","Inside onBindView where id and data are "+hii.getInt(0));
               /* int itemID = -1;
                Log.d("Vijay","here2");
                while(data.moveToNext()){
                    itemID = data.getInt(1);
                    Log.d("Vijay","here1");
                }
                if(itemID>-1){
                    Log.d("Vijay","Inside onBindView where id and data are "+itemID);
                }else{
                    Log.d("Vijay","NO ID");
                }*/
            }
        });

    }

    private void delete(int position) {
        arrayList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,arrayList.size());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        Button button;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.list);
            button = (Button)itemView.findViewById(R.id.delete);



        }
    }
}
