package br.com.custocar.custocar;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CalendarioActivity extends AppCompatActivity implements OnDateSelectedListener, OnMonthChangedListener {

    private static final DateFormat FORMAT = SimpleDateFormat.getDateInstance();
    public MaterialCalendarView caldario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        caldario = (MaterialCalendarView) findViewById(R.id.calendarView);
        caldario.setOnDateChangedListener(this);
        caldario.setOnMonthChangedListener(this);
        Typeface ubuntu = Typeface.createFromAsset(getResources().getAssets(), "Ubuntu-L.ttf");

        TextView txtViewCalendario = (TextView) findViewById(R.id.TextViewCalendario);
        txtViewCalendario.setTypeface(ubuntu);


    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        Toast.makeText(this, "Data esclolhida: " + getDate(), Toast.LENGTH_SHORT).show();

        String dataSelecionada = getDate();


        String tela =  getIntent().getStringExtra("tela");

        try {
            if (tela.equals(null)) {

            } else {

                if (tela.equals("relatorio1")) {
                    //Intent a = new Intent(this, RelatorioActivity.class);
                    //a.putExtra("data", dataSelecionada);
                    //startActivity(a);
                    SingletonData singletonData = SingletonData.getInstancia();
                    singletonData.setData1(dataSelecionada);
                    singletonData.setData2("");
                    super.onBackPressed();

                } else if (tela.equals("relatorio2")) {
                    //Intent a = new Intent(this, RelatorioActivity.class);
                    //a.putExtra("data2", dataSelecionada);
                    //startActivity(a);
                    SingletonData singletonData = SingletonData.getInstancia();
                    singletonData.setData1("");
                    singletonData.setData2(dataSelecionada);
                    super.onBackPressed();

                } else if (tela.equals("imprevistos")) {
                    Intent a = new Intent(this, ImprevistosActivity.class);
                    a.putExtra("data", dataSelecionada);
                    startActivity(a);

                } else if (tela.equals("combustivel")) {
                    Intent a = new Intent(this, CombustivelActivity.class);
                    a.putExtra("data", dataSelecionada);
                    startActivity(a);

                }else if (tela.equals("servicos")){
                    Intent a = new Intent(this, ServicosActivity.class);
                    a.putExtra("data",dataSelecionada);
                    startActivity(a);
                }
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

    }

    private String getDate(){
        CalendarDay date = caldario.getSelectedDate();
        if (date == null){
            return "Nenhuma data selecionada";
        }

        return FORMAT.format(date.getDate());
    }

}
