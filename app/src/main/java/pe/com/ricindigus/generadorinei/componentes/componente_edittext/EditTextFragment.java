package pe.com.ricindigus.generadorinei.componentes.componente_edittext;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
    private TextView txtSP1;
    private TextView txtSP2;
    private TextView txtSP3;
    private EditText edtSP1;
    private EditText edtSP2;
    private EditText edtSP3;


    public EditTextFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public EditTextFragment(Context context, String idEditText) {
        this.context = context;
        this.idEditText = idEditText;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_text, container, false);
        txtPregunta = rootView.findViewById(R.id.edittext_pregunta);

        return rootView;
    }

}
