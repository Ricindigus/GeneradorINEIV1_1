package pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.PCheckPrioridad;
import pe.com.ricindigus.generadorinei.componentes.componente_checkprioridad.pojos.SPCheckPrioridad;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckPrioridadFragment extends ComponenteFragment {
    private PCheckPrioridad pCheckPrioridad;
    private ArrayList<SPCheckPrioridad> subpreguntas;
    private Context context;
    private String idEmpresa;

    private TextView txtCabecera1, txtCabecera2, txtPregunta;
    private CheckBox ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10;
    private Spinner sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8,sp9,sp10;
    private EditText esp1,esp2,esp3,esp4,esp5,esp6,esp7,esp8,esp9,esp10;
    private LinearLayout lyt1, lyt2,lyt3,lyt4,lyt5,lyt6, lyt7, lyt8, lyt9, lyt10;

    private LinearLayout[] linearLayouts;
    private Spinner[] spinners;
    private EditText[] editEspecifiques;
    private CheckBox[] checkBoxes;
    private View rootView;
    private int prioridades[];
    private int controladorSpinners[];


    private boolean cargandoDatos = false;

    public CheckPrioridadFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CheckPrioridadFragment(PCheckPrioridad pCheckPrioridad, ArrayList<SPCheckPrioridad> subpreguntas, Context context, String idEmpresa) {
        this.pCheckPrioridad = pCheckPrioridad;
        this.subpreguntas = subpreguntas;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_check_prioridad, container, false);

        txtPregunta = (TextView) rootView.findViewById(R.id.checkprioridad_pregunta);
        txtCabecera1 = (TextView) rootView.findViewById(R.id.checkprioridad_cabecera1);
        txtCabecera2 = (TextView) rootView.findViewById(R.id.checkprioridad_cabecera2);

        lyt1 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp1);
        lyt2 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp2);
        lyt3 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp3);
        lyt4 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp4);
        lyt5 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp5);
        lyt6 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp6);
        lyt7 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp7);
        lyt8 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp8);
        lyt9 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp9);
        lyt10 = (LinearLayout) rootView.findViewById(R.id.checkprioridad_sp10);

        ck1 = (CheckBox) lyt1.findViewById(R.id.check_prioridad_sp_ck);
        ck2 = (CheckBox) lyt2.findViewById(R.id.check_prioridad_sp_ck);
        ck3 = (CheckBox) lyt3.findViewById(R.id.check_prioridad_sp_ck);
        ck4 = (CheckBox) lyt4.findViewById(R.id.check_prioridad_sp_ck);
        ck5 = (CheckBox) lyt5.findViewById(R.id.check_prioridad_sp_ck);
        ck6 = (CheckBox) lyt6.findViewById(R.id.check_prioridad_sp_ck);
        ck7 = (CheckBox) lyt7.findViewById(R.id.check_prioridad_sp_ck);
        ck8 = (CheckBox) lyt8.findViewById(R.id.check_prioridad_sp_ck);
        ck9 = (CheckBox) lyt9.findViewById(R.id.check_prioridad_sp_ck);
        ck10 = (CheckBox) lyt10.findViewById(R.id.check_prioridad_sp_ck);

        esp1 = (EditText) lyt1.findViewById(R.id.check_prioridad_sp_especifique);
        esp2 = (EditText) lyt2.findViewById(R.id.check_prioridad_sp_especifique);
        esp3 = (EditText) lyt3.findViewById(R.id.check_prioridad_sp_especifique);
        esp4 = (EditText) lyt4.findViewById(R.id.check_prioridad_sp_especifique);
        esp5 = (EditText) lyt5.findViewById(R.id.check_prioridad_sp_especifique);
        esp6 = (EditText) lyt6.findViewById(R.id.check_prioridad_sp_especifique);
        esp7 = (EditText) lyt7.findViewById(R.id.check_prioridad_sp_especifique);
        esp8 = (EditText) lyt8.findViewById(R.id.check_prioridad_sp_especifique);
        esp9 = (EditText) lyt9.findViewById(R.id.check_prioridad_sp_especifique);
        esp10 = (EditText) lyt10.findViewById(R.id.check_prioridad_sp_especifique);


        sp1 = (Spinner) lyt1.findViewById(R.id.check_prioridad_sp_spinner);
        sp2 = (Spinner) lyt2.findViewById(R.id.check_prioridad_sp_spinner);
        sp3 = (Spinner) lyt3.findViewById(R.id.check_prioridad_sp_spinner);
        sp4 = (Spinner) lyt4.findViewById(R.id.check_prioridad_sp_spinner);
        sp5 = (Spinner) lyt5.findViewById(R.id.check_prioridad_sp_spinner);
        sp6 = (Spinner) lyt6.findViewById(R.id.check_prioridad_sp_spinner);
        sp7 = (Spinner) lyt7.findViewById(R.id.check_prioridad_sp_spinner);
        sp8 = (Spinner) lyt8.findViewById(R.id.check_prioridad_sp_spinner);
        sp9 = (Spinner) lyt9.findViewById(R.id.check_prioridad_sp_spinner);
        sp10 = (Spinner) lyt10.findViewById(R.id.check_prioridad_sp_spinner);

        linearLayouts = new LinearLayout[]{lyt1,lyt2,lyt3,lyt4,lyt5,lyt6,lyt7,lyt8,lyt9,lyt10};
        spinners = new Spinner[]{sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8,sp9,sp10};
        editEspecifiques = new EditText[]{esp1,esp2,esp3,esp4,esp5,esp6,esp7,esp8,esp9,esp10};
        checkBoxes =  new CheckBox[]{ck1,ck2,ck3,ck4,ck5,ck6,ck7,ck8,ck9,ck10};
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prioridades =  new int[Integer.parseInt(pCheckPrioridad.getPRIORIDAD()) + 1];
        controladorSpinners = new int[subpreguntas.size()];
        llenarVista();
        cargarDatos();
    }

    @Override
    public void inhabilitar() {
        for (int i = 0; i <subpreguntas.size() ; i++) checkBoxes[i].setChecked(false);
        rootView.setVisibility(View.GONE);
    }

    @Override
    public void habilitar() {
        rootView.setVisibility(View.VISIBLE);
    }

    @Override
    public void guardarDatos() {
//        DataTablas data = new DataTablas(context);
//        data.open();
//        ContentValues contentValues = new ContentValues();
//        for (int i = 0; i < subpreguntas.size(); i++) {
//            if(editTexts[i].isEnabled()){
//                String variable = subpreguntas.get(i).getVARIABLE();
//                String valor = editTexts[i].getText().toString();
//                contentValues.put(variable, valor);
//                if(subpreguntas.get(i).getVARESP() != null){
//                    contentValues.put(subpreguntas.get(i).getVARESP(),editEspecifiques[i].getText().toString());
//                }
//            }
//        }
//        contentValues.put(pCheckPrioridad.getVALSUMA(),txtSumaTotal.getText().toString());
//        if(!data.existenDatos(getIdTabla(),idEmpresa)){
//            contentValues.put("ID_EMPRESA",idEmpresa);
//            data.insertarValores(getIdTabla(),contentValues);
//        }else data.actualizarValores(getIdTabla(),idEmpresa,contentValues);
//        data.close();
    }

    @Override
    public boolean validarDatos() {
        boolean correcto = true;
//        String mensaje = "";
//        if(estaHabilitado()){
//            int c = 0;
//            while(correcto && c < subpreguntas.size()){
//                if(linearLayouts[c].getVisibility() == View.VISIBLE){
//                    if(checkBoxes[c].isChecked()){
//                        if(editTexts[c].getText().toString().trim().equals("")){
//                            correcto = false;
//                            mensaje = "PREGUNTA " + pCheckPrioridad.getNUMERO() + ": COMPLETE LA PREGUNTA";
//                        }else if(subpreguntas.get(c).getVARESP() != null){
//                            if (editEspecifiques[c].getText().toString().trim().equals("")){
//                                correcto = false;
//                                mensaje = "PREGUNTA " + pCheckPrioridad.getNUMERO() + ": ESPECIFIQUE LA INFORMACION SOLICITADA";
//                            }
//                        }
//                    }
//                }
//                c++;
//            }
//            if (txtSumaTotal.getText().toString().equals("0")){
//                correcto = false;
//                mensaje = "PREGUNTA " + pCheckPrioridad.getNUMERO() + ": DEBE SELECCIONAR UNA O MAS OPCIONES";
//            }
//        }
//        if(!correcto) mostrarMensaje(mensaje);
        return correcto;
    }

    @Override
    public boolean estaHabilitado() {
        return (rootView.getVisibility() == View.VISIBLE);
    }

    @Override
    public String getIdTabla() {
        return pCheckPrioridad.getMODULO();
    }

    @Override
    public void cargarDatos() {
//        Data d = new Data(context);
//        d.open();
//        if(d.getNumeroControladores(idEmpresa, pCheckPrioridad.getID()) == 0){
//            cargandoDatos = true;
//            DataTablas data = new DataTablas(context);
//            data.open();
//            if(data.existenDatos(getIdTabla(),idEmpresa)){
//                for (int i = 0; i < subpreguntas.size() ; i++) {
//                    String variable = subpreguntas.get(i).getVARIABLE();
//                    String valor = data.getValor(getIdTabla(),variable,idEmpresa);
//                    if(valor != null) editTexts[i].setText(valor);
//                    if(subpreguntas.get(i).getVARESP() != null){
//                        String var = subpreguntas.get(i).getVARESP();
//                        String val = data.getValor(getIdTabla(),variable,idEmpresa);
//                        if(valor != null) editEspecifiques[i].setText(valor);
//                    }
//                }
//            }
//            data.close();
//            cargandoDatos = false;
//        }else{
//            inhabilitar();
//        }
    }

    @Override
    public void llenarVista() {
        txtPregunta.setText(pCheckPrioridad.getNUMERO() + ". " + pCheckPrioridad.getPREGUNTA().toUpperCase());
        txtCabecera1.setText(pCheckPrioridad.getCAB1());
        txtCabecera2.setText(pCheckPrioridad.getCAB2());

        for (int i = 0; i < subpreguntas.size(); i++) {
            final int posicionSubpregunta =  i;
            final SPCheckPrioridad spCheckPrioridad = subpreguntas.get(i);
            final LinearLayout linearLayout = linearLayouts[i];
            final Spinner spinner = spinners[i];
            final CheckBox checkBox = checkBoxes[i];
            final EditText editEspecifique =  editEspecifiques[i];

            linearLayout.setVisibility(View.VISIBLE);
            checkBox.setText(spCheckPrioridad.getSUBPREGUNTA());
            if (spCheckPrioridad.getVARSP() != null){
                spinner.setVisibility(View.VISIBLE);
                spinner.setEnabled(false);
            }


            if (spCheckPrioridad.getVARESP() != null){
                editEspecifique.setVisibility(View.VISIBLE);
                editEspecifique.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
            }

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        if (spCheckPrioridad.getVARSP() != null){
                            if(prioridades[0] != Integer.parseInt(pCheckPrioridad.getPRIORIDAD())) spinner.setEnabled(true);
                        }

                        if (spCheckPrioridad.getVARESP() != null){
                            editEspecifique.setEnabled(true);
                            editEspecifique.setBackgroundResource(R.drawable.edittext_enabled);
                        }

                        if(spCheckPrioridad.getDESHAB() != null){
                            for (int j = 0; j <subpreguntas.size() ; j++) {
                                if (j != posicionSubpregunta){
                                    checkBoxes[j].setChecked(false);
                                    checkBoxes[j].setEnabled(false);
                                }
                            }
                        }
                    }else{
                        if (spCheckPrioridad.getVARSP() != null){
                            spinner.setSelection(0);
                            spinner.setEnabled(false);
                        }

                        if (spCheckPrioridad.getVARESP() != null){
                            editEspecifique.setText("");
                            editEspecifique.setEnabled(false);
                            editEspecifique.setBackgroundResource(R.drawable.edittext_disabled);
                        }
                        if(spCheckPrioridad.getDESHAB() != null){
                            for (int j = 0; j <subpreguntas.size() ; j++) {
                                if (j != posicionSubpregunta){
                                    checkBoxes[j].setEnabled(true);
                                }
                            }
                        }
                    }
                }
            });

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int seleccion =  spinner.getSelectedItemPosition();
                    if(seleccion != 0){
                        if (prioridades[seleccion] != 1){
                            if(controladorSpinners[posicionSubpregunta] != 0){
                                int auxPrioridad = controladorSpinners[posicionSubpregunta];
                                prioridades[auxPrioridad] = 0;
                                prioridades[0]--;
                                controladorSpinners[posicionSubpregunta] = 0;
                            }
                            controladorSpinners[posicionSubpregunta] = seleccion;
                            prioridades[seleccion] =  1;
                            prioridades[0] ++;
                            if(prioridades[0] == Integer.parseInt(pCheckPrioridad.getPRIORIDAD())){
                                for (int j = 0; j < subpreguntas.size() ; j++) {
                                    if (spinners[j].getSelectedItemPosition() == 0) spinners[j].setEnabled(false);
                                }
                            }

                        }else{
                            Toast.makeText(context, "No puede existir dos opciones con prioridad " + seleccion, Toast.LENGTH_SHORT).show();
                            spinner.setSelection(0);
                        }
                    }else {
                        if(controladorSpinners[posicionSubpregunta] != 0){
                            int auxPrioridad = controladorSpinners[posicionSubpregunta];
                            prioridades[auxPrioridad] = 0;
                            prioridades[0]--;
                            controladorSpinners[posicionSubpregunta] = 0;
                        }
                        for (int j = 0; j <subpreguntas.size() ; j++) {
                            if (checkBoxes[j].isChecked()) spinners[j].setEnabled(true);
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ArrayList<String> prioridades = new ArrayList<String>();
            prioridades.add("Seleccione");
            for (int j = 1; j <= Integer.parseInt(pCheckPrioridad.getPRIORIDAD()); j++) {
                prioridades.add(j + "");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item,prioridades);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
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
