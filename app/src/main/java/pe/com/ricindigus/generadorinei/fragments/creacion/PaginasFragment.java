package pe.com.ricindigus.generadorinei.fragments.creacion;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.activities.creacion.activities_dialogs.ConfiguracionPaginaActivity;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionPaginasAdapter;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pagina;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaginasFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Context context;
    private ArrayList<Pagina> paginas;
    private CreacionPaginasAdapter creacionPaginasAdapter;
    private CreacionPaginasAdapter.OnItemClickListener onItemClickListener;


    public PaginasFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public PaginasFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_paginas, container, false);
        recyclerView =  (RecyclerView) rootView.findViewById(R.id.recycler_paginas);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        cargarDatos();
        onItemClickListener = new CreacionPaginasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, ConfiguracionPaginaActivity.class);
                Toast.makeText(context, paginas.get(position).get_id(), Toast.LENGTH_SHORT).show();
                intent.putExtra("id", paginas.get(position).get_id());
                intent.putExtra("modulo", paginas.get(position).getMODULO());
                startActivity(intent);
            }
        };
        creacionPaginasAdapter = new CreacionPaginasAdapter(paginas, context, onItemClickListener);
        recyclerView.setAdapter(creacionPaginasAdapter);
    }

    public void cargarDatos(){
        paginas = new ArrayList<>();
        DataComponentes dataComponentes = new DataComponentes(context);
        dataComponentes.open();
        paginas = dataComponentes.getAllPaginas();
        dataComponentes.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarDatos();
        creacionPaginasAdapter = new CreacionPaginasAdapter(paginas, context, onItemClickListener);
        recyclerView.setAdapter(creacionPaginasAdapter);
    }

}
