package pe.com.ricindigus.generadorinei.componentes.componente_visitas;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import pe.com.ricindigus.generadorinei.R;
import pe.com.ricindigus.generadorinei.modelo.DataSourceTablasGuardado.DataTablas;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitasFragment extends Fragment {
    private LinearLayoutManager linearLayoutManager;
    private VisitaAdapter visitaAdapter;
    private RecyclerView recyclerView;

    private FloatingActionButton btnAgregar;

    private TextView txtFechaFinal;
    private TextView txtHorafinal;
    private TextView txtResultadoFinal;

    private Context context;
    private String idEmpresa;
    private Visita visita;
    private DataVisitas dataVisitas;
    private DataTablas dataTablas;

//    private ResultadoEncuesta resultadoEncuesta;

    int diaInicio;
    int mesInicio;
    int anioInicio;

    int horaInicio;
    int minutoInicio;
    int horaFin;
    int minutoFin;

    int diaProx;
    int mesProx;
    int anioProx;

    int horaProx;
    int minutoProx;

    private String RESFIN_ID;
    private String RESFIN_DIA;
    private String RESFIN_MES;
    private String RESFIN_ANIO;
    private String RESFIN_MIN;
    private String RESFIN_HORA;
    private int RESFIN;
    private String RESFIN_O;

    public VisitasFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public VisitasFragment(Context context, String idEmpresa, Visita visita) {
        this.context = context;
        this.idEmpresa = idEmpresa;
        this.visita = visita;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_visitas, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.visita_recycler);
        txtResultadoFinal = (TextView) rootView.findViewById(R.id.visitas_resultado_final);
        txtFechaFinal = (TextView) rootView.findViewById(R.id.visitas_fecha_final);
        txtHorafinal = (TextView) rootView.findViewById(R.id.visitas_hora_final);
        btnAgregar = (FloatingActionButton) rootView.findViewById(R.id.visitas_btnAgregarVisita);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        cargarDatos();
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        try{
            dataTablas = new DataTablas(context);
            dataTablas.open();
            Cursor cursor = dataTablas.getAllTabla(SQLVisitas.tableVisitas);
            if(cursor != null){
                visitaAdapter = new VisitaAdapter(visita, context, cursor, new VisitaAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {
                        String resultadoVisita = dataTablas.getValor(getNumModulo(),visita.getVARRES(),idEmpresa);
                        if(resultadoVisita.equals("")){
                            PopupMenu popupMenu = new PopupMenu(context,view);
                            popupMenu.getMenuInflater().inflate(R.menu.menu_visita,popupMenu.getMenu());
                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem item) {
                                    switch(item.getItemId()){
                                        case R.id.opcion_editar:
//                                            editarVisita(pos);
                                            break;
                                        case R.id.opcion_eliminar:
//                                            eliminarVisita(pos);
                                            break;
                                        case R.id.opcion_finalizar:
//                                            finalizarVisita(pos);
                                            break;
                                    }
                                    return true;
                                }
                            });
                            popupMenu.show();
                        }
                    }
                });
                recyclerView.setAdapter(visitaAdapter);
            }
            dataTablas.close();
        }catch (SQLException e){}



        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int numVisitas = visitas.size();
//                if(numVisitas > 0 ){
//                    if(!visitas.get(numVisitas - 1).getV_RESULTADO().equals("")){
//                        agregarVisita();
//                    }else{
//                        Toast.makeText(context, "DEBE FINALIZAR LA VISITA ACTUAL, ANTES DE AGREGAR UNA NUEVA", Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    agregarVisita();
//                }
            }
        });
    }

