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

public class RelatorioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public Context c = this;
    public EditText editTextDataIncial;
    public EditText editTextDataFinal;
    public String dataInicialSelecionada;
    public String dataFinalSelecionada;

    @Override
    public void onResume() {
        super.onResume();
        SingletonData singletonData = SingletonData.getInstancia();

        if (singletonData.getData1() != null) {
            if (!singletonData.getData1().equals("")) {
                editTextDataIncial.setText(singletonData.getData1());
                singletonData.setData1("");
            }
        }

        if (singletonData.getData2() != null) {
            if (!singletonData.getData2().equals("")) {
                editTextDataFinal.setText(singletonData.getData2());
                singletonData.setData2("");
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        dataInicialSelecionada = getIntent().getStringExtra("data");
        dataFinalSelecionada = getIntent().getStringExtra("data2");

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        ImageView bntcalendarioInicial = (ImageView) findViewById(R.id.imageButtonCalInicial);
        ImageView bntcalendarioFinal = (ImageView) findViewById(R.id.imageButtonCalFinal);
        Button bntGerarRelatorio = (Button) findViewById(R.id.buttonGerarRelatorio);
        bntGerarRelatorio.setTypeface(ubuntu);


        TextView txtViewDataIncial = (TextView) findViewById(R.id.textViewDataIncial);
        txtViewDataIncial.setTypeface(ubuntu);
        editTextDataIncial = (EditText) findViewById(R.id.editTextDataIni);
        editTextDataIncial.setTypeface(ubuntu);

        TextView txtViewDataFinal = (TextView) findViewById(R.id.textViewDataFinal);
        txtViewDataFinal.setTypeface(ubuntu);
        editTextDataFinal = (EditText) findViewById(R.id.editTextDataFinal);
        editTextDataFinal.setTypeface(ubuntu);

        TextView txtViewCusto = (TextView) findViewById(R.id.textViewCusto);
        txtViewCusto.setTypeface(ubuntu);
        TextView txtViewRelatorio = (TextView) findViewById(R.id.textViewRelatorio);
        txtViewRelatorio.setTypeface(ubuntu);



        Spinner spinner = (Spinner) findViewById(R.id.spinnerCusto);

        spinner.setOnItemSelectedListener(RelatorioActivity.this);
        List<String> categoria = new ArrayList<String>();
        categoria.add(" ");
        categoria.add("Gasolina");
        categoria.add("Etanol");
        categoria.add("GNV");
        categoria.add("Diesel");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(RelatorioActivity.this, android.R.layout.simple_spinner_item, categoria);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );

        spinner.setAdapter(dataAdapter);

        SingletonData singletonData = SingletonData.getInstancia();

        if (singletonData.getData1() != null) {
            if (!singletonData.getData1().equals("")) {
                editTextDataIncial.setText(singletonData.getData1());
                singletonData.setData1("");
            }
        }

        if (singletonData.getData2() != null) {
            if (!singletonData.getData2().equals("")) {
                editTextDataFinal.setText(singletonData.getData2());
                singletonData.setData2("");
            }
        }

        bntcalendarioInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDataIncial.setText("");
                Intent intent = new Intent(c, CalendarioActivity.class);
                intent.putExtra("tela", "relatorio1");
                startActivity(intent);
            }
        });
        bntcalendarioFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDataFinal.setText("");
                Intent intent = new Intent(c, CalendarioActivity.class);
                intent.putExtra("tela", "relatorio2");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        if (item.equals(" ")) {

        } else
            Toast.makeText(parent.getContext(), "Selecionado: " + item, Toast.LENGTH_LONG).show();
            ((TextView) parent.getChildAt(0)).setTextColor(Color.argb(255,239,77,36));
            Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");
            ((TextView) parent.getChildAt(0)).setTypeface(ubuntu);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
