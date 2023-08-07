package com.example.asmphp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class FlashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 5000; // 5 giây

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        // Sử dụng Handler để đặt sự trễ
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tạo Intent để chuyển sang MainActivity
                Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Đóng Splash Screen Activity
            }
        }, SPLASH_DELAY);
    }
}