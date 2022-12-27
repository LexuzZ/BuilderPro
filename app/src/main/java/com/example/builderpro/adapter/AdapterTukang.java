package com.example.builderpro.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.builderpro.R;
import com.example.builderpro.data.model.Tukang;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterTukang extends RecyclerView.Adapter<AdapterTukang.MyViewHolder> {
    private List<Tukang> tList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterTukang(List<Tukang>tList, Activity activity){
        this.tList = tList;
        this.activity = activity;
    }
    @NonNull
    @Override
    public AdapterTukang.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item, parent, false);

        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTukang.MyViewHolder holder, int position) {
        final Tukang data = tList.get(position);
        holder.tv_tukang.setText("Nama : " + data.getNama());
        holder.tv_harga.setText("Harga :" + data.getHarga());
        holder.tv_date.setText("Kecamatan: " + data.getLoc());
        holder.tv_action.setText(" " + data.getAction());


    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tukang, tv_harga, tv_date, tv_action;
        CardView card_hasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tukang = itemView.findViewById(R.id.tv_tukang);
            tv_harga = itemView.findViewById(R.id.tv_harga);
            tv_date = itemView.findViewById(R.id.tv_loc);
            tv_action = itemView.findViewById(R.id.tv_action);
            card_hasil = itemView.findViewById(R.id.card_hasil);
        }
    }
}
