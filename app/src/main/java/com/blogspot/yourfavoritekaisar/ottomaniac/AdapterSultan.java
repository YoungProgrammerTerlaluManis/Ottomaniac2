package com.blogspot.yourfavoritekaisar.ottomaniac;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterSultan extends RecyclerView.Adapter<AdapterSultan.ViewHolder> {
    RecycleFragment context;
    int[] gambarSultan;
    String[] namaSultan,detailSultan;

    public AdapterSultan(RecycleFragment context, int[] gambarSultan, String[] namaSultan, String[] detailSultan) {
        this.context = context;
        this.gambarSultan = gambarSultan;
        this.namaSultan = namaSultan;
        this.detailSultan = detailSultan;
    }


    @NonNull
    @Override
    public AdapterSultan.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sultan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSultan.ViewHolder viewHolder, final int i) {
        viewHolder.txtSultan.setText(namaSultan[i]);
        Glide.with(context).load(gambarSultan[i]).into(viewHolder.logo);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(v.getContext(),DetailActivity.class);
                pindah.putExtra("ns", namaSultan[i]);
                pindah.putExtra("ds", detailSultan[i]);
                pindah.putExtra("gs", gambarSultan[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() { return gambarSultan.length; }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView txtSultan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.imgSultan);
            txtSultan = itemView.findViewById(R.id.txtSultan);
        }
    }
}

