package pe.com.ricindigus.generadorinei.componentes.componente_formulario;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoInput;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment {

    private View rootView;
    private DataComponentes dataComponentes;
    private Formulario formulario;
    private ArrayList<SPFormulario> subpreguntas;
    private Context context;
    private String idEmpresa;
    private String idFormulario;
    private TextView formularioTitulo, txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    private CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9,cv10;
    private EditText edtSP1,edtSP2, edtSP3, edtSP4, edtSP5, edtSP6, edtSP7, edtSP8, edtSP9, edtSP10,
                    edtE1,edtE2,edtE3,edtE4,edtE5,edtE6,edtE7,edtE8,edtE9,edtE10;
    private Spinner sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10;
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10;
    private LinearLayout formularioLayout, lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10;
    private CardView[] cardViews;
    private TextView[] textViews;
    private EditText[] editTexts;
    private LinearLayout[] layoutSpinners;
    private Spinner[] spinners;
    private EditText[] edtEspecifiques;
    private CheckBox[] checkBoxes;
    private int[] idCardViews = {R.id.formulario_sp1, R.id.formulario_sp2, R.id.formulario_sp3, R.id.formulario_sp4,
            R.id.formulario_sp5, R.id.formulario_sp6, R.id.formulario_sp7, R.id.formulario_sp8, R.id.formulario_sp9,
            R.id.formulario_sp10};

    public FormularioFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public FormularioFragment(Formulario formulario, ArrayList<SPFormulario> subpreguntas, Context context, String idEmpresa) {
        this.formulario = formulario;
        this.subpreguntas = subpreguntas;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_formulario, container, false);
        formularioTitulo = (TextView) rootView.findViewById(R.id.formulario_titulo);
        cardViews = new CardView[] {cv1, cv2, cv3, cv4, cv5, cv6, cv7, cv8, cv9, cv10};
        textViews = new TextView[]{txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10};
        editTexts = new EditText[]{edtSP1, edtSP2, edtSP3, edtSP4, edtSP5, edtSP6, edtSP7, edtSP8, edtSP9, edtSP10};
        layoutSpinners = new LinearLayout[]{lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10};
        spinners = new Spinner[]{sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10};
        edtEspecifiques = new EditText[]{edtE1,edtE2,edtE3,edtE4,edtE5,edtE6,edtE7,edtE8,edtE9,edtE10};
        checkBoxes = new CheckBox[]{ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10};
        for (int i = 0; i <subpreguntas.size() ; i++) {
            cardViews[i] = (CardView) rootView.findViewById(idCardViews[i]);
        }
        for (int i = 0; i <subpreguntas.size() ; i++) {
            textViews[i] = (TextView) cardViews[i].findViewById(R.id.formulario_sp_textview);
            editTexts[i] = (EditText) cardViews[i].findViewById(R.id.formulario_sp_edittext);
            layoutSpinners[i] = (LinearLayout) cardViews[i].findViewById(R.id.formulario_sp_spinner_layout);
            spinners[i] = (Spinner) cardViews[i].findViewById(R.id.formulario_sp_spinner);
            edtEspecifiques[i] = (EditText) cardViews[i].findViewById(R.id.formulario_sp_especifique);
            checkBoxes[i] = (CheckBox) cardViews[i].findViewById(R.id.formulario_sp_checkbox);
        }
        llenarVista();
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }


    public void llenarVista(){
        for (int i = 0; i <subpreguntas.size() ; i++) {
            cardViews[i].setVisibility(View.VISIBLE);
            textViews[i].setText(subpreguntas.get(i).getSUBPREGUNTA());
            if(!subpreguntas.get(i).getVARE().equals("")) {
                editTexts[i].setVisibility(View.VISIBLE);
                if(Integer.parseInt(subpreguntas.get(i).getTIPO()) == TipoInput.TEXTO) {
                    editTexts[i].setInputType(InputType.TYPE_CLASS_TEXT);
                    editTexts[i].setFilters(new InputFilter[]{
                            new InputFilter.AllCaps(),
                            new InputFilter.LengthFilter(Integer.parseInt(subpreguntas.get(i).getLONG()))
                    });
                }else{
                    editTexts[i].setTransformationMethod(new NumericKeyBoardTransformationMethod());
                    editTexts[i].setFilters(new InputFilter[]{
                            new InputFilter.LengthFilter(Integer.parseInt(subpreguntas.get(i).getLONG()))
                    });
                }
            }else{
                layoutSpinners[i].setVisibility(View.VISIBLE);
                if(subpreguntas.get(i).getVARESP().equals("")) edtEspecifiques[i].setVisibility(View.GONE);
            }
        }
    }

    public void cargarDatos(){}
    public boolean validarDatos(){
        boolean valido = true;
        return valido;
    }
    public void guardarDatos(){}




}
