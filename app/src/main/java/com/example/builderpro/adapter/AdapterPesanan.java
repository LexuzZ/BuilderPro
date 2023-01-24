package com.example.builderpro.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.R;
import com.example.builderpro.data.model.UserBiasa;
import com.example.builderpro.order.CekPesanan;

import java.util.List;

public class AdapterPesanan extends RecyclerView.Adapter<AdapterPesanan.MyViewHolder> {
    private List<UserBiasa> tList;
    private Activity activity;

    public AdapterPesanan(List<UserBiasa>tList, Activity activity) {
        this.tList = tList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public AdapterPesanan.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_pesanan, parent, false);

        return new AdapterPesanan.MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPesanan.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final UserBiasa data = tList.get(position);
        holder.cust.setText("Customer : " + data.getUsername());
        holder.address.setText("Address : " + data.getAlamat());
        holder.district.setText("District : " + data.getDistrict());
        holder.city.setText("City : " + data.getCity());
        holder.postal.setText("Postal : " + data.getKodepos());
        holder.cardPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(activity, CekPesanan.class);
                in.putExtra("Customers", tList.get(position).getUsername());
                activity.startActivity(in);
            }
        });

    }



            @Override
            public int getItemCount() {
                return tList.size();
            }

            public class MyViewHolder extends RecyclerView.ViewHolder {
                CardView cardPesanan;
                TextView cust, address, district, city, postal;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    cust = itemView.findViewById(R.id.tv_pcust);
                    address = itemView.findViewById(R.id.tv_paddress);
                    district = itemView.findViewById(R.id.tv_pdistrict);
                    city = itemView.findViewById(R.id.tv_pcity);
                    postal = itemView.findViewById(R.id.tv_ppostal);
                    cardPesanan = itemView.findViewById(R.id.card_pesanan);
                }

            }
        }