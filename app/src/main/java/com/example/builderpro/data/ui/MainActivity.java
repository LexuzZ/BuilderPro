package com.example.builderpro.data.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.builderpro.HomeUser;
import com.example.builderpro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
MainActivity extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private Button btn_logOut, btn_dash;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.name);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        btn_logOut = findViewById(R.id.btn_logout);
        btn_dash = findViewById(R.id.btn_dash);

        btn_dash.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HomeUser.class));
        });

        if (firebaseUser!=null){
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal");
        }
        btn_logOut.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), CreateAccount.class));
            finish();
        });

    }


}

