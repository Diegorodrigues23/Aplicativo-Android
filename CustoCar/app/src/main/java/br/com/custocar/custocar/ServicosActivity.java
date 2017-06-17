package br.com.custocar.custocar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ServicosActivity extends AppCompatActivity {
    public Context c =this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);

        String dataSelecionada =  getIntent().getStringExtra("data");

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        ImageView bntcalendario = (ImageView) findViewById(R.id.imageButtonCal);
        Button bntsalvar = (Button) findViewById(R.id.buttonSalvar);
        bntsalvar.setTypeface(ubuntu);

        TextView txtViewData = (TextView) findViewById(R.id.textViewData);
        txtViewData.setTypeface(ubuntu);
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        editTextData.setTypeface(ubuntu);

        TextView txtViewDesc = (TextView) findViewById(R.id.textViewDesc);
        txtViewDesc.setTypeface(ubuntu);
        EditText editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        editTextDesc.setTypeface(ubuntu);

        TextView txtViewValor = (TextView) findViewById(R.id.textViewValor);
        txtViewValor.setTypeface(ubuntu);
        EditText editTextValor = (EditText) findViewById(R.id.editTextValor);
        editTextValor.setTypeface(ubuntu);

        TextView txtViewCupom = (TextView) findViewById(R.id.textViewCupom);
        txtViewCupom.setTypeface(ubuntu);
        EditText editTextCupom = (EditText) findViewById(R.id.editTextCupom);
        editTextCupom.setTypeface(ubuntu);

        TextView txtViewServicos = (TextView) findViewById(R.id.textViewServicos);
        txtViewServicos.setTypeface(ubuntu);
        try {
            if (dataSelecionada.equals(null)) {

            } else {
                editTextData.setText(dataSelecionada);
            }
        } catch (Exception e) {
        }


        bntcalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, CalendarioActivity.class);
                intent.putExtra("tela","servicos");
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();

    /*
     * SOMETHING THAT TAKES A LONG TIME TO FINSIH
     */
        Intent a = new Intent(this, DespesasActivity.class);
        a.putExtra("data","servicos");
        startActivity(a);

    }
}
