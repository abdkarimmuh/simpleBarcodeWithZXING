package dev.setakarim.generatebarcode.network;

import java.util.List;

import dev.setakarim.generatebarcode.model.BonusOntimeModel;
import dev.setakarim.generatebarcode.model.BonusViralModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RouteServices {

    @GET("/llx_societe")
    Call<List<BonusOntimeModel>> getBonusOntime();

    @GET("/llx_afiliasi")
    Call<List<BonusViralModel>> getBonusViral();
}
