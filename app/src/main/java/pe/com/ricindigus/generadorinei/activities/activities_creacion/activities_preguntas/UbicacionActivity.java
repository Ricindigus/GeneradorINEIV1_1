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
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

public class UbicacionActivity extends AppCompatActivity {

    EditText varDepartamento;
    EditText varProvincia;
    EditText varDistrito;
    private String VARDEP = "";
    private String VARPRO = "";
    private String VARDIS = "";

    String tipo;
    String modulo;
    String pagina;
    String numero;
    String idPregunta;


    Button btnCancelar;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        varDepartamento = (EditText) findViewById(R.id.configuracion_ubicacion_departamento);
        varProvincia = (EditText) findViewById(R.id.configuracion_ubicacion_provincia);
        varDistrito = (EditText) findViewById(R.id.configuracion_ubicacion_distrito);
        btnCancelar = (Button) findViewById(R.id.configuracion_ubicacion_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.configuracion_ubicacion_btnGuardar);

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
                VARDEP = varDepartamento.getText().toString();
                VARPRO = varProvincia.getText().toString();
                VARDIS = varDistrito.getText().toString();

                if(validar()){
                    DataComponentes dataComponentes =  new DataComponentes(UbicacionActivity.this);
                    DataUbicacion data = new DataUbicacion(UbicacionActivity.this);
                    data.open();
                    dataComponentes.open();
                    Ubicacion ubicacion = new Ubicacion();
                    ubicacion.setID(idPregunta);
                    ubicacion.setMODULO(modulo);
                    ubicacion.setNUMERO(numero);
                    ubicacion.setVARDEP(VARDEP);
                    ubicacion.setVARPRO(VARPRO);
                    ubicacion.setVARDIS(VARDIS);
                    data.insertarUbicacion(ubicacion);

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