//    public void agregarVisita(){
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
//        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
//        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
//        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
//        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);
//
//        txtFechaI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int yy = calendario.get(Calendar.YEAR);
//                int mm = calendario.get(Calendar.MONTH);
//                int dd = calendario.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        diaInicio = dayOfMonth;
//                        mesInicio = monthOfYear + 1;
//                        anioInicio = year;
//                        String fecha = checkDigito(diaInicio) +"/"+checkDigito(mesInicio)
//                                +"/"+checkDigito(anioInicio);
//                        txtFechaI.setText(fecha);
//
//                    }
//                }, yy, mm, dd);
//                datePicker.show();
//            }
//        });
//
//        txtHoraI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int hh = calendario.get(Calendar.HOUR_OF_DAY);
//                int mm = calendario.get(Calendar.MINUTE);
//
//                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
//                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
//                        txtHoraI.setText(hora);
//                        horaInicio = hourofDay;
//                        minutoInicio = minute;
//                    }
//                }, hh, mm,true);
//                timePicker.show();
//            }
//        });
//
//        alert.setTitle("AGREGAR VISITA");
//        alert.setView(dialogView);
//        alert.setPositiveButton("Agregar",null);
//        alert.setNegativeButton("Cancelar",null);
//        final AlertDialog alertDialog = alert.create();
//
//        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                Calendar c = Calendar.getInstance();
//                diaInicio = c.get(Calendar.DAY_OF_MONTH);
//                mesInicio = c.get(Calendar.MONTH) + 1;
//                anioInicio = c.get(Calendar.YEAR);
//                horaInicio = c.get(Calendar.HOUR_OF_DAY);
//                minutoInicio = c.get(Calendar.MINUTE);
//
//                txtNumero.setText(checkDigito((visitaAdapter.getItemCount() + 1)));
//                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
//                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
//                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
//                btnAdd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // TODO Do something
//                        boolean valido =true;
//                        String mensaje = "";
//                        boolean vFechaInicio = true, vHoraInicio = true;
//                        if(visitas.size() > 0){
//                            int y = Integer.parseInt(visitas.get(visitas.size()-1).getV_ANIO());
//                            int m = Integer.parseInt(visitas.get(visitas.size()-1).getV_MES());
//                            int d = Integer.parseInt(visitas.get(visitas.size()-1).getV_DIA());
//
//                            int compHora = Integer.parseInt(visitas.get(visitas.size()-1).getV_HORA());
//                            int compMinuto = Integer.parseInt(visitas.get(visitas.size()-1).getV_MINUTO());
//
//
//                            Date fi1 = new Date(y,m,d);
//                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
//                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
//                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);
//                            if(fi2.before(fi1)){
//                                vFechaInicio = false;
//                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA NUEVA VISITA NO DEBE SER MENOR A LA VISITA ANTERIOR";
//                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
//                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
//                                    vHoraInicio = false;
//                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
//                                }
//                            }
//                        }
//                        valido = vFechaInicio && vHoraInicio;
//                        if(valido){
//                            Visita visita = new Visita();
//                            visita.setID(idEmpresa+String.valueOf(visitaAdapter.getItemCount()+1));
//                            visita.setID_EMPRESA(idEmpresa);
//                            visita.setV_NRO(String.valueOf(visitaAdapter.getItemCount()+1));
//                            visita.setV_DIA(diaInicio+"");
//                            visita.setV_MES(mesInicio+"");
//                            visita.setV_ANIO(anioInicio + "");
//                            visita.setV_HORA(horaInicio +"");
//                            visita.setV_MINUTO(minutoInicio + "");
//                            visitas.add(visita);
//                            data = new Data(context);
//                            data.open();
//                            data.insertarVisita(visita);
//                            data.close();
//                            recyclerView.getAdapter().notifyDataSetChanged();
//                            alertDialog.dismiss();
//                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//        alertDialog.show();
//    }
//
//    public void editarVisita(final int posicion){
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_agregar_visita, null);
//        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_agregar_visita_lyt);
//        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtNumero);
//        final TextView txtFechaI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtFI);
//        final TextView txtHoraI = (TextView) dialogView.findViewById(R.id.dialog_agregar_visita_txtHI);
//
//        txtFechaI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int dd = Integer.parseInt(visitas.get(posicion).getV_DIA());
//                int mm = Integer.parseInt(visitas.get(posicion).getV_MES());
//                int yy = Integer.parseInt(visitas.get(posicion).getV_ANIO());
//
//                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        diaInicio = dayOfMonth;
//                        mesInicio = monthOfYear + 1;
//                        anioInicio = year;
//                        String fecha = checkDigito(diaInicio) +"/"+checkDigito(mesInicio)
//                                +"/"+checkDigito(anioInicio);
//                        txtFechaI.setText(fecha);
//
//                    }
//                }, yy, mm-1, dd);
//                datePicker.show();
//            }
//        });
//
//        txtHoraI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int hh = calendario.get(Calendar.HOUR_OF_DAY);
//                int mm = calendario.get(Calendar.MINUTE);
//
//                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
//                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
//                        txtHoraI.setText(hora);
//                        horaInicio= hourofDay;
//                        minutoInicio = minute;
//                    }
//                }, hh, mm,true);
//                timePicker.show();
//            }
//        });
//
//        alert.setTitle("EDITAR VISITA");
//        alert.setView(dialogView);
//        alert.setPositiveButton("Guardar",null);
//        alert.setNegativeButton("Cancelar",null);
//        final AlertDialog alertDialog = alert.create();
//
//        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                diaInicio = Integer.parseInt(visitas.get(posicion).getV_DIA());
//                mesInicio = Integer.parseInt(visitas.get(posicion).getV_MES());
//                anioInicio = Integer.parseInt(visitas.get(posicion).getV_ANIO());
//                horaInicio = Integer.parseInt(visitas.get(posicion).getV_HORA());
//                minutoInicio = Integer.parseInt(visitas.get(posicion).getV_MINUTO());
//
//                txtNumero.setText(checkDigito(Integer.parseInt(visitas.get(posicion).getV_NRO())));
//                txtFechaI.setText(checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio));
//                txtHoraI.setText(checkDigito(horaInicio) + ":" + checkDigito(minutoInicio));
//                Button btnAdd = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
//                btnAdd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // TODO Do something
//                        boolean valido =true;
//                        String mensaje = "";
//                        boolean vFechaInicio = true, vHoraInicio = true;
//
//                        if(visitas.size() > 1){
//                            int y = Integer.parseInt(visitas.get(posicion-1).getV_ANIO());
//                            int m = Integer.parseInt(visitas.get(posicion-1).getV_MES());
//                            int d = Integer.parseInt(visitas.get(posicion-1).getV_DIA());
//
//                            int compHora = Integer.parseInt(visitas.get(visitas.size()-1).getV_HORA());
//                            int compMinuto = Integer.parseInt(visitas.get(visitas.size()-1).getV_MINUTO());
//
//                            Date fi1 = new Date(y,m,d);
//                            Date fi2 = new Date(anioInicio,mesInicio,diaInicio);
//                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
//                            String sfi2 = checkDigito(diaInicio) + "/" + checkDigito(mesInicio) + "/" + checkDigito(anioInicio);
//
//                            if(fi2.before(fi1)){
//                                vFechaInicio = false;
//                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
//                            }else if(d == diaInicio && m == mesInicio && y == anioInicio){
//                                if((horaInicio*60 + minutoInicio) <= (compHora*60+compMinuto)){
//                                    vHoraInicio = false;
//                                    if(mensaje.equals("")) mensaje = "FECHA: SI LA FECHA ES LA MISMA, LA HORA DE LA NUEVA VISITA NO DEBE SER MENOR O IGUAL A LA VISITA ANTERIOR";
//                                }
//                            }
//                        }
//                        valido = vFechaInicio && vHoraInicio;
//                        if(valido){
//                            visitas.get(posicion).setV_DIA(diaInicio+"");
//                            visitas.get(posicion).setV_MES(mesInicio+"");
//                            visitas.get(posicion).setV_ANIO(anioInicio + "");
//                            visitas.get(posicion).setV_HORA(horaInicio +"");
//                            visitas.get(posicion).setV_MINUTO(minutoInicio + "");
//                            data = new Data(context);
//                            data.open();
//                            data.actualizarVisita(visitas.get(posicion).getID(), visitas.get(posicion).toValues());
//                            data.close();
//                            visitaAdapter.notifyDataSetChanged();
//                            alertDialog.dismiss();
//                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//        alertDialog.show();
//    }
//
//    public void eliminarVisita(final int posicion){
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setMessage("¿Está seguro que desea eliminar la visita? (no podrá revertir el cambio)")
//                .setTitle("Aviso")
//                .setCancelable(false)
//                .setNegativeButton("No",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        })
//                .setPositiveButton("Sí",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                String idVisita = visitas.get(posicion).getID();
//                                visitas.remove(posicion);
//                                data = new Data(context);
//                                data.open();
//                                data.deleteVisita(idVisita);
//                                data.close();
//                                visitaAdapter.notifyDataSetChanged();
//                            }
//                        });
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
//
//    public void finalizarVisita(final int posicion){
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_finalizar_visita, null);
//        final LinearLayout lytDialog = (LinearLayout) dialogView.findViewById(R.id.dialog_finalizar_visita_lyt);
//        final TextView txtNumero = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtNumero);
//        final TextView txtHoraF = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraFin);
//        final Spinner spResultado = (Spinner) dialogView.findViewById(R.id.dialog_finalizar_visita_spResultado);
//        final EditText edtEspecifique = (EditText) dialogView.findViewById(R.id.dialog_finalizar_visita_edtEspecifique);
//        final CheckBox ckProxVisita = (CheckBox) dialogView.findViewById(R.id.dialog_finalizar_visita_ckProximaVisita);
//        final TextView txtFechaProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtFechaProx);
//        final TextView txtHoraProxVisita = (TextView) dialogView.findViewById(R.id.dialog_finalizar_visita_txtHoraProx);
//        String especifique = "";
//
//        txtHoraF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int dia = calendario.get(Calendar.DAY_OF_MONTH);
//                int mes = calendario.get(Calendar.MONTH);
//                int anio = calendario.get(Calendar.YEAR);
//                int hh = calendario.get(Calendar.HOUR_OF_DAY);
//                int mm = calendario.get(Calendar.MINUTE);
//
//                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
//                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
//                        txtHoraF.setText(hora);
//                        horaFin = hourofDay;
//                        minutoFin = minute;
//                    }
//                }, hh, mm,true);
//                timePicker.show();
//            }
//        });
//
//        spResultado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//                if(pos == 4 || pos == 2){
//                    ckProxVisita.setEnabled(true);
//                    ckProxVisita.setChecked(true);
//                }else{
//                    ckProxVisita.setChecked(false);
//                    ckProxVisita.setEnabled(false);
//                }
//                if(pos == 7){
//                    edtEspecifique.setEnabled(true);
//                    edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text);
//                }else{
//                    if(edtEspecifique.isEnabled()){
//                        edtEspecifique.setText("");
//                        edtEspecifique.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
//                        edtEspecifique.setEnabled(false);
//                    }
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {}
//        });
//
//        ckProxVisita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    txtFechaProxVisita.setEnabled(true);
//                    txtHoraProxVisita.setEnabled(true);
//                    txtFechaProxVisita.setClickable(true);
//                    txtHoraProxVisita.setClickable(true);
//                    txtFechaProxVisita.setBackgroundResource(R.drawable.fondo_edit_text);
//                    txtHoraProxVisita.setBackgroundResource(R.drawable.fondo_edit_text);
//                }else{
//                    txtFechaProxVisita.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
//                    txtHoraProxVisita.setBackgroundResource(R.drawable.fondo_edit_text_disabled);
//                    txtFechaProxVisita.setClickable(false);
//                    txtHoraProxVisita.setClickable(false);
//                    txtFechaProxVisita.setEnabled(false);
//                    txtHoraProxVisita.setEnabled(false);
//                }
//            }
//        });
//
//
//
//        txtFechaProxVisita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int yy = calendario.get(Calendar.YEAR);
//                int mm = calendario.get(Calendar.MONTH);
//                int dd = calendario.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        diaProx = dayOfMonth;
//                        mesProx = monthOfYear + 1;
//                        anioProx = year;
//                        String fecha = checkDigito(diaProx) +"/"+checkDigito(mesProx)
//                                +"/"+checkDigito(anioProx);
//                        txtFechaProxVisita.setText(fecha);
//
//                    }
//                }, yy, mm, dd);
//                datePicker.show();
//            }
//        });
//        txtHoraProxVisita.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Calendar calendario = Calendar.getInstance();
//                int hh = calendario.get(Calendar.HOUR_OF_DAY);
//                int mm = calendario.get(Calendar.MINUTE);
//
//                TimePickerDialog timePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker timePicker, int hourofDay, int minute) {
//                        String hora = checkDigito(hourofDay) +":"+checkDigito(minute);
//                        txtHoraProxVisita.setText(hora);
//                        horaProx = hourofDay;
//                        minutoProx = minute;
//                    }
//                }, hh, mm,true);
//                timePicker.show();
//            }
//        });
//
//        alert.setTitle("FINALIZAR VISITA");
//        alert.setView(dialogView);
//        alert.setPositiveButton("Finalizar",null);
//        alert.setNegativeButton("Cancelar",null);
//        final AlertDialog alertDialog = alert.create();
//
//        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
//            @Override
//            public void onShow(DialogInterface dialogInterface) {
//                ocultarTeclado(lytDialog);
//                Calendar c = Calendar.getInstance();
//                diaProx = c.get(Calendar.DAY_OF_MONTH);
//                mesProx = c.get(Calendar.MONTH) + 1;
//                anioProx = c.get(Calendar.YEAR);
//                horaProx = c.get(Calendar.HOUR_OF_DAY);
//                minutoProx = c.get(Calendar.MINUTE);
//                horaFin = horaProx;
//                minutoFin = minutoProx;
//                txtNumero.setText(checkDigito(Integer.parseInt(visitas.get(posicion).getV_NRO())));
//                txtHoraF.setText(checkDigito(horaFin) + ":" + checkDigito(minutoFin));
//                txtFechaProxVisita.setText(checkDigito(diaProx + 1) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx));
//                txtHoraProxVisita.setText(checkDigito(horaProx) + ":" + checkDigito(minutoProx));
//                Button btnFinalizarVisita = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
//                btnFinalizarVisita.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // TODO Do something
//                        boolean valido = false;
//                        boolean vHoraFin = true, vResultado = true, vEspecifique = true, vFechaProxima = true, vHoraProxima = true;
//                        String mensaje = "";
//
//                        int t1 = Integer.parseInt(visitas.get(posicion).getV_HORA())*60 + Integer.parseInt(visitas.get(posicion).getV_MINUTO());
//                        int t2 = horaFin * 60 + minutoFin;
//
//                        if(t1 >= t2){
//                            vHoraFin = false;
//                            if(mensaje.equals("")) mensaje = "LA HORA DE FIN DEBE SER MAYOR A LA DE INICIO";
//                        }
//
//                        if(spResultado.getSelectedItemPosition() == 0){
//                            vResultado = false;
//                            if(mensaje.equals("")) mensaje = "DEBE INDICAR EL RESULTADO DE LA VISITA";
//                        }
//                        if(spResultado.getSelectedItemPosition() == 1){
//                            if(!coberturaCorrecta()){
//                                vResultado = false;
//                                if(mensaje.equals("")) mensaje = "LA COBERTURA Y CIERRE ES INCORRECTA NO PUEDE FINALIZAR COMO COMPLETA";
//                            }
//                        }
//                        if(spResultado.getSelectedItemPosition() == 4 && !ckProxVisita.isChecked()){
//                            vResultado = false;
//                            if(mensaje.equals("")) mensaje = "DEBE REGISTRAR INFORMACION DE LA PROXIMA VISITA";
//                        }
//                        if(edtEspecifique.isEnabled() && edtEspecifique.getText().toString().trim().length() < 3){
//                            vEspecifique = false;
//                            if(mensaje.equals("")) mensaje = "DEBE ESPECIFICAR EL RESULTADO DE LA VISITA";
//                        }
//                        if(ckProxVisita.isChecked()){
//                            int y = Integer.parseInt(visitas.get(posicion).getV_ANIO());
//                            int m = Integer.parseInt(visitas.get(posicion).getV_MES());
//                            int d = Integer.parseInt(visitas.get(posicion).getV_DIA());
//                            Date fi1 = new Date(y,m,d);
//                            Date fi2 = new Date(anioProx,mesProx,diaProx);
//                            String sfi1 = checkDigito(d) + "/" + checkDigito(m) + "/" + checkDigito(y);
//                            String sfi2 = checkDigito(diaProx) + "/" + checkDigito(mesProx) + "/" + checkDigito(anioProx);
//
//                            if(fi2.before(fi1)){
//                                vFechaProxima = false;
//                                if(mensaje.equals("")) mensaje = "FECHA: LA FECHA DE LA PROXIMA VISITA NO DEBE SER MENOR A LA VISITA ACTUAL";
//                            }
//                        }
//
//                        valido = vHoraFin && vResultado && vEspecifique && vFechaProxima;
//
//                        if(valido){
//                            //actualizo visita con datos de finalizar
//                            visitas.get(posicion).setV_RESULTADO(String.valueOf(spResultado.getSelectedItemPosition()));
//                            visitas.get(posicion).setV_RESULTADO_O(edtEspecifique.getText().toString());
//                            if(ckProxVisita.isChecked()){
//                                visitas.get(posicion).setV_PROX_VIS_DIA(checkDigito(diaProx));
//                                visitas.get(posicion).setV_PROX_VIS_MES(checkDigito(mesProx));
//                                visitas.get(posicion).setV_PROX_VIS_ANIO(checkDigito(anioProx));
//                                visitas.get(posicion).setV_PROX_VIS_HORA(checkDigito(horaProx));
//                                visitas.get(posicion).setV_PROX_VIS_MINUTO(checkDigito(minutoProx));
//                            }
//                            data = new Data(context);
//                            data.open();
//                            data.actualizarVisita(visitas.get(posicion).getID(),visitas.get(posicion).toValues());
//                            data.close();
//                            visitaAdapter.notifyDataSetChanged();
//
//                            //MUESTRO Y GUARDO DATOS DE RESULTADO FINAL
//                            final Calendar cal = Calendar.getInstance();
//                            int yy = Integer.parseInt(visitas.get(posicion).getV_ANIO());
//                            int mm = Integer.parseInt(visitas.get(posicion).getV_MES());
//                            int dd = Integer.parseInt(visitas.get(posicion).getV_DIA());
//                            resultadoEncuesta = new ResultadoEncuesta();
//                            resultadoEncuesta.setRESFIN_ID(idEmpresa);
//                            resultadoEncuesta.setRESFIN(visitas.get(posicion).getV_RESULTADO());
//                            resultadoEncuesta.setRESFIN_O(visitas.get(posicion).getV_RESULTADO_O());
//                            resultadoEncuesta.setRESFIN_DIA(visitas.get(posicion).getV_DIA());
//                            resultadoEncuesta.setRESFIN_MES(visitas.get(posicion).getV_MES());
//                            resultadoEncuesta.setRESFIN_ANIO(visitas.get(posicion).getV_ANIO());
//                            resultadoEncuesta.setRESFIN_HORA(checkDigito(horaFin));
//                            resultadoEncuesta.setRESFIN_MIN(checkDigito(minutoFin));
//                            data = new Data(context);
//                            data.open();
//                            if(txtResultadoFinal.getText().toString().equals("")) data.insertarResultado(resultadoEncuesta);
//                            else data.actualizarResultado(idEmpresa,resultadoEncuesta.toValues());
//                            txtResultadoFinal.setText(getResources().getStringArray(R.array.array_resultado_visita)[spResultado.getSelectedItemPosition()]);
//                            txtFechaFinal.setText(checkDigito(dd) + "/" + checkDigito(mm) + "/" + checkDigito(yy));
//                            txtHorafinal.setText(checkDigito(horaFin) + ":" + checkDigito(minutoFin));
//                            alertDialog.dismiss();
//                        }else Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//        alertDialog.show();
//    }

