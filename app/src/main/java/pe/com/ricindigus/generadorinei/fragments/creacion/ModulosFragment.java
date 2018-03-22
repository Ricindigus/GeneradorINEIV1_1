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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs.IngresarModuloActivity;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionModulosAdapter;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
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
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}
