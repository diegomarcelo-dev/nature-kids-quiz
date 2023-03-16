package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TelaJogoInicial01 extends AppCompatActivity implements Animation.AnimationListener {

    private Animation anim01;

    private TextView t01;
    private ImageView im01, im02;
    private Button btn01;
    private Button b01, b02, b03;

    LinearLayout layout01, layout02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo_inicial01);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        final ImageView imageView02 = (ImageView) findViewById(R.id.im02);//animação erlenmeyer rosa
        imageView02.setBackgroundResource(R.drawable.animacao_mao);

        AnimationDrawable animation = (AnimationDrawable) imageView02.getBackground();
        animation.start();

        t01 = findViewById(R.id.text01);
        im01 = findViewById(R.id.im01);
        im02 = findViewById(R.id.im02);
        btn01 = findViewById(R.id.btn01);

        b01 = findViewById(R.id.b01);
        b02 = findViewById(R.id.b02);
        b03 = findViewById(R.id.b03);

        layout01 = findViewById(R.id.layout01);
        layout02 = findViewById(R.id.layout02);

        im01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t01.setVisibility(View.VISIBLE);
                btn01.setVisibility(View.VISIBLE);
                imageView02.setVisibility(View.GONE);
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout01.setVisibility(View.GONE);
                layout02.setVisibility(View.VISIBLE);
                //startActivity(new Intent(TelaJogoInicial01.this, TelaJogoQuiz01.class));
                //finish();
            }
        });

        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogoInicial01.this, TelaJogoQuiz01.class));
                finish();
            }
        });

        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b02.setVisibility(View.GONE);
            }
        });

        b03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b03.setVisibility(View.GONE);
            }
        });


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
