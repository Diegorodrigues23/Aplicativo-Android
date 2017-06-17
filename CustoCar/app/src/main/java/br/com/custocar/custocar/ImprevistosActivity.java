package br.com.custocar.custocar;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;


public class ImprevistosActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Context c = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprevistos);

        String dataSelecionada =  getIntent().getStringExtra("data");
        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        TextView txtViewData = (TextView) findViewById(R.id.textViewData);
        txtViewData.setTypeface(ubuntu);
        EditText editTextData = (EditText) findViewById(R.id.editTextData);
        editTextData.setTypeface(ubuntu);

        TextView txtViewNota = (TextView) findViewById(R.id.textViewNota);
        txtViewNota.setTypeface(ubuntu);
        EditText editTextNota = (EditText) findViewById(R.id.editTextNota);
        editTextNota.setTypeface(ubuntu);

        TextView txtViewValor = (TextView) findViewById(R.id.textViewValor);
        txtViewValor.setTypeface(ubuntu);
        EditText editTextValor = (EditText) findViewById(R.id.editTextValor);
        editTextValor.setTypeface(ubuntu);

        TextView txtViewCategoria = (TextView) findViewById(R.id.textViewCategoria);
        txtViewCategoria.setTypeface(ubuntu);
        TextView txtViewImprevisto = (TextView) findViewById(R.id.textViewImprevistos);
        txtViewImprevisto.setTypeface(ubuntu);

        Button bntsalvar = (Button) findViewById(R.id.buttonsalvarimpre);
        bntsalvar.setTypeface(ubuntu);

        ImageView bntcalendario = (ImageView) findViewById(R.id.imageViewCal);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCategoria);

            spinner.setOnItemSelectedListener(ImprevistosActivity.this);
            List<String> categoria = new ArrayList<String>();
            categoria.add(" ");
            categoria.add("Borracharia");
            categoria.add("Lâmpadas");
            categoria.add("Acessórios");
            categoria.add("Oficinas");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ImprevistosActivity.this, android.R.layout.simple_spinner_item, categoria);
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
                Intent intent = new Intent(c,CalendarioActivity.class);
                intent.putExtra("tela", "imprevistos");
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
