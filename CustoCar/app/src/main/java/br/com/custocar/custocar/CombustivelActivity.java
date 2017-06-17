package br.com.custocar.custocar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CombustivelActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        String dataSelecionada = getIntent().getStringExtra("data");

        ImageView bntcalendario = (ImageView) findViewById(R.id.imageViewCal);

        Button bntsalvar = (Button) findViewById(R.id.button_salvar);
        bntsalvar.setTypeface(ubuntu);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerTipo);

        TextView txtViewData = (TextView) findViewById(R.id.textViewData);
        txtViewData.setTypeface(ubuntu);
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        editTextData.setTypeface(ubuntu);

        TextView txtViewTipo = (TextView) findViewById(R.id.textViewTipo);
        txtViewTipo.setTypeface(ubuntu);

        TextView txtViewKm = (TextView) findViewById(R.id.textViewKm);
        txtViewKm.setTypeface(ubuntu);
        EditText editTextKm = (EditText) findViewById(R.id.editTextKm);
        editTextKm.setTypeface(ubuntu);

        TextView txtViewQtd = (TextView) findViewById(R.id.textViewQtd);
        txtViewQtd.setTypeface(ubuntu);
        EditText editTextQtd = (EditText) findViewById(R.id.editTextQtd);
        editTextQtd.setTypeface(ubuntu);

        TextView txtViewValor = (TextView) findViewById(R.id.textViewValor);
        txtViewValor.setTypeface(ubuntu);
        EditText editTextValor = (EditText) findViewById(R.id.editTextValor);
        editTextValor.setTypeface(ubuntu);

        TextView txtViewCupom = (TextView) findViewById(R.id.textViewCupom);
        txtViewCupom.setTypeface(ubuntu);
        EditText editTextCupom = (EditText) findViewById(R.id.editTextCupom);
        editTextCupom.setTypeface(ubuntu);

        TextView txtViewCombustivel = (TextView) findViewById(R.id.textViewCombustivel);
        txtViewCombustivel.setTypeface(ubuntu);

        spinner.setOnItemSelectedListener(CombustivelActivity.this);
            List<String>categoria = new ArrayList<String>();
            categoria.add(" ");
            categoria.add("Gasolina");
            categoria.add("Etanol");
            categoria.add("GNV");
            categoria.add("Diesel");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CombustivelActivity.this, android.R.layout.simple_spinner_item, categoria);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.getBackground().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);



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
                intent.putExtra("tela", "combustivel");
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
        startActivity(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        if (item.equals(" ")){

        }else
            Toast.makeText(parent.getContext(), "Selecionado: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
