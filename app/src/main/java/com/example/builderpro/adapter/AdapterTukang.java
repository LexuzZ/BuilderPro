package com.example.builderpro.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.builderpro.R;
import com.example.builderpro.recyclerView.DialogForm;
import com.example.builderpro.data.model.Tukang;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
        holder.tv_ahli.setText("Keahlian: " + data.getAhli());
        holder.tv_rate.setText("Rating: " + data.getRate());
        holder.tv_action.setText(" " + data.getAction());
        holder.btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        database.child("Tukang").child(data.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(activity, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(activity, "Gagal Menghapus Data", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setMessage("Apakah yakin ingin menghapus ? " + data.getNama());
                builder.show();

            }
        });
        holder.card_hasil.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                FragmentManager manager = ((AppCompatActivity)activity).getSupportFragmentManager();
                DialogForm dialog = new DialogForm(
                        data.getNama(),
                        data.getHarga(),
                        data.getLoc(),
                        data.getAhli(),
                        data.getRate(),
                        data.getAction(),
                        data.getKey(),
                        "Ubah"
                );
                dialog.show(manager, "form");
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return tList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tukang, tv_harga, tv_date, tv_action, tv_ahli, tv_rate;
        ImageView btn_hapus;
        CardView card_hasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tukang = itemView.findViewById(R.id.tv_tukang);
            tv_harga = itemView.findViewById(R.id.tv_harga);
            tv_date = itemView.findViewById(R.id.tv_loc);
            tv_ahli = itemView.findViewById(R.id.tv_ahli);
            tv_rate = itemView.findViewById(R.id.tv_rate);
            tv_action = itemView.findViewById(R.id.tv_action);
            card_hasil = itemView.findViewById(R.id.card_hasil);
            btn_hapus = itemView.findViewById(R.id.btn_hapus);

        }
    }
}
