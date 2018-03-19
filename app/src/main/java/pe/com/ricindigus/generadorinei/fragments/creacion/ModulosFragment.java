package pe.com.ricindigus.generadorinei.fragments.creacion;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionModulosAdapter;
import pe.com.ricindigus.generadorinei.dialogs.DialogModulo;
import pe.com.ricindigus.generadorinei.interfaces.InterfaceModulo;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.SQLConstantesComponente;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModulosFragment extends Fragment implements InterfaceModulo{
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private LinearLayoutManager linearLayoutManager;
    private Context context;
    private Button btnGuardar;
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
        btnGuardar = (Button) rootView.findViewById(R.id.modulo_btnGuardar);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        cargarDatos();
        creacionModulosAdapter = new CreacionModulosAdapter(modulos, context, new CreacionModulosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int pos) {
                PopupMenu popupMenu = new PopupMenu(context,view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_edicion,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.editar:
                                showDialogEditarModulo(modulos.get(pos));
                                break;
                            case R.id.eliminar:
                                eliminarModulo(pos);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        recyclerView.setAdapter(creacionModulosAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAgregarModulo();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataComponentes dataComponentes = new DataComponentes(context);
                dataComponentes.open();
                dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaModulos);
                for (Modulo m : modulos) dataComponentes.insertarModulo(m);
                dataComponentes.close();
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

    public void showDialogAgregarModulo() {
        DialogFragment newFragment = DialogModulo.newInstance("AGREGAR MODULO",modulos.size());
        newFragment.show(getActivity().getSupportFragmentManager(), "dialog");
    }

    public void showDialogEditarModulo(Modulo modulo) {
        DialogFragment newFragment = DialogModulo.newInstance("EDITAR MODULO", modulo);
        newFragment.show(getActivity().getSupportFragmentManager(), "dialog");
    }

    @Override
    public void agregarModulo(Modulo modulo) {
        modulos.add(modulo);
        creacionModulosAdapter.notifyDataSetChanged();
    }

    @Override
    public void editarModulo(Modulo modulo) {
        modulos.add(Integer.parseInt(modulo.getID()),modulo);
        creacionModulosAdapter.notifyDataSetChanged();
    }

    public void eliminarModulo(int pos){
        modulos.remove(pos);
        DataComponentes dataComponentes = new DataComponentes(context);
        dataComponentes.open();
        dataComponentes.deleteAllElementosFromTabla(SQLConstantesComponente.tablaModulos);
        int i = 1;
        for (Modulo m : modulos){
            m.setID(i+"");
            dataComponentes.insertarModulo(m);
            i++;
        }
        modulos = dataComponentes.getAllModulos();
        creacionModulosAdapter.notifyDataSetChanged();
        dataComponentes.close();
    }
    public void editarModulo(int pos){

    }
}
