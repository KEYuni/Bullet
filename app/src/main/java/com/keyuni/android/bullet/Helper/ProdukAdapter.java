package com.keyuni.android.bullet.Helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.keyuni.android.bullet.DaftarProdukActivity;
import com.keyuni.android.bullet.DetailProductActivity;
import com.keyuni.android.bullet.R;
import com.keyuni.android.bullet.UpdateProdukActivity;
import com.keyuni.android.bullet.db.DbProduk;
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
        public View layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Produk produk = produks.get(position);

        //holder.imgV.setText(transaksi.get());
        holder.tvNamaProduk.setText(String.valueOf(produk.getNama_produk()));
        holder.tvHargaProduk.setText(String.valueOf(produk.getHarga()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, String.valueOf(produk.getId_produk()), Toast.LENGTH_SHORT).show();
                goToDetailActivity(produk.getId_produk());
            }
        });

        holder.layout.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete produk?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        goToUpdateActivity(produk.getId_produk());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DbProduk dbProduk = new DbProduk(context);
                        dbProduk.open();
                        dbProduk.deleteProduk(produk.getId_produk(), context);

                        produks.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, produks.size());
                        notifyDataSetChanged();

                        dbProduk.close();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();

                return true;
            }
        });
    }

    private void goToDetailActivity(int produkId){
        Intent goToDetailProduk = new Intent(context, DetailProductActivity.class);
        goToDetailProduk.putExtra("id_produk", produkId);

        context.startActivity(goToDetailProduk);
    }

    private void goToUpdateActivity(int produkId){
        Intent goToUpdateProduk = new Intent(context, UpdateProdukActivity.class);
        goToUpdateProduk.putExtra("id_produk", produkId);

        context.startActivity(goToUpdateProduk);
    }

    @Override
    public int getItemCount() {
        return produks.size();
    }
}
