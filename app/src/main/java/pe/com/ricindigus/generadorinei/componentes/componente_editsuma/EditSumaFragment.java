package pe.com.ricindigus.generadorinei.componentes.componente_editsuma;


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
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.PEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_editsuma.pojos.SPEditSuma;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoInput;
import pe.com.ricindigus.generadorinei.fragments.ComponenteFragment;
import pe.com.ricindigus.generadorinei.modelo.DataSourceCaptura.Data;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditSumaFragment extends ComponenteFragment {
    private PEditSuma pEditSuma;
    private ArrayList<SPEditSuma> subpreguntas;
    private Context context;
    private String idEmpresa;

    private TextView txtCabeceraPregunta, txtCabeceraRespuesta, txtPregunta, txtSumaTotal;
    private TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10;
    private EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10;
    private CardView cv1, cv2,cv3,cv4,cv5,cv6, cv7, cv8, cv9, cv10;

    private CardView[] cardViews;
    private EditText[] editTexts;
    private TextView[] textViews;
    private View rootView;

    private boolean cargandoDatos = false;

    public EditSumaFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public EditSumaFragment(PEditSuma pEditSuma, ArrayList<SPEditSuma> subpreguntas, Context context, String idEmpresa) {
        this.pEditSuma = pEditSuma;
        this.subpreguntas = subpreguntas;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_edit_suma, container, false);

        txtPregunta = (TextView) rootView.findViewById(R.id.editsuma_pregunta);
        txtCabeceraPregunta = (TextView) rootView.findViewById(R.id.editsuma_cabecera_pregunta);
        txtCabeceraRespuesta = (TextView) rootView.findViewById(R.id.editsuma_cabecera_respuesta);

        cv1 = (CardView) rootView.findViewById(R.id.editsuma_sp1);
        cv2 = (CardView) rootView.findViewById(R.id.editsuma_sp2);
        cv3 = (CardView) rootView.findViewById(R.id.editsuma_sp3);
        cv4 = (CardView) rootView.findViewById(R.id.editsuma_sp4);
        cv5 = (CardView) rootView.findViewById(R.id.editsuma_sp5);
        cv6 = (CardView) rootView.findViewById(R.id.editsuma_sp6);
        cv7 = (CardView) rootView.findViewById(R.id.editsuma_sp7);
        cv8 = (CardView) rootView.findViewById(R.id.editsuma_sp8);
        cv9 = (CardView) rootView.findViewById(R.id.editsuma_sp9);
        cv10 = (CardView) rootView.findViewById(R.id.editsuma_sp10);

        edt1 = (EditText) cv1.findViewById(R.id.edit_suma_sp_edit);
        edt2 = (EditText) cv2.findViewById(R.id.edit_suma_sp_edit);
        edt3 = (EditText) cv3.findViewById(R.id.edit_suma_sp_edit);
        edt4 = (EditText) cv4.findViewById(R.id.edit_suma_sp_edit);
        edt5 = (EditText) cv5.findViewById(R.id.edit_suma_sp_edit);
        edt6 = (EditText) cv6.findViewById(R.id.edit_suma_sp_edit);
        edt7 = (EditText) cv7.findViewById(R.id.edit_suma_sp_edit);
        edt8 = (EditText) cv8.findViewById(R.id.edit_suma_sp_edit);
        edt9 = (EditText) cv9.findViewById(R.id.edit_suma_sp_edit);
        edt10 = (EditText) cv10.findViewById(R.id.edit_suma_sp_edit);

        txtSumaTotal = (TextView) rootView.findViewById(R.id.editsuma_cantidadTotal);


        txt1 = (TextView) cv1.findViewById(R.id.edit_suma_sp_text);
        txt2 = (TextView) cv2.findViewById(R.id.edit_suma_sp_text);
        txt3 = (TextView) cv3.findViewById(R.id.edit_suma_sp_text);
        txt4 = (TextView) cv4.findViewById(R.id.edit_suma_sp_text);
        txt5 = (TextView) cv5.findViewById(R.id.edit_suma_sp_text);
        txt6 = (TextView) cv6.findViewById(R.id.edit_suma_sp_text);
        txt7 = (TextView) cv7.findViewById(R.id.edit_suma_sp_text);
        txt8 = (TextView) cv8.findViewById(R.id.edit_suma_sp_text);
        txt9 = (TextView) cv9.findViewById(R.id.edit_suma_sp_text);
        txt10 = (TextView) cv10.findViewById(R.id.edit_suma_sp_text);



        cardViews = new CardView[]{cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9,cv10};
        editTexts = new EditText[]{edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10};
        textViews =  new TextView[]{txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10};
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
            String variable = subpreguntas.get(i).getVARIABLE();
            String valor = editTexts[i].getText().toString();
            contentValues.put(variable, valor);
        }
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
                if(cardViews[c].getVisibility() == View.VISIBLE){
                    if(editTexts[c].getText().toString().trim().equals("")){
                        correcto = false;
                        mensaje = "PREGUNTA " + pEditSuma.getNUMERO() + ": COMPLETE LA PREGUNTA";
                    }
                }
                c++;
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
        return pEditSuma.getMODULO();
    }

    @Override
    public void cargarDatos() {
        Data d = new Data(context);
        d.open();
        if(d.getNumeroControladores(idEmpresa,pEditSuma .getID()) == 0){
            cargandoDatos = true;
            DataTablas data = new DataTablas(context);
            data.open();
            if(data.existenDatos(getIdTabla(),idEmpresa)){
                String[] variables = new String[subpreguntas.size()];
                for (int i = 0; i < subpreguntas.size() ; i++) variables[i] = subpreguntas.get(i).getVARIABLE();
                String[] valores = data.getValores(getIdTabla(),variables,idEmpresa);
                for (int i = 0; i < valores.length; i++) {if(valores[i] != null) editTexts[i].setText(valores[i]);}
            }
            data.close();
            cargandoDatos = false;
        }else{
            inhabilitar();
        }
    }

    @Override
    public void llenarVista() {
        txtPregunta.setText(pEditSuma.getNUMERO() + ". " + pEditSuma.getPREGUNTA().toUpperCase());
        txtCabeceraPregunta.setText(pEditSuma.getCABPREG());
        txtCabeceraRespuesta.setText(pEditSuma.getCABRES());

        for (int i = 0; i < subpreguntas.size(); i++) {
            SPEditSuma spEditSuma = subpreguntas.get(i);
            final CardView cardView = cardViews[i];
            final EditText editText = editTexts[i];
            final TextView textView = textViews[i];

            cardView.setVisibility(View.VISIBLE);
            textView.setText(spEditSuma.getSUBPREGUNTA());
            editText.setTransformationMethod(new NumericKeyBoardTransformationMethod());
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.parseInt(spEditSuma.getLONGITUD()))});

            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        ocultarTeclado(editText);
                        cardView.requestFocus();
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
