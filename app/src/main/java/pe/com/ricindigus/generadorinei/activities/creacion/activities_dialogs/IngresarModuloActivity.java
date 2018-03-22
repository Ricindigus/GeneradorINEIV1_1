package pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

public class IngresarModuloActivity extends AppCompatActivity {
    TextInputEditText txtId;
    TextInputEditText txtTitulo;
    TextInputEditText txtCabecera;
    TextInputEditText txtNombreTabla;
    Button btnGuardar;
    Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_modulo);
        txtId = (TextInputEditText) findViewById(R.id.modulo_txtId);
        txtTitulo = (TextInputEditText) findViewById(R.id.modulo_txtTitulo);
        txtCabecera = (TextInputEditText) findViewById(R.id.modulo_txtCabecera);
        txtNombreTabla = (TextInputEditText) findViewById(R.id.modulo_txtNombreTabla);
        btnCancelar = (Button) findViewById(R.id.modulo_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.modulo_btnGuardar);

        Bundle bundle = getIntent().getExtras();
        final int id = bundle.getInt("id");
        txtId.setText(id+"");
        txtId.setEnabled(false);

        txtTitulo.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        txtCabecera.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        txtNombreTabla.setFilters(new InputFilter[]{new InputFilter.AllCaps()});


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataComponentes dataComponentes = new DataComponentes(IngresarModuloActivity.this);
                dataComponentes.open();
                dataComponentes.insertarModulo(new Modulo(
                        id+"",
                        txtTitulo.getText().toString(),
                        txtCabecera.getText().toString(),
                        txtNombreTabla.getText().toString()
                ));
                dataComponentes.close();
                finish();
            }
        });
    }
}
