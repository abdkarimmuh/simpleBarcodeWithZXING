package dev.setakarim.generatebarcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.setakarim.generatebarcode.model.BonusOntimeModel;
import dev.setakarim.generatebarcode.network.RetrofitClientInstance;
import dev.setakarim.generatebarcode.network.RouteServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BonusOntimeActivity extends AppCompatActivity {

    private ImageView imgBarcode;
    private TextView txtValue;
    private Bitmap result;

    private int height = 100, width = 300;

    List<BonusOntimeModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_ontime);

        imgBarcode = findViewById(R.id.img_barcode);
        txtValue = findViewById(R.id.txt_hasil);

        RouteServices service = RetrofitClientInstance.getRetrofitInstance().create(RouteServices.class);
        Call<List<BonusOntimeModel>> call = service.getBonusOntime();
        call.enqueue(new Callback<List<BonusOntimeModel>>() {
            @Override
            public void onResponse(Call<List<BonusOntimeModel>> call, Response<List<BonusOntimeModel>> response) {
                generateData(response.body());
                display();
            }

            @Override
            public void onFailure(Call<List<BonusOntimeModel>> call, Throwable t) {
                Toast.makeText(BonusOntimeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void generateData(List<BonusOntimeModel> data) {
        dataList.clear();
        dataList.addAll(data);
    }

    private void display(){
        String value = dataList.get(0).getVoucherOnt();

        txtValue.setText(value);

        try {
            result = generate(value);
            imgBarcode.setImageBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
            Toast.makeText(BonusOntimeActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
        }

    }

    private Bitmap generate(String value) throws WriterException {
        MultiFormatWriter writer = new MultiFormatWriter();
        String finalData = value;

        // Use 1 as the height of the matrix as this is a 1D Barcode.
        BitMatrix bm = writer.encode(finalData, BarcodeFormat.CODE_128, width, 1);
        int bmWidth = bm.getWidth();

        Bitmap imageBitmap = Bitmap.createBitmap(bmWidth, height, Bitmap.Config.ARGB_8888);

        for (int i = 0; i < bmWidth; i++) {
            // Paint columns of width 1
            int[] column = new int[height];
            Arrays.fill(column, bm.get(i, 0) ? Color.BLACK : Color.WHITE);
            imageBitmap.setPixels(column, 0, 1, i, 0, 1, height);
        }

        return imageBitmap;
    }
}
