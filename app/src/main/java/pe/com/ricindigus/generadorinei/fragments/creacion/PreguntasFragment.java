package pe.com.ricindigus.generadorinei.fragments.creacion;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.CheckBoxActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.EditTextActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.FormularioActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.GPSActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.RadioActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.UbicacionActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.VisitasActivity;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionPreguntasAdapter;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntasFragment extends Fragment {
    LinearLayoutManager linearLayoutManager;
    CreacionPreguntasAdapter creacionPreguntasAdapter;
    RecyclerView recyclerView;
    Context context;
    FloatingActionButton fab;
    ArrayList<Pregunta> preguntas;


    public PreguntasFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public PreguntasFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_preguntas, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.pregunta_recycler);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab_preguntas);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        cargarDatos();
        creacionPreguntasAdapter = new CreacionPreguntasAdapter(preguntas,context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(creacionPreguntasAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_pregunta,null);
                final Spinner spTipoPreguntas = (Spinner) dialogView.findViewById(R.id.dialog_pregunta_spTipoComponente);
                final Spinner spModulos = (Spinner) dialogView.findViewById(R.id.dialog_pregunta_spModulo);
                final Spinner spPaginas = (Spinner) dialogView.findViewById(R.id.dialog_pregunta_spPagina);
                final EditText edtNumero = (EditText) dialogView.findViewById(R.id.dialog_pregunta_txtNumero);
                DataComponentes data = new DataComponentes(context);
                data.open();
                ArrayList<String> modulos = data.getArregloModulos();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,modulos);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spModulos.setAdapter(adapter);
                data.close();
                builder.setTitle("INDIQUE EL TIPO DE PREGUNTA");
                builder.setView(dialogView);
                builder.setPositiveButton("ACEPTAR", null);
                builder.setNegativeButton("CANCELAR",null);
                final AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (spTipoPreguntas.getSelectedItemPosition() > 0 && spModulos.getSelectedItemPosition() > 0
                                        && spPaginas.getSelectedItemPosition() > 0 && !edtNumero.getText().toString().equals("")){
                                    Intent intent = null;
                                    switch (spTipoPreguntas.getSelectedItemPosition()){
                                        case TipoComponente.VISITAS:
                                            intent = new Intent(context, VisitasActivity.class);
                                            break;
                                        case TipoComponente.UBICACION:
                                            intent = new Intent(context, UbicacionActivity.class);
                                            break;
                                        case TipoComponente.GPS:
                                            intent = new Intent(context, GPSActivity.class);
                                            break;
                                        case TipoComponente.FORMULARIO:
                                            intent = new Intent(context, FormularioActivity.class);
                                            break;
                                        case TipoComponente.EDITTEXT:
                                            intent = new Intent(context, EditTextActivity.class);
                                            break;
                                        case TipoComponente.CHECKBOX:
                                            intent = new Intent(context, CheckBoxActivity.class);
                                            break;
                                        case TipoComponente.RADIO:
                                            intent = new Intent(context, RadioActivity.class);
                                            break;
                                    }
                                    intent.putExtra("tipo",spTipoPreguntas.getSelectedItemPosition()+"");
                                    intent.putExtra("modulo",spModulos.getSelectedItemPosition()+"");
                                    intent.putExtra("modulo",spPaginas.getSelectedItemPosition()+"");
                                    intent.putExtra("numero",edtNumero.getText().toString());
                                    startActivity(intent);
                                    alertDialog.dismiss();
                                }else{
                                    Toast.makeText(context, "DEBE LLENAR LOS DATOS QUE SE PIDEN", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        spModulos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                                Thread thread = new Thread(){
                                    @Override
                                    public void run() {
                                        DataComponentes data = new DataComponentes(context);
                                        data.open();
                                        final ArrayList<String> paginas = data.getArregloPaginas(position+"");
                                        data.close();
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,paginas);
                                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                spPaginas.setAdapter(adapter);
                                            }
                                        });
                                    }
                                };
                                thread.start();
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {}
                        });
                    }
                });

                alertDialog.show();
            }
        });
    }

    public void cargarDatos(){
        preguntas = new ArrayList<>();
        DataComponentes dataComponentes = new DataComponentes(context);
        dataComponentes.open();
        preguntas = dataComponentes.getAllPreguntas();
        dataComponentes.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarDatos();
        creacionPreguntasAdapter = new CreacionPreguntasAdapter(preguntas, context);
        recyclerView.setAdapter(creacionPreguntasAdapter);
    }
}
