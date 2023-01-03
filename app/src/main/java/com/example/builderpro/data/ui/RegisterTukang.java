package com.example.builderpro.data.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.builderpro.HomeUser;
import com.example.builderpro.HomeWorker;
import com.example.builderpro.R;
import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.Alamat;
import com.example.builderpro.data.model.User;
import com.example.builderpro.data.remote.AuthenticationRemoteDataSource;
import com.example.builderpro.data.repository.AuthenticationRepository;

public class RegisterTukang extends AppCompatActivity {
    private EditText editName,  editEmail, editPassword, editRepass;
    private Button btnSignU, btnSignW;
    private ProgressDialog progressDialog;
    private AuthenticationDataSource authenticationRemoteDataSource;
    private AuthenticationRepository authenticationRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_tukang);

        authenticationRemoteDataSource = new AuthenticationRemoteDataSource();
        authenticationRepository = new AuthenticationRepository(authenticationRemoteDataSource);

        editName = findViewById(R.id.name);
        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        editRepass = findViewById(R.id.repass);
        btnSignU = findViewById(R.id.button3);
        btnSignW = findViewById(R.id.button21);
        // Initialize Firebase Auth
        progressDialog = new ProgressDialog(RegisterTukang.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        btnSignW.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HomeWorker.class));
        });
        btnSignU.setOnClickListener(v -> {
            if ((editName.getText().length() > 0 && editEmail.getText().length() > 0 && editPassword.getText().length()>0)) {
                if (editPassword.getText().toString().equals(editRepass.getText().toString())) {
                    Alamat alamat = new Alamat("", "", "", "");
                    User user = new User(editName.getText().toString(), alamat, "", editEmail.getText().toString());
                    register(user, editPassword.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Silahkan masukan password yang sama!", Toast.LENGTH_SHORT).show();
                }
            } else{
                Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void register(User user, String password) {
        progressDialog.show();

        authenticationRepository.register(user, password, new AuthenticationDataSource.AuthenticationCallback() {
            @Override
            public void success(Boolean success) {
                Toast.makeText(getApplicationContext(), "Berhasil daftar", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
            @Override
            public void error(Throwable err) {
                Toast.makeText(getApplicationContext(), err.getMessage() , Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });


    }

}