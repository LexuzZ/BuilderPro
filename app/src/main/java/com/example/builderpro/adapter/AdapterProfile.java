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
import com.example.builderpro.order.CekOrder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdapterProfile extends RecyclerView.Adapter<AdapterProfile.MyViewHolder> {
    private List<UserBiasa> tList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public AdapterProfile(List<UserBiasa>tList, Activity activity){
        this.tList = tList;
        this.activity = activity;


    }
    @NonNull
    @Override
    public AdapterProfile.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_user, parent, false);

        return new AdapterProfile.MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProfile.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final UserBiasa data = tList.get(position);
        holder.cust.setText("Customer : " + data.getUsername());
        holder.address.setText("Address : " + data.getAlamat());
        holder.district.setText("District : " + data.getDistrict());
        holder.city.setText("City : " + data.getCity());
        holder.postal.setText("Postal : " + data.getKodepos());
        holder.cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(activity, CekOrder.class);
                in.putExtra("Customers", tList.get(position).getUsername());
//                in.putExtra("Alamat", tList.get(position).getAlamat());
//                in.putExtra("District", tList.get(position).getDistrict());
//                in.putExtra("City", tList.get(position).getCity());
//                in.putExtra("Postal", tList.get(position).getKodepos());
                activity.startActivity(in);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardProfile;
        TextView cust, address, district, city, postal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cust = itemView.findViewById(R.id.tv_cust);
            address = itemView.findViewById(R.id.tv_address);
            district = itemView.findViewById(R.id.tv_district);
            city = itemView.findViewById(R.id.tv_city);
            postal = itemView.findViewById(R.id.tv_postal);
            cardProfile = itemView.findViewById(R.id.card_profile);
        }
    }
}
