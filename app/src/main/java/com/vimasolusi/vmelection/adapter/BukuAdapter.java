package com.vimasolusi.vmelection.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vimasolusi.vmelection.R;
import com.vimasolusi.vmelection.etities.Buku;

import java.util.List;

public class BukuAdapter extends ArrayAdapter<Buku> {

    public BukuAdapter(@NonNull Context context, int resource, @NonNull List<Buku> objects){
        super(context,resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView , @NonNull ViewGroup parent)
    {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_buku,parent, false
            );
        }

        Buku buku = getItem(position);

        TextView tvJudul = (TextView) convertView.findViewById(R.id.tv_judul);
        tvJudul.setText(buku.getJudul());

        TextView tvPenerbit = (TextView) convertView.findViewById(R.id.tv_penerbit);
        tvPenerbit.setText(buku.getPenerbit());

        return  convertView;
    }
}
