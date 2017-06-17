package br.com.custocar.custocar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaInicialActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Handler handler = new Handler();
        handler.postDelayed(this,3000);




    }

    @Override
    public void run() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }
}