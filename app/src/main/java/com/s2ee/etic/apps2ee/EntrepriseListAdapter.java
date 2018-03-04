package com.s2ee.etic.apps2ee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * don't change here
 */

public class EntrepriseListAdapter extends RecyclerView.Adapter<EntrepriseListAdapter.MyViewHolder> {

    private List<Entreprise> Lists;
    private Context context;

    public EntrepriseListAdapter( List<Entreprise> lists,Context context) {
        this.Lists = lists;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final EntrepriseListAdapter.MyViewHolder holder, final int position) {
        final Entreprise current = Lists.get(position);
        Picasso.with(context).load(current.getEntreprisepic()).into(holder.Pic);
        holder.Nom.setText(current.getEntreprisenom());
        holder.Des.setText(current.getEntreprisedescrition());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent( context, ActivityShow.class);
                go.putExtra("entreprise",current);
                v.getContext().startActivity(go);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Lists.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView Pic;
        private TextView Nom,Des;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.Pic = (ImageView) itemView.findViewById(R.id.EntreprisePhoto);
            this.Nom = (TextView) itemView.findViewById(R.id.EntrepriseNom);
            this.Des = (TextView) itemView.findViewById(R.id.EntreprisDescritpion);

        }


    }
}
