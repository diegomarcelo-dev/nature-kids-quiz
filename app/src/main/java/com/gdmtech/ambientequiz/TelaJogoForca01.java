package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TelaJogoForca01 extends AppCompatActivity {

    Intent Forca04;
    Intent Forca05;
    Intent Forca06;

    private Button bt01, bt02, bt03, bt04, bt05, bt06, bt07, bt08, bt09, bt10, bt11, bt12, bt13, bt14, bt15, bt16, bt17, bt18, bt19, bt20, bt21, bt22, bt23, bt24, bt25, bt26, bt27, btnovamente, btvoltar, btprosseguir;
    TextView pergunta;
    TextView textoBoneco;
    TextView tv01, tv02, tv03, tv04, tv05, tv06, tv07, tv08, tv09, tv10, tv11, tv12;

    //ImageView barraProgresso;
    SoundManager sm;
    LinearLayout lv01, lv02, lvforca;

    public static int questoes [] = {
            R.drawable.forca01,
            R.drawable.forca02,
            R.drawable.forca03,
            R.drawable.forca04,
            R.drawable.forca05,
            R.drawable.forca06,
    };

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo_forca01);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        bt01 = (Button) findViewById(R.id.btn01);
        bt02 = (Button) findViewById(R.id.btn02);
        bt03 = (Button) findViewById(R.id.btn03);
        bt04 = (Button) findViewById(R.id.btn04);
        bt05 = (Button) findViewById(R.id.btn05);
        bt06 = (Button) findViewById(R.id.btn06);
        bt07 = (Button) findViewById(R.id.btn07);
        bt08 = (Button) findViewById(R.id.btn08);
        bt09 = (Button) findViewById(R.id.btn09);
        bt10 = (Button) findViewById(R.id.btn10);
        bt11 = (Button) findViewById(R.id.btn11);
        bt12 = (Button) findViewById(R.id.btn12);
        bt13 = (Button) findViewById(R.id.btn13);
        bt14 = (Button) findViewById(R.id.btn14);
        bt15 = (Button) findViewById(R.id.btn15);
        bt16 = (Button) findViewById(R.id.btn16);
        bt17 = (Button) findViewById(R.id.btn17);
        bt18 = (Button) findViewById(R.id.btn18);
        bt19 = (Button) findViewById(R.id.btn19);
        bt20 = (Button) findViewById(R.id.btn20);
        bt21 = (Button) findViewById(R.id.btn21);
        bt22 = (Button) findViewById(R.id.btn22);
        bt23 = (Button) findViewById(R.id.btn23);
        bt24 = (Button) findViewById(R.id.btn24);
        bt25 = (Button) findViewById(R.id.btn25);
        bt26 = (Button) findViewById(R.id.btn26);
        bt27 = (Button) findViewById(R.id.btn27);

        //barraProgresso = (ImageView) findViewById(R.id.progresso);
        //barraProgresso.setBackgroundResource(R.drawable.progress00);

        btnovamente = (Button) findViewById(R.id.btn_novamente);
        btvoltar = (Button) findViewById(R.id.btn_voltar);
        btprosseguir = (Button) findViewById(R.id.btn_prosseguir);

        setVolumeControlStream(
                AudioManager.STREAM_MUSIC);

        sm = SoundManager.getInstance(this);
        sm.addSound(R.raw.avante);
        sm.addSound(R.raw.fail_game);

        tv01 = (TextView) findViewById(R.id.tv01);
        tv02 = (TextView) findViewById(R.id.tv02);
        tv03 = (TextView) findViewById(R.id.tv03);
        tv04 = (TextView) findViewById(R.id.tv04);
        tv05 = (TextView) findViewById(R.id.tv05);
        tv06 = (TextView) findViewById(R.id.tv06);
        tv07 = (TextView) findViewById(R.id.tv07);
        tv08 = (TextView) findViewById(R.id.tv08);
        tv09 = (TextView) findViewById(R.id.tv09);
        tv10 = (TextView) findViewById(R.id.tv10);
        tv11 = (TextView) findViewById(R.id.tv11);
        tv12 = (TextView) findViewById(R.id.tv12);

        lv01 = (LinearLayout) findViewById(R.id.lv01);
        //lv02 = (LinearLayout) findViewById(R.id.lv02);
        lvforca = (LinearLayout) findViewById(R.id.lvforca);

        pergunta = (TextView) findViewById(R.id.pergunta);
        pergunta.setText("PERGUNTA TESTE RESPOSTA CORRETA oxigênio\n");

        textoBoneco = (TextView) findViewById(R.id.boneco);

        textoBoneco.setBackgroundResource(questoes[position]);

        tv01.setText("O");
        tv02.setText("X");
        tv03.setText("I");
        tv04.setText("G");
        tv05.setText("E");
        tv06.setText("N");
        tv07.setText("I");
        tv08.setText("O");
        tv09.setVisibility(View.GONE);
        tv10.setVisibility(View.GONE);
        tv11.setVisibility(View.GONE);
        tv12.setVisibility(View.GONE);

        bt01.setText("Q");
        bt02.setText("W");
        bt03.setText("E");
        bt04.setText("R");
        bt05.setText("T");
        bt06.setText("Y");
        bt07.setText("U");
        bt08.setText("I");
        bt09.setText("O");
        bt10.setText("P");

        bt11.setText("A");
        bt12.setText("S");
        bt13.setText("D");
        bt14.setText("F");
        bt15.setText("G");
        bt16.setText("H");
        bt17.setText("J");
        bt18.setText("K");
        bt19.setText("L");
        bt20.setText("Ç");

        bt21.setText("Z");
        bt22.setText("X");
        bt23.setText("C");
        bt24.setText("V");
        bt25.setText("B");
        bt26.setText("N");
        bt27.setText("M");


        bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt01.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);
                }
            }
        });

        bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt02.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);
                }
            }
        });

        bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt03.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt03.getText().toString();
                String selectedansText05 = tv05.getText().toString();

                if (selectedansText == selectedansText05) {
                    tv05.setTextColor(Color.rgb(48, 63, 159));
                }

                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });


        bt04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt04.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);
                }
            }
        });

        bt05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt05.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt06.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt07.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt08.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt08.getText().toString();
                String selectedansText03 = tv03.getText().toString();
                String selectedansText07 = tv07.getText().toString();

                if (selectedansText == selectedansText03) {
                    tv03.setTextColor(Color.rgb(48, 63, 159));
                }

                if (selectedansText == selectedansText07) {
                    tv07.setTextColor(Color.rgb(48, 63, 159));
                }
                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });

        bt09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt09.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt09.getText().toString();
                String selectedansText01 = tv01.getText().toString();
                String selectedansText08 = tv08.getText().toString();

                if (selectedansText == selectedansText01) {
                    tv01.setTextColor(Color.rgb(48, 63, 159));
                }

                if (selectedansText == selectedansText08) {
                    tv08.setTextColor(Color.rgb(48, 63, 159));
                }

                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt10.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt11.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt12.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt13.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt14.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt15.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt15.getText().toString();
                String selectedansText04 = tv04.getText().toString();

                if (selectedansText == selectedansText04) {
                    tv04.setTextColor(Color.rgb(48, 63, 159));
                }

                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });

        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt16.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt17.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt18.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt19.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt20.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt21.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt22.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt22.getText().toString();
                String selectedansText02 = tv02.getText().toString();

                if (selectedansText == selectedansText02) {
                    tv02.setTextColor(Color.rgb(48, 63, 159));
                }

                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });

        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt23.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt24.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt25.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        bt26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt26.setVisibility(View.INVISIBLE);
                sm.playSound(0);

                String selectedansText = bt26.getText().toString();
                String selectedansText06 = tv06.getText().toString();

                if (selectedansText == selectedansText06) {
                    tv06.setTextColor(Color.rgb(48, 63, 159));
                }

                if (bt03.getVisibility() == bt08.getVisibility() && bt08.getVisibility() == bt09.getVisibility() && bt09.getVisibility() == bt15.getVisibility() && bt15.getVisibility() == bt22.getVisibility() && bt22.getVisibility() == bt26.getVisibility()) {
                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.acerto, null);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                            drawable.getMinimumHeight());
                    textoBoneco.setCompoundDrawables(null, null, drawable, null);
                    lv01.setVisibility(View.GONE);
                    btprosseguir.setVisibility(View.VISIBLE);
                    tv01.setTextColor(Color.rgb(18, 10, 143));
                    tv02.setTextColor(Color.rgb(18, 10, 143));
                    tv03.setTextColor(Color.rgb(18, 10, 143));
                    tv04.setTextColor(Color.rgb(18, 10, 143));
                    tv05.setTextColor(Color.rgb(18, 10, 143));
                    tv06.setTextColor(Color.rgb(18, 10, 143));
                    tv07.setTextColor(Color.rgb(18, 10, 143));
                    tv08.setTextColor(Color.rgb(18, 10, 143));

                    /*String corLevel02 = "a02";

                    SharedPreferences sp02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    SharedPreferences.Editor editor = sp02.edit();
                    editor.putString("cod02", corLevel02);
                    editor.commit();

                    setBackgroundResource(corLevel02);

                    String cor02 = "b02";

                    SharedPreferences s02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                    editor = s02.edit();
                    editor.putString("cor02", cor02);
                    editor.commit();

                    setBackgroundResource(cor02);*/

                }
            }
        });

        bt27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt27.setVisibility(View.INVISIBLE);
                sm.playSound(1);

                position++;
                if (position < questoes.length) {
                    textoBoneco.setBackgroundResource(questoes[position]);

                } else {
                    textoBoneco.setBackgroundResource(R.drawable.forca07);
                    lv01.setVisibility(View.GONE);
                    btnovamente.setVisibility(View.VISIBLE);
                    btvoltar.setVisibility(View.VISIBLE);

                }
            }
        });

        btnovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogoForca01.this, TelaJogoForca01.class));
            }
        });

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });

        btprosseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sorteiaTela();
                Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

            }
        });

    }
}
