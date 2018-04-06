package pe.com.ricindigus.generadorinei.activities.activities_creacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.LoginActivity;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.SQLCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.SQLEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.SQLFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.SQLGps;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.SQLRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.SQLUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.SQLVisitas;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;

public class CreacionActivity extends AppCompatActivity {

    LinearLayout lytCrear;
    LinearLayout lytCargar;
    LinearLayout lytExportar;
    LinearLayout lytEditar;
    Button btnCerrarSesion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion);

        lytCargar = (LinearLayout) findViewById(R.id.creacion_lyt_cargar);
        lytCrear = (LinearLayout) findViewById(R.id.creacion_lyt_crear);
        lytExportar = (LinearLayout) findViewById(R.id.creacion_lyt_exportar);
        lytEditar = (LinearLayout) findViewById(R.id.creacion_lyt_editar);
        btnCerrarSesion = (Button) findViewById(R.id.creacion_btnCerrarSesion);


        lytCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreacionActivity.this,CargarEncuestaActivity.class);
                startActivity(intent);
            }
        });

        lytCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreacionActivity.this);
                builder.setMessage("Se borrará la encuesta actual, ¿desea continuar?")
                        .setTitle("Aviso")
                        .setCancelable(false)
                        .setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Sí",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        DataComponentes dataComponentes = new DataComponentes(CreacionActivity.this);
                                        dataComponentes.open();
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaEncuestas);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaModulos);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaPaginas);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaEventos);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaOpcionSpinner);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaInfoTablas);
                                        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaVariables);
                                        dataComponentes.deleteAllElementosFromTabla(SQLVisitas.tableVisitas);
                                        dataComponentes.deleteAllElementosFromTabla(SQLUbicacion.tablaUbicacion);
                                        dataComponentes.deleteAllElementosFromTabla(SQLGps.tablaGPS);
                                        dataComponentes.deleteAllElementosFromTabla(SQLFormulario.tablaFormulario);
                                        dataComponentes.deleteAllElementosFromTabla(SQLFormulario.tablaSPFormulario);
                                        dataComponentes.deleteAllElementosFromTabla(SQLEditText.tablaEditText);
                                        dataComponentes.deleteAllElementosFromTabla(SQLEditText.tablaSPEditText);
                                        dataComponentes.deleteAllElementosFromTabla(SQLRadio.tablaRadio);
                                        dataComponentes.deleteAllElementosFromTabla(SQLRadio.tablaSPRadio);
                                        dataComponentes.deleteAllElementosFromTabla(SQLCheckBox.tablaCheckBox);
                                        dataComponentes.deleteAllElementosFromTabla(SQLCheckBox.tablaSPCheckBox);
                                        dataComponentes.close();
                                        Intent intent = new Intent(CreacionActivity.this,CrearEncuestaActivity.class);
                                        startActivity(intent);
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        lytExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreacionActivity.this,ExportarEncuestaActivity.class);
                startActivity(intent);
            }
        });

        lytEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreacionActivity.this,EditarEncuestaActivity.class);
                startActivity(intent);
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CreacionActivity.this);
                builder.setMessage("¿Está seguro que desea cerrar sesión en la aplicación?")
                        .setTitle("Aviso")
                        .setCancelable(false)
                        .setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Sí",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(CreacionActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

    }
}
