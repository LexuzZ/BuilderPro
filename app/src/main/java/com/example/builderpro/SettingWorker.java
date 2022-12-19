package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.data.ui.MainActivity;
import com.example.builderpro.order.CekOrder;

public class SettingWorker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_worker);
    }

    public void lihat(View view) {
        Intent intent = new Intent(SettingWorker.this, LihatRating.class);
        startActivity(intent);
    }

    public void out(View view) {
        Intent intent = new Intent(SettingWorker.this, MainActivity.class);
        startActivity(intent);
    }

    public void history(View view) {
        Intent intent = new Intent(SettingWorker.this, History.class);
        startActivity(intent);

    }

    public void lonceng(View view) {
        Intent intent = new Intent(SettingWorker.this, CekOrder.class);
        startActivity(intent);
    }
}