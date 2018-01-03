package pe.com.ricindigus.generadorinei.componentes.componente_radio;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends Fragment {

    private POJORadio POJORadio;
    private ArrayList<SPRadio> subpreguntas;
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

    public RadioFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RadioFragment(POJORadio pojoRadio, ArrayList<SPRadio> subpreguntas, Context context) {
        this.POJORadio = pojoRadio;
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
        llenarVista();
        return rootView;
    }

    public void llenarVista(){
        txtPregunta.setText(POJORadio.getNUMERO() + ". " + POJORadio.getPREGUNTA().toUpperCase());
        RadioButton[] radioButtons = {radioButton1,radioButton2,radioButton3,radioButton4,
                radioButton5,radioButton6,radioButton7,radioButton8,radioButton9,radioButton10};
        EditText[] editTexts = {edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10};

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
