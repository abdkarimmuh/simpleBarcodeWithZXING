package dev.setakarim.generatebarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBonusViral, btnBonusOntime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBonusOntime = findViewById(R.id.btn_bonus_onetime);
        btnBonusViral = findViewById(R.id.btn_bonus_viral);

        btnBonusOntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BonusOntimeActivity.class);
                startActivity(i);
            }
        });

        btnBonusViral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BonusViralActivity.class);
                startActivity(i);
            }
        });
    }
}
