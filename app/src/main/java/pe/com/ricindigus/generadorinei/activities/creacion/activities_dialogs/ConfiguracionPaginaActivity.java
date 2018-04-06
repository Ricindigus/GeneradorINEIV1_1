package pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.modelo.DataCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_checkbox.pojos.PCheckBox;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.modelo.DataEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.modelo.DataFormulario;
import pe.com.ricindigus.generadorinei.componentes.componente_formulario.pojos.Formulario;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.modelo.DataGPS;
import pe.com.ricindigus.generadorinei.componentes.componente_gps.pojos.GPS;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.modelo.DataRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.modelo.DataUbicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_ubicacion.pojos.Ubicacion;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.modelo.DataVisitas;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.pojos.Visita;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

public class ConfiguracionPaginaActivity extends AppCompatActivity {
    TextView txtId;
    TextView txtModulo;

    EditText txtN1;
    EditText txtN2;
    EditText txtN3;
    EditText txtN4;
    EditText txtN5;
    EditText txtN6;
    EditText txtN7;
    EditText txtN8;
    EditText txtN9;
    EditText txtN10;

    Spinner spTipo1;
    Spinner spTipo2;
    Spinner spTipo3;
    Spinner spTipo4;
    Spinner spTipo5;
    Spinner spTipo6;
    Spinner spTipo7;
    Spinner spTipo8;
    Spinner spTipo9;
    Spinner spTipo10;

    Button btnGuardar;
    Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_pagina);
        txtId = (TextView) findViewById(R.id.pagina_txtId);
        txtModulo = (TextView) findViewById(R.id.pagina_txtModulo);

        txtN1 = (EditText) findViewById(R.id.pagina_txtN1);
        txtN2 = (EditText) findViewById(R.id.pagina_txtN2);
        txtN3 = (EditText) findViewById(R.id.pagina_txtN3);
        txtN4 = (EditText) findViewById(R.id.pagina_txtN4);
        txtN5 = (EditText) findViewById(R.id.pagina_txtN5);
        txtN6 = (EditText) findViewById(R.id.pagina_txtN6);
        txtN7 = (EditText) findViewById(R.id.pagina_txtN7);
        txtN8 = (EditText) findViewById(R.id.pagina_txtN8);
        txtN9 = (EditText) findViewById(R.id.pagina_txtN9);
        txtN10 = (EditText) findViewById(R.id.pagina_txtN10);

        spTipo1 = (Spinner) findViewById(R.id.pagina_spTipo1);
        spTipo2 = (Spinner) findViewById(R.id.pagina_spTipo2);
        spTipo3 = (Spinner) findViewById(R.id.pagina_spTipo3);
        spTipo4 = (Spinner) findViewById(R.id.pagina_spTipo4);
        spTipo5 = (Spinner) findViewById(R.id.pagina_spTipo5);
        spTipo6 = (Spinner) findViewById(R.id.pagina_spTipo6);
        spTipo7 = (Spinner) findViewById(R.id.pagina_spTipo7);
        spTipo8 = (Spinner) findViewById(R.id.pagina_spTipo8);
        spTipo9 = (Spinner) findViewById(R.id.pagina_spTipo9);
        spTipo10 = (Spinner) findViewById(R.id.pagina_spTipo10);



        EditText[] edts = {txtN1, txtN2, txtN3, txtN4, txtN5, txtN6, txtN7, txtN8, txtN9, txtN10};
        for (EditText e : edts){
            e.setTransformationMethod(new NumericKeyBoardTransformationMethod());
        }

        btnCancelar = (Button) findViewById(R.id.pagina_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.pagina_btnGuardar);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("id");
        final String modulo = bundle.getString("modulo");
        txtId.setText(id);
        txtModulo.setText(modulo);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataComponentes dataComponentes = new DataComponentes(ConfiguracionPaginaActivity.this);
                dataComponentes.open();
                Spinner[] spinners = {spTipo1, spTipo2, spTipo3, spTipo4, spTipo5, spTipo6, spTipo7, spTipo8, spTipo9, spTipo10};
                EditText[] editTexts = {txtN1, txtN2, txtN3, txtN4, txtN5, txtN6, txtN7, txtN8, txtN9, txtN10};

                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < editTexts.length ; i++) {
                    String numeroPregunta = editTexts[i].getText().toString();
                    int tipoPregunta = spinners[i].getSelectedItemPosition();
                    if(!numeroPregunta.equals("")){
                        contentValues.put("IDP" + (i+1), "M" + modulo + "P" + numeroPregunta);
                        contentValues.put("TIPO" + (i+1), tipoPregunta+"");
//                        switch (tipoPregunta){
//                            case TipoComponente.VISITAS:
//                                DataVisitas dataVisitas = new DataVisitas(ConfiguracionPaginaActivity.this);
//                                dataVisitas.open();
//                                dataVisitas.insertarVisita(new Visita("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataVisitas.close();
//                                break;
//                            case TipoComponente.UBICACION:
//                                DataUbicacion dataUbicacion = new DataUbicacion(ConfiguracionPaginaActivity.this);
//                                dataUbicacion.open();
//                                dataUbicacion.insertarUbicacion(new Ubicacion("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataUbicacion.close();
//                                break;
//                            case TipoComponente.GPS:
//                                DataGPS dataGPS = new DataGPS(ConfiguracionPaginaActivity.this);
//                                dataGPS.open();
//                                dataGPS.insertarGPS(new GPS("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataGPS.close();
//                                break;
//                            case TipoComponente.FORMULARIO:
//                                DataFormulario dataFormulario = new DataFormulario(ConfiguracionPaginaActivity.this);
//                                dataFormulario.open();
//                                dataFormulario.insertarFormulario(new Formulario("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataFormulario.close();
//                                break;
//                            case TipoComponente.EDITTEXT:
//                                DataEditText dataEditText = new DataEditText(ConfiguracionPaginaActivity.this);
//                                dataEditText.open();
//                                dataEditText.insertarPEditText(new PEditText("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataEditText.close();
//                                break;
//                            case TipoComponente.CHECKBOX:
//                                DataCheckBox dataCheckBox = new DataCheckBox(ConfiguracionPaginaActivity.this);
//                                dataCheckBox.open();
//                                dataCheckBox.insertarPCheckBox(new PCheckBox("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataCheckBox.close();
//                                break;
//                            case TipoComponente.RADIO:
//                                DataRadio dataRadio = new DataRadio(ConfiguracionPaginaActivity.this);
//                                dataRadio.open();
//                                dataRadio.insertarPRadio(new PRadio("M" + modulo + "P" + numeroPregunta,modulo+"",numeroPregunta+""));
//                                dataRadio.close();
//                                break;
//                        }
                    }
                }
                dataComponentes.actualizarPagina(id+"",contentValues);
                dataComponentes.close();
                finish();
            }
        });
    }
}
