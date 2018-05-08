package pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.PCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_checkeditsuma.pojos.SPCheckEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.SPEditSuma;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckEditSumaFragment extends ComponenteFragment {
    private PCheckEditSuma pCheckEditSuma;
    private ArrayList<SPCheckEditSuma> subpreguntas;
    private Context context;
    private String idEmpresa;

    private TextView txtCabeceraPregunta, txtCabeceraRespuesta, txtPregunta, txtSumaTotal;
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10;
    private EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10;
    private EditText esp1,esp2,esp3,esp4,esp5,esp6,esp7,esp8,esp9,esp10;
    private LinearLayout lyt1, lyt2,lyt3,lyt4,lyt5,lyt6, lyt7, lyt8, lyt9, lyt10;

    private LinearLayout[] linearLayouts;
    private EditText[] editTexts;
    private EditText[] editEspecifiques;
    private CheckBox[] checkBoxes;
    private View rootView;

    private boolean cargandoDatos = false;

    public CheckEditSumaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CheckEditSumaFragment(PCheckEditSuma pCheckEditSuma, ArrayList<SPCheckEditSuma> subpreguntas, Context context, String idEmpresa) {
        this.pCheckEditSuma = pCheckEditSuma;
        this.subpreguntas = subpreguntas;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_check_edit_suma, container, false);

        txtPregunta = (TextView) rootView.findViewById(R.id.checkeditsuma_pregunta);
        txtCabeceraPregunta = (TextView) rootView.findViewById(R.id.checkeditsuma_cabecera_pregunta);
        txtCabeceraRespuesta = (TextView) rootView.findViewById(R.id.checkeditsuma_cabecera_respuesta);

        lyt1 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp1);
        lyt2 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp2);
        lyt3 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp3);
        lyt4 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp4);
        lyt5 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp5);
        lyt6 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp6);
        lyt7 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp7);
        lyt8 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp8);
        lyt9 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp9);
        lyt10 = (LinearLayout) rootView.findViewById(R.id.checkeditsuma_sp10);

        ck1 = (CheckBox) lyt1.findViewById(R.id.check_edit_suma_sp_ck);
        ck2 = (CheckBox) lyt2.findViewById(R.id.check_edit_suma_sp_ck);
        ck3 = (CheckBox) lyt3.findViewById(R.id.check_edit_suma_sp_ck);
        ck4 = (CheckBox) lyt4.findViewById(R.id.check_edit_suma_sp_ck);
        ck5 = (CheckBox) lyt5.findViewById(R.id.check_edit_suma_sp_ck);
        ck6 = (CheckBox) lyt6.findViewById(R.id.check_edit_suma_sp_ck);
        ck7 = (CheckBox) lyt7.findViewById(R.id.check_edit_suma_sp_ck);
        ck8 = (CheckBox) lyt8.findViewById(R.id.check_edit_suma_sp_ck);
        ck9 = (CheckBox) lyt9.findViewById(R.id.check_edit_suma_sp_ck);
        ck10 = (CheckBox) lyt10.findViewById(R.id.check_edit_suma_sp_ck);

        esp1 = (EditText) lyt1.findViewById(R.id.check_edit_suma_sp_especifique);
        esp2 = (EditText) lyt2.findViewById(R.id.check_edit_suma_sp_especifique);
        esp3 = (EditText) lyt3.findViewById(R.id.check_edit_suma_sp_especifique);
        esp4 = (EditText) lyt4.findViewById(R.id.check_edit_suma_sp_especifique);
        esp5 = (EditText) lyt5.findViewById(R.id.check_edit_suma_sp_especifique);
        esp6 = (EditText) lyt6.findViewById(R.id.check_edit_suma_sp_especifique);
        esp7 = (EditText) lyt7.findViewById(R.id.check_edit_suma_sp_especifique);
        esp8 = (EditText) lyt8.findViewById(R.id.check_edit_suma_sp_especifique);
        esp9 = (EditText) lyt9.findViewById(R.id.check_edit_suma_sp_especifique);
        esp10 = (EditText) lyt10.findViewById(R.id.check_edit_suma_sp_especifique);


        edt1 = (EditText) lyt1.findViewById(R.id.check_edit_suma_sp_edit);
        edt2 = (EditText) lyt2.findViewById(R.id.check_edit_suma_sp_edit);
        edt3 = (EditText) lyt3.findViewById(R.id.check_edit_suma_sp_edit);
        edt4 = (EditText) lyt4.findViewById(R.id.check_edit_suma_sp_edit);
        edt5 = (EditText) lyt5.findViewById(R.id.check_edit_suma_sp_edit);
        edt6 = (EditText) lyt6.findViewById(R.id.check_edit_suma_sp_edit);
        edt7 = (EditText) lyt7.findViewById(R.id.check_edit_suma_sp_edit);
        edt8 = (EditText) lyt8.findViewById(R.id.check_edit_suma_sp_edit);
        edt9 = (EditText) lyt9.findViewById(R.id.check_edit_suma_sp_edit);
        edt10 = (EditText) lyt10.findViewById(R.id.check_edit_suma_sp_edit);

        txtSumaTotal = (TextView) rootView.findViewById(R.id.checkeditsuma_cantidadTotal);


        linearLayouts = new LinearLayout[]{lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10};
        editTexts = new EditText[]{edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10};
        editEspecifiques = new EditText[]{esp1,esp2,esp3,esp4,esp5,esp6,esp7,esp8,esp9,esp10};
        checkBoxes =  new CheckBox[]{ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10};
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        llenarVista();
        cargarDatos();
    }

    @Override
    public void inhabilitar() {
        for (int i = 0; i <subpreguntas.size() ; i++) editTexts[i].setText("");
        rootView.setVisibility(View.GONE);
    }

    @Override
    public void habilitar() {
        rootView.setVisibility(View.VISIBLE);
    }

    @Override
    public void guardarDatos() {
        DataTablas data = new DataTablas(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < subpreguntas.size(); i++) {
            if(editTexts[i].isEnabled()){
                String variable = subpreguntas.get(i).getVARIABLE();
                String valor = editTexts[i].getText().toString();
                contentValues.put(variable, valor);
                if(subpreguntas.get(i).getVARESP() != null){
                    contentValues.put(subpreguntas.get(i).getVARESP(),editEspecifiques[i].getText().toString());
                }
            }
        }
        contentValues.put(pCheckEditSuma.getVALSUMA(),txtSumaTotal.getText().toString());
        if(!data.existenDatos(getIdTabla(),idEmpresa)){
            contentValues.put("ID_EMPRESA",idEmpresa);
            data.insertarValores(getIdTabla(),contentValues);
        }else data.actualizarValores(getIdTabla(),idEmpresa,contentValues);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        boolean correcto = true;
        String mensaje = "";
        if(estaHabilitado()){
            int c = 0;
            while(correcto && c < subpreguntas.size()){
                if(linearLayouts[c].getVisibility() == View.VISIBLE){
                    if(checkBoxes[c].isChecked()){
                        if(editTexts[c].getText().toString().trim().equals("")){
                            correcto = false;
                            mensaje = "PREGUNTA " + pCheckEditSuma.getNUMERO() + ": COMPLETE LA PREGUNTA";
                        }else if(subpreguntas.get(c).getVARESP() != null){
                            if (editEspecifiques[c].getText().toString().trim().equals("")){
                                correcto = false;
                                mensaje = "PREGUNTA " + pCheckEditSuma.getNUMERO() + ": ESPECIFIQUE LA INFORMACION SOLICITADA";
                            }
                        }
                    }
                }
                c++;
            }
            if (txtSumaTotal.getText().toString().equals("0")){
                correcto = false;
                mensaje = "PREGUNTA " + pCheckEditSuma.getNUMERO() + ": DEBE SELECCIONAR UNA O MAS OPCIONES";
            }
        }
        if(!correcto) mostrarMensaje(mensaje);
        return correcto;
    }

    @Override
    public boolean estaHabilitado() {
        return (rootView.getVisibility() == View.VISIBLE);
    }

    @Override
    public String getIdTabla() {
        return pCheckEditSuma.getMODULO();
    }

    @Override
    public void cargarDatos() {
        Data d = new Data(context);
        d.open();
        if(d.getNumeroControladores(idEmpresa,pCheckEditSuma .getID()) == 0){
            cargandoDatos = true;
            DataTablas data = new DataTablas(context);
            data.open();
            if(data.existenDatos(getIdTabla(),idEmpresa)){
                for (int i = 0; i < subpreguntas.size() ; i++) {
                    String variable = subpreguntas.get(i).getVARIABLE();
                    String valor = data.getValor(getIdTabla(),variable,idEmpresa);
                    if(valor != null) editTexts[i].setText(valor);
                    if(subpreguntas.get(i).getVARESP() != null){
                        String var = subpreguntas.get(i).getVARESP();
                        String val = data.getValor(getIdTabla(),variable,idEmpresa);
                        if(valor != null) editEspecifiques[i].setText(valor);
                    }
                }
            }
            data.close();
            cargandoDatos = false;
        }else{
            inhabilitar();
        }
    }

    @Override
    public void llenarVista() {
        txtPregunta.setText(pCheckEditSuma.getNUMERO() + ". " + pCheckEditSuma.getPREGUNTA().toUpperCase());
        txtCabeceraPregunta.setText(pCheckEditSuma.getCABPREG());
        txtCabeceraRespuesta.setText(pCheckEditSuma.getCABRES());

        for (int i = 0; i < subpreguntas.size(); i++) {
            final SPCheckEditSuma spCheckEditSuma = subpreguntas.get(i);
            final LinearLayout linearLayout = linearLayouts[i];
            final EditText editText = editTexts[i];
            final CheckBox checkBox = checkBoxes[i];
            final EditText editEspecifique =  editEspecifiques[i];

            linearLayout.setVisibility(View.VISIBLE);
            checkBox.setText(spCheckEditSuma.getSUBPREGUNTA());
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.parseInt(spCheckEditSuma.getLONGITUD()))});

            if (spCheckEditSuma.getVARESP() != null){
                editEspecifique.setVisibility(View.VISIBLE);
                editEspecifique.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            }


            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        editText.setEnabled(true);
                        editText.setBackgroundResource(R.drawable.edittext_enabled);
                        if (spCheckEditSuma.getVARESP() != null){
                            editEspecifique.setEnabled(true);
                            editEspecifique.setBackgroundResource(R.drawable.edittext_enabled);
                        }
                    }else{
                        editText.setText("");
                        editText.setEnabled(false);
                        editText.setBackgroundResource(R.drawable.edittext_disabled);
                        if (spCheckEditSuma.getVARESP() != null){
                            editEspecifique.setText("");
                            editEspecifique.setEnabled(false);
                            editEspecifique.setBackgroundResource(R.drawable.edittext_disabled);
                        }
                    }
                }
            });

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        ocultarTeclado(editText);
                        linearLayout.requestFocus();
                        return true;
                    }
                    return false;
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if(!charSequence.toString().equals("")){
                        txtSumaTotal.setText((Integer.parseInt(txtSumaTotal.getText().toString()) - Integer.parseInt(charSequence.toString()))+"");
                    }
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                    int despues = 0;
                    if(!editable.toString().equals("")) despues = Integer.parseInt(editable.toString());
                    if(!(Integer.parseInt(txtSumaTotal.getText().toString())== 0)){
                        txtSumaTotal.setText((Integer.parseInt(txtSumaTotal.getText().toString()) + despues) + "");
                    }else{
                        txtSumaTotal.setText(despues + "");
                    }
                }
            });
        }
    }

    public void ocultarTeclado(View view){
        InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void mostrarMensaje(String m){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(m);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
