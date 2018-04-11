package pe.com.ricindigus.generadorinei.fragments.creacion;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.activities_creacion.IngresarModuloActivity;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionModulosAdapter;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Encuesta;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

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
