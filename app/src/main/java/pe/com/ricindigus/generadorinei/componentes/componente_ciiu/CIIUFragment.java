package pe.com.ricindigus.generadorinei.componentes.componente_ciiu;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.PCiiu;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.SPCiiu;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CIIUFragment extends ComponenteFragment {

    private Context context;
    private PCiiu pCiiu;
    private ArrayList<SPCiiu> spCiius;
    private String idEmpresa;

    public CIIUFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CIIUFragment(Context context, PCiiu pCiiu, ArrayList<SPCiiu> spCiius, String idEmpresa) {
        this.context = context;
        this.pCiiu = pCiiu;
        this.spCiius = spCiius;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ciiu, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void inhabilitar() {

    }

    @Override
    public void habilitar() {

    }

    @Override
    public void guardarDatos() {

    }

    @Override
    public boolean validarDatos() {
        return false;
    }

    @Override
    public boolean estaHabilitado() {
        return false;
    }

    @Override
    public String getIdTabla() {
        return null;
    }

    @Override
    public void cargarDatos() {

    }

    @Override
    public void llenarVista() {

    }
}
