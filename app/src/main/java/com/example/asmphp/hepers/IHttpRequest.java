package com.example.asmphp.hepers;



import com.example.asmphp.dto.ListLichhocResponseDTO;
import com.example.asmphp.dto.LoginRequestDTO;
import com.example.asmphp.dto.LoginResponseDTO;
import com.example.asmphp.dto.RegisterRequestDTO;
import com.example.asmphp.dto.RegisterResponseDTO;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface IHttpRequest {
    @POST("/api/register.php")
    Call<RegisterResponseDTO> register(@Body RegisterRequestDTO body);

    @POST("/api/login.php")
    Call<LoginResponseDTO> login(@Body LoginRequestDTO body);

    @POST("/api/getallproducts.php")
    Call<ListLichhocResponseDTO> getProducts(@QueryMap Map<String, String> options);
}
