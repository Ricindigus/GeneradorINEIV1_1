package pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs;


import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

public class IngresarPaginaActivity extends AppCompatActivity {
    TextInputEditText txtId;
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

    Spinner spModulos;
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
        txtId = (TextInputEditText) findViewById(R.id.pagina_txtId);

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

        spModulos = (Spinner) findViewById(R.id.pagina_spModulo);
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

        btnCancelar = (Button) findViewById(R.id.pagina_btnCancelar);
        btnGuardar = (Button) findViewById(R.id.pagina_btnGuardar);

        Bundle bundle = getIntent().getExtras();
        final int id = bundle.getInt("id");
        txtId.setText(id+"");
        txtId.setEnabled(false);

        DataComponentes dataComponentes = new DataComponentes(this);
        dataComponentes.open();
        ArrayList<Modulo> modulos = dataComponentes.getAllModulos();
        ArrayList<String> opcionesModulos = new ArrayList<>();
        opcionesModulos.add("Seleccione módulo...");
        for (Modulo m : modulos){
            opcionesModulos.add(m.getID()+"-"+m.getCABECERA());
        }
        dataComponentes.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opcionesModulos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spModulos.setAdapter(adapter);


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pagina pagina = new Pagina();
                pagina.setID(txtId.getText()+"");
                pagina.setMODULO(spModulos.getSelectedItemPosition()+"");
                if(!txtN1.getText().toString().equals("")){
                    pagina.setIDP1("M"+ spModulos.getSelectedItemPosition()+"P"+txtN1.getText());
                    pagina.setTIPO1(spTipo1.getSelectedItemPosition()+"");
                }
                if(!txtN2.getText().toString().equals("")){
                    pagina.setIDP2("M"+ spModulos.getSelectedItemPosition()+"P"+txtN2.getText());
                    pagina.setTIPO2(spTipo2.getSelectedItemPosition()+"");
                }
                if(!txtN3.getText().toString().equals("")){
                    pagina.setIDP3("M"+ spModulos.getSelectedItemPosition()+"P"+txtN3.getText());
                    pagina.setTIPO3(spTipo3.getSelectedItemPosition()+"");
                }
                if(!txtN4.getText().toString().equals("")){
                    pagina.setIDP4("M"+ spModulos.getSelectedItemPosition()+"P"+txtN4.getText());
                    pagina.setTIPO4(spTipo4.getSelectedItemPosition()+"");
                }
                if(!txtN5.getText().toString().equals("")){
                    pagina.setIDP5("M"+ spModulos.getSelectedItemPosition()+"P"+txtN5.getText());
                    pagina.setTIPO5(spTipo5.getSelectedItemPosition()+"");
                }
                if(!txtN6.getText().toString().equals("")){
                    pagina.setIDP6("M"+ spModulos.getSelectedItemPosition()+"P"+txtN6.getText());
                    pagina.setTIPO6(spTipo6.getSelectedItemPosition()+"");
                }
                if(!txtN7.getText().toString().equals("")){
                    pagina.setIDP7("M"+ spModulos.getSelectedItemPosition()+"P"+txtN7.getText());
                    pagina.setTIPO7(spTipo7.getSelectedItemPosition()+"");
                }
                if(!txtN8.getText().toString().equals("")){
                    pagina.setIDP8("M"+ spModulos.getSelectedItemPosition()+"P"+txtN8.getText());
                    pagina.setTIPO8(spTipo8.getSelectedItemPosition()+"");
                }
                if(!txtN9.getText().toString().equals("")){
                    pagina.setIDP9("M"+ spModulos.getSelectedItemPosition()+"P"+txtN9.getText());
                    pagina.setTIPO9(spTipo9.getSelectedItemPosition()+"");
                }
                if(!txtN10.getText().toString().equals("")){
                    pagina.setIDP10("M"+ spModulos.getSelectedItemPosition()+"P"+txtN10.getText());
                    pagina.setTIPO10(spTipo10.getSelectedItemPosition()+"");
                }

                DataComponentes dataComponentes = new DataComponentes(IngresarPaginaActivity.this);
                dataComponentes.open();
                dataComponentes.insertarPagina(pagina);
                dataComponentes.close();
                finish();
            }
        });
    }
}
