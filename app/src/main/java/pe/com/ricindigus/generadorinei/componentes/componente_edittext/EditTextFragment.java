package pe.com.ricindigus.generadorinei.componentes.componente_edittext;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import pe.com.ricindigus.generadorinei.NumericKeyBoardTransformationMethod;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.PEditText;
import pe.com.ricindigus.generadorinei.componentes.componente_edittext.pojos.SPEditText;
import pe.com.ricindigus.generadorinei.constantesglobales.TipoInput;
import pe.com.ricindigus.generadorinei.modelo.DataSourceComponentes.DataComponentes;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditTextFragment extends Fragment {
    private DataComponentes dataComponentes;
    private PEditText pEditText;
    private ArrayList<SPEditText> subpreguntas;
    private Context context;
    private String idEmpresa;
    private String idEditText;
    private TextView txtPregunta;
    private TextInputLayout edtLyt1,edtLyt2,edtLyt3;
    private TextInputEditText edtSP1,edtSP2,edtSP3;
    private CardView editTextCardView;
    private View rootView;

    private TextInputLayout[] textInputLayouts;
    private TextInputEditText[] textInputEditTexts;


    public EditTextFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public EditTextFragment(PEditText pEditText, ArrayList<SPEditText> subpreguntas, Context context, String idEmpresa) {
        this.pEditText = pEditText;
        this.subpreguntas = subpreguntas;
        this.context = context;
        this.idEmpresa = idEmpresa;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_edit_text, container, false);
        txtPregunta = rootView.findViewById(R.id.edittext_pregunta);
        edtLyt1 = (TextInputLayout) rootView.findViewById(R.id.edittext_sp1);
        edtLyt2 = (TextInputLayout) rootView.findViewById(R.id.edittext_sp2);
        edtLyt3 = (TextInputLayout) rootView.findViewById(R.id.edittext_sp3);
        edtSP1 = (TextInputEditText) edtLyt1.findViewById(R.id.edit_text_input);
        edtSP2 = (TextInputEditText) edtLyt2.findViewById(R.id.edit_text_input);
        edtSP3 = (TextInputEditText) edtLyt3.findViewById(R.id.edit_text_input);
        textInputLayouts = new TextInputLayout[]{edtLyt1,edtLyt2,edtLyt3};
        textInputEditTexts = new TextInputEditText[]{edtSP1,edtSP2,edtSP3};
        llenarVista();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cargarDatos();
    }

    public void llenarVista(){
        txtPregunta.setText(pEditText.getNUMERO() + ". " + pEditText.getPREGUNTA().toUpperCase());
        for (int i = 0; i < subpreguntas.size(); i++) {
            SPEditText spEditText = subpreguntas.get(i);
            textInputLayouts[i].setVisibility(View.VISIBLE);
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
        DataTablas data = new DataTablas(context);
        data.open();
        if(data.existenDatos(getNumModulo(),idEmpresa)){
            String[] variables = new String[subpreguntas.size()];
            for (int i = 0; i < subpreguntas.size() ; i++) variables[i] = subpreguntas.get(i).getVARIABLE();
            String[] valores = data.getValores(getNumModulo(),variables,idEmpresa);
            for (int i = 0; i < valores.length; i++) {if(valores[i] == null) textInputEditTexts[i].setText(valores[i]);}
        }
        data.close();
    }

    public void guardarDatos(){
        DataTablas data = new DataTablas(context);
        data.open();
        ContentValues contentValues = new ContentValues();
        if(data.existenDatos(getNumModulo(),idEmpresa)){
            //insertar
            for (int i = 0; i < subpreguntas.size(); i++) {
                String variable = subpreguntas.get(i).getVARIABLE();
                String valor = textInputEditTexts[i].getText().toString();
                contentValues.put(variable, valor);
            }
            data.insertarValores(Integer.parseInt(pEditText.getMODULO()),contentValues);
        }else{
            //actualizar
            for (int i = 0; i < subpreguntas.size(); i++) {
                String variable = subpreguntas.get(i).getVARIABLE();
                String valor = textInputEditTexts[i].getText().toString();
                contentValues.put(variable, valor);
            }
            data.actualizarValores(getNumModulo(),idEmpresa,contentValues);
        }
        data.close();
    }

    public boolean validarDatos(){
        boolean correcto = true;
        String mensaje = "";
        int c = 0;
        while(correcto && c < textInputLayouts.length){
            if(textInputLayouts[c].getVisibility() == View.VISIBLE){
//                String texto = textInputEditTexts[c].getText().toString();
//                String resul = textInputEditTexts[c].getText().toString().trim();
                if(textInputEditTexts[c].getText().toString().trim().equals("")){
                    correcto = false;
                    mensaje = "PREGUNTA " + pEditText.getNUMERO() + ": COMPLETE LA PREGUNTA";
                }
            }
            c++;
        }
        if(!correcto) mostrarMensaje(mensaje);
        return correcto;
    }

    public void inhabilitar(){
        rootView.setVisibility(View.GONE);
    }

    public boolean estaHabilitado(){
        boolean habilitado = false;
        if(rootView.getVisibility() == View.VISIBLE) habilitado = true;
        return habilitado;
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

    public int getNumModulo(){
        return Integer.parseInt(pEditText.getMODULO());
    }
}