//    public boolean coberturaCorrecta(){
//        boolean correcto = true;
//        return correcto;
//    }
//
//    public boolean tieneVisitas(){
//        boolean correcto = true;
//        if(visitas.size() == 0) correcto = false;
//        return correcto;
//    }
//    public boolean finalizacionCorrecta(){
//        boolean correcto = true;
//        if(visitas.get(visitas.size()-1).getV_RESULTADO().equals("")) correcto = false;
//        return correcto;
//    }
//    public void cargarDatos(){
//        visitas = new ArrayList<Visita>();
//        data = new Data(context);
//        data.open();
//        if(data.existenVisitas(idEmpresa)){
//            visitas = data.getVisitas(idEmpresa);
//        }
//
//        if(data.existenResultados(idEmpresa)){
//            ResultadoEncuesta resultado = data.getResultados(idEmpresa);
//            txtResultadoFinal.setText(getResources().getStringArray(R.array.array_resultado_visita)[Integer.parseInt(resultado.getRESFIN())]);
//            txtFechaFinal.setText(resultado.getRESFIN_DIA() + "/" + resultado.getRESFIN_MES() + "/" + resultado.getRESFIN_ANIO());
//            txtHorafinal.setText(resultado.getRESFIN_HORA() + ":" + resultado.getRESFIN_MIN());
//        }
//
//        data.close();
//    }
//    public boolean validar(){
//        boolean valido = true;
//        String mensaje = "";
//        if(visitas.size() > 0){
//            if(!visitas.get(visitas.size()-1).getV_RESULTADO().equals("")){
//                valido =  false;
//                mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
//            }
//        }else{
//            valido =  false;
//            mensaje = "DEBE INICIAR UNA VISITA ANTES DE CONTINUAR";
//        }
//
//        if(!valido){
//            mostrarMensaje(mensaje);
//        }
//        return valido;
//    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
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
    public String getNumModulo(){
        return visita.getMODULO();
    }
}
