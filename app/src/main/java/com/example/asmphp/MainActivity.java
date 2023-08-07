package com.example.asmphp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asmphp.dto.LoginRequestDTO;
import com.example.asmphp.dto.LoginResponseDTO;
import com.example.asmphp.hepers.HttpRequest;
import com.example.asmphp.hepers.IHttpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    AppCompatButton btnLogin;

    IHttpRequest iHttpRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        edtEmail= findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3456/") // Thay thế BASE_URL bằng URL thích hợp của máy chủ
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iHttpRequest = retrofit.create(IHttpRequest.class);

        iHttpRequest = HttpRequest.createService(IHttpRequest.class);
    }

    public void onLoginClick(View view){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        LoginRequestDTO requestDTO = new LoginRequestDTO(email,password);
        iHttpRequest.login(requestDTO).enqueue(login);
    }

    Callback<LoginResponseDTO> login = new Callback<LoginResponseDTO>() {
        @Override
        public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
            try {
                if (response.isSuccessful()){
                    LoginResponseDTO loginResponse = response.body();
                    if(loginResponse.isStatus()){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();// depj manf hinh dang nhap luon
                        Toast.makeText(MainActivity.this, "Thành công", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (Exception e){
                Log.d(TAG, "onResponse: loi");
            }
        }

        //lỗi sẽ trả về đây
        @Override
        public void onFailure(Call<LoginResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };
}