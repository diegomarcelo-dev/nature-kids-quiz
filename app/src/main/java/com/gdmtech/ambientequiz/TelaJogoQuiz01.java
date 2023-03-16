package com.gdmtech.ambientequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TelaJogoQuiz01 extends AppCompatActivity implements Animation.AnimationListener{

    LinearLayout l00, l01, l02, l03, l04;

    TextView pergunta, progresso, percurso;
    TextView life01, life02, life03;
    SoundManager sm;

    RadioGroup rg;
    RadioButton b01, b02, b03;
    private Button text01, text02, text03;
    private Button t01, t02, t03;
    private Button p01, p02, p03;
    private Button btn_confirmar;
    private Animation anim01, anim02, anim03, quest_inc;
    private Animation anim01_text, anim02_text, anim03_text;
    private Animation anim_perdeu, animPisca, anim_venceu;

    String questoes [] = {
            "Qual destes animais está ameaçado de extinção?",       //  1
            "É um animal silvestre?",       //  2
            "Animal que vive em regiões de Floresta?",       //  3
            "Felino encontrado nas florestas brasileiras?",       //  4
            "Pergunta05",       //  5
            "Pergunta06",       //  6
            "Pergunta07",       //  7
            "Pergunta08",       //  8
            "Pergunta09",       //  9
            "Pergunta10",       //  10
            "Pergunta11",       //  11
            "Pergunta12",       //  12
            "Pergunta13",       //  13
    };

    String respostas [] = {
            "a) Onça",              //1
            "b) Onça-pintada",              //2
            "a) Arara-azul",        //3
            "b) Onça-pintada",      //4
            "c) correta",           //5
            "c) correta",           //6
            "c) correta",           //7
            "c) correta",           //8
            "c) correta",           //9
            "c) correta",           //10
            "c) correta",           //11
            "c) correta",           //12
            "c) correta",           //13
    };

    String avante [] = {
            "1/10",
            "2/10",
            "3/10",
            "4/10",
            "5/10",
            "6/10",
            "7/10",
            "8/10",
            "9/10",
            "10/10",
            "11/10"
    };

    String alternativasA [] = {
            "a) Onça", //1
            "a) Gato",              //2
            "a) Arara-azul",                          //3
            "a) Tigre",                      //4
            "a) errada",                       //5
            "a) errada",                          //6
            "a) errada",                     //7
            "a) errada",                     //8
            "a) errada",                      //9
            "a) errada",                          //10
            "a) errada",                       //11
            "a) errada",                           //12
            "a) errada",                     //13
    };

    String alternativasB [] = {
            "b) Cachorro", //1
            "b) Onça-pintada",             //2
            "b) Galinha",                          //3
            "b) Onça-pintada",                       //4
            "b) errada",                      //5
            "b) errada",                          //6
            "b) errada",                        //7
            "b) errada",                       //8
            "b) errada",                    //9
            "b) errada",                          //10
            "b) errada",                       //11
            "b) errada",                           //12
            "b) errada",                     //13
    };

    String alternativasC [] = {
            "c) Macaco", //1
            "c) Cachorro",            //2
            "c) Pato",                          //3
            "c) Leão",                       //4
            "c) correta",                      //5
            "c) correta",                          //6
            "c) correta",                   //7
            "c) correta",                      //8
            "c) correta",                     //9
            "c) correta",                          //10
            "c) correta",                        //11
            "c) correta",                           //12
            "c) correta",                   //13
    };

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogo_quiz01);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        overridePendingTransition(R.anim.entrada_tela_direita, R.anim.saida_tela);

        //animPisca = new AlphaAnimation(1, 0); // Altera alpha de invisível a visível
        //animPisca.setDuration(1000); // duração - um segundo
        //animPisca.setInterpolator(new LinearInterpolator());

        anim01 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita01);
        anim01.setAnimationListener(this);

        anim02 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita02);
        anim02.setAnimationListener(this);

        anim03 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita03);
        anim03.setAnimationListener(this);

        anim01_text = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita_texto01);
        anim01_text.setAnimationListener(this);

        anim02_text = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita_texto02);
        anim02_text.setAnimationListener(this);

        anim03_text = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita_texto03);
        anim03_text.setAnimationListener(this);

        quest_inc = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.questao_incorreta);
        quest_inc.setAnimationListener(this);

        anim_perdeu = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita03);
        anim_perdeu.setAnimationListener(this);

        anim_venceu = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.entrada_tela_direita03);
        anim_venceu.setAnimationListener(this);

        ImageView imagemAnimPerdeu = (ImageView) findViewById(R.id.anim_perdeu);//animação Você Perdeu
        imagemAnimPerdeu.setBackgroundResource(R.drawable.animacao_voce_perdeu);
        imagemAnimPerdeu.startAnimation(anim_perdeu);

        AnimationDrawable animation01 = (AnimationDrawable) imagemAnimPerdeu.getBackground();
        animation01.start();

        ImageView imagemAnimVenceu = (ImageView) findViewById(R.id.anim_venceu);//animação Você Venceu
        imagemAnimVenceu.setBackgroundResource(R.drawable.animacao_voce_venceu);
        imagemAnimVenceu.startAnimation(anim_venceu);

        AnimationDrawable animation02 = (AnimationDrawable) imagemAnimVenceu.getBackground();
        animation02.start();

        /*final ImageView im01 = (ImageView) findViewById(R.id.animal01);
        Bitmap bitmap01 = BitmapFactory.decodeResource(getResources(),R.drawable.button_oncaa);
        RoundedBitmapDrawable roundedBitmapDrawable01 = RoundedBitmapDrawableFactory.create(getResources(), bitmap01);
        roundedBitmapDrawable01.setCircular(true);
        im01.setImageDrawable(roundedBitmapDrawable01);

        final ImageView im02 = (ImageView) findViewById(R.id.animal02);
        Bitmap bitmap02 = BitmapFactory.decodeResource(getResources(),R.drawable.button_oncaa);
        RoundedBitmapDrawable roundedBitmapDrawable02 = RoundedBitmapDrawableFactory.create(getResources(), bitmap02);
        roundedBitmapDrawable02.setCircular(true);
        im02.setImageDrawable(roundedBitmapDrawable02);

        final ImageView im03 = (ImageView) findViewById(R.id.animal03);
        Bitmap bitmap03 = BitmapFactory.decodeResource(getResources(),R.drawable.button_oncaa);
        RoundedBitmapDrawable roundedBitmapDrawable03 = RoundedBitmapDrawableFactory.create(getResources(), bitmap03);
        roundedBitmapDrawable03.setCircular(true);
        im03.setImageDrawable(roundedBitmapDrawable03);

        im01.startAnimation(animPisca);
        im02.startAnimation(animPisca);
        im03.startAnimation(animPisca);*/

        setVolumeControlStream(
                AudioManager.STREAM_MUSIC);

        sm = SoundManager.getInstance(this);
        sm.addSound(R.raw.avante);
        sm.addSound(R.raw.fail_game);

        l00 = findViewById(R.id.layout_texto);
        l01 = findViewById(R.id.layout_jogo);
        l02 = findViewById(R.id.layout_perdeu);
        l03 = findViewById(R.id.layout_venceu);
        l04 = findViewById(R.id.layout_explicar);

        percurso = findViewById(R.id.percurso);
        percurso.setText(avante[position]);

        pergunta = findViewById(R.id.pergunta);
        pergunta.setText(questoes[position]);

        progresso = findViewById(R.id.progresso);
        progresso.setText(respostas[position]);

        life01 = findViewById(R.id.p01);
        life02 = findViewById(R.id.p02);
        life03 = findViewById(R.id.p03);

        p01 = findViewById(R.id.button_prosseguir01);
        p02 = findViewById(R.id.button_prosseguir02);
        p03 = findViewById(R.id.button_prosseguir03);

        t01 = findViewById(R.id.t01);
        t02 = findViewById(R.id.t02);
        t03 = findViewById(R.id.t03);

        rg = findViewById(R.id.rg);

        btn_confirmar = findViewById(R.id.button_confirmar);

        text01 = findViewById(R.id.bt01);
        text02 = findViewById(R.id.bt02);
        text03 = findViewById(R.id.bt03);

        text01.startAnimation(anim01_text);
        text02.startAnimation(anim02_text);
        text03.startAnimation(anim03_text);

        text01.setText("Sou uma onça-pintada");
        text02.setText("Sou um animal silvestre");
        text03.setText("Eu vivo em Florestas");

        b01 = findViewById(R.id.btn01);
        b02 = findViewById(R.id.btn02);
        b03 = findViewById(R.id.btn03);

        b01.setText(alternativasA[position]);
        b02.setText(alternativasB[position]);
        b03.setText(alternativasC[position]);

        b01.startAnimation(anim01);
        b02.startAnimation(anim02);
        b03.startAnimation(anim03);

        p01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l00.setVisibility(View.GONE);
                l04.setVisibility(View.VISIBLE);
                p01.setVisibility(View.GONE);
                btn_confirmar.setVisibility(View.INVISIBLE);
                p03.setVisibility(View.VISIBLE);
            }
        });

        p03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l04.setVisibility(View.GONE);
                l01.setVisibility(View.VISIBLE);
                p03.setVisibility(View.GONE);
                btn_confirmar.setVisibility(View.INVISIBLE);
            }
        });

        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_confirmar.setVisibility(View.VISIBLE);
            }
        });

        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_confirmar.setVisibility(View.VISIBLE);
            }
        });

        b03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_confirmar.setVisibility(View.VISIBLE);
            }
        });

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();
                String selectedansTextPergunta = progresso.getText().toString();

                rg.clearCheck();
                btn_confirmar.setVisibility(View.INVISIBLE);

                if (selectedansText == selectedansTextPergunta) {
                    sm.playSound(0);
                    position++;
                    b01.setText(alternativasA[position]);
                    b02.setText(alternativasB[position]);
                    b03.setText(alternativasC[position]);
                    b01.startAnimation(anim01);
                    b02.startAnimation(anim02);
                    b03.startAnimation(anim03);
                    if (position < 10) {
                        pergunta.setText(questoes[position]);
                        progresso.setText(respostas[position]);
                        percurso.setText(avante[position]);
                    } else {
                        l01.setVisibility(View.GONE);
                        l03.setVisibility(View.VISIBLE);
                        l03.startAnimation(anim01);

                        //Texto 02
                        /*String textoLevel02 = "te02";

                        SharedPreferences tex02 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                        SharedPreferences.Editor editor = tex02.edit();
                        editor.putString("texto02", textoLevel02);
                        editor.commit();

                        setBackgroundResource(textoLevel02);

                        String textoLevel002 = "te002";

                        SharedPreferences tex002 = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                        editor = tex002.edit();
                        editor.putString("texto002", textoLevel002);
                        editor.commit();

                        setBackgroundResource(textoLevel002);*/
                    }
                    if (b01.getVisibility() == View.INVISIBLE){
                        b01.setVisibility(View.VISIBLE);
                    }

                    if (b02.getVisibility() == View.INVISIBLE){
                        b02.setVisibility(View.VISIBLE);
                    }

                    if (b03.getVisibility() == View.INVISIBLE){
                        b03.setVisibility(View.VISIBLE);
                    }
                } else {
                    sm.playSound(1);
                    pergunta.startAnimation(quest_inc);
                    //b01.setVisibility(View.INVISIBLE);
                    if (life01.getVisibility() == View.VISIBLE){
                        life01.setVisibility(View.GONE);
                        life02.setVisibility(View.VISIBLE);
                    }
                    else if (life02.getVisibility() == View.VISIBLE){
                        life02.setVisibility(View.GONE);
                        life03.setVisibility(View.VISIBLE);
                    }
                    else if (life03.getVisibility() == View.VISIBLE) {
                        life03.setVisibility(View.GONE);
                        if (life03.getVisibility() == View.GONE) {
                            l01.setVisibility(View.GONE);
                            l02.setVisibility(View.VISIBLE);
                            l02.startAnimation(anim01);
                        }
                    }

                    if (b01.getText().toString() != selectedansTextPergunta){
                        b01.setVisibility(View.INVISIBLE);
                    }

                    if (b02.getText().toString() != selectedansTextPergunta){
                        b02.setVisibility(View.INVISIBLE);
                    }

                    if (b03.getText().toString() != selectedansTextPergunta){
                        b03.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        p02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogoQuiz01.this, TelaJogoForca01.class));
            }
        });

        t01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogoQuiz01.this, TelaJogoQuiz01.class));
            }
        });

        t02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });

        t03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TelaMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
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
