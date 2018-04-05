package pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs.configuracion_preguntas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;

public class VisitasActivity extends AppCompatActivity {
    EditText varNumero;
    EditText varDia;
    EditText varMes;
    EditText varAnio;
    EditText varHoraInicio;
    EditText varMinutoInicio;
    EditText varHorafinal;
    EditText varMinFinal;
    EditText varRes;
    EditText varDiaProx;
    EditText varMesProx;
    EditText varAnioProx;
    EditText varHoraProx;
    EditText varMinProx;

    EditText varResFinal;
    EditText varResDia;
    EditText varResMes;
    EditText varResAnio;
    EditText varResHora;
    EditText varResMin;

    Button btnCancelar;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitas);
        varNumero = (EditText) findViewById(R.id.configuracion_visita_numero);
        varDia = (EditText) findViewById(R.id.configuracion_visita_dia);
        varMes = (EditText) findViewById(R.id.configuracion_visita_mes);
        varAnio = (EditText) findViewById(R.id.configuracion_visita_anio);
        varHoraInicio = (EditText) findViewById(R.id.configuracion_visita_hora_inicio);
        varMinutoInicio = (EditText) findViewById(R.id.configuracion_visita_minuto_inicio);
        varHorafinal = (EditText) findViewById(R.id.configuracion_visita_hora_final);
        varMinFinal = (EditText) findViewById(R.id.configuracion_visita_minuto_final);
        varRes = (EditText) findViewById(R.id.configuracion_visita_resultado);
        varDiaProx = (EditText) findViewById(R.id.configuracion_visita_dia_prox);
        varMesProx = (EditText) findViewById(R.id.configuracion_visita_mes_prox);
        varAnioProx = (EditText) findViewById(R.id.configuracion_visita_anio_prox);
        varHoraProx = (EditText) findViewById(R.id.configuracion_visita_hora_prox);
        varMinProx = (EditText) findViewById(R.id.configuracion_visita_min_prox);
        varResFinal = (EditText) findViewById(R.id.configuracion_visita_resultado_final);
        varResDia = (EditText) findViewById(R.id.configuracion_visita_res_dia);
        varResMes = (EditText) findViewById(R.id.configuracion_visita_res_mes);
        varResAnio = (EditText) findViewById(R.id.configuracion_visita_res_anio);
        varResHora = (EditText) findViewById(R.id.configuracion_visita_res_hora);
        varResMin = (EditText) findViewById(R.id.configuracion_visita_res_minuto);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validar()){
                    DataVisitas data = new DataVisitas(VisitasActivity.this);
                    data.open();
                    data.insertarVisita(new Visita(

                    ));
                    data.close();
                }
            }
        });
    }

    public boolean validar(){
        boolean valido = true;
        if(varNumero.getText().toString().equals("") ||
                varDia.getText().toString().equals("") ||
                varMes.getText().toString().equals("") ||
                varAnio.getText().toString().equals("") ||
                varHoraInicio.getText().toString().equals("") ||
                varMinutoInicio.getText().toString().equals("") ||
                varHorafinal.getText().toString().equals("") ||
                varMinFinal.getText().toString().equals("") ||
                varRes.getText().toString().equals("") ||
                varDiaProx.getText().toString().equals("") ||
                varMesProx.getText().toString().equals("") ||
                varAnioProx.getText().toString().equals("") ||
                varHoraProx.getText().toString().equals("") ||
                varMinProx.getText().toString().equals("") ||
                varResFinal.getText().toString().equals("") ||
                varResDia.getText().toString().equals("") ||
                varResMes.getText().toString().equals("") ||
                varResAnio.getText().toString().equals("") ||
                varResHora.getText().toString().equals("") ||
                varResMin.getText().toString().equals("")){
            valido = false;
        }
        return valido;
    }
}
