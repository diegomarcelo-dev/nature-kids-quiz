package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class TelaMenu extends AppCompatActivity implements Animation.AnimationListener {

    private Button level01, level02, level03;
    private Button s01, s02, s03, s04, s05, s06;

    //private Button bt01, bt02, bt03, bt04, bt05, bt06, bt07, bt08, bt09;
    //private Button bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18;
    //private Button bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27;

    LinearLayout tela1, tela2, tela3;
    RelativeLayout r01, r02, r03;

    private Animation anim01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        anim01 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_por_baixo);
        anim01.setAnimationListener(this);

        tela1 = (LinearLayout) findViewById(R.id.tela1);
        tela2 = (LinearLayout) findViewById(R.id.tela2);
        tela3 = (LinearLayout) findViewById(R.id.tela3);

        r01 = (RelativeLayout) findViewById(R.id.relative01);
        r02 = (RelativeLayout) findViewById(R.id.relative02);
        r03 = (RelativeLayout) findViewById(R.id.relative03);

        level01 = findViewById(R.id.f01);
        level01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaMenu.this, TelaJogoInicial01.class));
            }
        });

        level02 = findViewById(R.id.f02);
        level02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaMenu.this, TelaJogoQuiz01.class));
            }
        });

        level03 = findViewById(R.id.f03);
        level03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaMenu.this, TelaJogoForca01.class));
            }
        });

        s01 = (Button)findViewById(R.id.seta01);
        s01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela1.setVisibility(View.GONE);
                tela3.setVisibility(View.VISIBLE);
                r01.setVisibility(View.GONE);
                r03.setVisibility(View.VISIBLE);
                tela3.startAnimation(anim01);
            }

        });

        s02 = (Button)findViewById(R.id.seta02);
        s02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela1.setVisibility(View.GONE);
                tela2.setVisibility(View.VISIBLE);
                r01.setVisibility(View.GONE);
                r02.setVisibility(View.VISIBLE);
                tela2.startAnimation(anim01);
            }

        });

        s03 = (Button)findViewById(R.id.seta03);
        s03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela1.setVisibility(View.VISIBLE);
                tela2.setVisibility(View.GONE);
                r02.setVisibility(View.GONE);
                r01.setVisibility(View.VISIBLE);
                tela1.startAnimation(anim01);
            }

        });

        s04 = (Button)findViewById(R.id.seta04);
        s04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela2.setVisibility(View.GONE);
                tela3.setVisibility(View.VISIBLE);
                r02.setVisibility(View.GONE);
                r03.setVisibility(View.VISIBLE);
                tela3.startAnimation(anim01);
            }

        });

        s05 = (Button)findViewById(R.id.seta05);
        s05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela3.setVisibility(View.GONE);
                tela2.setVisibility(View.VISIBLE);
                r03.setVisibility(View.GONE);
                r02.setVisibility(View.VISIBLE);
                tela2.startAnimation(anim01);
            }

        });

        s06 = (Button)findViewById(R.id.seta06);
        s06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tela3.setVisibility(View.GONE);
                tela1.setVisibility(View.VISIBLE);
                r03.setVisibility(View.GONE);
                r01.setVisibility(View.VISIBLE);
                tela1.startAnimation(anim01);
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
