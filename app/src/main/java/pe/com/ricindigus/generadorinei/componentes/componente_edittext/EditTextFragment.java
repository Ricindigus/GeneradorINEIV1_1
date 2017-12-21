package pe.com.ricindigus.generadorinei.componentes.componente_edittext;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {
    private DataComponentes dataComponentes;
    private CEditText cEditText;
    private Context context;
    private String idEditText;
    private TextView txtPregunta;
    private TextInputLayout edtLyt1;
    private TextInputLayout edtLyt2;
    private TextInputLayout edtLyt3;
    private TextInputEditText edtSP1;
    private TextInputEditText edtSP2;
    private TextInputEditText edtSP3;
    private LinearLayout lyt1;
    private LinearLayout lyt2;
    private LinearLayout lyt3;


    public EditTextFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public EditTextFragment(CEditText cEditText, Context context) {
        this.cEditText = cEditText;
        this.context = context;
    }

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
        txtPregunta.setText(cEditText.getNUMERO() + ". " + cEditText.getPREGUNTA().toUpperCase());
        String[] subPreguntas = {cEditText.getSP1(), cEditText.getSP2(), cEditText.getSP3()};
        TextInputLayout[] textInputLayouts = {edtLyt1, edtLyt2, edtLyt3};
        LinearLayout[] linearLayouts = {lyt1, lyt2, lyt3};
        for (int i = 0; i < subPreguntas.length; i++) {
            if(subPreguntas[i].equals("")){
                linearLayouts[i].setVisibility(View.GONE);
            }else{
                textInputLayouts[i].setHint(subPreguntas[i]);
            }
        }
    }

    public void cargarDatos(){

    }
}
