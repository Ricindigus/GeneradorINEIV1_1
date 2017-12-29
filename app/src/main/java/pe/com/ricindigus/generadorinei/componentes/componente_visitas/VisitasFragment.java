package pe.com.ricindigus.generadorinei.componentes.componente_visitas;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitasFragment extends Fragment {

    private String idEmpresa;
    private Context context;

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
        return inflater.inflate(R.layout.fragment_visitas, container, false);
    }

}
