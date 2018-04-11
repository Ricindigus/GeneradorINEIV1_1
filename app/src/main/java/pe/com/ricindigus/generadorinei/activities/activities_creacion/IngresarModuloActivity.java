package pe.com.ricindigus.generadorinei.activities.activities_creacion;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

public class IngresarModuloActivity extends AppCompatActivity {
    TextView txtId;
    TextInputEditText txtTitulo;
    TextInputEditText txtCabecera;
    TextInputEditText txtTablaXml;
    TextInputEditText txtNumPaginas;

    Button btnGuardar;
    Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_modulo);
        txtId = (TextView) findViewById(R.id.modulo_txtId);
        txtTitulo = (TextInputEditText) findViewById(R.id.modulo_txtTitulo);
        txtCabecera = (TextInputEditText) findViewById(R.id.modulo_txtCabecera);
        txtTablaXml = (TextInputEditText) findViewById(R.id.modulo_txtNombreTabla);
        txtNumPaginas = (TextInputEditText) findViewById(R.id.modulo_txtNPaginas);
        btnCancelar = (Button) findViewById(R.id.modulo_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.modulo_btnGuardar);

        Bundle bundle = getIntent().getExtras();
        final int id = bundle.getInt("id");
        txtId.setText(id+"");

        txtTitulo.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        txtCabecera.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        txtTablaXml.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        txtNumPaginas.setTransformationMethod(new NumericKeyBoardTransformationMethod());


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
                        txtTablaXml.getText().toString(),
                        txtNumPaginas.getText().toString()
                ));
                int numPaginas = Integer.parseInt(txtNumPaginas.getText().toString());
                for (int i = 1; i <= numPaginas; i++) {
                    dataComponentes.insertarPagina(new Pagina(i+"",id+""));
                }
                dataComponentes.close();
                finish();
            }
        });
    }
}
