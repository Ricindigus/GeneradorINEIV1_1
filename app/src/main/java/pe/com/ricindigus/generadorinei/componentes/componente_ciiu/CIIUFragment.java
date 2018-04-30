package pe.com.ricindigus.generadorinei.componentes.componente_ciiu;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.PCiiu;
import pe.com.ricindigus.generadorinei.componentes.componente_ciiu.pojos.SPCiiu;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class CIIUFragment extends ComponenteFragment {

    private Context context;
    private PCiiu pCiiu;
    private ArrayList<SPCiiu> spCiius;
    private String idEmpresa;

    private TextView txtPregunta;
    private LinearLayout lyt1,lyt2,lyt3,lyt4;
    private EditText edtAct1,edtAct2,edtAct3,edtAct4;
    private TextView txtSp1,txtSp2,txtSp3,txtSp4;
    private TextView txtCiiu1,txtCiiu2,txtCiiu3,txtCiiu4;
    private AutoCompleteTextView autoBuscadorCiiu1,autoBuscadorCiiu2,autoBuscadorCiiu3,autoBuscadorCiiu4;
    private CheckBox ck1,ck2,ck3,ck4;

    private LinearLayout[] linearLayouts;
    private EditText[] editTexts;
    private TextView[] textViewSps;
    private TextView[] textViewCiius;
    private AutoCompleteTextView[] autoCompleteTextViews;
    private CheckBox[] checkBoxes;
    private boolean cargandoDatos = false;
    View rootView;

    public CIIUFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CIIUFragment( PCiiu pCiiu, ArrayList<SPCiiu> spCiius, Context context,String idEmpresa) {
        this.context = context;
        this.pCiiu = pCiiu;
        this.spCiius = spCiius;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_ciiu, container, false);
        txtPregunta =  (TextView) rootView.findViewById(R.id.ciiu_pregunta);
        lyt1 = (LinearLayout) rootView.findViewById(R.id.ciiu_sp1);
        lyt2 = (LinearLayout) rootView.findViewById(R.id.ciiu_sp2);
        lyt3 = (LinearLayout) rootView.findViewById(R.id.ciiu_sp3);
        lyt4 = (LinearLayout) rootView.findViewById(R.id.ciiu_sp4);

        edtAct1 = (EditText) lyt1.findViewById(R.id.ciiu_edt);
        edtAct2 = (EditText) lyt2.findViewById(R.id.ciiu_edt);
        edtAct3 = (EditText) lyt3.findViewById(R.id.ciiu_edt);
        edtAct4 = (EditText) lyt4.findViewById(R.id.ciiu_edt);

        txtSp1 = (TextView) lyt1.findViewById(R.id.ciiu_txtSubpregunta);
        txtSp2 = (TextView) lyt2.findViewById(R.id.ciiu_txtSubpregunta);
        txtSp3 = (TextView) lyt3.findViewById(R.id.ciiu_txtSubpregunta);
        txtSp4 = (TextView) lyt4.findViewById(R.id.ciiu_txtSubpregunta);

        txtCiiu1 = (TextView) lyt1.findViewById(R.id.ciiu_ciiu);
        txtCiiu2 = (TextView) lyt2.findViewById(R.id.ciiu_ciiu);
        txtCiiu3 = (TextView) lyt3.findViewById(R.id.ciiu_ciiu);
        txtCiiu4 = (TextView) lyt4.findViewById(R.id.ciiu_ciiu);

        autoBuscadorCiiu1 = (AutoCompleteTextView) lyt1.findViewById(R.id.ciiu_autocomplete);
        autoBuscadorCiiu2 = (AutoCompleteTextView) lyt2.findViewById(R.id.ciiu_autocomplete);
        autoBuscadorCiiu3 = (AutoCompleteTextView) lyt3.findViewById(R.id.ciiu_autocomplete);
        autoBuscadorCiiu4 = (AutoCompleteTextView) lyt4.findViewById(R.id.ciiu_autocomplete);

        ck1 = (CheckBox) lyt1.findViewById(R.id.ciiu_check);
        ck2 = (CheckBox) lyt2.findViewById(R.id.ciiu_check);
        ck3 = (CheckBox) lyt3.findViewById(R.id.ciiu_check);
        ck4 = (CheckBox) lyt4.findViewById(R.id.ciiu_check);


        linearLayouts = new LinearLayout[]{lyt1, lyt2, lyt3, lyt4};
        editTexts = new EditText[]{edtAct1, edtAct2, edtAct3, edtAct4};
        textViewSps = new TextView[]{txtSp1,txtSp2,txtSp3,txtSp4};
        textViewCiius = new TextView[]{txtCiiu1, txtCiiu2, txtCiiu3, txtCiiu4};
        autoCompleteTextViews =  new AutoCompleteTextView[]{autoBuscadorCiiu1, autoBuscadorCiiu2, autoBuscadorCiiu3, autoBuscadorCiiu4};
        checkBoxes = new CheckBox[]{ck1,ck2,ck3,ck4};
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
        for (int i = 0; i <spCiius.size() ; i++) {
            editTexts[i].setText("");
            autoCompleteTextViews[i].setText("");
            textViewCiius[i].setText("");
            if(checkBoxes[i].getVisibility() == View.VISIBLE){checkBoxes[i].setChecked(false);}
        }
        rootView.setVisibility(View.GONE);
    }

    @Override
    public void habilitar() {
        rootView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean estaHabilitado() {
        return (rootView.getVisibility() == View.VISIBLE);
    }

    @Override
    public String getIdTabla() {
        return pCiiu.getMODULO();
    }

    @Override
    public void cargarDatos() {
        Data d = new Data(context);
        d.open();
        if(d.getNumeroControladores(idEmpresa,pCiiu.getID()) == 0){
            cargandoDatos = true;
            DataTablas data = new DataTablas(context);
            data.open();
            if(data.existenDatos(getIdTabla(),idEmpresa)){
                for (int i = 0; i < spCiius.size() ; i++){
                    SPCiiu sp = spCiius.get(i);
                    editTexts[i].setText(data.getValor(getIdTabla(),sp.getVARACT(),idEmpresa));
                    String codigoCiiu =  data.getValor(getIdTabla(),sp.getVARCIIU(),idEmpresa);
                    textViewCiius[i].setText(codigoCiiu);
                    autoCompleteTextViews[i].setText(d.getDescripcionCiiu(codigoCiiu));
                    if(!sp.getVARCK().equals("")){
                        if (data.getValor(getIdTabla(),sp.getVARCK(),idEmpresa).equals("1")) checkBoxes[i].setChecked(true);
                    }
                }
            }
            data.close();
            cargandoDatos = false;
        }else{
            inhabilitar();
        }
        d.close();
    }

    @Override
    public void guardarDatos() {
        DataTablas data = new DataTablas(context);
        data.open();
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < spCiius.size(); i++) {

            String varAct = spCiius.get(i).getVARACT();
            String varCiiu = spCiius.get(i).getVARCIIU();
            String varCk = spCiius.get(i).getVARCK();

            if (linearLayouts[i].getVisibility() == View.VISIBLE){
                contentValues.put(varAct, editTexts[i].getText().toString());
                contentValues.put(varCiiu, textViewCiius[i].getText().toString());
                if(!varCk.equals("")){
                    if(checkBoxes[i].isChecked())contentValues.put(varCk,"1");
                    else contentValues.put(varCk,"0");
                }
            }else{
                contentValues.put(varAct, "");
                contentValues.put(varCiiu, "");
                contentValues.put(varCk, "");
            }
        }

        if(!data.existenDatos(getIdTabla(),idEmpresa)){
            //insertar
            contentValues.put("ID_EMPRESA",idEmpresa);
            data.insertarValores(getIdTabla(),contentValues);
        }else data.actualizarValores(getIdTabla(),idEmpresa,contentValues);
        data.close();
    }

    @Override
    public boolean validarDatos() {
        boolean valido = true;
        String mensaje = "";
        int i = 0;
        while(valido && i < spCiius.size()) {
            final LinearLayout linearLayout = linearLayouts[i];
            TextView textViewSp = textViewSps[i];
            final TextView textViewCiiu = textViewCiius[i];
            final EditText editText = editTexts[i];
            final AutoCompleteTextView autoCompleteTextView = autoCompleteTextViews[i];
            CheckBox checkBox = checkBoxes[i];
            if(linearLayout.getVisibility() == View.VISIBLE){
                if (checkBox.getVisibility() == View.VISIBLE ){
                    if(!checkBox.isChecked()){
                        if(editText.getText().toString().trim().equals("")){
                            valido = false;
                            mostrarMensaje("PREGUNTA " + pCiiu.getID() + ": " + "DEBE INDICAR " + spCiius.get(i).getSUBPREGUNTA().toUpperCase());
                        }else{
                            if(textViewCiiu.getText().toString().equals("")){
                                valido = false;
                                mostrarMensaje("PREGUNTA " + pCiiu.getID() + ": " + "DEBE INDICAR EL CIIU DE "+ spCiius.get(i).getSUBPREGUNTA().toUpperCase());
                            }
                        }
                    }
                }else{
                    if(editText.getText().toString().trim().equals("")){
                        valido = false;
                        mostrarMensaje("PREGUNTA " + pCiiu.getID() + ": " + "DEBE INDICAR " + spCiius.get(i).getSUBPREGUNTA().toUpperCase());
                    }else if(textViewCiiu.getText().toString().trim().equals("")){
                        valido = false;
                        mostrarMensaje("PREGUNTA " + pCiiu.getID() + ": " + "DEBE INDICAR EL CIIU DE "+ spCiius.get(i).getSUBPREGUNTA().toUpperCase());
                    }
                }
            }
            i++;
        }
        return valido;
    }

    @Override
    public void llenarVista() {
        txtPregunta.setText(pCiiu.getNUMERO() + "." + pCiiu.getPREGUNTA().toUpperCase());
        for (int i = 0; i < spCiius.size(); i++) {
            Data data = new Data(context);
            data.open();
            SPCiiu subpregunta = spCiius.get(i);
            final LinearLayout linearLayout = linearLayouts[i];
            TextView textViewSp = textViewSps[i];
            final TextView textViewCiiu = textViewCiius[i];
            final EditText editText = editTexts[i];
            final AutoCompleteTextView autoCompleteTextView = autoCompleteTextViews[i];
            CheckBox checkBox = checkBoxes[i];

            linearLayout.setVisibility(View.VISIBLE);
            textViewSp.setText(subpregunta.getSUBPREGUNTA());
            ArrayList<String> ciuus = data.getCiius();
            ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),R.layout.lista_item,R.id.item,ciuus);
            autoCompleteTextView.setAdapter(adapter);

            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            autoCompleteTextView.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

            final int contador = i + 1;
            if (!subpregunta.getVARCK().equals("")){
                checkBox.setVisibility(View.VISIBLE);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            editText.setText("");
                            textViewCiiu.setText("");
                            autoCompleteTextView.setText("");

                            editText.setEnabled(false);
                            autoCompleteTextView.setEnabled(false);

                            editText.setBackgroundResource(R.drawable.edittext_disabled);
                            textViewCiiu.setBackgroundResource(R.drawable.edittext_disabled);
                            autoCompleteTextView.setBackgroundResource(R.drawable.edittext_disabled);
                            for (int j = contador; j <spCiius.size() ; j++) {
                                editTexts[j].setText("");
                                textViewCiius[j].setText("");
                                autoCompleteTextViews[j].setText("");

                                linearLayouts[j].setVisibility(View.GONE);
                            }
                        }else{
                            editText.setEnabled(true);
                            autoCompleteTextView.setEnabled(true);

                            editText.setBackgroundResource(R.drawable.edittext_enabled);
                            textViewCiiu.setBackgroundResource(R.drawable.edittext_enabled);
                            autoCompleteTextView.setBackgroundResource(R.drawable.edittext_enabled);

                            for (int j = contador; j <spCiius.size() ; j++) {
                                linearLayouts[j].setVisibility(View.VISIBLE);
                            }
                        }
                    }
                });
            }

            autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        ocultarTeclado(autoCompleteTextView);
                        linearLayout.requestFocus();
                        return true;
                    }
                    return false;
                }
            });
            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textViewCiiu.setText(extraerCodigo(autoCompleteTextView.getText().toString()));
                    ocultarTeclado(autoCompleteTextView);
                    linearLayout.requestFocus();
                }
            });

            watcherCIUU(editText,textViewCiiu,autoCompleteTextView);
        }
    }
    public String extraerCodigo(String ocupacion){
        int indiceI = ocupacion.indexOf("[");
        int indiceF = ocupacion.indexOf("]");
        ocupacion = ocupacion.substring(indiceI + 1, indiceF);

        return ocupacion;
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

    public void watcherCIUU(final EditText editText, final TextView textView, final AutoCompleteTextView autoCompleteTextView){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")){
                    textView.setText("");
                    autoCompleteTextView.setText("");
                }
            }
        });
    }
}
