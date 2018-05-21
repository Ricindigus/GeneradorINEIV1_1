package pe.com.ricindigus.generadorinei.componentes.componente_selectpais;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.PaisAdapter;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_selectpais.pojos.PSelectPais;
import pe.com.ricindigus.generadorinei.componentes.componente_visitas.VisitaAdapter;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoInput;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectPaisFragment extends ComponenteFragment {
    private PSelectPais pSelectPais;
    private Context context;
    private String idEmpresa;
    private TextView txtPregunta;
    private TextView txtPais;
    private View rootView;

    private boolean cargandoDatos = false;

    public SelectPaisFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SelectPaisFragment(PSelectPais pSelectPais, Context context, String idEmpresa) {
        this.pSelectPais = pSelectPais;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_select_pais, container, false);
        txtPregunta = (TextView) rootView.findViewById(R.id.selectpais_txtPregunta);
        txtPais = (TextView) rootView.findViewById(R.id.selectpais_txtPais);
        txtPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_seleccionar_pais, null);
                final RecyclerView recyclerViewPaises = (RecyclerView) dialogView.findViewById(R.id.dialog_selectpais_recyclerPais);


                alert.setTitle("INDICAR PAIS");
                alert.setView(dialogView);

                final AlertDialog alertDialog = alert.create();

                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {

                        final List<String> paises = Arrays.asList(getResources().getStringArray(R.array.paises));
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                        PaisAdapter paisAdapter =  new PaisAdapter(paises, context, new PaisAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                txtPais.setText(paises.get(position));
                                alertDialog.dismiss();
                            }
                        });
                        recyclerViewPaises.setLayoutManager(layoutManager);
                        recyclerViewPaises.setAdapter(paisAdapter);
                    }
                });
                alertDialog.show();
            }
        });

        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llenarVista();
        cargarDatos();
    }

    public void llenarVista(){
        txtPregunta.setText(pSelectPais.getNUMERO() + ". " + pSelectPais.getPREGUNTA().toUpperCase());
    }

    public void cargarDatos(){
        Data d = new Data(context);
        d.open();
        if(d.getNumeroControladores(idEmpresa,pSelectPais.getID()) == 0){
            cargandoDatos = true;
            DataTablas data = new DataTablas(context);
            data.open();
            if(data.existenDatos(getIdTabla(),idEmpresa)){
                String valor = data.getValor(getIdTabla(),pSelectPais.getVARPAIS(),idEmpresa);
                txtPais.setText(valor);
            }
            data.close();
            cargandoDatos = false;
        }else{
            inhabilitar();
        }
    }

    public void guardarDatos(){
        DataTablas data = new DataTablas(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(pSelectPais.getVARPAIS(), txtPais.getText().toString());
        if(!data.existenDatos(getIdTabla(),idEmpresa)){
            contentValues.put("ID_EMPRESA",idEmpresa);
            data.insertarValores(getIdTabla(),contentValues);
        }else data.actualizarValores(getIdTabla(),idEmpresa,contentValues);
        data.close();
    }

    public boolean validarDatos(){
        boolean correcto = true;
        String mensaje = "";
        if(estaHabilitado()){
            if(txtPais.getText().toString().trim().equals("")){
                correcto = false;
                mensaje = "PREGUNTA " + pSelectPais.getNUMERO() + ": DEBE INDICAR PAIS";
            }
        }
        if(!correcto) mostrarMensaje(mensaje);
        return correcto;
    }

    public void inhabilitar(){
        txtPais.setText("");
        rootView.setVisibility(View.GONE);
    }

    public void habilitar(){
        rootView.setVisibility(View.VISIBLE);
    }

    public boolean estaHabilitado(){
        boolean habilitado = false;
        if(rootView.getVisibility() == View.VISIBLE) habilitado = true;
        return habilitado;
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public String getIdTabla(){
        return pSelectPais.getMODULO();
    }

}
