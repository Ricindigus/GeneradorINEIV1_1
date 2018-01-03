package pe.com.ricindigus.generadorinei.componentes.componente_checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import pe.com.ricindigus.generadorinei.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxFragment extends Fragment {

    private Context context;
    private POJOCheckBox POJOCheckBox;
    private ArrayList<SPCheckBox> subpreguntas;
    private LinearLayout lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10,
            lyt11,lyt12,lyt13,lyt14,lyt15,lyt16,lyt17,lyt18,lyt19,lyt20;
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10,
            ck11,ck12,ck13,ck14,ck15,ck16,ck17,ck18,ck19,ck20;
    private EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10,
            edt11,edt12,edt13,edt14,edt15,edt16,edt17,edt18,edt19,edt20;
    private TextView txtPregunta;


    public CheckBoxFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CheckBoxFragment(POJOCheckBox POJOCheckBox, ArrayList<SPCheckBox> subpreguntas, Context context) {
        this.context = context;
        this.POJOCheckBox = POJOCheckBox;
        this.subpreguntas = subpreguntas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_check_box, container, false);
        txtPregunta = (TextView) rootView.findViewById(R.id.checkbox_pregunta);
        lyt1 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp1);
        lyt2 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp2);
        lyt3 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp3);
        lyt4 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp4);
        lyt5 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp5);
        lyt6 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp6);
        lyt7 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp7);
        lyt8 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp8);
        lyt9 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp9);
        lyt10 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp10);
        lyt11 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp11);
        lyt12 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp12);
        lyt13 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp13);
        lyt14 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp14);
        lyt15 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp15);
        lyt16 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp16);
        lyt17 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp17);
        lyt18 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp18);
        lyt19 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp19);
        lyt20 = (LinearLayout) rootView.findViewById(R.id.checkbox_sp20);
        ck1 = (CheckBox) lyt1.findViewById(R.id.checkbox_check);
        ck2 = (CheckBox) lyt2.findViewById(R.id.checkbox_check);
        ck3 = (CheckBox) lyt3.findViewById(R.id.checkbox_check);
        ck4 = (CheckBox) lyt4.findViewById(R.id.checkbox_check);
        ck5 = (CheckBox) lyt5.findViewById(R.id.checkbox_check);
        ck6 = (CheckBox) lyt6.findViewById(R.id.checkbox_check);
        ck7 = (CheckBox) lyt7.findViewById(R.id.checkbox_check);
        ck8 = (CheckBox) lyt8.findViewById(R.id.checkbox_check);
        ck9 = (CheckBox) lyt9.findViewById(R.id.checkbox_check);
        ck10 = (CheckBox) lyt10.findViewById(R.id.checkbox_check);
        ck11 = (CheckBox) lyt11.findViewById(R.id.checkbox_check);
        ck12 = (CheckBox) lyt12.findViewById(R.id.checkbox_check);
        ck13 = (CheckBox) lyt13.findViewById(R.id.checkbox_check);
        ck14 = (CheckBox) lyt14.findViewById(R.id.checkbox_check);
        ck15 = (CheckBox) lyt15.findViewById(R.id.checkbox_check);
        ck16 = (CheckBox) lyt16.findViewById(R.id.checkbox_check);
        ck17 = (CheckBox) lyt17.findViewById(R.id.checkbox_check);
        ck18 = (CheckBox) lyt18.findViewById(R.id.checkbox_check);
        ck19 = (CheckBox) lyt19.findViewById(R.id.checkbox_check);
        ck20 = (CheckBox) lyt20.findViewById(R.id.checkbox_check);
        edt1 = (EditText) lyt1.findViewById(R.id.checkbox_descripcion);
        edt2 = (EditText) lyt2.findViewById(R.id.checkbox_descripcion);
        edt3 = (EditText) lyt3.findViewById(R.id.checkbox_descripcion);
        edt4 = (EditText) lyt4.findViewById(R.id.checkbox_descripcion);
        edt5 = (EditText) lyt5.findViewById(R.id.checkbox_descripcion);
        edt6 = (EditText) lyt6.findViewById(R.id.checkbox_descripcion);
        edt7 = (EditText) lyt7.findViewById(R.id.checkbox_descripcion);
        edt8 = (EditText) lyt8.findViewById(R.id.checkbox_descripcion);
        edt9 = (EditText) lyt9.findViewById(R.id.checkbox_descripcion);
        edt10 = (EditText) lyt10.findViewById(R.id.checkbox_descripcion);
        edt11 = (EditText) lyt11.findViewById(R.id.checkbox_descripcion);
        edt12 = (EditText) lyt12.findViewById(R.id.checkbox_descripcion);
        edt13 = (EditText) lyt13.findViewById(R.id.checkbox_descripcion);
        edt14 = (EditText) lyt14.findViewById(R.id.checkbox_descripcion);
        edt15 = (EditText) lyt15.findViewById(R.id.checkbox_descripcion);
        edt16 = (EditText) lyt16.findViewById(R.id.checkbox_descripcion);
        edt17 = (EditText) lyt17.findViewById(R.id.checkbox_descripcion);
        edt18 = (EditText) lyt18.findViewById(R.id.checkbox_descripcion);
        edt19 = (EditText) lyt19.findViewById(R.id.checkbox_descripcion);
        edt20 = (EditText) lyt20.findViewById(R.id.checkbox_descripcion);
        llenarVista();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void llenarVista(){
        txtPregunta.setText(POJOCheckBox.getNUMERO() + ". " + POJOCheckBox.getPREGUNTA().toUpperCase());
        LinearLayout[] linearLayouts = {lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10,
                lyt11,lyt12,lyt13,lyt14,lyt15,lyt16,lyt17,lyt18,lyt19,lyt20};
        CheckBox[] checkBoxes = {ck1, ck2, ck3, ck4, ck5, ck6, ck7, ck8, ck9, ck10,
                ck11, ck12, ck13, ck14, ck15, ck16, ck17, ck18, ck19,ck20};
        EditText[] editTexts = {edt1, edt2, edt3, edt4, edt5, edt6, edt7, edt8, edt9, edt10,
                edt11, edt12, edt13, edt14, edt15, edt16, edt17, edt18, edt19,edt20};

        for (int i = 0; i <subpreguntas.size() ; i++) {
            final LinearLayout linearLayout = linearLayouts[i];
            final CheckBox checkBox = checkBoxes[i];
            final EditText editText = editTexts[i];
            linearLayout.setVisibility(View.VISIBLE);
            checkBox.setText(subpreguntas.get(i).getSUBPREGUNTA());
            if(!subpreguntas.get(i).getVARDESC().equals("")){
                editText.setVisibility(View.VISIBLE);
                editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
