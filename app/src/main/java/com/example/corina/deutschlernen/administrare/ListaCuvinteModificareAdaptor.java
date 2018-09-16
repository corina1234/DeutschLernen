package com.example.corina.deutschlernen.administrare;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.corina.deutschlernen.cuvinteAfisare.DetaliiStructura;
import com.example.corina.deutschlernen.R;
import com.example.corina.deutschlernen.structuraSchelet.Structura;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Corina on 27.08.2018.
 */

public class ListaCuvinteModificareAdaptor  extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    private List<Structura> structura = null;
    private ArrayList<Structura> arraylist;

    public ListaCuvinteModificareAdaptor(Context mContext, List<Structura> structura) {
        this.mContext = mContext;
        this.structura = structura;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Structura>();
        this.arraylist.addAll(structura);
    }


    class ViewHolder {
        CheckBox checkBox;
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
        final ListaCuvinteModificareAdaptor.ViewHolder holder;
        if (view == null){            holder = new ListaCuvinteModificareAdaptor.ViewHolder();
            view = inflater.inflate(R.layout.activity_cuvinte_modificare_adaptor, parent, false);
            holder.nume = (TextView) view.findViewById(R.id.itemLista);

            view.setTag(holder);
        }
        else{
            holder = (ListaCuvinteModificareAdaptor.ViewHolder) view.getTag();
        }

        holder.nume.setText(structura.get(position).getStructuraGermana()+" = " + structura.get(position).getTraducere());

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(mContext, AdaugaStructuriiView.class);
                intent.putExtra("nume",(structura.get(position)));
                intent.putExtra("tip", "modificare");
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
    public void updateResults(ArrayList<Structura> results) {
        arraylist = results;
        notifyDataSetChanged();
    }

}
