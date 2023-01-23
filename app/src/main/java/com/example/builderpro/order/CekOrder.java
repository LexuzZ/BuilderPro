package com.example.builderpro.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CekOrder extends AppCompatActivity {
    ImageView view1, view2, view3;
    SeekBar seekBar;
    TextView name;
    FirebaseUser firebaseUser;
    ImageButton img;
    Boolean catetgoryid;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_order);
        img = findViewById(R.id.imageView10);
        name = findViewById(R.id.tv_cust);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Intent in = getIntent();
        String username = in.getExtras().getString("Customers");
        name.setText("Customer " + username);




    }
    public  void cek2 (View view ){
        Intent intent = new Intent(CekOrder.this, CekOrder2.class);
        startActivity(intent);
    }
}