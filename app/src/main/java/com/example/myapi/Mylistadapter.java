package com.example.myapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mylistadapter extends BaseAdapter {

    Context c;
    ArrayList<Products> pro;

    LayoutInflater inflater;

    public Mylistadapter(Context c, ArrayList<Products> pro) {
        this.c = c;
        this.pro = pro;
    }

    public Mylistadapter() {
    }



    @Override
    public int getCount() {
        return pro.size();
    }

    @Override
    public Object getItem(int position) {
        return pro.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item,parent,false);
        }

        ImageView img = convertView.findViewById(R.id.img);
        TextView Pname = convertView.findViewById(R.id.txt_Pname);



        return null;
    }
}
