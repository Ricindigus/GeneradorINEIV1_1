package pe.com.ricindigus.generadorinei.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.InputFilter;
import android.view.View;
import android.widget.Toast;
import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.interfaces.InterfaceModulo;
import pe.com.ricindigus.generadorinei.pojos.Modulo;

/**
 * Created by DMORALES on 09/03/2018.
 */

public class DialogModulo extends DialogFragment{
    public static DialogModulo newInstance(String title, int cantidad) {
        DialogModulo frag = new DialogModulo();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("cantidad",cantidad);
        frag.setArguments(args);
        return frag;
    }

    public static DialogModulo newInstance(String title, Modulo modulo) {
        DialogModulo frag = new DialogModulo();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("id",modulo.getID());
        args.putString("titulo",modulo.getTITULO());
        args.putString("cabecera",modulo.getCABECERA());
        args.putString("ntabla",modulo.getNTABLA());
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String title = getArguments().getString("title");


        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_modulo, null);
        final TextInputEditText inputId =  (TextInputEditText) dialogView.findViewById(R.id.moduloId);
        final TextInputEditText inputTitulo =  (TextInputEditText) dialogView.findViewById(R.id.moduloTitulo);
        final TextInputEditText inputCabecera =  (TextInputEditText) dialogView.findViewById(R.id.moduloCabecera);
        final TextInputEditText inputTabla =  (TextInputEditText) dialogView.findViewById(R.id.moduloTabla);

        inputId.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        inputTitulo.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        inputCabecera.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        inputTabla.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        if(title.equals("EDITAR MODULO")){
            inputId.setText(getArguments().getString("id"));
            inputTitulo.setText(getArguments().getString("titulo"));
            inputCabecera.setText(getArguments().getString("cabecera"));
            inputTabla.setText(getArguments().getString("ntabla"));
        }


        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setView(dialogView)
                .setPositiveButton("ACEPTAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                InterfaceModulo interfaceModulo = (InterfaceModulo)getActivity().getSupportFragmentManager().findFragmentByTag("modulos");
                                if(title.equals("EDITAR MODULO")){
                                    interfaceModulo.editarModulo(new Modulo(
                                            inputId.getText().toString(),
                                            inputTitulo.getText().toString(),
                                            inputCabecera.getText().toString(),
                                            inputTabla.getText().toString()
                                    ));
                                }else{
                                    interfaceModulo.agregarModulo(new Modulo(
                                            getArguments().getInt("cantidad")+"",
                                            inputTitulo.getText().toString(),
                                            inputCabecera.getText().toString(),
                                            inputTabla.getText().toString()
                                    ));
                                }

                            }
                        }
                )
                .setNegativeButton("CANCELAR",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity().getApplicationContext(), "CANCELAR", Toast.LENGTH_SHORT).show();
                            }
                        }
                )
                .create();
    }
}
