package dev.setakarim.generatebarcode.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Arrays;
import java.util.List;

import dev.setakarim.generatebarcode.R;
import dev.setakarim.generatebarcode.model.BonusViralModel;

public class BonusViralAdapter extends RecyclerView.Adapter<BonusViralAdapter.BonusViralViewHolder> {

    private List<BonusViralModel> dataList;
    private Context context;
    private Bitmap result;

    private int height = 100, width = 300;


    public BonusViralAdapter(Context context, List<BonusViralModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public BonusViralViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_bonus_viral, viewGroup, false);
        return new BonusViralViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BonusViralViewHolder bonusViralViewHolder, int i) {
        String date = dataList.get(i).getDatec();
        String phone = dataList.get(i).getPhoneAfi();
        String value = dataList.get(i).getVoucherRef();

        bonusViralViewHolder.txtDate.setText(date);
        bonusViralViewHolder.txtPhone.setText(phone);

        try {
            result = generate(value);
            bonusViralViewHolder.imgBarcode.setImageBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class BonusViralViewHolder extends RecyclerView.ViewHolder{

        public final View mView;

        TextView txtDate, txtPhone;
        private ImageView imgBarcode;

        public BonusViralViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            txtDate = mView.findViewById(R.id.txt_date);
            txtPhone = mView.findViewById(R.id.txt_phone);
            imgBarcode = mView.findViewById(R.id.img_barcode);
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
