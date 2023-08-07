package com.example.asmphp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.asmphp.adapters.LichhocAdapter;
import com.example.asmphp.dto.LichhocResponseDTO;
import com.example.asmphp.dto.ListLichhocResponseDTO;
import com.example.asmphp.hepers.HttpRequest;
import com.example.asmphp.hepers.IHttpRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListlichocActivity extends AppCompatActivity {

    RecyclerView listLichhoc;

    IHttpRequest iHttpRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listlichoc);

        listLichhoc =findViewById(R.id.listLichhoc);
        iHttpRequest = HttpRequest.createService(IHttpRequest.class);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        listLichhoc.setLayoutManager(manager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Map<String ,String > queries = new HashMap<>();
        queries.put("keyword", "4");
        queries.put("sort", "1");
        queries.put("limit", "3");
        queries.put("page", "1");
        iHttpRequest.getProducts(queries).enqueue(getlichhocCallback);
    }

    Callback<ListLichhocResponseDTO> getlichhocCallback = new Callback<ListLichhocResponseDTO>() {
        @Override
        public void onResponse(Call<ListLichhocResponseDTO> call, Response<ListLichhocResponseDTO> response) {
            if (response.isSuccessful()){
                ListLichhocResponseDTO responseDTO = response.body();
                if(responseDTO.isStatus()){
                    List<LichhocResponseDTO> lichhoc = responseDTO.getData();
                    if(lichhoc.size() > 0) {
                        LichhocAdapter adapter = new LichhocAdapter(lichhoc);
                        listLichhoc.setAdapter(adapter);
                    }
                }
            }
        }

        //lỗi sẽ trả về đây
        @Override
        public void onFailure(Call<ListLichhocResponseDTO> call, Throwable t) {
            Log.d(">>> login", "onFailure: " + t.getMessage());
        }
    };

}