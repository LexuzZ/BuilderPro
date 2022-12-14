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


public class CreateAccount extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private EditText editEmail, editPassword;
    private Button btnLoginUser, btnLoginWorker, btnRegister;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        editEmail = findViewById(R.id.email);
        editPassword = findViewById(R.id.password);
        btnLoginUser = findViewById(R.id.btnu);
        btnLoginWorker = findViewById(R.id.buttonw);
        btnRegister = findViewById(R.id.btnreg);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(CreateAccount.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Silahkan Tunggu");
        progressDialog.setCancelable(false);

        btnRegister.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), register2.class));
        });
        btnLoginUser.setOnClickListener(v ->{
            if (editEmail.getText().length()>0 && editPassword.getText().length()>0){
                login(editEmail.getText().toString(), editPassword.getText().toString());
            }else{
                Toast.makeText(getApplicationContext(),"Silahkan isi semua data", Toast.LENGTH_SHORT).show();
            }
        });
        btnLoginWorker.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(),HomeWorker.class));
        });

    }
    private void login(String email, String password){
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful() && task.getResult()!=null){
                    if (task.getResult().getUser()!=null){
                        reload();
                    }else{
                        Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Login Gagal", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }
    private void reload(){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    private void reloading(){
        startActivity(new Intent(getApplicationContext(), HomeWorker.class));
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

}