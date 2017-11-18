package pe.com.ricindigus.generadorinei.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.R;

public class LoginActivity extends AppCompatActivity {
    private TextView txtTituloEncuesta;
    private TextInputEditText edtUsuario;
    private TextInputEditText edtPassword;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtTituloEncuesta = (TextView) findViewById(R.id.login_titulo_encuesta);
        edtUsuario = (TextInputEditText) findViewById(R.id.login_input_usuario);
        edtPassword = (TextInputEditText) findViewById(R.id.login_input_password);
        btnIngresar = (Button) findViewById(R.id.login_boton_ingresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(LoginActivity.this, MarcoActivity.class);
                startActivity(intent);
            }
        });
    }
}
