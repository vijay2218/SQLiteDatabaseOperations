package com.vijay.kataria.programmingworld;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    LayoutInflater inflater;
    ArrayList<String> arrayList;
    public ListAdapter(Context context,ArrayList<String> arrayList){
        inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



       View view = inflater.inflate(R.layout.language_row, parent, false);
        ListAdapter.MyViewHolder holder = new ListAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.language);
        }
    }
}
