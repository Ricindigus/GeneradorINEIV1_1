package pe.com.ricindigus.generadorinei.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.CreacionActivity;
import pe.com.ricindigus.generadorinei.activities.activities_encuesta.MarcoActivity;
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
    private String tituloEncuesta;


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
        tituloEncuesta = encuesta.getTITULO();
        txtTituloEncuesta.setText(tituloEncuesta);
        txtUsuario.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});
        txtPassword.setFilters(new InputFilter[]{new InputFilter.AllCaps(),new InputFilter.LengthFilter(10)});

        txtUsuario.setText("ADMI");
        txtPassword.setText("1234");

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos() == true){
                    Usuario usuario = new Usuario();
                    data.open();
                    usuario = data.getUsuario(txtUsuario.getText().toString());
                    data.close();
                    if(usuario.getUSUARIO_PASSWORD().equals(txtPassword.getText().toString())){
                        Intent intent = new Intent(getApplicationContext(),MarcoActivity.class);
                        intent.putExtra("idUsuario",usuario.getUSUARIO_ID());
                        intent.putExtra("permisoUsuario",usuario.getUSUARIO_PERMISO());
                        intent.putExtra("tituloEncuesta",tituloEncuesta);
//                        createData();
                        startActivity(intent);
                        finish();
                    }else{
                        if(txtUsuario.getText().toString().equals("ADMI") && txtPassword.getText().toString().equals("1234")){
                            Intent intent = new Intent(getApplicationContext(),CreacionActivity.class);
                            startActivity(intent);
                            finish();
                        }else Toast.makeText(LoginActivity.this, "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
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

    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Está seguro que desea salir de la aplicación?")
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
                                    finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
        return super.onKeyDown(keyCode, event);
    }

}
