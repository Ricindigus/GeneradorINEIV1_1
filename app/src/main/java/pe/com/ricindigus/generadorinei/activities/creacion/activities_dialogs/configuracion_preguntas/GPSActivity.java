package pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs.configuracion_preguntas;

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
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;

public class GPSActivity extends AppCompatActivity {
    EditText varLatitud;
    EditText varAltitud;
    EditText varLongitud;

    private String VARLAT = "";
    private String VARLONG = "";
    private String VARALT = "";
    String id;

    Button btnCancelar;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        varLatitud = (EditText) findViewById(R.id.configuracion_gps_latitud);
        varLongitud = (EditText) findViewById(R.id.configuracion_gps_longitud);
        varAltitud = (EditText) findViewById(R.id.configuracion_gps_altitud);

        id = getIntent().getExtras().getString("id");

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
                    DataGPS data = new DataGPS(GPSActivity.this);
                    data.open();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SQLGps.GPS_ALTITUD,VARALT);
                    contentValues.put(SQLGps.GPS_LATITUD,VARLAT);
                    contentValues.put(SQLGps.GPS_LONGITUD,VARLONG);
                    data.actualizarGPS(id,contentValues);
                    data.close();
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
