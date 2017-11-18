package com.example.corina.deutschlernen;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 * Created by Corina on 03.06.2017.
 */

public class ListaVerbeAdaptor  extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<Structura> structura = null;
    private ArrayList<Structura> arraylist;

    public ListaVerbeAdaptor(Context mContext, List<Structura> structura) {
        this.mContext = mContext;
        this.structura = structura;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Structura>();
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
    public Structura getItem(int position) {
        return structura.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null){            holder = new ViewHolder();
            view = inflater.inflate(R.layout.activity_verbe_lista_adaptor, parent, false);
            holder.nume = (TextView) view.findViewById(R.id.itemLista);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        holder.nume.setText(structura.get(position).getStructuraGermana()+" = " + structura.get(position).getTraducere());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, DetaliiStructura.class);
                intent.putExtra("nume",(structura.get(position).getStructuraGermana()));
                mContext.startActivity(intent);



            }
        });

        return view;
    }


    public void filter(String text1) {
        text1 = text1.toLowerCase(Locale.getDefault());
        structura.clear();
        if (text1.length() == 0) {
            structura.addAll(arraylist);
        }
        else
        {
            for (Structura wp : arraylist)
            {
                if (wp.getStructuraGermana().toLowerCase(Locale.getDefault()).contains(text1) || wp.getTraducere().toLowerCase(Locale.getDefault()).contains(text1)){
                    structura.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }


}

