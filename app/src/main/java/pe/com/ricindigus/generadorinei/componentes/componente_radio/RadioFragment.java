package pe.com.ricindigus.generadorinei.componentes.componente_radio;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {

    private CRadio cRadio;
    private Context  context;
    private TextView txtPregunta;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private RadioButton radioButton10;
    private EditText edtEspecifique;


    public RadioFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RadioFragment(CRadio cRadio, Context context) {
        this.cRadio = cRadio;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_radio, container, false);
        txtPregunta = (TextView) rootView.findViewById(R.id.radio_pregunta);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_grupo);
        radioButton1 = (RadioButton) rootView.findViewById(R.id.radio_sp1);
        radioButton2 = (RadioButton) rootView.findViewById(R.id.radio_sp2);
        radioButton3 = (RadioButton) rootView.findViewById(R.id.radio_sp3);
        radioButton4 = (RadioButton) rootView.findViewById(R.id.radio_sp4);
        radioButton5 = (RadioButton) rootView.findViewById(R.id.radio_sp5);
        radioButton6 = (RadioButton) rootView.findViewById(R.id.radio_sp6);
        radioButton7 = (RadioButton) rootView.findViewById(R.id.radio_sp7);
        radioButton8 = (RadioButton) rootView.findViewById(R.id.radio_sp8);
        radioButton9 = (RadioButton) rootView.findViewById(R.id.radio_sp9);
        radioButton10 = (RadioButton) rootView.findViewById(R.id.radio_sp10);
        edtEspecifique = (EditText) rootView.findViewById(R.id.radio_especifique);
        llenarVista();
        return rootView;
    }

    public void llenarVista(){
        txtPregunta.setText(cRadio.getNUMERO() + ". " + cRadio.getPREGUNTA().toUpperCase());
        String[] subPreguntas = {cRadio.getSP1(),cRadio.getSP2(),cRadio.getSP3(),cRadio.getSP4(),
                cRadio.getSP5(),cRadio.getSP6(),cRadio.getSP7(),cRadio.getSP8(),cRadio.getSP9(),
                cRadio.getSP10()};
        RadioButton[] radioButtons = {radioButton1,radioButton2,radioButton3,radioButton4,
                radioButton5,radioButton6,radioButton7,radioButton8,radioButton9,radioButton10};
        for (int i = 0; i <radioButtons.length; i++) {
            if(!subPreguntas[i].equals("")){
                radioButtons[i].setText(subPreguntas[i]);
            }else{
                radioButtons[i].setVisibility(View.GONE);
            }
        }
        if(cRadio.getVARESP().equals("")) edtEspecifique.setVisibility(View.GONE);
    }
}
