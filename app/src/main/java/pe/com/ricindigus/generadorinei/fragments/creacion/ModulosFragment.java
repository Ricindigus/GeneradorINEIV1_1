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
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.IngresarModuloActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.CheckBoxActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.EditTextActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.FormularioActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.GPSActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.RadioActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.UbicacionActivity;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.activities_preguntas.VisitasActivity;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionModulosAdapter;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.InfoTabla;
import pe.com.ricindigus.generadorinei.pojos.Modulo;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModulosFragment extends Fragment{
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private LinearLayoutManager linearLayoutManager;
    private Context context;
    private ArrayList<Modulo> modulos;
    private CreacionModulosAdapter creacionModulosAdapter;
    private EditText edtTituloEncuesta;


    public ModulosFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ModulosFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modulos, container, false);
        recyclerView =  (RecyclerView) rootView.findViewById(R.id.recycler_modulos);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab_modulos);
        edtTituloEncuesta = (EditText) rootView.findViewById(R.id.titulo_edtTituloEncuesta);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtTituloEncuesta.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        cargarDatos();
        creacionModulosAdapter = new CreacionModulosAdapter(modulos, context);
        recyclerView.setAdapter(creacionModulosAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, IngresarModuloActivity.class);
                intent.putExtra("id",modulos.size()+1);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_tipo_modulo,null);
                final Spinner spTipoModulo = (Spinner) dialogView.findViewById(R.id.dialog_tipo_componente_spinner);
                builder.setTitle("SELECCIONE EL TIPO DE MODULO");
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
                                int id = modulos.size() + 1;
                                if (spTipoModulo.getSelectedItemPosition() > 0){
                                    if(spTipoModulo.getSelectedItemPosition() == 2){
                                        Intent intent = new Intent(context, IngresarModuloActivity.class);
                                        intent.putExtra("id",id + "");
                                        startActivity(intent);
                                    }else{
                                        DataComponentes dataComponentes = new DataComponentes(context);
                                        dataComponentes.open();
                                        dataComponentes.insertarModulo(
                                                new Modulo(id + "", "VISITAS", "VISITAS", "VISITAS", "1")
                                        );
                                        onResume();
                                        int numPag = dataComponentes.getAllPaginas().size();
                                        dataComponentes.insertarPagina(new Pagina((numPag+1)+"",id+""));
                                        dataComponentes.insertarInfoTablas(new InfoTabla(id+"_1",id+"","1","VISITAS","2"));
                                        dataComponentes.insertarInfoTablas(new InfoTabla(id+"_2",id+"","2","RESULTADO","1"));
                                        dataComponentes.close();
                                    }
                                    alertDialog.dismiss();
                                }else{
                                    Toast.makeText(context, "DEBE SELECCIONAR UN TIPO DE MODULO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                alertDialog.show();
            }
        });


        edtTituloEncuesta.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    ocultarTeclado(edtTituloEncuesta);
                    recyclerView.requestFocus();
                    return true;
                }
                return false;
            }
        });
    }

    public void cargarDatos(){
        modulos = new ArrayList<>();
        DataComponentes dataComponentes = new DataComponentes(context);
        dataComponentes.open();
        modulos = dataComponentes.getAllModulos();
        dataComponentes.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarDatos();
        creacionModulosAdapter = new CreacionModulosAdapter(modulos, context);
        recyclerView.setAdapter(creacionModulosAdapter);
    }

    public void guardarDatos(){
        DataComponentes data = new DataComponentes(context);
        data.open();
        data.insertarEncuesta(new Encuesta("1",edtTituloEncuesta.getText().toString()));
        data.close();
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
