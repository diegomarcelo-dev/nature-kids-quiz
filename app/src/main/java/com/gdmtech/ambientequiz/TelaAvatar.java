package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class TelaAvatar extends AppCompatActivity {

    private Button im01, im02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_avatar);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        im01 = findViewById(R.id.avatar01);
        im01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaAvatar.this, TelaMenu.class));
            }
        });

        im02 = findViewById(R.id.avatar02);
        im02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaAvatar.this, TelaMenu.class));
            }
        });
    }
}
