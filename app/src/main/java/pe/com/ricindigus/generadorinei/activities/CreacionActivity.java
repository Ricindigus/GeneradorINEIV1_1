package pe.com.ricindigus.generadorinei.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import pe.com.ricindigus.generadorinei.R;

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
                Intent intent = new Intent(CreacionActivity.this,CrearEncuestaActivity.class);
                startActivity(intent);
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
