package com.example.builderpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
MainActivity extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private Button btn_logOut;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textName = findViewById(R.id.name);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        btn_logOut = findViewById(R.id.btn_logout);

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

