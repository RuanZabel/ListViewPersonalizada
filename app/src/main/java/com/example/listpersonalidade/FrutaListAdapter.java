package com.example.listpersonalidade;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.example.listpersonalidade.R;
import com.example.listpersonalidade.Fruta;


public  class FrutaListAdapter extends ArrayAdapter<Fruta> {
    private static  final String TAG = "FrutaListAdapter";
    private Context mContext;
    private  int mResource;

    /**
     * Default Construtor
     * @param context
     * @param resource
     * @param objects
     */
    public FrutaListAdapter ( Context context, int resource, ArrayList<Fruta> objects)  {
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,  @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView= inflater.inflate(mResource, parent, false);


        TextView tvCodigo = (TextView) convertView.findViewById(R.id.text1);
        TextView tvNome = (TextView) convertView.findViewById(R.id.text2);
        TextView tvPreco =  (TextView) convertView.findViewById(R.id.preco);
        TextView tvPrecoVenda =(TextView) convertView.findViewById(R.id.preco_venda);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);

        NumberFormat nf = new DecimalFormat("#,###.00");
        tvCodigo.setText(Integer.toString(getItem(position).getCodigo()));
        tvNome.setText(getItem(position).getNome());
        tvPreco.setText(nf.format (getItem(position).getPreco()));
        tvPrecoVenda.setText(nf.format (getItem(position).getPreco_venda()));
        imgView.setImageResource(getItem(position).getImagem());
        return  convertView;
    }
}