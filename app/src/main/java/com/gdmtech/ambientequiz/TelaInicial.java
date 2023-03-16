package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class TelaInicial extends AppCompatActivity {

    private Button btn_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        ImageView imageView02 = (ImageView) findViewById(R.id.anim_mascote);//animação erlenmeyer rosa
        imageView02.setBackgroundResource(R.drawable.animacao_onca);

        AnimationDrawable animation = (AnimationDrawable) imageView02.getBackground();
        animation.start();

        btn_play = findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicial.this,  TelaAvatar.class));
            }
        });
    }
}
