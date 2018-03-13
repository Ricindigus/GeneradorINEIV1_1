package pe.com.ricindigus.generadorinei.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import pe.com.ricindigus.generadorinei.R;

public class CreacionActivity extends AppCompatActivity {

    LinearLayout lytCrear;
    LinearLayout lytCargar;
    LinearLayout lytExportar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion);

        lytCargar = (LinearLayout) findViewById(R.id.creacion_lyt_cargar);
        lytCrear = (LinearLayout) findViewById(R.id.creacion_lyt_crear);
        lytExportar = (LinearLayout) findViewById(R.id.creacion_lyt_exportar);

        lytCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreacionActivity.this, "Cargar", Toast.LENGTH_SHORT).show();
            }
        });

        lytCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreacionActivity.this, "Crear", Toast.LENGTH_SHORT).show();
            }
        });

        lytExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreacionActivity.this, "Exportar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
