package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    private Context context;
    private CCheckBox cCheckBox;
    private LinearLayout lytCkOtro;
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10,
            ck11,ck12,ck13,ck14,ck15,ck16,ck17,ck18,ck19,ckOtro;
    private TextView txtPregunta;


    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CheckBoxFragment(CCheckBox cCheckBox,Context context) {
        this.context = context;
        this.cCheckBox = cCheckBox;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_check_box, container, false);
        txtPregunta = (TextView) rootView.findViewById(R.id.checkbox_pregunta);
        ck1 = (CheckBox) rootView.findViewById(R.id.checkbox_sp1);
        ck2 = (CheckBox) rootView.findViewById(R.id.checkbox_sp2);
        ck3 = (CheckBox) rootView.findViewById(R.id.checkbox_sp3);
        ck4 = (CheckBox) rootView.findViewById(R.id.checkbox_sp4);
        ck5 = (CheckBox) rootView.findViewById(R.id.checkbox_sp5);
        ck6 = (CheckBox) rootView.findViewById(R.id.checkbox_sp6);
        ck7 = (CheckBox) rootView.findViewById(R.id.checkbox_sp7);
        ck8 = (CheckBox) rootView.findViewById(R.id.checkbox_sp8);
        ck9 = (CheckBox) rootView.findViewById(R.id.checkbox_sp9);
        ck10 = (CheckBox) rootView.findViewById(R.id.checkbox_sp10);
        ck11 = (CheckBox) rootView.findViewById(R.id.checkbox_sp11);
        ck12 = (CheckBox) rootView.findViewById(R.id.checkbox_sp12);
        ck13 = (CheckBox) rootView.findViewById(R.id.checkbox_sp13);
        ck14 = (CheckBox) rootView.findViewById(R.id.checkbox_sp14);
        ck15 = (CheckBox) rootView.findViewById(R.id.checkbox_sp15);
        ck16 = (CheckBox) rootView.findViewById(R.id.checkbox_sp16);
        ck17 = (CheckBox) rootView.findViewById(R.id.checkbox_sp17);
        ck18 = (CheckBox) rootView.findViewById(R.id.checkbox_sp18);
        ck19 = (CheckBox) rootView.findViewById(R.id.checkbox_sp19);
        lytCkOtro = (LinearLayout) rootView.findViewById(R.id.checkbox_lyt_otro);
        ckOtro = (CheckBox) lytCkOtro.findViewById(R.id.checkbox_check);
        llenarVista();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void llenarVista(){
        txtPregunta.setText(cCheckBox.getNUMERO() + ". " + cCheckBox.getPREGUNTA().toUpperCase());
        CheckBox[] checkBoxes = {ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9,
                ck10, ck11, ck12, ck13, ck14, ck15, ck16, ck17, ck18, ck19};
        String[] subPreguntas = {cCheckBox.getSP1(), cCheckBox.getSP2(), cCheckBox.getSP3(),
                cCheckBox.getSP4(), cCheckBox.getSP5(), cCheckBox.getSP6(), cCheckBox.getSP7(),
                cCheckBox.getSP8(), cCheckBox.getSP9(), cCheckBox.getSP10(), cCheckBox.getSP11(),
                cCheckBox.getSP12(), cCheckBox.getSP13(), cCheckBox.getSP14(), cCheckBox.getSP15(),
                cCheckBox.getSP16(), cCheckBox.getSP17(), cCheckBox.getSP18(), cCheckBox.getSP19()};
        for (int i = 0; i <subPreguntas.length ; i++) {
            if(!subPreguntas[i].equals("")){
                checkBoxes[i].setText(subPreguntas[i]);
            } else{
                checkBoxes[i].setVisibility(View.GONE);
            }
        }
        if(cCheckBox.getVARESP().equals("")){
           lytCkOtro.setVisibility(View.GONE);
        }
    }

}
