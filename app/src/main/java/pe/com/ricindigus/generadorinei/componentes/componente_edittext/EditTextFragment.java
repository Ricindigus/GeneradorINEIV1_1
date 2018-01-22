package pe.com.ricindigus.generadorinei.componentes.componente_edittext;


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
import android.widget.LinearLayout;
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
public class EditTextFragment extends Fragment {
    private DataComponentes dataComponentes;
    private pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText PEditText;
    private ArrayList<SPEditText> subpreguntas;
    private Context context;
    private String idEditText;
    private TextView txtPregunta;
    private TextInputLayout edtLyt1,edtLyt2,edtLyt3;
    private TextInputEditText edtSP1,edtSP2,edtSP3;
    private LinearLayout lyt1,lyt2,lyt3;
    private CardView editTextCardView;
    private View rootView;

    private TextInputLayout[] textInputLayouts = {edtLyt1, edtLyt2, edtLyt3};
    private TextInputEditText[] textInputEditTexts = {edtSP1,edtSP2,edtSP3};
    private LinearLayout[] linearLayouts = {lyt1, lyt2, lyt3};


    public EditTextFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public EditTextFragment(PEditText PEditText, ArrayList<SPEditText> subpreguntas, Context context) {
        this.PEditText = PEditText;
        this.subpreguntas = subpreguntas;
        this.context = context;
    }

    @SuppressLint("ValidFragment")



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_text, container, false);
        lyt1 = (LinearLayout) rootView.findViewById(R.id.edittext_sp1);
        lyt2 = (LinearLayout) rootView.findViewById(R.id.edittext_sp2);
        lyt3 = (LinearLayout) rootView.findViewById(R.id.edittext_sp3);
        txtPregunta = rootView.findViewById(R.id.edittext_pregunta);
        edtLyt1 = (TextInputLayout)lyt1.findViewById(R.id.edit_text_lyt);
        edtLyt2 = (TextInputLayout)lyt2.findViewById(R.id.edit_text_lyt);
        edtLyt3 = (TextInputLayout)lyt3.findViewById(R.id.edit_text_lyt);
        edtSP1 = (TextInputEditText) lyt1.findViewById(R.id.edit_text_input);
        edtSP2 = (TextInputEditText) lyt2.findViewById(R.id.edit_text_input);
        edtSP3 = (TextInputEditText) lyt3.findViewById(R.id.edit_text_input);

        llenarVista();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }

    public void llenarVista(){
        txtPregunta.setText(PEditText.getNUMERO() + ". " + PEditText.getPREGUNTA().toUpperCase());

        for (int i = 0; i < subpreguntas.size(); i++) {
            SPEditText spEditText = subpreguntas.get(i);
            linearLayouts[i].setVisibility(View.VISIBLE);
            textInputLayouts[i].setHint(spEditText.getSUBPREGUNTA());
            if(Integer.parseInt(spEditText.getTIPO()) == TipoInput.TEXTO) {
                textInputEditTexts[i].setInputType(InputType.TYPE_CLASS_TEXT);
                textInputEditTexts[i].setFilters(new InputFilter[]{
                        new InputFilter.AllCaps(),
                        new InputFilter.LengthFilter(Integer.parseInt(spEditText.getLONGITUD()))
                });
            }else{
                textInputEditTexts[i].setTransformationMethod(new NumericKeyBoardTransformationMethod());
                textInputEditTexts[i].setFilters(new InputFilter[]{
                        new InputFilter.LengthFilter(Integer.parseInt(spEditText.getLONGITUD()))
                });
            }
        }
    }

    public void cargarDatos(){

    }

    public void guardarDatos(){

    }

//    public void validar(){
//        boolean correcto = true, vEdt1, vEdt2, vEdt3;
//        if(rootView.getVisibility() == View.VISIBLE){
//            for (int i = 0; i < subpreguntas.size(); i++) {
//                if(linearLayouts[i].getVisibility() == View.VISIBLE){
//
//                }
//
//                if(Integer.parseInt(spEditText.getTIPO()) == TipoInput.TEXTO) {
//                    textInputEditTexts[i].setInputType(InputType.TYPE_CLASS_TEXT);
//                    textInputEditTexts[i].setFilters(new InputFilter[]{
//                            new InputFilter.AllCaps(),
//                            new InputFilter.LengthFilter(Integer.parseInt(spEditText.getLONGITUD()))
//                    });
//                }else{
//                    textInputEditTexts[i].setTransformationMethod(new NumericKeyBoardTransformationMethod());
//                    textInputEditTexts[i].setFilters(new InputFilter[]{
//                            new InputFilter.LengthFilter(Integer.parseInt(spEditText.getLONGITUD()))
//                    });
//                }
//            }
//        }
//    }

    public void inhabilitar(){
        rootView.setVisibility(View.GONE);
    }
}
