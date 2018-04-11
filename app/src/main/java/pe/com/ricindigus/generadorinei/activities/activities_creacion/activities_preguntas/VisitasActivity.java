package pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;

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


    private String VARNUM = "";
    private String VARDIA = "";
    private String VARMES = "";
    private String VARANIO = "";
    private String VARHORI = "";
    private String VARMINI = "";
    private String VARHORF = "";
    private String VARMINF = "";
    private String VARRES = "";
    private String VARDIAP = "";
    private String VARMESP = "";
    private String VARANIOP = "";
    private String VARHORP = "";
    private String VARMINP = "";
    private String VARRESFINAL = "";
    private String VARRESDIA = "";
    private String VARRESMES = "";
    private String VARRESANIO = "";
    private String VARRESHORA = "";
    private String VARRESMIN = "";

    Button btnCancelar;
    Button btnGuardar;

    String tipo;
    String modulo;
    String pagina;
    String numero;


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

        btnCancelar = (Button) findViewById(R.id.configuracion_visita_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.configuracion_visita_btnGuardar);


        tipo = getIntent().getExtras().getString("tipo");
        modulo = getIntent().getExtras().getString("modulo");
        pagina = getIntent().getExtras().getString("pagina");
        numero = getIntent().getExtras().getString("numero");


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VARNUM = varNumero.getText().toString();
                VARDIA = varDia.getText().toString();
                VARMES = varMes.getText().toString();
                VARANIO = varAnio.getText().toString();
                VARHORI = varHoraInicio.getText().toString();
                VARMINI = varMinutoInicio.getText().toString();
                VARHORF = varHorafinal.getText().toString();
                VARMINF = varMinFinal.getText().toString();
                VARRES = varRes.getText().toString();
                VARDIAP = varDiaProx.getText().toString();
                VARMESP = varMesProx.getText().toString();
                VARANIOP = varAnioProx.getText().toString();
                VARHORP = varHoraProx.getText().toString();
                VARMINP = varMinProx.getText().toString();
                VARRESFINAL = varResFinal.getText().toString();
                VARRESDIA = varResDia.getText().toString();
                VARRESMES = varResMes.getText().toString();
                VARRESANIO = varResAnio.getText().toString();
                VARRESHORA = varResHora.getText().toString();
                VARRESMIN = varResMin.getText().toString();
                if(validar()){
                    DataVisitas data = new DataVisitas(VisitasActivity.this);
                    data.open();
                    Visita visita = new Visita();

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SQLVisitas.VISITA_VARNUM,VARNUM);
                    contentValues.put(SQLVisitas.VISITA_VARDIA,VARDIA);
                    contentValues.put(SQLVisitas.VISITA_VARMES,VARMES);
                    contentValues.put(SQLVisitas.VISITA_VARANIO,VARANIO);
                    contentValues.put(SQLVisitas.VISITA_VARHORI,VARHORI);
                    contentValues.put(SQLVisitas.VISITA_VARMINI,VARMINI);
                    contentValues.put(SQLVisitas.VISITA_VARHORF,VARHORF);
                    contentValues.put(SQLVisitas.VISITA_VARMINF,VARMINF);
                    contentValues.put(SQLVisitas.VISITA_VARRES,VARRES);
                    contentValues.put(SQLVisitas.VISITA_VARDIAP,VARDIAP);
                    contentValues.put(SQLVisitas.VISITA_VARMESP,VARMESP);
                    contentValues.put(SQLVisitas.VISITA_VARANIOP,VARANIOP);
                    contentValues.put(SQLVisitas.VISITA_VARHORP,VARHORP);
                    contentValues.put(SQLVisitas.VISITA_VARMINP,VARMINP);
                    contentValues.put(SQLVisitas.VISITA_VARRESFINAL,VARRESFINAL);
                    contentValues.put(SQLVisitas.VISITA_VARRESDIA,VARRESDIA);
                    contentValues.put(SQLVisitas.VISITA_VARRESMES,VARRESMES);
                    contentValues.put(SQLVisitas.VISITA_VARRESANIO,VARRESANIO);
                    contentValues.put(SQLVisitas.VISITA_VARRESHORA,VARRESHORA);
                    contentValues.put(SQLVisitas.VISITA_VARRESMIN,VARRESMIN);

                    data.close();
                    finish();
                }
            }
        });
    }

    public boolean validar(){
        boolean valido = true;
        if(VARNUM.equals("") || VARDIA.equals("") || VARMES.equals("") || VARANIO.equals("") ||
                VARHORI.equals("") || VARMINI.equals("") || VARHORF.equals("") || VARMINF.equals("") ||
                VARRES.equals("") || VARDIAP.equals("") || VARMESP.equals("") || VARANIOP.equals("") ||
                VARHORP.equals("") || VARMINP.equals("") || VARRESFINAL.equals("") || VARRESDIA.equals("") ||
                VARRESMES.equals("") || VARRESANIO.equals("") || VARRESHORA.equals("") || VARRESMIN.equals("")){
                mostrarMensaje("DEBE LLENAR TODOS LOS CAMPOS");
                valido = false;
        }
        return valido;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
