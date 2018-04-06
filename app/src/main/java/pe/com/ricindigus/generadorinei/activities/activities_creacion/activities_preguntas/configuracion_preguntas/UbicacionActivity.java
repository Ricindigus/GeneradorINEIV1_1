package pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.configuracion_preguntas;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;

public class UbicacionActivity extends AppCompatActivity {

    EditText varDepartamento;
    EditText varProvincia;
    EditText varDistrito;
    private String VARDEP = "";
    private String VARPRO = "";
    private String VARDIS = "";
    String id;

    Button btnCancelar;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        varDepartamento = (EditText) findViewById(R.id.configuracion_ubicacion_departamento);
        varProvincia = (EditText) findViewById(R.id.configuracion_ubicacion_provincia);
        varDistrito = (EditText) findViewById(R.id.configuracion_ubicacion_distrito);

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
                VARDEP = varDepartamento.getText().toString();
                VARPRO = varProvincia.getText().toString();
                VARDIS = varDistrito.getText().toString();

                if(validar()){
                    DataUbicacion data = new DataUbicacion(UbicacionActivity.this);
                    data.open();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SQLUbicacion.UBICACION_DEPARTAMENTO,VARDEP);
                    contentValues.put(SQLUbicacion.UBICACION_PROVINCIA,VARPRO);
                    contentValues.put(SQLUbicacion.UBICACION_DISTRITO,VARDIS);
                    data.actualizarUbicacion(id,contentValues);
                    data.close();
                    finish();
                }
            }
        });
    }

    public boolean validar(){
        boolean valido = true;
        if(VARDEP.equals("") || VARDIS.equals("") || VARPRO.equals("")){
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
