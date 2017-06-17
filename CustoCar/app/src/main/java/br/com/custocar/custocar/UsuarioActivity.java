package br.com.custocar.custocar;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;

public class UsuarioActivity extends AppCompatActivity {
    public Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextNome.setTypeface(ubuntu);

        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextEmail.setTypeface(ubuntu);

        EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        editTextSenha.setTypeface(ubuntu);


        Button bntsalvar = (Button) findViewById(R.id.salvarUsuario);
        bntsalvar.setTypeface(ubuntu);
        bntsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, CadastrarVeiculoActivity.class);
                startActivity(intent);

         }
        });


    }
}
