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
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.CCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.CEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.CRadio;
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
        modulos.add(new Modulo("3","MODULO 3"));
        modulos.add(new Modulo("4","MODULO 4"));

        ArrayList<Pagina> paginas = new ArrayList<Pagina>();
        paginas.add(new Pagina("1","1","01001","1","01002","1","01003","1","","","",""));
        paginas.add(new Pagina("2","1","01004","1","01005","1","","","","","",""));
        paginas.add(new Pagina("3","1","01006","1","01007","1","","","","","",""));
        paginas.add(new Pagina("4","1","01008","1","","","","","","","",""));
        paginas.add(new Pagina("5","2","02001","1","02002","2","02003","2","","","",""));
        paginas.add(new Pagina("6","2","02004","2","02005","2","","","","","",""));
        paginas.add(new Pagina("7","3","03001","2","03002","3","03003","3","","","",""));
        paginas.add(new Pagina("8","3","03004","3","03005","3","","","","","",""));
        paginas.add(new Pagina("9","4","04001","3","","","","","","","",""));



        ArrayList<CEditText> cEditTexts = new ArrayList<CEditText>();
        cEditTexts.add(new CEditText("01001","01","001","¿Cuánto es tu sueldo?","SOLES","M1_P1","","","",""));
        cEditTexts.add(new CEditText("01002","01","002","¿Cuáles fueron tus 3 ultimos trabajos?","1er TRABAJO","M1_P2_1","2do TRABAJO","M1_P2_2","3er TRABAJO","M1_P2_3"));
        cEditTexts.add(new CEditText("01003","01","003","¿Cuánto tiempo llevas en tu empresa?","AÑOS","M1_P3_1","MESES","M1_P3_2","",""));
        cEditTexts.add(new CEditText("01004","01","004","En el año 2016 ¿Cuántos trabajadores tenía en promedio su empresa?","NUMERO DE TRABAJADORES","M1_P4","","","",""));
        cEditTexts.add(new CEditText("01005","01","005","¿En qué año implementó la norma técnica o estándar de calidad más importante?","AÑO","M1_P5","","","",""));
        cEditTexts.add(new CEditText("01006","01","006","¿Cuál es el gasto aproximado incurrido en las calibraciones realizadas durante el 2016?","Gasto en S/.","M1_P6","","","",""));
        cEditTexts.add(new CEditText("01007","01","007","Su empresa ¿cuántos establecimientos tiene?","N° de establecimientos","M1_P7","","","",""));
        cEditTexts.add(new CEditText("01008","01","008","Actualmente su empresa, ¿cuántas vacantes tiene?","Cantidad de vacantes","M1_P8","","","",""));
        cEditTexts.add(new CEditText("02001","02","001","Durante el año 2016, en su empresa ¿a cuánto asciende el excedente bruto de operación?","SOLES","M2_P1","","","",""));

        ArrayList<CCheckBox> cCheckBoxes = new ArrayList<CCheckBox>();
        cCheckBoxes.add(new CCheckBox("02002","02","002","PREGUNTA DE PRUEBA CHECKBOX1"
                ,"SUBPREGUNTA CHECKBOX 1","M2_P2_1","SUBPREGUNTA CHECKBOX 2","M2_P2_2"
                ,"SUBPREGUNTA CHECKBOX 3","M2_P2_3","SUBPREGUNTA CHECKBOX 4","M2_P2_4"
                ,"SUBPREGUNTA CHECKBOX 5","M2_P2_5","SUBPREGUNTA CHECKBOX 6","M2_P2_6"
                ,"SUBPREGUNTA CHECKBOX 7","M2_P2_7","SUBPREGUNTA CHECKBOX 8","M2_P2_8"
                ,"SUBPREGUNTA CHECKBOX 9","M2_P2_9","SUBPREGUNTA CHECKBOX 10","M2_P2_10"
                ,"SUBPREGUNTA CHECKBOX 11","M2_P2_11","SUBPREGUNTA CHECKBOX 12","M2_P2_12"
                ,"SUBPREGUNTA CHECKBOX 13","M2_P2_13","SUBPREGUNTA CHECKBOX 14","M2_P2_14"
                ,"SUBPREGUNTA CHECKBOX 15","M2_P2_15","SUBPREGUNTA CHECKBOX 16","M2_P2_16"
                ,"SUBPREGUNTA CHECKBOX 17","M2_P2_17","SUBPREGUNTA CHECKBOX 18","M2_P2_18"
                ,"SUBPREGUNTA CHECKBOX 19","M2_P2_19","M2_P2_ESP"));
        cCheckBoxes.add(new CCheckBox("02003","02","003","PREGUNTA DE PRUEBA CHECKBOX2"
                ,"SUBPREGUNTA CHECKBOX 1","M2_P3_1","SUBPREGUNTA CHECKBOX 2","M2_P3_2"
                ,"SUBPREGUNTA CHECKBOX 3","M2_P3_3","SUBPREGUNTA CHECKBOX 4","M2_P3_4"
                ,"SUBPREGUNTA CHECKBOX 5","M2_P3_5","SUBPREGUNTA CHECKBOX 6","M2_P3_6"
                ,"","","","","","","",""
                ,"","","","","","","",""
                ,"","","","","","","",""
                ,"","",""));
        cCheckBoxes.add(new CCheckBox("02004","02","004","PREGUNTA DE PRUEBA CHECKBOX3"
                ,"SUBPREGUNTA CHECKBOX 1","M2_P4_1","SUBPREGUNTA CHECKBOX 2","M2_P4_2"
                ,"SUBPREGUNTA CHECKBOX 3","M2_P4_3","SUBPREGUNTA CHECKBOX 4","M2_P4_4"
                ,"SUBPREGUNTA CHECKBOX 5","M2_P4_5","SUBPREGUNTA CHECKBOX 6","M2_P4_6"
                ,"SUBPREGUNTA CHECKBOX 7","M2_P4_7","SUBPREGUNTA CHECKBOX 8","M2_P4_8"
                ,"","","","","","","",""
                ,"","","","","","","",""
                ,"","","","","","","M2_P4_ESP"));
        cCheckBoxes.add(new CCheckBox("02005","02","005","PREGUNTA DE PRUEBA CHECKBOX4"
                ,"SUBPREGUNTA CHECKBOX 1","M2_P5_1","SUBPREGUNTA CHECKBOX 2","M2_P5_2"
                ,"SUBPREGUNTA CHECKBOX 3","M2_P5_3","SUBPREGUNTA CHECKBOX 4","M2_P5_4"
                ,"SUBPREGUNTA CHECKBOX 5","M2_P5_5","SUBPREGUNTA CHECKBOX 6","M2_P5_6"
                ,"","","","","","","","","","","",""
                ,"","","","","","","","","","","",""
                ,"","",""));
        cCheckBoxes.add(new CCheckBox("03001","03","001","PREGUNTA DE PRUEBA CHECKBOX5"
                ,"SUBPREGUNTA CHECKBOX 1","M3_P5_1","SUBPREGUNTA CHECKBOX 2","M3_P5_2"
                ,"SUBPREGUNTA CHECKBOX 3","M3_P5_3","SUBPREGUNTA CHECKBOX 4","M3_P5_4"
                ,"SUBPREGUNTA CHECKBOX 5","M3_P5_5","SUBPREGUNTA CHECKBOX 6","M3_P5_6"
                ,"","","","","","","","","","","",""
                ,"","","","","","","","","","","",""
                ,"","",""));

        ArrayList<CRadio> cRadios = new ArrayList<CRadio>();
        cRadios.add(new CRadio("03002","03","002","PREGUNTA DE PRUEBA RADIOS",
                "SUBPREGUNTA RADIO 1","SUBPREGUNTA RADIO 2","SUBPREGUNTA RADIO 3",
                "SUBPREGUNTA RADIO 4","SUBPREGUNTA RADIO 5","SUBPREGUNTA RADIO 6",
                "SUBPREGUNTA RADIO 7","SUBPREGUNTA RADIO 8","SUBPREGUNTA RADIO 9",
                "SUBPREGUNTA RADIO 10","M3_P2","M3_P2_0"));
        cRadios.add(new CRadio("03003","03","003","PREGUNTA DE PRUEBA RADIOS",
                "SUBPREGUNTA RADIO 1","SUBPREGUNTA RADIO 2","SUBPREGUNTA RADIO 3",
                "SUBPREGUNTA RADIO 4","SUBPREGUNTA RADIO 5","SUBPREGUNTA RADIO 6",
                "SUBPREGUNTA RADIO 7","","",
                "","M3_P3",""));
        cRadios.add(new CRadio("03004","03","004","PREGUNTA DE PRUEBA RADIOS",
                "SI","NO","NO SABE",
                "","","",
                "","","",
                "","M3_P4",""));
        cRadios.add(new CRadio("03005","03","005","PREGUNTA DE PRUEBA RADIOS",
                "SUBPREGUNTA RADIO 1","SUBPREGUNTA RADIO 2","SUBPREGUNTA RADIO 3",
                "SUBPREGUNTA RADIO 4","SUBPREGUNTA RADIO 5","SUBPREGUNTA RADIO 6",
                "","","",
                "","M3_P5","M3_P5_0"));
        cRadios.add(new CRadio("04001","04","001","PREGUNTA DE PRUEBA RADIOS",
                "SUBPREGUNTA RADIO 1","SUBPREGUNTA RADIO 2","SUBPREGUNTA RADIO 3",
                "SUBPREGUNTA RADIO 4","SUBPREGUNTA RADIO 5","SUBPREGUNTA RADIO 6",
                "SUBPREGUNTA RADIO 7","SUBPREGUNTA RADIO 8","SUBPREGUNTA RADIO 9",
                "SUBPREGUNTA RADIO 10","M4_P1","M4_P1_0"));

        DataComponentes dataComponentes = new DataComponentes(getApplicationContext());
        dataComponentes.open();
        dataComponentes.insertarModulos(modulos);
        dataComponentes.insertarPaginas(paginas);
        dataComponentes.insertarCEditTexts(cEditTexts);
        dataComponentes.insertarCCheckBoxs(cCheckBoxes);
        dataComponentes.insertarCRadios(cRadios);
        dataComponentes.close();
    }

}
