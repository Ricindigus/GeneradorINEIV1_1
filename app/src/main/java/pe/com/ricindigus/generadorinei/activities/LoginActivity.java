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

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Usuario;

public class LoginActivity extends AppCompatActivity {

    private TextView txtTituloEncuesta;
    private TextInputEditText txtUsuario;
    private TextInputEditText txtPassword;
    private Button btnIngresar;
    private LinearLayout layoutPrincipal;
    private Data data;
    private DataComponentes dataComponentes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtTituloEncuesta = (TextView) findViewById(R.id.login_titulo_encuesta);
        txtUsuario = (TextInputEditText) findViewById(R.id.login_input_usuario);
        txtPassword = (TextInputEditText) findViewById(R.id.login_input_password);
        btnIngresar = (Button) findViewById(R.id.login_boton_ingresar);
        data = new Data(this);
        dataComponentes = new DataComponentes(this);
        dataComponentes.open();
        Encuesta encuesta = dataComponentes.getEncuesta();

        txtTituloEncuesta.setText(encuesta.getTITULO());
        txtUsuario.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});
        txtPassword.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});

        txtUsuario.setText("OPER001");
        txtPassword.setText("INEI1");

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
//                        createData();
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



}
