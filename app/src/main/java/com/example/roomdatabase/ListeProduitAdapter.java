package com.example.roomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ListeProduitAdapter extends BaseAdapter {
    Context context;
    List<Produit> produitsList;
    ListeProduitAdapter( List<Produit> produitsList,Context context){
        this.context=context;
        this.produitsList=produitsList;
    }
    @Override
    public int getCount() {
        return produitsList.size();
    }

    @Override
    public Object getItem(int position) {
        return produitsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produit pr =produitsList.get(position);
        if(convertView==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_produit_item,parent,false);
        }
        TextView codeTxt,designationTxt,prixUnitaireTxt;
        CheckBox typeMouvementChx;
        codeTxt= convertView.findViewById(R.id.codeTxt);
        designationTxt=convertView.findViewById(R.id.designationTxt);
        prixUnitaireTxt=convertView.findViewById(R.id.prixUnitaireTxt);
        codeTxt.setText(String.valueOf(pr.getId()));
        designationTxt.setText(String.valueOf(pr.getDescription()));
        prixUnitaireTxt.setText(String.valueOf(pr.getMontant()));
        typeMouvementChx=convertView.findViewById(R.id.typeCh);
        if (pr.getTypeOperation()) {
            typeMouvementChx.setChecked(true);
            typeMouvementChx.setText("sortie d'argent");
        }else {
            typeMouvementChx.setChecked(false);
            typeMouvementChx.setText("entree d'argent ");

        }
        return convertView;
    }
}
