package com.keyuni.android.bullet.Helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.keyuni.android.bullet.R;
import com.keyuni.android.bullet.model.Produk;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater mInflater;
    private ArrayList<Produk> produks;

    public ProdukAdapter(Context context,ArrayList<Produk> produks) {

        this.context = context;
        this.produks = produks;
        this.mInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView imgV, tvNamaProduk, tvHargaProduk;

        public MyViewHolder(View itemView) {
            super(itemView);
            //imgV = itemView.findViewById(R.id.image);
            tvNamaProduk = itemView.findViewById(R.id.tvNama_produk);
            tvHargaProduk = itemView.findViewById(R.id.tvHarga_produk);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.produk_row, parent, false);
        ProdukAdapter.MyViewHolder viewHolder = new ProdukAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produk produk = produks.get(position);

        //holder.imgV.setText(transaksi.get());
        holder.tvNamaProduk.setText(String.valueOf(produk.getNama_produk()));
        holder.tvHargaProduk.setText(String.valueOf(produk.getHarga()));
    }

    @Override
    public int getItemCount() {
        return produks.size();
    }
}
