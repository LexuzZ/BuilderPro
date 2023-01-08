package com.example.builderpro.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.HomeOrder;
import com.example.builderpro.HomeUser;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;
import com.example.builderpro.data.model.Tukang;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolder> {
    private List<Tukang> tList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterUser(List<Tukang> tList, Activity activity) {
        this.tList = tList;
        this.activity = activity;

    }

    @NonNull
    @Override
    public AdapterUser.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item2, parent, false);

        return new AdapterUser.MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Tukang data = tList.get(position);
        holder.tv_tukang.setText("Nama : " + data.getNama());
        holder.tv_harga.setText("Harga :" + data.getHarga());
        holder.tv_date.setText("Kecamatan: " + data.getLoc());
        holder.tv_ahli.setText("Keahlian: " + data.getAhli());
        holder.tv_rate.setText("Rating: " + data.getRate());
        holder.tv_action.setText(" " + data.getAction());
        holder.card_tukang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, HomeOrder.class);
                intent.putExtra("Tukang",tList.get(position).getNama());
                intent.putExtra("Harga", tList.get(position).getHarga());
                intent.putExtra("Lokasi", tList.get(position).getLoc());
                intent.putExtra("Keahlian", tList.get(position).getAhli());
                intent.putExtra("Rate", tList.get(position).getRate());
                intent.putExtra("Action", tList.get(position).getAction());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView card_tukang;
        TextView tv_tukang, tv_harga, tv_date, tv_ahli, tv_rate, tv_action;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tukang = itemView.findViewById(R.id.tv_tukang);
            tv_harga = itemView.findViewById(R.id.tv_harga);
            tv_date = itemView.findViewById(R.id.tv_loc);
            tv_ahli = itemView.findViewById(R.id.tv_ahli);
            tv_rate = itemView.findViewById(R.id.tv_rate);
            tv_action = itemView.findViewById(R.id.tv_action);
            card_tukang = itemView.findViewById(R.id.card_tukang);
        }
    }
}
