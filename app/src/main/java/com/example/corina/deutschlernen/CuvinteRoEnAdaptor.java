package com.example.corina.deutschlernen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.corina.deutschlernen.cuvinteAfisare.ListaVerbeAdaptor;
import com.example.corina.deutschlernen.structuraSchelet.Structura;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CuvinteRoEnAdaptor  extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<String> structura = null;
    private ArrayList<String> arraylist;

    public CuvinteRoEnAdaptor(Context mContext, List<String> structura) {
        this.mContext = mContext;
        this.structura = structura;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<String>();
        this.arraylist.addAll(structura);
    }


    public class ViewHolder {
        TextView nume;
    }


    @Override
    public int getCount() {
        return structura.size();
    }

    @Override
    public String getItem(int position) {
        return structura.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final CuvinteRoEnAdaptor.ViewHolder holder;
        if (view == null) {
            holder = new CuvinteRoEnAdaptor.ViewHolder();
            view = inflater.inflate(R.layout.activity_cuvinte_ro_en_adaptor, parent, false);
            holder.nume = (TextView) view.findViewById(R.id.itemLista);

            view.setTag(holder);
        } else {
            holder = (CuvinteRoEnAdaptor.ViewHolder) view.getTag();
        }

        holder.nume.setText(structura.get(position));
        notifyDataSetChanged();

        return view;
    }


}