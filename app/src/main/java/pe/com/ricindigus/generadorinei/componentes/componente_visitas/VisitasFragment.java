package pe.com.ricindigus.generadorinei.componentes.componente_visitas;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitasFragment extends Fragment {

    private String idEmpresa;
    private Context context;
    private View rootView;

    private ArrayList<Visita> visitas;
    private LinearLayoutManager linearLayoutManager;
    private VisitaAdapter visitaAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton btnAgregar;
    private TextView txtFechaFinal;
    private TextView txtHorafinal;
    private TextView txtResultadoFinal;
//    private Data data;
//    private ResultadoEncuesta resultadoEncuesta;

    int diaInicio,mesInicio, anioInicio;
    int horaInicio, minutoInicio;
    int horaFin, minutoFin;
    int diaProx, mesProx,anioProx;
    int horaProx, minutoProx;

    public VisitasFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public VisitasFragment(String idEmpresa, Context context) {
        this.idEmpresa = idEmpresa;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_visitas, container, false);
        return rootView;
    }

    public void cargarDatos(){}
    public boolean validarDatos(){
        boolean valido = true;
        return valido;
    }
    public void guardarDatos(){}
    public void llenarVista(){}
}
