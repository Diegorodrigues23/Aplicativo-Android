package br.com.custocar.custocar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;



public class CadastrarVeiculoActivity extends AppCompatActivity {
    public Context c=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_veiculo);

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        Button bntsalvarveiculo = (Button) findViewById(R.id.buttonSalvarVeiculo);
        bntsalvarveiculo.setTypeface(ubuntu);
        TextView textViewtoolbar = (TextView) findViewById(R.id.toolbartext);
        textViewtoolbar.setTypeface(ubuntu);

        TextView txtresultado = (TextView) findViewById(R.id.textViewTipo);
        txtresultado.setTypeface(ubuntu);
        TextView txtViewFabricante =  (TextView) findViewById(R.id.textViewFabricante);
        txtViewFabricante.setTypeface(ubuntu);

        TextView txtViewModelo = (TextView) findViewById(R.id.textViewData);
        txtViewModelo.setTypeface(ubuntu);
        TextView txtViewOndometro = (TextView) findViewById(R.id.textViewOndometro);
        txtViewOndometro.setTypeface(ubuntu);

        TextView txtViewPlaca = (TextView) findViewById(R.id.textViewPlaca);
        txtViewPlaca.setTypeface(ubuntu);
        EditText editTextOndometro = (EditText) findViewById(R.id.editTextOndometro);
        editTextOndometro.setTypeface(ubuntu);

        EditText editTextPlaca = (EditText) findViewById(R.id.editTextPlaca);
        editTextPlaca.setTypeface(ubuntu);
        bntsalvarveiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, CadastroActivity.class);
                startActivity(intent);

            }
        });
    }
}
