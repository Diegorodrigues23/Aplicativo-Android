package br.com.custocar.custocar;

import android.content.Intent;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DespesasActivity extends AppCompatActivity {
    private Context c = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesas);
        Toolbar myToolbar= (Toolbar) findViewById(R.id.toolbarmenu);
        setSupportActionBar(myToolbar);

        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        TextView txtviewmenu = (TextView) findViewById(R.id.TextViewMenu);
        txtviewmenu.setTypeface(ubuntu);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        Toolbar tb = (Toolbar) findViewById(R.id.toolbarmenu);
        tb.inflateMenu(R.menu.menu);



        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                return onOptionsItemSelected(item);
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if (item.getItemId() == R.id.idcombustivel){
            Intent intent = new Intent(c, CombustivelActivity.class);
            startActivity(intent);
            return true;

        }
        if (item.getItemId() == R.id.idimprevisto) {
            Intent intent = new Intent(c, ImprevistosActivity.class);
            startActivity(intent);
            return true;
        }

        if (item.getItemId() == R.id.idServicos) {
            Intent intent = new Intent(c, ServicosActivity.class);
            startActivity(intent);
            return true;

        }else {
                return super.onOptionsItemSelected(item);
            }
        }

    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(c, CadastroActivity.class);
        startActivity(intent);
        finish();
    /*
     * SOMETHING THAT TAKES A LONG TIME TO FINSIH
     */
    }
    }
