package dev.setakarim.generatebarcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import dev.setakarim.generatebarcode.adapter.BonusViralAdapter;
import dev.setakarim.generatebarcode.model.BonusViralModel;
import dev.setakarim.generatebarcode.network.RetrofitClientInstance;
import dev.setakarim.generatebarcode.network.RouteServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BonusViralActivity extends AppCompatActivity {

    private BonusViralAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_viral);

        RouteServices service = RetrofitClientInstance.getRetrofitInstance().create(RouteServices.class);
        Call<List<BonusViralModel>> call = service.getBonusViral();
        call.enqueue(new Callback<List<BonusViralModel>>() {
            @Override
            public void onResponse(Call<List<BonusViralModel>> call, Response<List<BonusViralModel>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<BonusViralModel>> call, Throwable t) {
                Toast.makeText(BonusViralActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<BonusViralModel> dataList) {
        recyclerView = findViewById(R.id.rv_bonus_viral);
        adapter = new BonusViralAdapter(this, dataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BonusViralActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
