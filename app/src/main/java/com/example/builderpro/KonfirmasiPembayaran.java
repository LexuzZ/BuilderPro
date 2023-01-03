package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.RadioButton;

import android.widget.Toast;

import java.time.Duration;

public class KonfirmasiPembayaran extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pembayaran);
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_paypal:
                if (checked)
                    break;
            case R.id.radio_gopay:
                if (checked)
                    break;
            case R.id.radio_bank:
                if (checked)
                    break;
        }
    }


    public void showToast(View view) {
        String myString = "Payment Success!";
        Toast toast = Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG);
        toast.show();
    }
    public void userr(View view){
        Intent intent = new Intent(KonfirmasiPembayaran.this, HomeUser.class);
        startActivity(intent);
    }
}






