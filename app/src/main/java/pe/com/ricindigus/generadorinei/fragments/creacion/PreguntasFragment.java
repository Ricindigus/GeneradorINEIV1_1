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

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.adapters.creacion.CreacionPreguntasAdapter;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.pojos.Pagina;
import pe.com.ricindigus.generadorinei.pojos.Pregunta;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntasFragment extends Fragment {
    LinearLayoutManager linearLayoutManager;
    CreacionPreguntasAdapter creacionPreguntasAdapter;
    RecyclerView recyclerView;
    Context context;
    ArrayList<Pregunta> preguntas;
    CreacionPreguntasAdapter.OnItemClickListener onItemClickListener;

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
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(context);
        cargarDatos();
        onItemClickListener = new CreacionPreguntasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent;
//                switch (Integer.parseInt(preguntas.get(position).getTipoComponente())){
//                    case TipoComponente.VISITAS:
//                        intent = new Intent(context, VisitasActivity.class);
//                        intent.putExtra("id",preguntas.get(position).getIdPregunta());
//                        startActivity(new Intent(context, VisitasActivity.class));
//                        break;
//                    case TipoComponente.UBICACION:break;
//                    case TipoComponente.GPS:break;
//                    case TipoComponente.FORMULARIO:break;
//                    case TipoComponente.EDITTEXT:break;
//                    case TipoComponente.CHECKBOX:break;
//                    case TipoComponente.RADIO:break;
//                }
            }
        };
        creacionPreguntasAdapter = new CreacionPreguntasAdapter(preguntas,context, onItemClickListener);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(creacionPreguntasAdapter);
    }

    public void cargarDatos(){
        preguntas = new ArrayList<>();
        DataComponentes dataComponentes = new DataComponentes(context);
        dataComponentes.open();
        ArrayList<Pagina> paginas = dataComponentes.getAllPaginas();
        for (Pagina p : paginas){
//            ArrayList<String> idPreguntas = dataComponentes.getIdPreguntasXPagina(p.get_id());
//            ArrayList<String> idTipos = dataComponentes.getIdTiposXPagina(p.get_id());
//            for (int i = 0; i < idPreguntas.size(); i++) {
//                String idPregunta = idPreguntas.get(i);
//                String idTipo = idTipos.get(i);
//                String descripcion = "";
//                switch (Integer.parseInt(idTipo)){
//                    case TipoComponente.VISITAS:
//                        DataVisitas dataVisitas = new DataVisitas(context);
//                        dataVisitas.open();
//                        if(dataVisitas.existeVisita(idPregunta)) descripcion = "PREGUNTA REGISTRADA OK";
//                        else descripcion = "SIN REGISTRAR";
//                        dataVisitas.close();
//                        break;
//                    case TipoComponente.UBICACION:
//                        DataUbicacion dataUbicacion =  new DataUbicacion(context);
//                        dataUbicacion.open();
//                        if (dataUbicacion.existeUbicacion(idPregunta)) descripcion = "PREGUNTA REGISTRADA OK";
//                        dataUbicacion.close();
//                        break;
//                    case TipoComponente.GPS:break;
//                    case TipoComponente.FORMULARIO:break;
//                    case TipoComponente.EDITTEXT:break;
//                    case TipoComponente.CHECKBOX:break;
//                    case TipoComponente.RADIO:break;
//
//                }
//                String numeroPregunta = idPregunta.substring(idPregunta.indexOf('P')+1);
////                preguntas.add(new Pregunta(numeroPregunta,p.getMODULO(),idPregunta,idTipo,""));
//            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        cargarDatos();
        creacionPreguntasAdapter = new CreacionPreguntasAdapter(preguntas, context, onItemClickListener);
        recyclerView.setAdapter(creacionPreguntasAdapter);
    }
}
