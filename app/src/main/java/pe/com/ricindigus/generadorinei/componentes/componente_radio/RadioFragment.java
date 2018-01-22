package pe.com.ricindigus.generadorinei.componentes.componente_radio;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio;
import pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.SPRadio;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {

    private pe.com.ricindigus.generadorinei.componentes.componente_radio.pojos.PRadio PRadio;
    private ArrayList<SPRadio> subpreguntas;
    private Context  context;
    private TextView txtPregunta;
    private RadioGroup radioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;
    private RadioButton rb6;
    private RadioButton rb7;
    private RadioButton rb8;
    private RadioButton rb9;
    private RadioButton rb10;
    private RadioButton rb11;
    private RadioButton rb12;
    private RadioButton rb13;
    private RadioButton rb14;
    private RadioButton rb15;

    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private EditText edit4;
    private EditText edit5;
    private EditText edit6;
    private EditText edit7;
    private EditText edit8;
    private EditText edit9;
    private EditText edit10;
    private EditText edit11;
    private EditText edit12;
    private EditText edit13;
    private EditText edit14;
    private EditText edit15;


    public RadioFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RadioFragment(PRadio pRadio, ArrayList<SPRadio> subpreguntas, Context context) {
        this.PRadio = pRadio;
        this.subpreguntas = subpreguntas;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_radio, container, false);
        txtPregunta = (TextView) rootView.findViewById(R.id.radio_pregunta);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_grupo);
        rb1 = (RadioButton) rootView.findViewById(R.id.radio_sp1);
        rb2 = (RadioButton) rootView.findViewById(R.id.radio_sp2);
        rb3 = (RadioButton) rootView.findViewById(R.id.radio_sp3);
        rb4 = (RadioButton) rootView.findViewById(R.id.radio_sp4);
        rb5 = (RadioButton) rootView.findViewById(R.id.radio_sp5);
        rb6 = (RadioButton) rootView.findViewById(R.id.radio_sp6);
        rb7 = (RadioButton) rootView.findViewById(R.id.radio_sp7);
        rb8 = (RadioButton) rootView.findViewById(R.id.radio_sp8);
        rb9 = (RadioButton) rootView.findViewById(R.id.radio_sp9);
        rb10 = (RadioButton) rootView.findViewById(R.id.radio_sp10);
        rb11 = (RadioButton) rootView.findViewById(R.id.radio_sp11);
        rb12 = (RadioButton) rootView.findViewById(R.id.radio_sp12);
        rb13 = (RadioButton) rootView.findViewById(R.id.radio_sp13);
        rb14 = (RadioButton) rootView.findViewById(R.id.radio_sp14);
        rb15 = (RadioButton) rootView.findViewById(R.id.radio_sp15);

        edit1 = (EditText) rootView.findViewById(R.id.radio_descripcion1);
        edit2 = (EditText) rootView.findViewById(R.id.radio_descripcion2);
        edit3 = (EditText) rootView.findViewById(R.id.radio_descripcion3);
        edit4 = (EditText) rootView.findViewById(R.id.radio_descripcion4);
        edit5 = (EditText) rootView.findViewById(R.id.radio_descripcion5);
        edit6 = (EditText) rootView.findViewById(R.id.radio_descripcion6);
        edit7 = (EditText) rootView.findViewById(R.id.radio_descripcion7);
        edit8 = (EditText) rootView.findViewById(R.id.radio_descripcion8);
        edit9 = (EditText) rootView.findViewById(R.id.radio_descripcion9);
        edit10 = (EditText) rootView.findViewById(R.id.radio_descripcion10);
        edit11 = (EditText) rootView.findViewById(R.id.radio_descripcion11);
        edit12 = (EditText) rootView.findViewById(R.id.radio_descripcion12);
        edit13 = (EditText) rootView.findViewById(R.id.radio_descripcion13);
        edit14 = (EditText) rootView.findViewById(R.id.radio_descripcion14);
        edit15 = (EditText) rootView.findViewById(R.id.radio_descripcion15);
        llenarVista();
        return rootView;
    }

    public void llenarVista(){
        txtPregunta.setText(PRadio.getNUMERO() + ". " + PRadio.getPREGUNTA().toUpperCase());
        RadioButton[] radioButtons = {rb1,rb2,rb3,rb4,
                rb5,rb6,rb7,rb8,rb9,rb10,rb11,rb12,rb13,rb14,rb15};
        EditText[] editTexts = {edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10
                ,edit11,edit12,edit13,edit14,edit15};

        for (int i = 0; i <subpreguntas.size() ; i++) {
            final RadioButton radioButton = radioButtons[i];
            final EditText editText = editTexts[i];
            radioButton.setVisibility(View.VISIBLE);
            radioButton.setText(subpreguntas.get(i).getSUBPREGUNTA());
            if(!subpreguntas.get(i).getVARDESC().equals("")){
                editText.setVisibility(View.VISIBLE);
                editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            editText.setEnabled(true);
                            editText.setBackgroundResource(R.drawable.edittext_enabled);
                        } else{
                            editText.setText("");
                            editText.setEnabled(false);
                            editText.setBackgroundResource(R.drawable.edittext_disabled);
                        }
                    }
                });
            }
        }
    }
}
