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
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

public class GPSActivity extends AppCompatActivity {
    EditText varLatitud;
    EditText varAltitud;
    EditText varLongitud;

    private String VARLAT = "";
    private String VARLONG = "";
    private String VARALT = "";

    Button btnCancelar;
    Button btnGuardar;

    String tipo;
    String modulo;
    String pagina;
    String numero;
    String idPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        varLatitud = (EditText) findViewById(R.id.configuracion_gps_latitud);
        varLongitud = (EditText) findViewById(R.id.configuracion_gps_longitud);
        varAltitud = (EditText) findViewById(R.id.configuracion_gps_altitud);
        btnCancelar = (Button) findViewById(R.id.configuracion_gps_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.configuracion_gps_btnGuardar);

        tipo = getIntent().getExtras().getString("tipo");
        modulo = getIntent().getExtras().getString("modulo");
        pagina = getIntent().getExtras().getString("pagina");
        numero = getIntent().getExtras().getString("numero");
        idPregunta = "M" + modulo + "P" + numero;

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VARLAT = varLatitud.getText().toString();
                VARALT = varAltitud.getText().toString();
                VARLONG = varLongitud.getText().toString();

                if(validar()){
                    DataComponentes dataComponentes =  new DataComponentes(GPSActivity.this);
                    DataGPS data = new DataGPS(GPSActivity.this);
                    data.open();
                    dataComponentes.open();
                    GPS gps = new GPS(idPregunta,numero,modulo);
                    gps.setVARALT(VARALT);
                    gps.setVARLAT(VARLAT);
                    gps.setVARLONG(VARLONG);
                    data.insertarGPS(gps);

                    Pregunta pregunta = new Pregunta();
                    pregunta.set_id(idPregunta);
                    pregunta.setTIPO(tipo);
                    pregunta.setMODULO(modulo);
                    pregunta.setPAGINA(pagina);
                    pregunta.setNUMERO(numero);
                    dataComponentes.insertarPregunta(pregunta);

                    data.close();
                    dataComponentes.close();
                    finish();
                }
            }
        });

    }

    public boolean validar(){
        boolean valido = true;
        if(VARLAT.equals("") || VARALT.equals("") || VARLONG.equals("")){
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
