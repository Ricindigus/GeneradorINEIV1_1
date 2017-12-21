package pe.com.ricindigus.generadorinei.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.CEditText;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText txtUsuario;
    private TextInputEditText txtPassword;
    private Button btnIngresar;
    private LinearLayout layoutPrincipal;
    private Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuario = (TextInputEditText) findViewById(R.id.login_input_usuario);
        txtPassword = (TextInputEditText) findViewById(R.id.login_input_password);
        btnIngresar = (Button) findViewById(R.id.login_boton_ingresar);
        data = new Data(this);

        txtUsuario.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});
        txtPassword.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos() == true){
                    Usuario usuario = new Usuario();
                    data.open();
                    usuario = data.getUsuario(txtUsuario.getText().toString());
                    data.close();
                    if(usuario.getUSUARIO_ID().equals(txtUsuario.getText().toString()) &&
                            usuario.getUSUARIO_PASSWORD().equals(txtPassword.getText().toString())){
                        Intent intent = new Intent(getApplicationContext(),MarcoActivity.class);
                        intent.putExtra("idUsuario",usuario.getUSUARIO_ID());
                        intent.putExtra("permisoUsuario",usuario.getUSUARIO_PERMISO());
                        createData();
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Debe ingresar USUARIO y CONTRASEÑA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        layoutPrincipal = (LinearLayout) findViewById(R.id.login_layout);
        layoutPrincipal.requestFocus();
    }

    @Override
    protected void onResume() {
        super.onResume();
        layoutPrincipal = (LinearLayout) findViewById(R.id.login_layout);
        layoutPrincipal.requestFocus();
    }

    public boolean validarCampos(){
        boolean valido = true;
        if(txtUsuario.getText().toString().equals("") || txtPassword.getText().toString().equals("")) valido = false;
        return valido;
    }

    public void createData(){
        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        modulos.add(new Modulo("1","MODULO 1"));
        modulos.add(new Modulo("2","MODULO 2"));

        ArrayList<Pagina> paginas = new ArrayList<Pagina>();
        paginas.add(new Pagina("1","1","0101","1","0102","1","0103","1","","","",""));
        paginas.add(new Pagina("2","1","0104","1","0105","1","","","","","",""));
        paginas.add(new Pagina("3","1","0106","1","0107","1","","","","","",""));
        paginas.add(new Pagina("4","1","0108","1","","","","","","","",""));
        paginas.add(new Pagina("5","2","0209","1","","","","","","","",""));

        ArrayList<CEditText> cEditTexts = new ArrayList<CEditText>();
        cEditTexts.add(new CEditText("0101","01","01","¿Cuánto es tu sueldo?","SOLES","M1_P1","","","",""));
        cEditTexts.add(new CEditText("0102","01","02","¿Cuáles fueron tus 3 ultimos trabajos?","1er TRABAJO","M1_P2_1","2do TRABAJO","M1_P2_2","3er TRABAJO","M1_P2_3"));
        cEditTexts.add(new CEditText("0103","01","03","¿Cuánto tiempo llevas en tu empresa?","AÑOS","M1_P3_1","MESES","M1_P3_2","",""));
        cEditTexts.add(new CEditText("0104","01","04","En el año 2016 ¿Cuántos trabajadores tenía en promedio su empresa?","NUMERO DE TRABAJADORES","M1_P4","","","",""));
        cEditTexts.add(new CEditText("0105","01","05","¿En qué año implementó la norma técnica o estándar de calidad más importante?","AÑO","M1_P5","","","",""));
        cEditTexts.add(new CEditText("0106","01","06","¿Cuál es el gasto aproximado incurrido en las calibraciones realizadas durante el 2016?","Gasto en S/.","M1_P6","","","",""));
        cEditTexts.add(new CEditText("0107","01","07","Su empresa ¿cuántos establecimientos tiene?","N° de establecimientos","M1_P7","","","",""));
        cEditTexts.add(new CEditText("0108","01","08","Actualmente su empresa, ¿cuántas vacantes tiene?","Cantidad de vacantes","M1_P8","","","",""));
        cEditTexts.add(new CEditText("0209","02","09","Durante el año 2016, en su empresa ¿a cuánto asciende el excedente bruto de operación?","SOLES","M1_P9","","","",""));


        DataComponentes dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        dataComponentes.insertarModulos(modulos);
        dataComponentes.insertarPaginas(paginas);
        dataComponentes.insertarCEditTexts(cEditTexts);
        dataComponentes.close();
    }

}
