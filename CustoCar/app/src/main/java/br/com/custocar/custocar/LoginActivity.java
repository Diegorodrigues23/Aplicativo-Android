package br.com.custocar.custocar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    public Context c = this;
    public ArrayList<User> arrayListUsers = new ArrayList<>();
    public Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lerJson();

                    for (int i = 0; i < arrayListUsers.size(); i++) {

                        User user = new User();

                        user.setId(arrayListUsers.get(i).getId());
                        user.setNome(arrayListUsers.get(i).getNome());
                        user.setEmail(arrayListUsers.get(i).getEmail());
                        final String concat = user.getId() + " " + user.getNome() + " " + user.getEmail();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(context, concat, Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        Button bntAcessar = (Button) findViewById(R.id.button_entrar);
        bntAcessar.setTypeface(ubuntu);

        TextView txtCadatrar = (TextView) findViewById(R.id.txtcadastrar);
        txtCadatrar.setTypeface(ubuntu);

        TextView txtViewLogin = (TextView) findViewById(R.id.textViewLogin);
        txtViewLogin.setTypeface(ubuntu);

        TextView txtViewSenha = (TextView) findViewById(R.id.textViewSenha);
        txtViewSenha.setTypeface(ubuntu);

        final EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        editTextLogin.setTypeface(ubuntu);

        final EditText editTextSenha = (EditText) findViewById(R.id.editTextSenha);
        editTextSenha.setTypeface(ubuntu);



        bntAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String senha = editTextSenha.getText().toString();

                Intent intent = new Intent(c, CadastroActivity.class);
                startActivity(intent);
            }
        });

        txtCadatrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c, UsuarioActivity.class);
                startActivity(intent);

            }
        });
    }



    public void lerJson() throws ExecutionException, InterruptedException, JSONException {

        //se comunicando com o servidor
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://10.1.4.4/webservicecustocar/listarUsuarios.php");
        baseRequester.setContext(context);

        //Caso precise enviar dados para o servidor, utilize o jsonput
        //JSONObject jsonPut = new JSONObject();
        //jsonPut.put("login", login);
        //jsonPut.put("senha", senha);
        //baseRequester.setJsonString(jsonPut.toString());

        //recuperando o json em formato tetxo
        String jsonString = baseRequester.execute(baseRequester).get();

        //transformando o json texto em JsonObject
        //JSONObject jsonObject = new JSONObject(jsonString);

        //transformando o json texto em JsonOArray
        JSONArray jsonArrayUsers = new JSONArray(jsonString);

        for (int i=0; i < jsonArrayUsers.length(); i++) {

            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);

            User user = new User();
            user.setId(Integer.parseInt(jsonObjectUsuario.get("id").toString()));
            user.setNome(jsonObjectUsuario.get("nome").toString());
            user.setSenha(jsonObjectUsuario.get("senha").toString());
            user.setEmail(jsonObjectUsuario.get("email").toString());
            arrayListUsers.add(user);
        }

    }
}
