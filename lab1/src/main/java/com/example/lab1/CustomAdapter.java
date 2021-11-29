package com.example.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> mobileTypes = new ArrayList<String>();
    private List<String> companies = new ArrayList<String>();

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
    }

    public CustomAdapter(Context context, List<String> mobileTypes, List<String> companies) {
        inflater = LayoutInflater.from(context);
        this.mobileTypes = mobileTypes;
        this.companies = companies;
    }

    public int getCount() {
        return mobileTypes.size();
    }

    public String getItem(int position) {
        return companies.get(position) + " " + mobileTypes.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.custom_adapter, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.company);
            holder.textView2 = (TextView) convertView.findViewById(R.id.mobileType);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(companies.get(position));
        holder.textView2.setText(mobileTypes.get(position));
        return convertView;
    }
}
